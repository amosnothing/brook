package cn.nothinghere.brook.util;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author amos
 */
public final class JsonPathUtils {

    @SuppressWarnings("unchecked")
    public static String randomPath(Object object, String... keys) {
        Object paths = allPaths(object, keys);
        if (paths instanceof List) {
            return RandomUtils.choice((List<String>) paths);
        } else {
            // 只找到单条记录
            return (String) paths;
        }
    }

    @SuppressWarnings("unchecked")
    public static Object randomValue(Object object, String... keys) {
        Object values = allValues(object, keys);
        if (values instanceof List) {
            // 可以找到多条记录 随机取一条
            // 比如[A, B, C]
            Object choice = RandomUtils.choice((List<Object>) values);
            // 另外一种情况：同一个key存在多个value的时候
            // 比如[[A, B], C , [D, E, F]]
            if (choice instanceof List) {
                return RandomUtils.choice((List<Object>) choice);
            } else {
                return choice;
            }
        } else {
            // 只找到单条记录
            return values;
        }
    }

    /**
     * 为确保 该键值对一定是匹配的
     * 需要把所有符号的条件的都查出来然后同时随机取一个
     * 有个地方需要注意下： 如果传入的 path 不存在，
     * 查找path方法会抛出异常
     * 查找value方法则会返回空数组
     *
     * @param object 被查找的对象
     * @param keys   多层级key 比如 key1.key2.key3...
     * @return 随机查到的键值对
     */
    @SuppressWarnings("unchecked")
    public static Map.Entry<String, Object> random(Object object, String... keys) {
        Objects.requireNonNull(object);
        Object paths = allPaths(object, keys);
        Object values = allValues(object, keys);
        if (paths instanceof List && values instanceof List) {
            int nextInt = RandomUtils.nextInt(((List<?>) paths).size());
            // 可以找到多条记录 随机取一条
            // 比如[A, B, C]
            Object choice = RandomUtils.choice((List<Object>) values);
            // 另外一种情况：同一个key存在多个value的时候
            // 比如[[A, B], C , [D, E, F]]
            if (choice instanceof List) {
                return new AbstractMap.SimpleEntry<>(((List<String>) paths).get(nextInt), RandomUtils.choice((List<Object>) choice));
            }

            return new AbstractMap.SimpleEntry<>(((List<String>) paths).get(nextInt), ((List<?>) values).get(nextInt));
        } else {
            // 只找到单条记录
            return new AbstractMap.SimpleEntry<>(String.valueOf(paths), values);
        }
    }

    public static <T> T allPaths(Object object, String... keys) {
        String path = toKey(keys);
        // 获取路径
        Configuration pathConfig = Configuration.builder().options(Option.AS_PATH_LIST).build();
        return JsonPath.using(pathConfig)
                .parse(object)
                .read(path);
    }

    public static <T> T allValues(Object object, String... keys) {
        String path = toKey(keys);
        // 获取数值
        return JsonPath.read(object, path);
    }

    private static String toKey(String... keys) {
        StringBuilder sb = new StringBuilder("$");
        for (String key : keys) {
            if (key == null) {
                sb.append(".*");
            } else {
                sb.append(".");
                sb.append(key);
            }
        }
        return sb.toString();
    }

    private JsonPathUtils() {
    }
}
