package com.kuier.tool.core.Util;

import com.kuier.tool.core.Collection.EnumerationIterator;
import com.kuier.tool.core.Io.Exception.IORuntimeException;
import com.kuier.tool.core.Io.Resource.ClassPathResource;
import com.kuier.tool.core.Io.Resource.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * @ClassName ResourceUtil
 * @Description ResourceUtil 资源获取工具类
 * @Author LiuQi
 * @Date 2024/8/2 10:44
 * @Version 1.0
 */
public class ResourceUtil {

    /**
     * getResource 获取资源文件对应的URL
     *
     * @param resource
     * @return {@link URL}
     * @author LiuQi
     */
    public static URL getResource(String resource) {
        // 获取资源文件对应的URL
        return getResource(resource, null);
    }

    /**
     * getResource 获取资源文件对应的URL
     *
     * @param resource
     * @param clazz
     * @return {@link  URL}
     * @author LiuQi
     */
    public static URL getResource(String resource, Class<?> clazz) {
        // 处理null情况
        resource = StrUtil.nullToEmpty(resource);
        // 根据类加载 获取资源文件对应的URL
        return (null != clazz) ? clazz.getResource(resource) : ClassLoaderUtil.getClassLoader().getResource(resource);
    }

    /**
     * ClassPath资源中获取stream流
     *
     * @return {@link InputStream}
     * @author LiuQi
     */
    public static InputStream getStreamSafe(String resource) {
        try {
            // 获取资源文件对应的Resource对象
            return getResourceObj(resource).getStream();
        } catch (Exception e) {
            // IGNORE
        }
        return null;
    }

    /**
     * getResourceObj 获取资源文件对应的Resource对象
     *
     * @param path
     * @return {@link Resource}
     * @author LiuQi
     */
    public static Resource getResourceObj(String path) {
        if (StrUtil.isNotBlank(path)) { // 路径不为空
            if (path.startsWith(UrlUtil.FILE_URL_PREFIX) || FileUtil.isAbsolutePath(path)) { // 匹配的绝对路径
                // TODO
                System.out.println("匹配的绝对路径 .......... ");
            }
        }
        // 返回ClassPath单一资源访问类对象
        return new ClassPathResource(path);
    }

    /**
     * getResourceIterator 获取指定路径下的资源文件迭代器
     * @param resource
     * @param classLoader
     * @author LiuQi
     */
    public static EnumerationIterator<URL> getResourceIterator(String resource, ClassLoader classLoader){
        // 定义资源文件
        Enumeration<URL> resources = null;
        try {
            // 如果classLoader为null，则使用默认的类加载器
            classLoader = ObjUtil.defaultIfNull(classLoader, ClassUtil::getClassLoader);
            // 获取资源文件
            resources = classLoader.getResources(resource);
        }catch (final IOException e){
            throw new IORuntimeException(e);
        }
        // 返回枚举迭代器 EnumerationIterator 对象
        return new EnumerationIterator<URL>(resources);
    }
}
