package cn.nothinghere.brook.util;

import org.yaml.snakeyaml.Yaml;

/**
 * @author amos.chenj@outlook.com
 */
public class YamlUtil {

    private YamlUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T load(String fileName) {
        Object object;
        object = new Yaml().load(FileUtil.asInputStream(fileName));
        return (T) object;
    }
}
