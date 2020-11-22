package cn.nothinghere.brook.value;

/**
 * 车牌类型
 *
 * @author amos.chenj@outlook.com
 */

public enum PlateType {

    /**
     * 摩托车
     */
    MOTOR,
    /**
     * 公交车 ，大巴
     */
    BUS,
    /**
     * 出租车
     */
    TAXI,
    /**
     * 外籍 ，或者外籍公司车牌
     */
    FOREIGNER,
    /**
     * 临时号牌
     */
    TEMPORARY,
    /**
     * 国家机关：公安部等机构，仅仅标明但不用于数据生成
     */
//    GOVERNMENT,
    /**
     * 常用车牌，非特殊作用，家庭/个人用
     */
    COMMON,
    ;
}
