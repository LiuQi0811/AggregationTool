package com.kuier.tool.core.Util;

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
     * @param param
     * @param defaultValueSupplier
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public static <T> T defaultIfNull(T param, Supplier<? extends T> defaultValueSupplier) {
        // 参数是否为空
        if (isNull(param)) {// 参数为空时返回默认值
            return defaultValueSupplier.get();
        }
        // 参数不为空时返回参数
        return param;
    }

    /**
     * isNull 参数是否为空
     *
     * @param param
     * @return {@link  Boolean}
     * @author LiuQi
     */
    public static Boolean isNull(Object param) {
        // 为空返回 true 否则返回 false
        return null == param || param.equals(null);
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
        return null;
    }
}
