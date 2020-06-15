package com.amos.common;


/**
 * @author chenjun
 */
public final class NameBuilder extends BaseBuilder {


    public NameBuilder withName(String name) {
        PARAM_MAP.put("name", name);
        return this;
    }

    @Override
    public String build() {
        return super.build();
    }
}
