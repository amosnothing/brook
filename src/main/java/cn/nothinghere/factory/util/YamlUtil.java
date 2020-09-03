package cn.nothinghere.factory.util;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;

/**
 * @author amos
 */
public class YamlUtil {

    @SuppressWarnings("unchecked")
    public static  <T> T load(String fileName) {
        Object object;
        try {
            object = new Yaml().load(FileUtil.asInputStream(fileName));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("传入的文件不存在");
        }
        return (T) object;
    }
}
