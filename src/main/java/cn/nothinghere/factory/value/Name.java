package cn.nothinghere.factory.value;

import cn.nothinghere.factory.Field;
import cn.nothinghere.factory.Randomize;
import cn.nothinghere.factory.util.RandomUtil;
import cn.nothinghere.factory.util.YamlUtil;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author amos
 */
public class Name implements Field, Randomize, Serializable {

    private Gender gender;
    private Integer length;

    private final static Map<String, Object> NAME_MAP = Collections.unmodifiableMap(YamlUtil.load("name.yml"));
    @SuppressWarnings("unchecked")
    private final static Map<String, Integer> LAST_NAME_MAP = Collections.unmodifiableMap((Map<String, Integer>) NAME_MAP.get("last_name"));
    @SuppressWarnings("unchecked")
    private final static Map<String, Object> FIRST_NAME_MAP = Collections.unmodifiableMap((Map<String, Object>) NAME_MAP.get("first_name"));
    @SuppressWarnings("unchecked")
    private final static Map<String, Integer> FIRST_NAME_MALE_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("male"));
    @SuppressWarnings("unchecked")
    private final static Map<String, Integer> FIRST_NAME_FEMALE_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("female"));
    @SuppressWarnings("unchecked")
    private final static Map<String, Integer> FIRST_NAME_UNKNOWN_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("unknown"));

    /**
     * 筛选女性中长度=2的名字
     */
    private final static Map<String, Integer> FIRST_NAME_FEMALE_LEN2_MAP = FIRST_NAME_FEMALE_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 2)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    /**
     * 筛选女性中长度=1的名字
     */
    private final static Map<String, Integer> FIRST_NAME_FEMALE_LEN1_MAP = FIRST_NAME_FEMALE_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    /**
     * 筛选男性中长度=2的名字
     */
    private final static Map<String, Integer> FIRST_NAME_MALE_LEN2_MAP = FIRST_NAME_MALE_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 2)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    /**
     * 筛选男性中长度=1的名字
     */
    private final static Map<String, Integer> FIRST_NAME_MALE_LEN1_MAP = FIRST_NAME_MALE_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    /**
     * 筛选性别未知中长度=2的名字
     */
    private final static Map<String, Integer> FIRST_NAME_UNKNOWN_LEN2_MAP = FIRST_NAME_UNKNOWN_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 2)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    /**
     * 筛选性别未知中长度=1的名字
     */
    private final static Map<String, Integer> FIRST_NAME_UNKNOWN_LEN1_MAP = FIRST_NAME_UNKNOWN_MAP.entrySet().stream()
            .filter(map -> map.getKey().length() == 1)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String asString() {
        // 姓氏随机
        String lastName = RandomUtil.choice(LAST_NAME_MAP);

        String firstName;
        switch (this.getGender()) {
            case FEMALE:
                firstName = this.length == 3 ? RandomUtil.choice(FIRST_NAME_FEMALE_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_FEMALE_LEN1_MAP);
                break;
            case MALE:
                firstName = this.length == 3 ? RandomUtil.choice(FIRST_NAME_MALE_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_MALE_LEN1_MAP);
                break;
            default:
                firstName = this.length == 3 ? RandomUtil.choice(FIRST_NAME_UNKNOWN_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_UNKNOWN_LEN1_MAP);
        }
        return lastName + firstName;
    }

    @Override
    public void random() {
        long now = System.currentTimeMillis();
        if (null == this.gender) {
            // 取到性别未知的概率设置小些, 接近 1/7
            // 男女性别随机概率 1/2 * 6/7 = 3/7
            this.setGender(now % 7 == 0 ? Gender.UNKNOWN : now % 2 == 0 ? Gender.FEMALE : Gender.MALE);
        }
        if (null == this.length) {
            this.setLength(now % 2 == 0 ? 2 : 3);
        }
    }
}
