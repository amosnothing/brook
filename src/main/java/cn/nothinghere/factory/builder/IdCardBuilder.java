package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.util.RandomUtil;
import cn.nothinghere.factory.value.Area;
import cn.nothinghere.factory.value.Birthday;
import cn.nothinghere.factory.value.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import static cn.nothinghere.factory.value.Birthday.choiceByAge;

/**
 * @author amos
 */
public final class IdCardBuilder implements Builder {

    /**
     * 身份证的最大长度
     */
    private static final int ID_CARD_MAX_LENGTH = 18;
    private final Area area = new Area();
    private final Birthday birthday = new Birthday();
    private Gender gender = Gender.UNKNOWN;

    protected IdCardBuilder(){}

    public IdCardBuilder withProvince(String province) {
        Objects.requireNonNull(province, "province");
        area.setProvince(province);
        return this;
    }

    public IdCardBuilder withCity(String city) {
        Objects.requireNonNull(city, "city");
        area.setCity(city);
        return this;
    }

    public IdCardBuilder withDistrict(String district) {
        Objects.requireNonNull(district, "district");
        area.setDistrict(district);
        return this;
    }

    public IdCardBuilder withAge(int age) {
        LocalDate birth = choiceByAge(age, age + 1);
        birthday.setBirth(birth);
        return this;
    }


    public IdCardBuilder withAge(int beginAgeInclude, int endAgeExclude) {
        LocalDate birth = choiceByAge(beginAgeInclude, endAgeExclude);
        birthday.setBirth(birth);
        return this;
    }

    /**
     * @param birth 必须满足 ： yyyyMMDD
     * @return
     */
    public IdCardBuilder withBirthday(final String birth) {
        Objects.requireNonNull(birth, "birthday");
        try {
            birthday.setBirth(birth);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("日期格式不符合yyyyMMdd格式 或者 传参日期有误");
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
     * @return 身份证序号
     */
    private static String serialNo() {
        int no = RandomUtil.nextInt(1, 100);
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
        this.area.randomIfNull();
        String areaCode = this.area.asCode();
        this.birthday.randomIfNull();
        String birth = this.birthday.asString();

        String serialNo = serialNo();
        String genderCode = this.gender.asCode().toString();

        String uncheckedCode = areaCode + birth + serialNo + genderCode;
        return uncheckedCode + calcTrailingNumber(uncheckedCode.toCharArray());
    }
}
