package com.kuier.tool.core.Util;

/**
 * @ClassName CharUtil
 * @Description CharUtil 字符工具类
 * @Author LiuQi
 * @Date 2024/8/2 14:37
 * @Version 1.0
 */
public class CharUtil {
    /**
     * isBlankChar 字符为空处理
     *
     * @param char_
     * @return
     */
    public static boolean isBlankChar(char char_) {
        // 返回 字符串为空处理
        return isBlankChar(((int) char_));
    }

    /**
     * isBlankChar 字符为空处理
     *
     * @param char_
     * @return
     */
    public static boolean isBlankChar(int char_) {

        return
                // 检查指定的字符是否为空白字符
                Character.isWhitespace(char_)
                        // 检查指定的字符是否为空格字符
                        || Character.isSpaceChar(char_)
                        // 检查指定的字符是否为非法字符
                        || char_ == '\ufeff' || char_ == '\u202a' || char_ == '\u0000'
                        // issue #I5UGSQ Hangul Filler
                        || char_ == '\u3164'
                        // Braille Pattern Blank
                        || char_ == '\u2800'
                        // MONGOLIAN VOWEL SEPARATOR
                        || char_ == '\u180e';
    }

    /**
     * equals 字符相等处理（含是否忽略大小写）
     *
     * @param char_
     * @param char__
     * @param ignoreCase
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean equals(char char_, char char__, boolean ignoreCase) {
        if (ignoreCase) { // 忽略大小写
            // 返回 字符串相等处理（含是否忽略大小写）
            return Character.toLowerCase(char_) == Character.toLowerCase(char__);
        }
        // 返回 字符相等处理
        return char_ == char__;
    }
}
