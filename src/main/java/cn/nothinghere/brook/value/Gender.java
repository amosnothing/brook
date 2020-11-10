package cn.nothinghere.factory.value;

import cn.nothinghere.factory.Value;
import cn.nothinghere.factory.util.RandomUtil;


/**
 * @author amos.chenj@outlook.com
 */
public enum Gender implements Value<Integer> {

    /**
     * 英、中对应
     */
    MALE("male", "男"),
    FEMALE("female", "女"),
    UNKNOWN("unknown", "未知"),
    ;

    private String name;
    private String display;

    private Gender(String name, String display) {
        this.name = name;
        this.display = display;
    }

    public static Gender fromName(String name) {
        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            if (name.equals(gender.getName())) {
                return gender;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return name;
    }

    /**
     * @return 男 or 女 | male or female
     */
    @Override
    public String asString() {
        return this.name;
    }

    /**
     * @return 女 10内的偶数 + 0 | 男 10内的奇数
     */
    @Override
    public Integer asCode() {
        int bound = 10;
        switch (this) {
            case MALE:
                return RandomUtil.odd(bound);
            case FEMALE:
                return RandomUtil.even(bound);
            default:
                return RandomUtil.nextInt(bound);
        }
    }
}