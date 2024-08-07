package com.kuier.tool.core.Util;

/**
 * @ClassName NumberUtil
 * @Description NumberUtil 数字工具类
 * @Author LiuQi
 * @Date 2024/8/6 15:19
 * @Version 1.0
 */
public class NumberUtil {

    /**
     * equals 比较字符是否相同处理（含是否忽略大小写）
     *
     * @param char_
     * @param char__
     * @param ignoreCase
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static Boolean equals(char char_, char char__, boolean ignoreCase) {
        // 字符相等处理
        return CharUtil.equals(char_, char__, ignoreCase);
    }
}
