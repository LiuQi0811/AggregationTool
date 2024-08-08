package com.kuier.tool.core.Convert;

import java.lang.reflect.Type;

/**
 * @ClassName Convert
 * @Description Convert 类型转换器
 * @Author LiuQi
 * @Date 2024/8/7 14:30
 * @Version 1.0
 */
public class Convert {
    /**
     * toStr 转换为字符串
     *
     * @param data
     * @return {@link String}
     * @author LiuQi
     */
    public static String toStr(Object data) {
        // 转换为字符串处理
        return toStr(data, null);
    }

    /**
     * toStr 转换为字符串
     *
     * @param value
     * @param defaultValue
     * @return {@link String}
     * @author LiuQi
     */
    public static String toStr(Object value, String defaultValue) {
        // 转换值为指定类型 可选是否不抛异常转换
        return convertQuietly(String.class, value, defaultValue);
    }

    /**
     * convertQuietly 转换值为指定类型 可选是否不抛异常转换
     *
     * @param type
     * @param value
     * @param defaultValue
     * @param <T>
     * @return
     */
    public static <T> T convertQuietly(Type type, Object value, T defaultValue) {
        // 转换值为指定类型 可选是否不抛异常转换
        return convertWithCheck(type, value, defaultValue, true);
    }

    /**
     * convertWithCheck 转换值为指定类型 可选是否不抛异常转换
     *
     * @param type
     * @param value
     * @param defaultValue
     * @param quietly
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public static <T> T convertWithCheck(Type type, Object value, T defaultValue, boolean quietly) {
        // 获取ConverterRegistry 单例实例
        ConverterRegistry registry = ConverterRegistry.getInstance();
        try {
            // 返回转换值为指定类型
            return registry.convert(type, value, defaultValue);
        } catch (Exception e) {
            if (quietly) { // 静默转换 true不抛异常
                // 返回默认值
                return defaultValue;
            }
            // 抛出RuntimeException 异常
            throw new RuntimeException(e);
        }
    }
}
