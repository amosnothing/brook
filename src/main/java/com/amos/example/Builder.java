package com.amos.example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjun
 * @date 2020/6/11 8:29
 */
public class Builder {
    public final ReentrantLock LOCK = new ReentrantLock();
    static final Map<String, Object> PARAM_MAP = new ConcurrentHashMap<>();

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        PARAM_MAP.forEach((k, v) -> stringBuilder.append(v));
        String ret = stringBuilder.toString();
        clear();
        LOCK.unlock();
        return ret;
    }

    private void clear() {
        PARAM_MAP.clear();
    }
}
