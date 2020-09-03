package cn.nothinghere;

import cn.nothinghere.factory.util.FileUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author chenjun
 * @date 2020/6/8 18:34
 */
public final class Factory {


    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Object> object = new Yaml().load(FileUtil.asInputStream("area.yaml"));
        System.out.println(object);
    }
}
