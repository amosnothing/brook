package cn.nothinghere.brook.value.human;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.util.YamlUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author amos.chenj@outlook.com
 */
@SuppressWarnings("unchecked")
public class Name implements Field, Randomize, Serializable {

    private static final String LAST_NAME = "last_name";
    private static final String FIRST_NAME = "first_name";
    private static final String MALE = "male";
    private static final String FEMALE = "female";
    private static final String UNKNOWN = "unknown";

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
        NAME_MAP = Collections.unmodifiableMap(YamlUtils.load("name.yml"));
        LAST_NAME_MAP = childIntegerMap(NAME_MAP, LAST_NAME);
        FIRST_NAME_MAP = Collections.unmodifiableMap((Map<String, Object>) NAME_MAP.get(FIRST_NAME));
        FIRST_NAME_MALE_MAP = childIntegerMap(FIRST_NAME_MAP, MALE);
        FIRST_NAME_FEMALE_MAP = childIntegerMap(FIRST_NAME_MAP, FEMALE);
        FIRST_NAME_UNKNOWN_MAP = childIntegerMap(FIRST_NAME_MAP, UNKNOWN);
        LAST_NAME_LEN1_MAP = filterByLength(LAST_NAME_MAP, 1);
        LAST_NAME_LEN2_MAP = filterByLength(LAST_NAME_MAP, 2);
        FIRST_NAME_FEMALE_LEN2_MAP = filterByLength(FIRST_NAME_FEMALE_MAP, 2);
        FIRST_NAME_FEMALE_LEN1_MAP = filterByLength(FIRST_NAME_FEMALE_MAP, 1);
        FIRST_NAME_MALE_LEN2_MAP = filterByLength(FIRST_NAME_MALE_MAP, 2);
        FIRST_NAME_MALE_LEN1_MAP = filterByLength(FIRST_NAME_MALE_MAP, 1);
        FIRST_NAME_UNKNOWN_LEN2_MAP = filterByLength(FIRST_NAME_UNKNOWN_MAP, 2);
        FIRST_NAME_UNKNOWN_LEN1_MAP = filterByLength(FIRST_NAME_UNKNOWN_MAP, 1);
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
            throw new IllegalArgumentException("姓名长度只允许取 2~4");
        }
        this.length = length;
    }

    @Override
    public String asString() {
        String lastName;
        int firstNameLength;
        // 姓氏随机
        if (this.length == MAX_LENGTH) {
            lastName = RandomUtils.choice(LAST_NAME_LEN2_MAP);
            firstNameLength = 2;
        } else {
            lastName = RandomUtils.choice(LAST_NAME_LEN1_MAP);
            firstNameLength = this.length - 1;
        }

        String firstName;
        switch (this.getGender()) {
            case FEMALE:
                firstName = chooseFirstName(FIRST_NAME_FEMALE_LEN2_MAP, FIRST_NAME_FEMALE_LEN1_MAP, firstNameLength);
                break;
            case MALE:
                firstName = chooseFirstName(FIRST_NAME_MALE_LEN2_MAP, FIRST_NAME_MALE_LEN1_MAP, firstNameLength);
                break;
            default:
                firstName = chooseFirstName(FIRST_NAME_UNKNOWN_LEN2_MAP, FIRST_NAME_UNKNOWN_LEN1_MAP, firstNameLength);
        }
        return lastName + firstName;
    }

    @Override
    public void randomIfNull() {
        if (null == this.getGender()) {
            // 取到性别未知的概率设置小些, 接近 1/7
            // 男女性别随机概率 1/2 * 6/7 = 3/7
            this.setGender(RandomUtils.nextInt(7) == 0 ? Gender.UNKNOWN
                    : RandomUtils.nextInt(2) == 0 ? Gender.FEMALE : Gender.MALE);
        }
        if (null == this.getLength()) {
            this.setLength(RandomUtils.nextInt(2, 4));
        }
    }

    private static Map<String, Integer> childIntegerMap(Map<String, ?> parent, String key) {
        return Collections.unmodifiableMap((Map<String, Integer>) parent.get(key));
    }

    private static Map<String, Integer> filterByLength(Map<String, Integer> source, int length) {
        return source.entrySet().stream()
                .filter(entry -> entry.getKey().length() == length)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static String chooseFirstName(Map<String, Integer> length2Names,
                                          Map<String, Integer> length1Names,
                                          int firstNameLength) {
        return firstNameLength == 2 ? RandomUtils.choice(length2Names) : RandomUtils.choice(length1Names);
    }
}
