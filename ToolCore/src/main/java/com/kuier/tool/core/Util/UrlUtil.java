package com.kuier.tool.core.Util;

import com.kuier.tool.core.Lang.Assert;
import com.kuier.tool.core.Net.URLDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

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

    /**
     * getStream 获取URL对应的输入流
     *
     * @param url
     * @return {@link InputStream}
     * @author LiuQi
     */
    public static InputStream getStream(URL url) {
        // 非空断言
        Assert.notNull(url, "URL must be not null");
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    /**
     * decode 解码
     * @param content 内容 URL 路径信息
     * @param charset 字符集编码
     * @return {@link String}
     * @author LiuQi
     */
    public static String decode(String content, String charset){
        // 字符集编码为空 返回null 否则 返回字符编码处理结果
        return decode(content, StrUtil.isEmpty(charset) ? null : CharsetUtil.charset(charset));
    }

    /**
     * decode 解码
     * @param content 内容 URL 路径信息
     * @param charset 编码
     * @return {@link String}
     * @author LiuQi
     */
    public static String decode(String content, Charset charset){
        // URL解码 返回解码处理后的结果
        return URLDecoder.decode(content, charset);
    }

}
