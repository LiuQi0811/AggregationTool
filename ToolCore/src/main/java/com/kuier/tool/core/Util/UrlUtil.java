package com.kuier.tool.core.Util;

/**
 * @ClassName UrlUtil
 * @Description UrlUtil 统一资源定位符相关工具类
 * @Author LiuQi
 * @Date 2024/8/2 16:08
 * @Version 1.0
 */
public class UrlUtil extends UrlEncodeUtil {
    /**
     * URL 前缀表示文件: "file:"
     */
    public static final String FILE_URL_PREFIX = "file:";
    /**
     * 针对ClassPath路径的伪协议前缀（兼容Spring）: "classpath:"
     */
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

}
