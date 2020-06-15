package com.amos.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenjun
 * @date 2020/6/8 11:52
 */
class BaseBuilder {

    static final Map<String, Object> PARAM_MAP = new ConcurrentHashMap<>();

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        PARAM_MAP.forEach((k, v) -> stringBuilder.append(v));
        String ret = stringBuilder.toString();
        clear();
        return ret;
    }

    private void clear() {
        PARAM_MAP.clear();
    }
}
