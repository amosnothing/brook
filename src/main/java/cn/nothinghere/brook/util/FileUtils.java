package cn.nothinghere.brook.util;

import java.io.InputStream;

/**
 * @author amos.chenj@outlook.com
 */
public class FileUtils {

    public static InputStream asInputStream(String fileName) {
        return FileUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

    private FileUtils() {
    }
}
