package cn.nothinghere.factory.value;

/**
 * 参考wiki ：https://zh.wikipedia.org/wiki/%E4%B8%AD%E5%9B%BD%E5%A4%A7%E9%99%86%E9%93%B6%E8%A1%8C%E5%88%97%E8%A1%A8
 * <p>
 * 进行的分类，子类枚举继承该接口
 *
 * @author amos
 */
public interface BankCode {

    /**
     * 不同子类枚举的name()转为小写即可
     *
     * @return 銀行編碼
     */
    String getCode();
}
