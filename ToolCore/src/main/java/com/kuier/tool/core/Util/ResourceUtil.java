package com.kuier.tool.core.Util;

import com.kuier.tool.core.Io.Resource.ClassPathResource;
import com.kuier.tool.core.Io.Resource.Resource;

import java.io.InputStream;
import java.net.URL;

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
     * @return
     * @author LiuQi
     */
    public static InputStream getStreamSafe() {
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

        }
        // 返回ClassPath单一资源访问类对象
        return new ClassPathResource(path);
    }
}
