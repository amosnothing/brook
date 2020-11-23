package cn.nothinghere.brook.value.human;

import cn.nothinghere.brook.Field;
import cn.nothinghere.brook.Randomize;
import cn.nothinghere.brook.util.RandomUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author amos.chenj@outlook.com
 */
public class Birthday implements Field, Randomize, Serializable {

    private static final long serialVersionUID = -1964418712492743885L;

    private static final int MIN_AGE = 18;
    /**
     * 根据wiki：https://zh.wikipedia.org/wiki/中国大陆人口
     * 预期寿命	76.34岁（2015年国家统计局抽样）
     * • 男性	73.64岁（2015年国家统计局抽样）
     * • 女性	79.43岁（2015年国家统计局抽样）
     */
    private static final int MAX_AGE = 80;

    private LocalDate birth;

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setBirth(String birth) {
        this.birth = LocalDate.parse(birth, DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static LocalDate choiceByAge(int age) {
        return choiceByAge(age, age + 1);
    }

    /**
     * @param startAgeInclude 起始年龄 包含，亦是说生成的年龄一定是大於等於此年龄
     * @param endAgeExclude   结束年龄 不包含
     * @return 在起始年龄 ~ 结束年龄范围内的证件号码
     */
    public static LocalDate choiceByAge(int startAgeInclude, int endAgeExclude) {
        if (startAgeInclude <= 0 || endAgeExclude <= 0) {
            throw new IllegalArgumentException("起始年龄和结束年龄必须为正数");
        }
        if (startAgeInclude >= endAgeExclude) {
            throw new IllegalArgumentException("结束年龄不允许小于等于起始年龄");
        }

        LocalDate now = LocalDate.now();
        // 刚好满足结束年龄的起始日期，不可以取，再往后推一天
        LocalDate startDate = now.plusYears(-endAgeExclude).plusDays(1L);
        // 刚好满足开始年龄的结束日期，可以取
        LocalDate endDate = now.plusYears(-startAgeInclude);
        // 最后一天取不到，需要另外加一天
        return randomDate(startDate, endDate.plusDays(1));
    }

    private static LocalDate randomDate(LocalDate startInclude, LocalDate endExclude) {
        long interval = DAYS.between(startInclude, endExclude);
        // 一般而言，传入的年龄相差不会超过int的最大值
        return startInclude.plusDays(RandomUtils.nextInt((int) interval));
    }

    @Override
    public String asString() {
        return DateTimeFormatter.BASIC_ISO_DATE.format(this.birth);
    }

    @Override
    public void randomIfNull() {
        if (this.getBirth() == null) {
            this.setBirth(choiceByAge(MIN_AGE, MAX_AGE + 1));
        }
    }
}
