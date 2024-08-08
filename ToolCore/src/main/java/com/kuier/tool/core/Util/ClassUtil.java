package com.kuier.tool.core.Util;

/**
 * @ClassName ClassUtil
 * @Description ClassUtil 类处理相关工具类
 * @Author LiuQi
 * @Date 2024/8/8 12:02
 * @Version 1.0
 */
public class ClassUtil {
    /**
     * getTypeArgument 获得给定类的第一个泛型参数
     *
     * @param targetClass
     * @return {@link Class<?>}
     * @author LiuQi
     */
    public static Class<?> getTypeArgument(Class<?> targetClass) {
        return getTypeArgument(targetClass, 0);
    }

    /**
     * getTypeArgument 获得给定类的泛型参数
     *
     * @param targetClass
     * @param index
     * @return {@link Class<?>}
     * @author LiuQi
     */
    public static Class<?> getTypeArgument(Class<?> targetClass, int index) {
        return null;
    }

}
