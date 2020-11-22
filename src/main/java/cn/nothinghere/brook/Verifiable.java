package cn.nothinghere.brook;

/**
 * @author amos.chenj@outlook.com
 */
public interface Verifiable {

    /**
     * 每一个继承该类的子类都需要实现自己的参数校验方法
     */
    void verify();
}
