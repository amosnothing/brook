package cn.nothinghere.brook.value.occupation;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.Verifiable;
import cn.nothinghere.brook.util.JsonPathUtils;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.util.YamlUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Map;

/**
 * @author amos.chenj@outlook.com
 */
public class Occupation implements Field, Randomize, Serializable, Verifiable {
    private static final long serialVersionUID = -8313473735902908218L;
    private MajorType majorType;

    private String valueHolder;

    private static final Map<String, Object> OCCUPATION_MAP;

    static {

        OCCUPATION_MAP = Collections.unmodifiableMap(YamlUtils.load("occupation.yml"));
    }

    public MajorType getMajorType() {
        return majorType;
    }

    public void setMajorType(MajorType majorType) {
        this.majorType = majorType;
    }

    @Override
    public String asString() {
        return valueHolder;
    }

    @Override
    public void randomIfNull() {
        MajorType[] majorTypes = new MajorType[]{MajorType.PROFESSION, MajorType.BUSINESS_AND_SERVICE_PERSONNEL,
                MajorType.PRODUCER_AND_OPERATOR, MajorType.FARMER, MajorType.STAFF
        };
        if (null == this.majorType) {
            majorType = RandomUtils.choice(majorTypes);
        }

    }

    @Override
    public void verify() {
        valueHolder = (String) JsonPathUtils.randomValue(OCCUPATION_MAP, this.majorType.name(), null);
        if (valueHolder == null) {
            throw new IllegalArgumentException(MessageFormat.format("找不到{0}对应的职业类型", this.majorType.name()));
        }
    }
}
