package cn.nothinghere.brook.util;

import java.io.*;
import java.net.URL;
import java.text.MessageFormat;

/**
 * @author amos.chenj@outlook.com
 */
public class FileUtil {

    public static File fileInResourceInstance(String fileName) {

        URL url = FileUtil.class.getClassLoader().getResource(fileName);
        if (null == url) {
            throw new IllegalArgumentException(MessageFormat.format("file-[{0}] not found", fileName));
        }
        return new File(url.getPath());
    }


    public static BufferedReader asBufferedReader(String fileName) throws FileNotFoundException {
        File file = fileInResourceInstance(fileName);
        return new BufferedReader(new FileReader(file));
    }

    public static InputStream asInputStream(String fileName) throws FileNotFoundException {
        File file = fileInResourceInstance(fileName);
        return new FileInputStream(file);
    }

}
