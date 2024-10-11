package com.kuier.tool.core.Util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName CharsetUtil
 * @Description CharsetUtil 字符集工具类
 * @Author LiuQi
 * @Date 2024/8/3 13:54
 * @Version 1.0
 */
public class CharsetUtil {
    /**
     * UTF-8 编码
     */
    public static final Charset CHARSET_UTF_8 = StandardCharsets.UTF_8;

    /**
     * charset 字符编码处理
     * @param charsetName
     * @return {@link Charset}
     * @author LiuQi
     */
    public static Charset charset(String charsetName){
        // 如果字符参数为空 返回默认的字符集 否则返回指定字符集
        return StrUtil.isBlank(charsetName) ? Charset.defaultCharset() : Charset.forName(charsetName);
    }
}
