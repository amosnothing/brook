package com.amos.example;


/**
 * @author chenjun
 * @date 2020/6/8 18:33
 */
public final class PhoneBuilder extends Builder {

    public PhoneBuilder withPhone(String phone) {
        PARAM_MAP.put("phone", phone);
        return this;
    }

    @Override
    public String build() {
        return super.build();
    }
}
