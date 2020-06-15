package com.amos.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenjun
 * @date 2020/6/11 8:29
 */
public class Builder {

    static final Map<String, Object> PARAM_MAP = new ConcurrentHashMap<>();

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        PARAM_MAP.forEach((k, v) -> stringBuilder.append(v));
        String ret = stringBuilder.toString();
        clear();
        return ret;
    }

    public Builder withStr(String str) {
        PARAM_MAP.put("key", str);
        return this;
    }

    private void clear() {
        PARAM_MAP.clear();
    }
}
