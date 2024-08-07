package com.kuier.tool.core.Convert;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * @ClassName ConverterRegistry
 * @Description ConverterRegistry 转换器登记中心
 * @Author LiuQi
 * @Date 2024/8/7 15:02
 * @Version 1.0
 */
public class ConverterRegistry implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * SingletonHolder 内部类实现单例 只有被调用到才会装载 从而实现了延迟加载
     *
     * @author LiuQi
     */
    private static class SingletonHolder {
        /**
         * ConverterRegistry实例 静态初始化器 由JVM来保证线程安全
         */
        private static final ConverterRegistry INSTANCE = new ConverterRegistry();
    }

    /**
     * getInstance 获得单例的 ConverterRegistry
     *
     * @return {@link ConverterRegistry}
     * @author LiuQi
     */
    public static ConverterRegistry getInstance() {
        // 延迟加载 调用getInstance时才会装载
        return SingletonHolder.INSTANCE;
    }

    /**
     * convert 转换值为指定类型
     *
     * @param type
     * @param value
     * @param defaultValue
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public <T> T convert(Type type, Object value, T defaultValue) {
        // 转换值为指定类型（含是否自定义转换器优先）
        return convert(type, value, defaultValue, false);
    }

    /**
     * convert 转换值为指定类型（含是否自定义转换器优先）
     *
     * @param type
     * @param value
     * @param defaultValue
     * @param isCustomFirst
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public <T> T convert(Type type, Object value, T defaultValue, boolean isCustomFirst) {

        return null;
    }

}
