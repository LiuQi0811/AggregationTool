package com.kuier.tool.core.Util;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * @ClassName ServiceLoaderUtil
 * @Description ServiceLoaderUtil 服务加载工具类
 * @Author LiuQi
 * @Date 2024/7/29 13:33
 * @Version 1.0
 */
public class ServiceLoaderUtil {

    /**
     * loadFirstAvailable 加载第一个可用的服务
     *
     * @param clazz
     * @param <T>
     * @return {@link T}
     */
    public static <T> T loadFirstAvailable(Class<T> clazz) {
        Iterator<T> iterator = loader(clazz).iterator();
        while (iterator.hasNext()) {
            try {
                return iterator.next();
            } catch (ServiceConfigurationError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * load 加载服务
     *
     * @param <T>
     * @return {@link ServiceLoader<T>}
     * @author LiuQi
     */
    public static <T> ServiceLoader<T> loader(Class<T> clazz) {
        return loader(clazz, null);
    }

    /**
     * load 加载服务
     *
     * @param clazz
     * @param loader
     * @param <T>
     * @return {@link ServiceLoader<T>}
     * @author LiuQi
     */
    public static <T> ServiceLoader<T> loader(Class<T> clazz, ClassLoader loader) {
        // 类加载为空 默认加载当前类的类加载器
        return ServiceLoader.load(clazz, ObjUtil.defaultIfNull(loader, ClassLoaderUtil::getClassLoader));
    }
}
