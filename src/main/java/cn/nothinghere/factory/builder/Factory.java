package cn.nothinghere.factory.builder;

/**
 * @author chenjun
 * @date 2020/6/8 18:34
 */
public final class Factory {


    public static IdCardBuilder idCardBuilder() {
        return new IdCardBuilder();
    }

    public static NameBuilder nameBuilder() {
        return new NameBuilder();
    }

    private Factory() {
    }
}
