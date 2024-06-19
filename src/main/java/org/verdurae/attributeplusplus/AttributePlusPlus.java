package org.verdurae.attributeplusplus;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.bukkit.plugin.java.JavaPlugin;
import org.serverct.ersha.AttributePlus;
import org.serverct.ersha.script.AttrScriptUtils;
import org.verdurae.attributeplusplus.listener.EntityDeath;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public final class AttributePlusPlus extends JavaPlugin {
    public static AttributePlusPlus instance;
    public static AttrScriptUtils attrScriptUtils;
    public static Map<Integer, SubAttributePlus> subAttributes;

    @Override
    public void onEnable() {
        instance = this;
        attrScriptUtils = AttrScriptUtils.INSTANCE;
        subAttributes = new HashMap<>();
        try {
            File file = new File(this.getDataFolder(), "script");
            System.out.println("AttributePlusPlus: 准备向AttributePlus注册属性");
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files != null) {
                    if (files.length == 0) System.out.println("脚本文件夹为空，跳过");
                    for (File f : files) {
                        if (f.getName().endsWith(".js")) {
                            NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
                            ScriptEngine engine = factory.getScriptEngine();
                            engine.put("Math", java.lang.Math.class);
                            try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(f.toPath()), StandardCharsets.UTF_8)) {
                                char[] buffer = new char[1024];
                                int read;
                                StringBuilder builder = new StringBuilder();
                                while ((read = reader.read(buffer, 0, buffer.length)) != -1) {
                                    builder.append(buffer, 0, read);
                                }
                                String scriptContent = builder.toString();
                                engine.eval(scriptContent);
                                int priority = (int) engine.get("priority");
                                double combatPower = (double) engine.get("combatPower");
                                String attributeName = (String) engine.get("attributeName");
                                String placeholder = (String) engine.get("placeholder");
                                AttrScriptUtils.registerOtherAttribute(attributeName, combatPower, placeholder);
                                SubAttributePlus subAttributePlus = new SubAttributePlus(engine, AttributePlus.attributeManager.attributeNameList.get(attributeName));
                                catchAttribute(priority, subAttributePlus);
                            } catch (IOException | ScriptException e) {
                                System.err.println("Error processing file " + f.getAbsolutePath() + ": " + e.getMessage());
                            }
                        }
                    }
                } else {
                    System.out.println("脚本文件夹为空，跳过");
                }
            } else {
                System.out.println("脚本文件夹不存在，跳过");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        getServer().getPluginManager().registerEvents(new EntityDeath(), this);
    }

    @Override
    public void onDisable() {
        for (SubAttributePlus subAttributePlus : subAttributes.values()) {
        }
    }

    public void catchAttribute(int priority, SubAttributePlus subAttribute) {
        while (subAttributes.containsKey(priority)) {
            priority++;
        }
        subAttributes.put(priority, subAttribute);
    }
}
