package com.amos;

import com.amos.common.NameBuilder;
import com.amos.common.PhoneBuilder;
import com.amos.example.Builder;

/**
 * @author chenjun
 * @date 2020/6/8 18:34
 */
public final class Factory {

    private static final NameBuilder NAME_BUILDER = new NameBuilder();
    private static final PhoneBuilder PHONE_BUILDER = new PhoneBuilder();
    private static final Builder BASE_BUILDER = new Builder();

    private Factory() {
    }

    public static NameBuilder nameBuilder() {
        return NAME_BUILDER;
    }

    public static PhoneBuilder phoneBuilder() {
        return PHONE_BUILDER;
    }

    public static Builder baseBuilder() {
        return BASE_BUILDER;
    }

}
