package com.amos;

import com.amos.example.Builder;
import com.amos.example.NameBuilder;
import com.amos.example.PhoneBuilder;

import java.util.concurrent.TimeUnit;

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
        try{
            NAME_BUILDER.LOCK.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return NAME_BUILDER;
    }

    public static PhoneBuilder phoneBuilder() {
        try{
            PHONE_BUILDER.LOCK.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PHONE_BUILDER;
    }
}
