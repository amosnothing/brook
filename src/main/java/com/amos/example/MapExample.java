package com.amos.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenjun
 * @date 2020/6/15 10:14
 */
public class MapExample {

    static final Map<String, String> PARAM_MAP = new ConcurrentHashMap<>();

    public MapExample withObj(String obj) {
        PARAM_MAP.put("obj", obj);
        return this;
    }

    public String build() {
        String str = PARAM_MAP.get("obj");
        clear();
        return str;
    }

    private void clear() {
        PARAM_MAP.clear();
    }
}
