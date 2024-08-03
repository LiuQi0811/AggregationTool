package com.kuier.tool.core.Util;

import com.kuier.tool.core.Text.StrFormatter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @ClassName CharSequenceUtil
 * @Description CharSequenceUtil 字符工具类
 * @Author LiuQi
 * @Date 2024/8/2 11:01
 * @Version 1.0
 */
public class CharSequenceUtil {

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * null 字符串
     */
    public static final String NULL = "null";

    /**
     * nullToEmpty null转换为Empty
     *
     * @param charStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToEmpty(CharSequence charStr) {
        return nullToDefault(charStr, EMPTY);
    }

    /**
     * nullToDefault null转换默认字符串
     *
     * @param charStr
     * @param defaultStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToDefault(CharSequence charStr, String defaultStr) {
        // 字符为空 设置默认字符串 则返回原字符
        return (charStr == null) ? defaultStr : charStr.toString();
    }

    /**
     * isNotBlank 字符串非空处理
     *
     * @param charStr
     * @return {@link Boolean}
     */
    public static Boolean isNotBlank(CharSequence charStr) {
        return !isBlank(charStr);
    }

    /**
     * isBlank 字符串为空处理
     *
     * @param charStr
     * @return {@link Boolean}
     */
    public static Boolean isBlank(CharSequence charStr) {
        // 定义字符长度变量
        final int len;
        if (charStr == null || (len = charStr.length()) == 0) { // 字符为空 或者字符长度等于0
            // 返回true
            return true;
        }
        for (int i = 0; i < len; i++) { // 遍历字符串长度
            if (false == CharUtil.isBlankChar(charStr.charAt(i))) { // 字符不为空
                // 返回false
                return false;
            }
        }
        // 返回true
        return true;
    }

    /**
     * isEmpty 字符串为空处理
     *
     * @param charStr
     * @return {@link  Boolean}
     * @author LiuQi
     */
    public static Boolean isEmpty(CharSequence charStr) {
        return charStr == null || charStr.length() == 0;
    }

    /**
     * format 字符串格式化处理
     *
     * @param template
     * @param params
     * @return {@link String}
     * @author LiuQi
     */
    public static String format(CharSequence template, Object... params) {
        if (null == template) { // 字符串模板为空
            // 返回null 字符串
            return NULL;
        }
        if (ArrayUtil.isEmpty(params) || isBlank(template)) { // 数组参数为空 或者字符串模板为空
            // 返回字符串模板
            return template.toString();
        }
        // 返回格式化字符串
        return StrFormatter.format(template.toString(), params);
    }

    /**
     * utf8Str 字符串utf8编码处理
     *
     * @param data
     * @return {@link String}
     * @author LiuQi
     */
    public static String utf8Str(Object data) {
        // 对象转字符串处理
        return str(data, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * str 对象转字符串处理
     *
     * @param data
     * @param charset
     * @return {@link String}
     * @author LiuQi
     */
    public static String str(Object data, Charset charset) {
        if (null == data) { // 参数对象为空
            // 返回null
            return null;
        }
        // 类型转换
        if (data instanceof String) { // 参数对象类型是字符串
            // 返回字符串
            return ((String) data);
        } else if (data instanceof byte[]) { // 参数对象类型是字节数组
            //TODO
        } else if (data instanceof Byte[]) { // 参数对象类型是字节包装数组
            //TODO
        } else if (data instanceof ByteBuffer) { // 参数对象类型是ByteBuffer 字节缓冲区
            //TODO
        }
        // 返回字符串
        return data.toString();
    }
}
