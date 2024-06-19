package org.verdurae.attributeplusplus.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.serverct.ersha.api.AttributeAPI;
import org.serverct.ersha.attribute.enums.AttributeType;
import org.verdurae.attributeplusplus.AttributePlusPlus;
import org.verdurae.attributeplusplus.SubAttributePlus;

import javax.script.Invocable;
import javax.script.ScriptException;

/**
 * @author Kaminy
 * @since 1.0
 */
public class EntityDeath implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) throws ScriptException, NoSuchMethodException {
        LivingEntity entity = event.getEntity();
        LivingEntity killer = event.getEntity().getKiller();
        for (SubAttributePlus attribute : AttributePlusPlus.subAttributes.values()) {
            if (attribute != null) {
                if (attribute.subAttribute.getAttributeType() == AttributeType.OTHER) {
                    if (AttributeAPI.getAttrData(entity).getRandomValue(attribute.subAttribute.getAttributeName()).doubleValue() != 0) {
                        Invocable inv = (Invocable) attribute.engine;
                        try {
                            inv.invokeFunction("runDeath", event);
                        } catch (NoSuchMethodException ignored) {
                        }
                    } else if (killer != null) {
                        if (AttributeAPI.getAttrData(killer).getRandomValue(attribute.subAttribute.getAttributeName()).doubleValue() != 0) {
                            Invocable inv = (Invocable) attribute.engine;
                            try {
                                inv.invokeFunction("runKill", event);
                            } catch (NoSuchMethodException ignored) {
                            }
                        }
                    }
                }
            }
        }
    }
}
