package cn.nothinghere.factory;

/**
 * @author amos
 */
public interface Attribute {

    /**
     * 返回属性的中文字符串形式，比如：地址，姓名，性别
     * 属性原有的样子，不需要二次转义的
     * @return like toString
     */
    String asString();
}
