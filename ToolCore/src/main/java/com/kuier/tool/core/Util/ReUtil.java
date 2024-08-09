package com.kuier.tool.core.Util;

import java.util.regex.Pattern;

/**
 * @ClassName ReUtil
 * @Description ReUtil 正则相关工具类
 * @Author LiuQi
 * @Date 2024/8/3 9:21
 * @Version 1.0
 */
public class ReUtil {

    /**
     * isMatch 是否匹配正则
     *
     * @param pattern
     * @param charSequence
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isMatch(Pattern pattern, CharSequence charSequence) {
        if (null == pattern || null == charSequence) { // 匹配参数为空
            return false;
        }
        // 返回匹配结果
        return pattern.matcher(charSequence).matches();
    }
}
