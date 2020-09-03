package cn.nothinghere.factory;

import cn.nothinghere.factory.util.RandomUtil;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author amos
 */
public class Birthday implements Attribute {

    private String year;
    private String month;
    private String day;
    public static final String BIRTHDAY_FORMAT = "yyyyMMdd";

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @param startAge 起始年龄 包含，亦是说生成的年龄一定是>=此年龄
     * @param endAge   结束年龄 不包含
     * @return 在起始年龄 ~ 结束年龄范围内的证件号码
     */
    public static String getByAge(int startAge, int endAge) {

        if (startAge <= 0 || endAge <= 0) {
            throw new IllegalArgumentException("起始年龄和结束年龄必须为正数");
        }
        if (startAge >= endAge) {
            throw new IllegalArgumentException("结束年龄不允许小于等于起始年龄");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(BIRTHDAY_FORMAT);
        // 计算出日历范围， 该范围要求：
        // 日历的起始 = 当前日历 - endAge
        // 日历的结尾 = 当前日历 - beginAge
        Calendar beginCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        beginCal.setTime(new Date());
        endCal.setTime(new Date());
        beginCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR) - endAge);
        endCal.set(Calendar.YEAR, endCal.get(Calendar.YEAR) - startAge);

        Calendar scaleCal = (Calendar) beginCal.clone();
        List<Calendar> calendars = new ArrayList<>();
        // 保证效率的前提下，不把每个日期都遍历，暂时只遍历在日历范围内的所有年份+月份
        while (endCal.after(scaleCal)) {
            final Calendar cal = (Calendar) scaleCal.clone();
            calendars.add(cal);
            scaleCal.set(Calendar.MONTH, scaleCal.get(Calendar.MONTH) + 1);
        }
        // 第一个日历不取 ， 因为它刚好 = 起始日期
        calendars.remove(0);
        Calendar randomCal = RandomUtil.choice(calendars);
        // 日期随机赋值
        randomCal.set(Calendar.DATE, new SecureRandom().nextInt(31));
        // 有一定概率会出现随机到的数据超过日历的范围
        // 则重新获取
        while (randomCal.before(beginCal) || randomCal.after(endCal)) {
            randomCal = RandomUtil.choice(calendars);
        }
        return sdf.format(randomCal.getTime());
    }


    @Override
    public String asString() {
        return this.year + this.month + this.day;
    }
}
