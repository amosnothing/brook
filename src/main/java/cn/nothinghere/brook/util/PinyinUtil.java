package cn.nothinghere.factory.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 中文转拼音
 *
 * @author amos.chenj@outlook.com
 */
public class PinyinUtil {

    public static String toPinyin(String chineseOrEnglish) {
        StringBuilder pinyinStr = new StringBuilder();
        char[] newChar = chineseOrEnglish.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        for (char aNewChar : newChar) {
            if (aNewChar > 128) {
                try {
                    pinyinStr.append(PinyinHelper.toHanyuPinyinStringArray(aNewChar, defaultFormat)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr.append(aNewChar);
            }
        }
        return pinyinStr.toString();
    }

}
