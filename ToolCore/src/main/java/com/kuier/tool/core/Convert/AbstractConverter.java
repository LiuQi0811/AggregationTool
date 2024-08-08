package com.kuier.tool.core.Convert;

import com.kuier.tool.core.Util.ClassUtil;
import com.kuier.tool.core.Util.StrUtil;

import java.io.Serializable;
import java.util.Map;

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
        // 获取目标类型
        Class<T> classTargetType = getTargetType();
        if (null == defaultValue || classTargetType.isInstance(defaultValue)) { // 默认值参数为空或者 目标类型是默认值参数类型
            if (classTargetType.isInstance(value) && false == Map.class.isAssignableFrom(classTargetType)) {//  目标类型是被转换值参数类型 并且 目标类型非Map类的子类
                // 除Map外 已经是目标类型 不需要转换（Map类型涉及参数类型 需要单独转换）
                return classTargetType.cast(value);
            }
            // TODO 内部转换器 待优化.....
            convertInternal(value);
            return null;
        } else {
            throw new IllegalArgumentException(StrUtil.format("Default value [{}]({}) is not the instance of [{}]", defaultValue, defaultValue.getClass(), classTargetType));
        }
    }

    /**
     * getTargetType 获取目标类型
     *
     * @return {@link Class<T>}
     * @author LiuQi
     */
    private Class<T> getTargetType() {
        // 返回 获取给定类的第一个泛型参数的目标类型
        return ((Class<T>) ClassUtil.getTypeArgument(getClass()));
    }
}
