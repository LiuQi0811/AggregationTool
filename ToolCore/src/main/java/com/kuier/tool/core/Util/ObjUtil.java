package com.kuier.tool.core.Util;

import com.kuier.tool.core.Convert.Convert;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @ClassName ObjectUtil
 * @Description ObjectUtil Object 工具类
 * @Author LiuQi
 * @Date 2024/7/29 14:22
 * @Version 1.0
 */
public class ObjUtil {

    /**
     * defaultIfNull 参数为空默认值
     *
     * @param value
     * @param defaultValueSupplier
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public static <T> T defaultIfNull(T value, Supplier<? extends T> defaultValueSupplier) {
        // 参数是否为空
        if (isNull(value)) {// 参数为空时返回默认值
            return defaultValueSupplier.get();
        }
        // 参数不为空时返回参数
        return value;
    }

    /**
     * isNull 参数是否为空
     *
     * @param data
     * @return {@link  boolean}
     * @author LiuQi
     */
    public static boolean isNull(Object data) {
        // 为空返回 true 否则返回 false
        return null == data || data.equals(null);
    }

    /**
     * toString 对象转字符串
     *
     * @param data
     * @return
     */
    public static String toString(Object data) {
        if (null == data) { // 对象参数为空
            // 返回 null字符串
            return StrUtil.NULL;
        }
        if (data instanceof Map) { // 对象参数类型为Map
            // 返回 Map 转字符串
            return data.toString();
        }
        // 返回对象转字符串
        return Convert.toStr(data);
    }
}
