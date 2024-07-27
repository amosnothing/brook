package cn.nothinghere.brook.builder;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import cn.nothinghere.brook.Builder;
import cn.nothinghere.brook.util.RandomUtils;
import cn.nothinghere.brook.value.human.Birthday;
import cn.nothinghere.brook.value.human.Gender;
import cn.nothinghere.brook.value.region.Area;
import cn.nothinghere.brook.value.region.City;
import cn.nothinghere.brook.value.region.Province;

import static cn.nothinghere.brook.value.human.Birthday.choiceByAge;

/**
 * @author amos.chenj@outlook.com
 */
public final class IdCardBuilder implements Builder {

    /**
     * 身份证的最大长度
     */
    private static final int ID_CARD_MAX_LENGTH = 18;
    private final Area area;
    private final Birthday birthday;
    private Gender gender = Gender.UNKNOWN;

    IdCardBuilder() {
        this.area = new Area();
        this.birthday = new Birthday();
    }

    /**
     * @return self
     */
    public static IdCardBuilder of() {
        return new IdCardBuilder();
    }

    public IdCardBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        this.area.setProvince(province);
        return this;
    }

    public IdCardBuilder withProvince(Province province) {
        Objects.requireNonNull(province, "province");
        this.area.setProvince(province.getName());
        return this;
    }

    public IdCardBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        this.area.setCity(city);
        return this;
    }

    public IdCardBuilder withCity(City city) {
        Objects.requireNonNull(city, "city");
        this.area.setCity(city.getName());
        return this;
    }

    public IdCardBuilder withDistrict(String district) {
        Objects.requireNonNull(district, "district");
        this.area.setDistrict(district);
        return this;
    }

    public IdCardBuilder withAge(int age) {
        final LocalDate birth = choiceByAge(age, age + 1);
        this.birthday.setBirth(birth);
        return this;
    }


    public IdCardBuilder withAge(int beginAgeInclude, int endAgeExclude) {
        final LocalDate birth = choiceByAge(beginAgeInclude, endAgeExclude);
        this.birthday.setBirth(birth);
        return this;
    }

    /**
     * @param birth 必须满足 ： yyyyMMdd
     *
     * @return IdCardBuilder
     */
    public IdCardBuilder withBirthday(final String birth) {
        Objects.requireNonNull(birth, "birthday");
        try {
            this.birthday.setBirth(birth);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("日期格式不符合yyyyMMdd格式");
        }
        return this;
    }

    public IdCardBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public IdCardBuilder withGender(String gender) {
        this.gender = Gender.fromName(gender);
        return this;
    }

    /**
     * 比如说同一个地区两个人是同年同月同日出生
     * 那么其中一个序号就是01，下一个就是02，以此类推
     *
     * @return 身份证序号
     */
    private static String serialNo() {
        int no = RandomUtils.nextInt(1, 100);
        String noStr = String.valueOf(no);
        return noStr.length() == 2 ? noStr : 0 + noStr;
    }

    private static char calcTrailingNumber(char[] chars) {
        if (chars.length < ID_CARD_MAX_LENGTH - 1) {
            return ' ';
        }
        int[] c = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] r = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        return r[result % 11];
    }

    @Override
    public String build() {
        this.area.verify();
        String areaCode = this.area.asCode();
        this.birthday.randomIfNull();
        String birth = this.birthday.asString();
        String serialNo = serialNo();
        String genderCode = this.gender.asCode().toString();

        String uncheckedCode = areaCode + birth + serialNo + genderCode;
        return uncheckedCode + calcTrailingNumber(uncheckedCode.toCharArray());
    }
}
