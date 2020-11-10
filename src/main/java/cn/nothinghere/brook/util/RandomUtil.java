package cn.nothinghere.factory.util;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author amos.chenj@outlook.com
 */
public final class RandomUtil {

    private RandomUtil() {
    }

    /**
     * 根据value的数值（权重），返回因权重选中键值对的value
     *
     * @param originMap
     * @param <K>
     * @return
     */
    public static <K> K choice(Map<K, Integer> originMap) {
        TreeMap<Double, K> weightMap = new TreeMap<>();

        AtomicReference<Double> i = new AtomicReference<>(0D);
        originMap.forEach(
                (k, v) -> weightMap.put((i.updateAndGet(v1 -> v1 + v)), k));

        double randomWeight = weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = weightMap.tailMap(randomWeight, false);
        return weightMap.get(tailMap.firstKey());
    }

    /**
     * 集合随机取值
     *
     * @param tList 集合
     * @param <T>   集合类型
     * @return 集合当中随机的某几个数值
     */
    public static <T> List<T> choice(List<T> tList, int count) {
        if (count > tList.size() || count <= 0) {
            throw new IllegalArgumentException("选取的元素个数必须为正数且不能大于源列表长度");
        }
        Collections.shuffle(tList);
        return tList.stream().limit(count).collect(Collectors.toList());
    }

    /**
     * 集合随机取值
     *
     * @param tList 集合
     * @param <T>   集合类型
     * @return 集合当中随机的某一个数值
     */
    public static <T> T choice(List<T> tList) {
        return tList.get(new SecureRandom().nextInt(tList.size()));
    }

    /**
     * 集合随机取值
     *
     * @param tSet 集合
     * @param <T>  集合类型
     * @return 集合当中随机的某几个数值
     */
    public static <T> Set<T> choice(Set<T> tSet, int count) {
        if (count > tSet.size() || count <= 0) {
            throw new IllegalArgumentException("选取的元素个数必须为正数且不能大于源列表长度");
        }
        List<T> list = new ArrayList<>(tSet);
        Collections.shuffle(list);
        List<T> choice = choice(list, count);
        return new HashSet<>(choice);
    }

    /**
     * 集合随机取值
     *
     * @param tSet 集合
     * @param <T>  集合类型
     * @return 集合当中随机的某一个数值
     */
    public static <T> T choice(Set<T> tSet) {
        List<T> list = new ArrayList<>(tSet);
        Collections.shuffle(list);
        return choice(list);
    }

    /**
     * 数组随机取值
     *
     * @param tArray 数据
     * @param <T>    数组类型
     * @return 数组当中随机的某几个数值
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] choice(T[] tArray, int count) {
        if (tArray.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        if (count < 1) {
            throw new IllegalArgumentException("选取的数目必须为正数");
        }
        // 当数组的长度不大于选取数目时 直接返回该数组本身
        if (tArray.length <= count) {
            return tArray;
        }
        List<T> choiceList = choice(Arrays.asList(tArray), count);
        T[] t = (T[]) Array.newInstance(tArray.getClass().getComponentType(), choiceList.size());
        for (int i = 0; i < choiceList.size(); i++) {
            t[i] = choiceList.get(i);
        }
        return t;
    }


    /**
     * 数组随机取值
     *
     * @param tArray 数据
     * @param <T>    数组类型
     * @return 集合当中随机的某一个数值
     */
    public static <T> T choice(T[] tArray) {
        return tArray[(new SecureRandom().nextInt(tArray.length))];
    }

    public static <K, V> V choiceV(Map<K, V> kvMap) {
        return kvMap.get(choiceK(kvMap));
    }

    public static <K, V> K choiceK(Map<K, V> kvMap) {
        Set<K> keySet = kvMap.keySet();
        return RandomUtil.choice(keySet);
    }

    /**
     * 1 = 0000 0001
     * 最后一位总是被置为1，前面几位不变
     *
     * @param bound 数字上届（不包含），必须为正数
     * @return 随机奇数
     */
    public static int odd(int bound) {
        return new SecureRandom().nextInt(bound) | 1;
    }

    /**
     * -2 = 1111 1110
     * 最后一位总是被置为0，前面几位不改变
     *
     * @param bound 数字上届（不包含），必须为正数
     * @return 随机偶数 + 0
     */
    public static int even(int bound) {
        return new SecureRandom().nextInt(bound) & -2;
    }

    public static int nextInt(int bound) {
        return new SecureRandom().nextInt(bound);
    }

    public static int nextInt(int startInclude, int endExclude) {
        return new SecureRandom().nextInt(endExclude - startInclude) + startInclude;
    }


}
