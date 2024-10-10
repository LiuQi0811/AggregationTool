package com.kuier.tool.core.Lang;

import com.kuier.tool.core.Collection.EnumerationIterator;
import com.kuier.tool.core.Util.CharsetUtil;
import com.kuier.tool.core.Util.ResourceUtil;
import com.kuier.tool.core.Util.StrUtil;

import java.io.Serializable;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ClassScanner
 * @Description ClassScanner 类扫描
 * @Author LiuQi
 * @Date 2024/10/10 13:10
 * @Version 1.0
 */
public class ClassScanner implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 包名称
     */
    private final String packageName;

    /**
     * class过滤器
     */
    private final Filter<Class<?>> classFilter;

    /**
     * 编码格式
     */
    private final Charset charset;

    /**
     * 包路径
     */
    private final String packagePath;

    /**
     * 类加载器
     */
    private ClassLoader classLoader;

    /**
     * 扫描类结果集 存储
     */
    private final Set<Class<?>> classes = new HashSet<>();

    /**
     * 类加载错误结果集 存储
     */
    private final Set<Class<?>> classesOfLoadError = new HashSet<>();


    /**
     * 类扫描无参构造
     *
     * @author LiuQi
     */
    public ClassScanner() {
        this(null);
    }

    /**
     * 类扫描有参构造
     *
     * @param packageName 包名称
     * @author LiuQi
     */
    public ClassScanner(String packageName) {
        this(packageName, null);
    }

    /**
     * 类扫描有参构造
     *
     * @param packageName 包名称
     * @param classFilter class过滤器
     * @author LiuQi
     */
    public ClassScanner(String packageName, Filter<Class<?>> classFilter) {
        this(packageName, classFilter, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 类扫描有参构造
     *
     * @param packageName 包名称
     * @param classFilter class过滤器
     * @param charset     编码格式
     * @author LiuQi
     */
    public ClassScanner(String packageName, Filter<Class<?>> classFilter, Charset charset) {
        // 如果包名称为空 则设置为空字符串
        packageName = StrUtil.nullToEmpty(packageName);
        this.packageName = packageName;
        this.classFilter = classFilter;
        this.charset = charset;
        // 将包名称中的点替换为斜杠
        this.packagePath = packageName.replace(StrUtil.DOT, StrUtil.SLASH);
    }


    /**
     * scannerPackage 扫描包路径下满足class过滤器条件的所有class文件
     *
     * @param packageName 包名称
     * @param classFilter class过滤器
     * @author LiuQi
     */
    public static void scannerPackage(String packageName, Filter<Class<?>> classFilter) {
        ClassScanner classScanner = new ClassScanner(packageName, classFilter);
        classScanner.scannerClass();
    }

    /**
     * scannerClass 扫描包路径下满足class过滤器条件的所有class文件
     *
     * @author LiuQi
     */
    public void scannerClass() {
        // 调用scan方法 不强制扫描其他位于classpath关联的类
        scannerClass(false);
    }

    /**
     * scannerClass 扫描包路径下满足class过滤器条件的所有class文件
     *
     * @param isForceScan 是否强制扫描其他位于classpath关联的类
     * @author LiuQi
     */
    public void scannerClass(boolean isForceScan) {
        System.out.println("...扫描结果.." + this.classes + "  ...扫描错误结果.." + this.classesOfLoadError);
        // 多次调用scan方法 会清除之前的扫描结果
        this.classes.clear();
        // 多次调用scan方法 会清除之前的扫描错误结果
        this.classesOfLoadError.clear();
        // 获取指定路径下的资源文件迭代器
        EnumerationIterator<URL> resourceIterator = ResourceUtil.getResourceIterator(packagePath, classLoader);
        resourceIterator.forEach(url -> {
            // 获取资源的协议
            String protocol = url.getProtocol();
            switch (protocol){
                case "file":
                    System.out.println(StrUtil.format("{}://{}", protocol, url));
                    break;
            }
        });
        System.out.println("资源迭代器信息 ........  " + packagePath);
    }
}