package cn.nothinghere.brook.value.region;

/**
 * @author amos.chenj@outlook.com
 */

public enum Province implements Region {
    /**
     * 直辖市
     */
    BEIJING("北京"),
    TIANJIN("天津"),
    CHONGQING("重庆"),
    SHANGHAI("上海"),
    /**
     * 省
     */
    HEBEI("河北省"),
    SHANXI("山西省"),
    LIAONING("辽宁省"),
    JILIN("吉林省"),
    HEILONGJIANG("黑龙江省"),
    JIANGSU("江苏省"),
    ZHEJIANG("浙江省"),
    ANHUI("安徽省"),
    FUJIAN("福建省"),
    JIANGXI("江西省"),
    SHANDONG("山东省"),
    HENAN("河南省"),
    HUBEI("湖北省"),
    HUNAN("湖南省"),
    GUANGDONG("广东省"),
    HAINAN("海南省"),
    SICHUAN("四川省"),
    GUIZHOU("贵州省"),
    YUNNAN("云南省"),
    /**
     * 陕西和山西的拼音是一样的，但是英文翻译有差别
     */
    SHAANXI("陕西省"),
    GANSU("甘肃省"),
    QINGHAI("青海省"),
    /**
     * 自治区
     */
    NEI_MONGGOL("内蒙古自治区"),
    GUANGXI("广西壮族自治区"),
    XIZANG("西藏自治区"),
    NINGXIA("宁夏回族自治区"),
    XINJIANG("新疆维吾尔自治区"),
    TAIWAN("台湾"),
    HONG_KONG("香港特别行政区"),
    MACAO("澳门特别行政区"),
    ;
    private final String name;

    Province(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
