package cn.nothinghere.brook.region;

/**
 * @author amos.chenj@outlook.com
 */

public enum Province implements Region{
    /**
     * 直辖市
     */
    Beijing("北京"),
    Tianjin("天津"),
    Chongqing("重庆"),
    Shanghai("上海"),
    /**
     * 省
     */
    Hebei("河北省"),
    Shanxi("山西省"),
    Liaoning("辽宁省"),
    Jilin("吉林省"),
    Heilongjiang("黑龙江省"),
    Jiangsu("江苏省"),
    Zhejiang("浙江省"),
    Anhui("安徽省"),
    Fujian("福建省"),
    Jiangxi("江西省"),
    Shandong("山东省"),
    Henan("河南省"),
    Hubei("湖北省"),
    Hunan("湖南省"),
    Guangdong("广东省"),
    Hainan("海南省"),
    Sichuan("四川省"),
    Guizhou("贵州省"),
    Yunnan("云南省"),
    /**
     * 陕西和山西的拼音是一样的，但是英文翻译有差别
     */
    Shaanxi("陕西省"),
    Gansu("甘肃省"),
    Qinghai("青海省"),
    /**
     * 自治区
     */
    NeiMonggol("内蒙古自治区"),
    Guangxi("广西壮族自治区"),
    Xizang("西藏自治区"),
    Ningxia("宁夏回族自治区"),
    Xinjiang("新疆维吾尔自治区"),
    Taiwan("台湾"),
    HongKong("香港特别行政区"),
    Macao("澳门特别行政区"),
    ;
    private String name;

    Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
