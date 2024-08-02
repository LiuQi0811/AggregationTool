package com.kuier.tool.core.Caller;

/**
 * @ClassName Caller
 * @Description Caller 调用者接口
 * @Author LiuQi
 * @Date 2024/7/29 9:41
 * @Version 1.0
 */
public interface Caller {
    /**
     * getCallerCaller 获取调用者的调用者
     *
     * @return
     * @author LiuQi
     */
    Class<?> getCallerCaller();

    /**
     * callerInstance 获取调用者
     * @return
     * @author LiuQi
     */
    Class<?> getCaller();
}
