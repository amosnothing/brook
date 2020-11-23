package cn.nothinghere.brook.value.region;

import cn.nothinghere.brook.Value;
import cn.nothinghere.brook.Verifiable;
import cn.nothinghere.brook.util.JsonPathUtils;
import cn.nothinghere.brook.util.YamlUtils;
import com.jayway.jsonpath.PathNotFoundException;

import java.io.Serializable;
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
public class Area  implements Value<String>, Serializable, Verifiable {

    private static final long serialVersionUID = -8607770453586455092L;
    private String province;
    private String city;
    private String district;

    private transient Map.Entry<String, Object> kvHolder;

    private static final Map<String, Object> AREA_MAP;

    static {
        AREA_MAP = Collections.unmodifiableMap(YamlUtils.load("area.yml"));
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
    public String asCode() {
        return String.valueOf(kvHolder.getValue());

    }

    /**
     * 根据json-path获取到的多层级key，带有一些特殊符号需要去掉
     * @return 地区名
     */
    @Override
    public String asString() {
        return kvHolder.getKey()
                .replaceAll("\\$|\\[|]|'", "")
                ;
    }

    @Override
    public void verify() {
        try {
            // 校验 省/市/区 如果没有会提示找不到
            kvHolder = JsonPathUtils.random(AREA_MAP, this.province, this.city, this.district);
        } catch (PathNotFoundException exception) {
            throw new IllegalArgumentException(exception.getMessage().replace('$', ' '));
        }
    }
}
