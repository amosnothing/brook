package cn.nothinghere.brook.value;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Verifiable;
import cn.nothinghere.brook.util.JsonPathUtils;
import cn.nothinghere.brook.util.RandomStringUtils;
import cn.nothinghere.brook.util.YamlUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;

/**
 * 省-市 OR 车牌类型
 *
 * @author amos.chenj@outlook.com
 */
public class Plate implements Field, Verifiable, Serializable {

    private static final long serialVersionUID = -4962754012132540949L;
    /**
     * 车牌字符长度
     */
    protected static final int PLATE_LENGTH = 8;

    private String province;
    private String city;
    private PlateType type;

    private String valueHolder;

    private static final Map<String, Object> PLATE_MAP;

    static {
        PLATE_MAP = Collections.unmodifiableMap(YamlUtils.load("license-plate-number.yml"));
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(PlateType type) {
        this.type = type;
    }


    @Override
    public void verify() {
        // 校验 省/市/车牌类型 如果没有会提示找不到
        if (null == this.type) {
            setType(PlateType.COMMON);
        }
        valueHolder = (String) JsonPathUtils.randomValue(PLATE_MAP, this.province, this.city, this.type.name());
        if (valueHolder == null) {
            throw new IllegalArgumentException(MessageFormat.format("找不到对应的记录[{0}].[{1}].[{2}]",
                    this.province == null ? "*" : this.province,
                    this.city == null ? "*" : this.city,
                    this.type.name()));
        }
    }

    @Override
    public String asString() {
        // 车牌号没有使用I/O 字母 替换为数字1和0
        return valueHolder + RandomStringUtils.alphanumeric(PLATE_LENGTH - valueHolder.length())
                .toUpperCase()
                .replace('I', '1')
                .replace('O', '0')
                ;
    }
}
