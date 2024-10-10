package com.kuier.tool.core.Util;

import com.kuier.tool.core.Lang.ClassScanner;
import com.kuier.tool.core.Lang.Filter;

import java.lang.reflect.Type;

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
        // 返回获得给定类的泛型参数
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
        // 获得给定类的泛型参数
        Type argumentType = TypeUtil.getTypeArgument(targetClass, index);
        // 返回 获取Type对应的映射类类型
        return TypeUtil.getClass(argumentType);
    }

    /**
     * getClassLoader 获取ClassLoader 类加载器
     *
     * @return {@link ClassLoader}
     * @author LiuQi
     */
    public static ClassLoader getClassLoader() {
        // 返回 获取类加载器
        return ClassLoaderUtil.getClassLoader();
    }

    /**
     * scannerPackage 扫描包
     * @param packageName 包名
     * @param classFilter 类过滤器
     * @author LiuQi
     */
    public static void scannerPackage(String packageName, Filter<Class<?>> classFilter){
        // 扫描包
         ClassScanner.scannerPackage(packageName, classFilter);
    }

}
