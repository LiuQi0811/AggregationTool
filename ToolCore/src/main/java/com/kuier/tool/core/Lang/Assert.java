package com.kuier.tool.core.Lang;

import com.kuier.tool.core.Util.StrUtil;

import java.util.function.Supplier;

/**
 * @ClassName Assert
 * @Description Assert 断言对象类
 * @Author LiuQi
 * @Date 2024/8/3 10:13
 * @Version 1.0
 */
public class Assert {

    /**
     * notNull 断言对象非空处理
     *
     * @param data
     * @param errorTemplate
     * @param params
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public static <T> T notNull(T data, String errorTemplate, Object... params) {
        // notNull 断言对象非空
        return notNull(data, () -> new IllegalArgumentException(StrUtil.format(errorTemplate, params)));
    }

    /**
     * notNull 断言对象非空处理
     *
     * @param data
     * @param errorSupplier
     * @param <T>
     * @param <E>
     * @return {@link T,E,Throwable}
     * @throws E
     * @author LiuQi
     */
    public static <T, E extends Throwable> T notNull(T data, Supplier<E> errorSupplier) throws E {
        if (null == data) { // 检查对象参数为空
            // 抛出自定义异常
            throw errorSupplier.get();
        }
        // 返回检查参数对象
        return data;
    }
}
