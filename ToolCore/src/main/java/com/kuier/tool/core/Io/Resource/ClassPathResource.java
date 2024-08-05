package com.kuier.tool.core.Io.Resource;

import com.kuier.tool.core.Lang.Assert;
import com.kuier.tool.core.Util.FileUtil;

import java.net.URL;

/**
 * @ClassName ClassPathResource
 * @Description ClassPathResource ClassPath单一资源访问类
 * @Author LiuQi
 * @Date 2024/8/2 15:12
 * @Version 1.0
 */
public class ClassPathResource extends UrlResource {

    /**
     * 参数构造 path
     *
     * @param path
     */
    public ClassPathResource(String path) {
        this(path, null, null);
    }

    /**
     * 参数构造 path classLoader clazz
     *
     * @param pathClassLoader
     * @param classLoader
     * @param clazz
     */
    public ClassPathResource(String pathClassLoader, ClassLoader classLoader, Class<?> clazz) {
        super(((URL) null));
        // 路径非空断言
        Assert.notNull(pathClassLoader, "Path must not be null");
        // 标准路径
        normalizePath(pathClassLoader);
    }

    /**
     * normalizePath 标准路径
     *
     * @param path
     * @return {@link String}
     * @author LiuQi
     */
    private String normalizePath(String path) {

        FileUtil.normalize(path);
        return null;
    }
}
