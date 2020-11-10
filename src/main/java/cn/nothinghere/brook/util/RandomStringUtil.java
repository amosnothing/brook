package cn.nothinghere.brook.util;

import java.util.Arrays;

/**
 * @author amos.chenj@outlook.com
 */
public final class RandomStringUtil {

    public static String numeric(int count) {
        return random(count, false, true);
    }

    /**
     * 字符数字混合
     *
     * @return
     */
    public static String alphanumeric(int count) {
        return random(count, true, true);
    }

    public static String alphabetic(int count) {
        return random(count, true, false);
    }

    private static String random(int count, boolean letter, boolean number) {

        Character[] upperLetterChars = fromTo('A', 'Z');
        Character[] lowerLetterChars = fromTo('a', 'z');
        Character[] numberChars = fromTo('0', '9');

        Character[] chars;
        if (letter && number) {
            chars = concat(upperLetterChars, lowerLetterChars, numberChars);
        } else if (letter) {
            chars = concat(upperLetterChars, lowerLetterChars);
        } else {
            chars = numberChars;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(RandomUtil.choice(chars));
        }
        return builder.toString();
    }

    private static Character[] fromTo(char from, char to) {
        if (from > to) {
            throw new IllegalArgumentException("from (" + from + ") must be less than to (" + to + ")");
        }
        Character[] chars = new Character[to - from + 1];
        for (char i = 0; i <= to - from; i++) {
            chars[i] = (char) (from + i);
        }
        return chars;
    }

    private static <T> T[] concat(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}