package cn.nothinghere.brook.util;

import java.io.InputStream;
import java.util.Objects;

/**
 * @author amos.chenj@outlook.com
 */
public final class FileUtils {

    public static InputStream asInputStream(String fileName) {
        Objects.requireNonNull(fileName, "fileName");
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("资源文件不存在: " + fileName);
        }
        return inputStream;
    }

    private FileUtils() {
    }
}
