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
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static <T> Boolean isEmpty(T[] data) {
        // 返回空数组
        return data == null || data.length == 0;
    }

    /**
     * isArray 是否是数组类型处理
     *
     * @param data
     * @param <T>
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static <T> Boolean isArray(Object data) {
        // 对象参数不为空并且类型为数组 返回true 则返回false
        return null != data && data.getClass().isArray();
    }
}
