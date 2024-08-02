package com.kuier.tool.core.Util;

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
     * @param charSequence
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToEmpty(CharSequence charSequence) {
        return nullToDefault(charSequence, EMPTY);
    }

    /**
     * nullToDefault null转换默认字符串
     *
     * @param charSequence
     * @param defaultStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToDefault(CharSequence charSequence, String defaultStr) {
        // 字符为空 设置默认字符串 则返回原字符
        return (charSequence == null) ? defaultStr : charSequence.toString();
    }

    /**
     * isNotBlank 字符串非空处理
     *
     * @param charSequence
     * @return {@link Boolean}
     */
    public static Boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    /**
     * isBlank 字符串为空处理
     *
     * @param charSequence
     * @return {@link Boolean}
     */
    public static Boolean isBlank(CharSequence charSequence) {
        // 定义字符长度变量
        final int len;
        if (charSequence == null || (len = charSequence.length()) == 0) { // 字符为空 或者字符长度等于0
            // 返回true
            return true;
        }
        for (int i = 0; i < len; i++) { // 遍历字符串长度
            if (false == CharUtil.isBlankChar(charSequence.charAt(i))) { // 字符不为空
                // 返回false
                return false;
            }
        }
        // 返回true
        return true;
    }
}
