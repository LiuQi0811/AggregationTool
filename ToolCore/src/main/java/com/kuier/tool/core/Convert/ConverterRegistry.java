package com.kuier.tool.core.Convert;

import com.kuier.tool.core.Util.ObjUtil;
import com.kuier.tool.core.Util.TypeUtil;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Optional;

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
        return convert(type, value, defaultValue, true);
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
        if (TypeUtil.isUnknown(type) && null == defaultValue) { // 类型参数是未知类型 并且默认值为空
            // 不指定目标类型的情况 返回原值
            return ((T) value);
        }
        if (ObjUtil.isNull(value)) { // 被转换值为空
            // 返回默认值
            return defaultValue;
        }
        if (TypeUtil.isUnknown(type)) { // 类型参数是未知类型
            // 类型参数赋值默认值原始类
            type = defaultValue.getClass();
        }
        if (value instanceof Optional) { // 被转换值是Optional类型
            // TODO 被转换值是Optional类型
        }
        // TODO other type .....
        // 获取标准转换器
        Converter<T> converter = getConverter(type, isCustomFirst);
        return null;
    }

    /**
     * getConverter 获取转换器
     *
     * @param type
     * @param isCustomFirst
     * @param <T>
     * @return {@link Converter<T>}
     * @author LiuQi
     */
    public <T> Converter<T> getConverter(Type type, boolean isCustomFirst) {
        // 转换器接口声明
        Converter<T> converter;
        if (isCustomFirst) { // 优先使用自定义转换器
            // 获取自定义转换器
            converter = getCustomConverter(type);
        } else {
            // 获取默认转换器
            // TODO 获取默认转换器
            converter = null;
        }
        // 返回转换器接口
        return converter;
    }

    /**
     * getCustomConverter 获取自定义转换器
     *
     * @param type
     * @param <T>
     * @return {@link  Converter<T>}
     * @author LiuQi
     */
    public <T> Converter<T> getCustomConverter(Type type) {
        return null;
    }

}
