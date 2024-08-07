package com.kuier.tool.core.Util;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @ClassName TypeUtil
 * @Description TypeUtil 参数和返回值类型相关 工具类
 * @Author LiuQi
 * @Date 2024/8/7 16:09
 * @Version 1.0
 */
public class TypeUtil {
    /**
     * isUnknown 是否为未知类型
     *
     * @param type
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static Boolean isUnknown(Type type) {
        // 类型参数为空 或者 类型参数是 TypeVariable 返回true 则返回false
        return null == type || type instanceof TypeVariable;
    }

    /**
     * getClass 获取Type对应的映射类
     *
     * @param type
     * @return {@link Class<?>}
     * @author LiuQi
     */
    public static Class<?> getClass(Type type) {
        if (null != type) { // 类型参数不为空
            if (type instanceof Class) { // 类型参数是Class
                // 返回 类型参数类型
                return ((Class<?>) type);
            }
            // TODO other type .....
        }
        return null;
    }
}
