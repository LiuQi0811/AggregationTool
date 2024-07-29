package com.kuier.tool.core.Map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SafeConcurrentHashMap
 * @Description SafeConcurrentHashMap 安全并发HashMap
 * @Author LiuQi
 * @Date 2024/7/29 11:38
 * @Version 1.0
 */
public class SafeConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
    /**
     * 参数构造
     *
     * @author LiuQi
     */
    public SafeConcurrentHashMap() {
        super();
    }
}
