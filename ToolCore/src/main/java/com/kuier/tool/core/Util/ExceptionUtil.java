package com.kuier.tool.core.Util;

/**
 * @ClassName ExceptionUtil
 * @Description ExceptionUtil 异常工具类
 * @Author LiuQi
 * @Date 2024/10/10 15:42
 * @Version 1.0
 */
public class ExceptionUtil {

    /**
     * getMessage 获取异常信息
     * @param throwable
     * @return
     */
    public static String getMessage(Throwable throwable){
        if (throwable == null){ //  异常为空
            return StrUtil.EMPTY;
        }
        // 通过字符串模板 返回异常的类名和异常信息
        return StrUtil.format("{}: {}", throwable.getClass().getSimpleName(), throwable.getMessage());
    }
}
