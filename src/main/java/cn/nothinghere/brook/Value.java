package cn.nothinghere.brook;

/**
 * @author amos.chenj@outlook.com
 */
public interface Value<T> extends Field {
    /**
     * 返回属性所对应的数字/字母编码形式
     * 属性经过二次转义的，比如
     * 湖北省武汉市 1. 对应身份证的编码: 4201XX
     *             2. 对应的车牌号码: 鄂A
     * @return 字符串映射对应的编码
     */
    T asCode();
}
