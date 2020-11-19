package cn.nothinghere.brook.util;

import java.io.InputStream;

/**
 * @author amos.chenj@outlook.com
 */
public class FileUtil {

    public static InputStream asInputStream(String fileName) {
        return FileUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    private FileUtil() {
    }
}
