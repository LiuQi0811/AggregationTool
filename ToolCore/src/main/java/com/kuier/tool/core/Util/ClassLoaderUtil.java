package com.kuier.tool.core.Util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @ClassName ClassLoaderUtil
 * @Description ClassLoaderUtil 类加载工具类
 * @Author LiuQi
 * @Date 2024/7/29 14:33
 * @Version 1.0
 */
public class ClassLoaderUtil {

    /**
     * getClassLoader 获取类加载器
     *
     * @return {@link ClassLoader}
     * @author LiuQi
     */
    public static ClassLoader getClassLoader() {
        // 获取当前线程的上下文类加载器
        ClassLoader classLoader = getContextClassLoader();
        if (classLoader == null) { // 上下文类加载器为空,则获取当前类加载器
            // 获取当前类的类加载器
            classLoader = ClassLoaderUtil.class.getClassLoader();
            if (null == classLoader) { // 当前类的类加载器为空,则获取系统类加载器
                // 获取系统类加载器
                classLoader = getSystemClassLoader();
            }
        }
        // 返回类加载器
        return classLoader;
    }

    /**
     * getContextClassLoader 获取上下文环境类加载器
     *
     * @return {@link ClassLoader}
     * @author LiuQi
     */
    public static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) { // 获取当前应用程序的安全管理器为空
            // 直接返回当前线程的上下文类加载器
            return Thread.currentThread().getContextClassLoader();
        } else { // 绕开权限检查
            // 授权机制 作用是为了防止恶意代码或其他不安全的代码获取系统中的敏感信息或执行不允许的操作
            return AccessController.doPrivileged((PrivilegedAction<ClassLoader>) () -> Thread.currentThread().getContextClassLoader());
        }
    }

    /**
     * getSystemClassLoader 获取系统类加载器
     *
     * @return {@link ClassLoader}
     * @author LiuQi
     */
    public static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) { // 获取当前应用程序的安全管理器为空
            // 直接返回系统类加载器
            return ClassLoader.getSystemClassLoader();
        } else { // 绕开权限检查
            // 授权机制 作用是为了防止恶意代码或其他不安全的代码获取系统中的敏感信息或执行不允许的操作
            return AccessController.doPrivileged((PrivilegedAction<ClassLoader>) ClassLoader::getSystemClassLoader);
        }
    }
}
