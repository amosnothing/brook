package cn.nothinghere.brook.value;

import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.Value;
import cn.nothinghere.brook.Verifiable;
import cn.nothinghere.brook.util.RandomUtil;
import cn.nothinghere.brook.util.YamlUtil;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;

/**
 * 省-市-区
 * 分析一下有可能的传参情况：
 * 1.有传入省/市/区，则根据传入的返回，如果没有与传参对应的结果，则抛出异常
 * 2.只传省，则找到对应的省，没有则抛出异常，若有则省下属市随机，再在市下属区域随机
 * 3.只传省市，则找到对应的省、市，没有则抛出异常，若有再在下属区域随机，
 * 4.省也没有传，省市区全部随机
 *
 * @author amos.chenj@outlook.com
 */
public class Area implements Value<String>, Randomize, Verifiable, Serializable {

    private static final long serialVersionUID = -8607770453586455092L;
    private String province;
    private String city;
    private String district;

    private static final Map<String, Object> AREA_MAP;

    static {
        AREA_MAP = Collections.unmodifiableMap(YamlUtil.load("area.yml"));
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }


    @Override
    @SuppressWarnings("unchecked")
    public String asCode() {
        Map<String, Object> provinceMap = (Map<String, Object>) AREA_MAP.get(this.getProvince());
        Map<String, Object> cityMap = (Map<String, Object>) provinceMap.get(this.getCity());
        return String.valueOf(cityMap.get(this.getDistrict()));
    }

    @Override
    public String asString() {
        return this.getProvince() + this.getCity() + this.getDistrict();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void randomIfNull() {
        String provinceKey = this.getProvince();
        // 省随机赋值
        if (null == provinceKey) {
            provinceKey = RandomUtil.choiceK(AREA_MAP);
            this.setProvince(provinceKey);
        }
        Map<String, Object> provinceMap = (Map<String, Object>) AREA_MAP.get(provinceKey);

        String cityKey = this.getCity();
        // 市随机赋值
        if (null == cityKey) {
            cityKey = RandomUtil.choiceK(provinceMap);
            this.setCity(cityKey);
        }
        Map<String, Object> cityMap = (Map<String, Object>) provinceMap.get(cityKey);

        String districtKey = this.getDistrict();
        // 区域随机赋值
        if (districtKey == null) {
            districtKey = RandomUtil.choiceK(cityMap);
            this.setDistrict(districtKey);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void verify() {
        String provinceKey = this.getProvince();
        // 校验 省 字段
        if (null == provinceKey) {
            return;
        }
        Map<String, Object> provinceMap = (Map<String, Object>) AREA_MAP.get(provinceKey);
        if (null == provinceMap) {
            throw new IllegalArgumentException(MessageFormat.format("There is no {0} province in Chinese Mainland.", provinceKey));
        }
        // 校验 市 字段
        String cityKey = this.getCity();
        if (null == cityKey) {
            return;
        }
        Map<String, Object> cityMap = (Map<String, Object>) provinceMap.get(cityKey);
        if (null == cityMap) {
            throw new IllegalArgumentException(MessageFormat.format("There is no {0} in {1}.", cityKey, provinceKey));
        }
        // 校验 区 字段
        String districtKey = this.getDistrict();
        if (null == districtKey) {
            return;
        }
        Integer districtName = (Integer) cityMap.get(districtKey);
        if (null == districtName) {
            throw new IllegalArgumentException(MessageFormat.format("There is no {0} in {1}-{2}.", districtKey, cityKey, provinceKey));
        }
    }
}
