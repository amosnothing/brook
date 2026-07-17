package cn.nothinghere.brook.value.human;

import cn.nothinghere.brook.Value;
import cn.nothinghere.brook.util.RandomUtils;

import java.util.Locale;

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

    private final String name;
    private final String display;

    private Gender(String name, String display) {
        this.name = name;
        this.display = display;
    }

    public static Gender fromName(String name) {
        if (name == null) {
            return UNKNOWN;
        }
        String normalized = name.toLowerCase(Locale.ROOT);
        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            if (normalized.equals(gender.getName()) || name.equals(gender.display)) {
                return gender;
            }
        }
        return UNKNOWN;
    }

    public String getName() {
        return name;
    }

    public String getDisplay() {
        return display;
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
                return RandomUtils.odd(bound);
            case FEMALE:
                return RandomUtils.even(bound);
            default:
                return RandomUtils.nextInt(bound);
        }
    }
}
