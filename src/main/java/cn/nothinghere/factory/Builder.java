package cn.nothinghere.factory;

/**
 * @author chenjun
 * @date 2020/6/11 8:29
 */
public interface Builder {
    /**
     * 每个实现该接口的类都需要实现返回所构造的数据
     * @return 构造的数据
     */
    String build();
}