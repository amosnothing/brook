package cn.nothinghere.brook;

/**
 * 1.如果属性类的字段有层层递进关系，比如A-B-C，若没有给A赋值，则赋值给B，C将被省略；若未赋值给B，则赋值给C将被省略
 *
 * @author amos.chenj@outlook.com
 */
public interface Field {

    /**
     * 返回属性的中文字符串形式，比如：地址，姓名，性别
     * 属性原有的样子，不需要二次转义的
     *
     * @return like toString
     */
    String asString();
}
