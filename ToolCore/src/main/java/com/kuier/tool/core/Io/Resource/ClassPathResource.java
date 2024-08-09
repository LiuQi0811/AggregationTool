package com.kuier.tool.core.Io.Resource;

import com.kuier.tool.core.Lang.Assert;
import com.kuier.tool.core.Util.ClassUtil;
import com.kuier.tool.core.Util.FileUtil;
import com.kuier.tool.core.Util.ObjUtil;
import com.kuier.tool.core.Util.StrUtil;

import java.net.URL;

/**
 * @ClassName ClassPathResource
 * @Description ClassPathResource ClassPath单一资源访问类
 * @Author LiuQi
 * @Date 2024/8/2 15:12
 * @Version 1.0
 */
public class ClassPathResource extends UrlResource {
    private static final long serialVersionUID = 1L;

    /**
     * 路径
     */
    private final String path;

    /**
     * 类加载器
     */
    private final ClassLoader classLoader;

    /**
     * 类信息
     */
    private final Class<?> clazz;

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
        final String normalizePath = normalizePath(pathClassLoader);
        this.path = normalizePath;
        this.name = StrUtil.isBlank(normalizePath) ? null : FileUtil.getName(normalizePath);
        this.classLoader = ObjUtil.defaultIfNull(classLoader, ClassUtil::getClassLoader);
        this.clazz = clazz;
        // 初始化URL
        initURL();
    }

    /**
     * initURL 初始化URL
     *
     * @author LiuQi
     */
    private void initURL() {
        if (null != this.clazz) { // clazz 类不为空
        } else if (null != this.classLoader) { // classLoader类加载器不为空
            super.url = this.classLoader.getResource(this.path);
        }
    }

    /**
     * normalizePath 标准路径
     *
     * @param path
     * @return {@link String}
     * @author LiuQi
     */
    private String normalizePath(String path) {
        // 修复路径处理
        path = FileUtil.normalize(path);
        // 移除指定前缀
        path = StrUtil.removePrefix(path, StrUtil.SLASH);
        // 断言
        Assert.isFalse(FileUtil.isAbsolutePath(path), "Path [{}] must be a relative path !", path);
        // 返回处理后的路径
        return path;
    }
}
