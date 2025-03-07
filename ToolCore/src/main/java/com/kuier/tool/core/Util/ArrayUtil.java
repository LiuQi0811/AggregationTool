package com.kuier.tool.core.Util;

/**
 * @ClassName ArrayUtil
 * @Description ArrayUtil 数组工具类
 * @Author LiuQi
 * @Date 2024/8/3 10:41
 * @Version 1.0
 */
public class ArrayUtil {
    /**
     * isEmpty 数组空处理
     *
     * @param data
     * @param <T>
     * @return {@link boolean}
     * @author LiuQi
     */
    public static <T> boolean isEmpty(T[] data) {
        // 返回空数组
        return data == null || data.length == 0;
    }

    /**
     * isNotEmpty 数组非空处理
     *
     * @param data 数组
     * @param <T>
     * @return {@link boolean}
     * @author LiuQi
     */
    public static <T> boolean isNotEmpty(T[] data) {
        // 返回非空数组
        return (null != data && data.length != 0);
    }

    /**
     * isArray 是否是数组类型处理
     *
     * @param data
     * @param <T>
     * @return {@link boolean}
     * @author LiuQi
     */
    public static <T> boolean isArray(Object data) {
        // 对象参数不为空并且类型为数组 返回true 则返回false
        return null != data && data.getClass().isArray();
    }
}
