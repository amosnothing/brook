package cn.nothinghere.brook.util;

import org.yaml.snakeyaml.Yaml;

/**
 * @author amos.chenj@outlook.com
 */
public final class YamlUtils {

    private YamlUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T load(String fileName) {
        Object object = new Yaml().load(FileUtils.asInputStream(fileName));
        return (T) object;
    }
}
