package cn.nothinghere.brook.value.bank;

/**
 * 参考wiki ：https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%9B%BD%E5%A4%A7%E9%99%86%E9%93%B6%E8%A1%8C%E5%88%97%E8%A1%A8
 * <p>
 * 进行的分类，子类枚举继承该接口
 *
 * @author amos.chenj@outlook.com
 */
public interface Bank {

    /**
     * 为方便直接取到对应枚举的code
     *
     * @return 银行编码
     */
    String getCode();

    /**
     * 为方便直接取到对应枚举的name
     *
     * @return 银行全名
     */
    String getName();
}
