package cn.nothinghere.factory;

/**
 * @author amos
 */
public interface Value extends Attribute {
    /**
     * 返回属性所对应的数字/字母编码形式
     * 属性经过二次转义的，比如
     * 湖北省武汉市 1. 对应身份证的编码: 4201XX
     *             2. 对应的车牌号码: 鄂A
     * @return 字符串映射对应的编码
     */
    String asCode();

    /**
     * 如果类中某个属性数值未被赋值，则对其随机赋值
     */
    void random();
}
