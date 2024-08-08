package com.kuier.tool.core.Convert;

import com.kuier.tool.core.Util.TypeUtil;

import java.io.Serializable;

/**
 * @ClassName AbstractConverter
 * @Description AbstractConverter 转换器抽象类
 * @Author LiuQi
 * @Date 2024/8/8 10:54
 * @Version 1.0
 */
public abstract class AbstractConverter<T> implements Converter<T>, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * convertInternal 内部转换器
     *
     * @param value
     * @return {@link T}
     * @author LiuQi
     */
    protected abstract T convertInternal(Object value);

    @Override
    public T convert(Object value, T defaultValue) throws IllegalArgumentException {
        System.out.println(" ... " + value);
        System.out.println(" ... " + defaultValue);
        System.out.println("?????? Convert Any");
        // 获取目标类型
        Class<T> targetType = getTargetType();
        // 内部转换器
        convertInternal(value);
        return null;
    }

    /**
     * getTargetType 获取目标类型
     *
     * @return {@link Class<T>}
     * @author LiuQi
     */
    private Class<T> getTargetType() {
        System.out.println(" getTargetType 获取目标类型  " + getClass());
        TypeUtil.toParameterizedType(getClass());
        return null;
    }
}
