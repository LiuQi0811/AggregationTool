package com.kuier.tool.core.Util;

import com.kuier.tool.core.Text.CharPool;

/**
 * @ClassName CharUtil
 * @Description CharUtil 字符工具类
 * @Author LiuQi
 * @Date 2024/8/2 14:37
 * @Version 1.0
 */
public class CharUtil implements CharPool {
    /**
     * isBlankChar 字符为空处理
     *
     * @param char_
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isBlankChar(char char_) {
        // 返回 字符串为空处理
        return isBlankChar(((int) char_));
    }

    /**
     * isBlankChar 字符为空处理
     *
     * @param char_
     * @return {@link boolean}
     * @author LiuQi
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

    /**
     * isFileSeparator 是否为Windows或者Linux（Unix）文件分隔符
     *
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isFileSeparator(char char_) {
        //  返回 Windows或者Linux（Unix）文件分隔符匹配结果
        return SLASH == char_ || BACKSLASH == char_;
    }

    /**
     * isNumber 是否为数字
     * @param char_
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isNumber(char char_){
        // 返回 字符 大于等于 0 小于等于 9 的结果
        return char_ >= '0' && char_ <= '9';
    }

    /**
     * isHexChar 是否为十六进制字符
     * @param char_ 字符 0-9 a-f A-F
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isHexChar(char char_){
        // 返回 是否为数字 0-9 或 是否为 a-f 小写字母 或 是否为 A-F 大写字母
        return isNumber(char_) || (char_ >= 'a' && char_ <= 'f') || (char_ >= 'A' && char_ <= 'F');
    }
}
