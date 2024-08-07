package com.kuier.tool.core.Util;

/**
 * @ClassName CollUtil
 * @Description CollUtil 集合相关工具类
 * @Author LiuQi
 * @Date 2024/8/7 10:57
 * @Version 1.0
 */
public class CollUtil {
    /**
     * join 集合拆解拼接组合字符串处理
     *
     * @param iterable
     * @param charMark
     * @param <T>
     * @return {@link String}
     * @author LiuQi
     */
    public static <T> String join(Iterable<T> iterable, CharSequence charMark) {
        if (null == iterable) { // iterable 参数为空
            // 返回null
            return null;
        }
        // 返回集合拆解拼接组合后的字符串
        return IterUtil.join(iterable.iterator(), charMark);
    }
}
