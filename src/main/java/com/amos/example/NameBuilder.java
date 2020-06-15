package com.amos.example;


/**
 * @author chenjun
 */
public final class NameBuilder extends Builder {

    public NameBuilder withName(String name) {
        PARAM_MAP.put("name", name);
        return this;
    }

    @Override
    public String build() {
        return super.build();
    }
}
