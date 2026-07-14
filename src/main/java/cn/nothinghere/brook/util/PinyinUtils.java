package cn.nothinghere.brook.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Objects;

/**
 * 中文转拼音
 *
 * @author amos.chenj@outlook.com
 */
public final class PinyinUtils {

    public static String toPinyin(String chineseOrEnglish) {
        Objects.requireNonNull(chineseOrEnglish, "chineseOrEnglish");
        StringBuilder pinyinStr = new StringBuilder();
        char[] newChar = chineseOrEnglish.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        for (char aNewChar : newChar) {
            if (aNewChar > 128) {
                try {
                    String[] result = PinyinHelper.toHanyuPinyinStringArray(aNewChar, defaultFormat);
                    pinyinStr.append(result == null || result.length == 0 ? aNewChar : result[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    throw new IllegalStateException("拼音转换失败: " + aNewChar, e);
                }
            } else {
                pinyinStr.append(aNewChar);
            }
        }
        return pinyinStr.toString();
    }

    private PinyinUtils() {
    }
}
