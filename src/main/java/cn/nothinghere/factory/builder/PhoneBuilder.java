package cn.nothinghere.factory.builder;


import cn.nothinghere.factory.Builder;

/**
 * @author chenjun
 * @date 2020/6/8 18:33
 */
public final class PhoneBuilder implements Builder {

    public PhoneBuilder withPhone(String phone) {
        return this;
    }

    @Override
    public String build() {
        return null;
    }
}
