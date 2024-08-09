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

    /**
     * isFalse 断言是否为假 如果为 true 抛出  IllegalArgumentException  异常
     *
     * @param expression
     * @param errorMsgTemplate
     * @param params
     * @throws IllegalArgumentException
     * @author LiuQi
     */
    public static void isFalse(boolean expression, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        // 调取 isFalse 断言是否为假方法
        isFalse(expression, () -> new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params)));
    }

    /**
     * isFalse 断言是否为假 如果为 true 抛出指定类型异常 并使用指定的函数获取错误信息返回
     *
     * @param expression
     * @param errorSupplier
     * @param <E>
     * @throws E
     * @author LiuQi
     */
    public static <E extends Throwable> void isFalse(boolean expression, Supplier<E> errorSupplier) throws E {
        if (expression) { // 布尔值为true
            // 抛出异常信息
            throw errorSupplier.get();
        }
    }
}
