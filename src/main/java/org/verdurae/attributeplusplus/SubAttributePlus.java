package org.verdurae.attributeplusplus;

import org.serverct.ersha.api.component.SubAttribute;
import org.serverct.ersha.attribute.enums.AttributeType;

import javax.script.ScriptEngine;

/**
 * @author Kaminy
 * @since 1.0
 */
public class SubAttributePlus {
    public ScriptEngine engine;
    public SubAttribute subAttribute;

    public SubAttributePlus(ScriptEngine engine, SubAttribute subAttribute) {
        this.engine = engine;
        this.subAttribute = subAttribute;
    }
}
