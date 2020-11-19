package cn.nothinghere.brook.value;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomUtil;
import cn.nothinghere.brook.util.YamlUtil;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author amos.chenj@outlook.com
 */
@SuppressWarnings("unchecked")
public class Name implements Field, Randomize, Serializable {

    private Gender gender;
    private Integer length;

    /**
     * 最短姓名长度
     */
    private static final int MIN_LENGTH = 2;
    /**
     * 最长姓名长度
     */
    private static final int MAX_LENGTH = 4;

    private static final Map<String, Object> NAME_MAP;
    /**
     * 姓氏中存在复姓：比如：欧阳
     */
    private static final Map<String, Integer> LAST_NAME_MAP;
    /**
     * 单字姓氏
     */
    private static final Map<String, Integer> LAST_NAME_LEN1_MAP;
    /**
     * 复姓
     */
    private static final Map<String, Integer> LAST_NAME_LEN2_MAP;

    /**
     * 名字 ~ 包括男/女/未知
     */
    private static final Map<String, Object> FIRST_NAME_MAP;
    /**
     * 名字 ~ 男
     */
    private static final Map<String, Integer> FIRST_NAME_MALE_MAP;
    /**
     * 名字 ~ 女
     */
    private static final Map<String, Integer> FIRST_NAME_FEMALE_MAP;
    /**
     * 名字 ~ 未知
     */
    private static final Map<String, Integer> FIRST_NAME_UNKNOWN_MAP;

    /**
     * 筛选女性中长度=2的名字
     */
    private static final Map<String, Integer> FIRST_NAME_FEMALE_LEN2_MAP;
    /**
     * 筛选女性中长度=1的名字
     */
    private static final Map<String, Integer> FIRST_NAME_FEMALE_LEN1_MAP;
    /**
     * 筛选男性中长度=2的名字
     */
    private static final Map<String, Integer> FIRST_NAME_MALE_LEN2_MAP;
    /**
     * 筛选男性中长度=1的名字
     */
    private static final Map<String, Integer> FIRST_NAME_MALE_LEN1_MAP;

    /**
     * 筛选性别未知中长度=2的名字
     */
    private static final Map<String, Integer> FIRST_NAME_UNKNOWN_LEN2_MAP;
    /**
     * 筛选性别未知中长度=1的名字
     */
    private static final Map<String, Integer> FIRST_NAME_UNKNOWN_LEN1_MAP;

    static {
        NAME_MAP = Collections.unmodifiableMap(YamlUtil.load("name.yml"));
        LAST_NAME_MAP = Collections.unmodifiableMap((Map<String, Integer>) NAME_MAP.get("last_name"));
        FIRST_NAME_MAP = Collections.unmodifiableMap((Map<String, Object>) NAME_MAP.get("first_name"));
        FIRST_NAME_MALE_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("male"));
        FIRST_NAME_FEMALE_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("female"));
        FIRST_NAME_UNKNOWN_MAP = Collections.unmodifiableMap((Map<String, Integer>) FIRST_NAME_MAP.get("unknown"));
        LAST_NAME_LEN1_MAP = LAST_NAME_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        LAST_NAME_LEN2_MAP = LAST_NAME_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_FEMALE_LEN2_MAP = FIRST_NAME_FEMALE_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_FEMALE_LEN1_MAP = FIRST_NAME_FEMALE_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_MALE_LEN2_MAP = FIRST_NAME_MALE_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_MALE_LEN1_MAP = FIRST_NAME_MALE_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_UNKNOWN_LEN2_MAP = FIRST_NAME_UNKNOWN_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        FIRST_NAME_UNKNOWN_LEN1_MAP = FIRST_NAME_UNKNOWN_MAP.entrySet().stream()
                .filter(map -> map.getKey().length() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

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
        // 姓名长度只允许取 2，3，4
        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new IllegalArgumentException("length");
        }
        this.length = length;
    }

    @Override
    public String asString() {
        String lastName;
        int firstNameLength;
        // 姓氏随机
        if (this.length == MAX_LENGTH) {
            lastName = RandomUtil.choice(LAST_NAME_LEN2_MAP);
            firstNameLength = 2;
        } else {
            lastName = RandomUtil.choice(LAST_NAME_LEN1_MAP);
            firstNameLength = this.length - 1;
        }

        String firstName;
        switch (this.getGender()) {
            case FEMALE:
                firstName = firstNameLength == 2 ? RandomUtil.choice(FIRST_NAME_FEMALE_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_FEMALE_LEN1_MAP);
                break;
            case MALE:
                firstName = firstNameLength == 2 ? RandomUtil.choice(FIRST_NAME_MALE_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_MALE_LEN1_MAP);
                break;
            default:
                firstName = firstNameLength == 2 ? RandomUtil.choice(FIRST_NAME_UNKNOWN_LEN2_MAP)
                        : RandomUtil.choice(FIRST_NAME_UNKNOWN_LEN1_MAP);
        }
        return lastName + firstName;
    }

    @Override
    public void randomIfNull() {
        long now = System.currentTimeMillis();
        if (null == this.getGender()) {
            // 取到性别未知的概率设置小些, 接近 1/7
            // 男女性别随机概率 1/2 * 6/7 = 3/7
            this.setGender(now % 7 == 0 ? Gender.UNKNOWN : now % 2 == 0 ? Gender.FEMALE : Gender.MALE);
        }
        if (null == this.getLength()) {
            this.setLength(now % 2 == 0 ? 2 : 3);
        }
    }
}
