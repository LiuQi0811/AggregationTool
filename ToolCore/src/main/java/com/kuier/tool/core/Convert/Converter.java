package com.kuier.tool.core.Convert;

/**
 * @ClassName Converter
 * @Description Converter 转换器接口 实现类型转换
 * @Author LiuQi
 * @Date 2024/8/7 17:44
 * @Version 1.0
 */
public interface Converter<T> {
    /**
     * convert 转换为指定类型
     *
     * @param value
     * @param defaultValue
     * @return {@link T}
     * @throws IllegalArgumentException
     */
    T convert(Object value, T defaultValue) throws IllegalArgumentException;
}
