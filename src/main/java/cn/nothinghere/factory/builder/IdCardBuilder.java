package cn.nothinghere.factory.builder;

import cn.nothinghere.factory.BaseArea;
import cn.nothinghere.factory.Birthday;
import cn.nothinghere.factory.Builder;
import cn.nothinghere.factory.Gender;
import cn.nothinghere.factory.util.RandomUtil;
import cn.nothinghere.factory.util.YamlUtil;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static cn.nothinghere.factory.Birthday.BIRTHDAY_FORMAT;
import static cn.nothinghere.factory.Birthday.getByAge;

/**
 * @author amos
 */
public final class IdCardBuilder implements Builder {

    private Area area = new Area();
    private Birthday birthday = new Birthday();
    private Gender gender = new Gender();

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
        String birth = getByAge(age, age + 1);
        birthday.setYear(birth.substring(0, 4));
        birthday.setMonth(birth.substring(4, 6));
        birthday.setDay(birth.substring(6));
        return this;
    }

    public IdCardBuilder withGender(String genderStr) {
        gender.setGender(genderStr);
        return this;
    }

    public IdCardBuilder withAge(int beginAgeInclude, int endAgeExclude) {
        if (beginAgeInclude >= endAgeExclude) {
            throw new IllegalArgumentException("结束年龄必须大于起始年龄");
        }
        if (endAgeExclude <= 0 || beginAgeInclude <= 0) {
            throw new IllegalArgumentException("起始年龄/结束年龄必须都是正数");
        }
        String birth = getByAge(beginAgeInclude, endAgeExclude);
        birthday.setYear(birth.substring(0, 4));
        birthday.setMonth(birth.substring(4, 6));
        birthday.setDay(birth.substring(6));
        return this;
    }

    public IdCardBuilder withBirthday(final String birth) {
        Objects.requireNonNull(birth, "birthday");
        // 对传入的生日格式进行解析判断
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(BIRTHDAY_FORMAT);
            dateFormat.parse(birth);
        } catch (ParseException e) {
            throw new IllegalArgumentException(MessageFormat.format("生日[{0}]格式有误，需要符合[{1}]", birth, BIRTHDAY_FORMAT));
        }
        birthday.setYear(birth.substring(0, 4));
        birthday.setMonth(birth.substring(4, 6));
        birthday.setDay(birth.substring(6));
        return this;
    }


    @Override
    public String build() {
        return area.asCode() + birthday.asString() + gender.asCode() + "校验码--等待实现";
    }

    /**
     * 分析一下有可能的传参情况：
     * 1.有传入省/市/区，则根据传入的返回，如果没有与传参对应的结果，则抛出异常
     * 2.只传省，则找到对应的省，没有则抛出异常，若有则省下属市随机，再在市下属区域随机
     * 3.只传省市，则找到对应的省、市，没有则抛出异常，若有再在下属区域随机，
     * 4.省也没有传，省市区全部随机
     */
    private static class Area extends BaseArea {

        private final static Map<String, Object> AREA_MAP = Collections.unmodifiableMap(YamlUtil.load("area.yaml"));

        @Override
        public String asCode() {
            return null;
        }

        @Override
        public String asString() {
            return this.getProvince() + this.getCity() + this.getDistrict();
        }

        @Override
        @SuppressWarnings("unchecked")
        public void random() {
            String provinceKey = this.getProvince();
            String cityKey = this.getCity();
            String districtKey = this.getDistrict();

            if (null == provinceKey) {
                Set<String> provinceKeys = AREA_MAP.keySet();
                provinceKey = RandomUtil.choice(provinceKeys);
                this.setProvince(provinceKey);

            }



        }

        @Override
        @SuppressWarnings("unchecked")
        public void verify() {
            String provinceKey = this.getProvince();
            String cityKey = this.getCity();
            String districtKey = this.getDistrict();
            // 校验 省 字段
            if (null == provinceKey) {
                return;
            }
            Map<String, Object> provinceMap = (Map<String, Object>) AREA_MAP.get(provinceKey);
            if (null == provinceMap) {
                throw new IllegalArgumentException(MessageFormat.format("No {0} province in Chinese Mainland.", provinceKey));
            }
            // 校验 市 字段
            if (null == cityKey) {
                return;
            }
            Map<String, Object> cityMap = (Map<String, Object>) provinceMap.get(cityKey);
            if (null == cityMap) {
                throw new IllegalArgumentException(MessageFormat.format("No {0} in {1}.", cityKey, provinceKey));
            }
            // 校验 区 字段
            if (null == districtKey) {
                return;
            }
            Map<String, Object> districtMap = (Map<String, Object>) cityMap.get(districtKey);
            if (null == districtMap) {
                throw new IllegalArgumentException(MessageFormat.format("No {0} in {1}-{2}.", districtKey, cityKey, provinceKey));
            }
        }
    }
}
