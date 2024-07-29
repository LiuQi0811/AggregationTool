package com.kuier.tool.core.Caller;

/**
 * @ClassName CallerHandler
 * @Description CallerHandler 调用者处理器
 * @Author LiuQi
 * @Date 2024/7/29 9:26
 * @Version 1.0
 */
public class CallerHandler {
    // 调用者接口实例
    private static Caller INSTANCE;

    // 静态代码块
    static {
        // 尝试创建调用者接口实例
        INSTANCE = tryCreateCaller();
    }

    /**
     * callerCallerInstance 获取调用者的调用者
     *
     * @return
     * @author LiuQi
     */
    public static Class<?> callerCallerInstance() {
        return INSTANCE.callerCallerInstance();
    }

    /**
     * tryCreateCaller 尝试创建调用者接口实例
     *
     * @return
     * @author LiuQi
     */
    private static Caller tryCreateCaller() {
        // 调用者接口
        Caller caller;
        try {
            caller = new SecurityManagerCaller();
            //  验证调用者接口实例是否创建成功
            if (null != caller.callerCallerInstance() && null != caller.callerInstance()) {// 调用者接口实例创建成功
                return caller;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        caller = new StackTraceCaller();
        System.out.println(" 使用 StackTraceCaller 创建调用者接口实例  " + caller);
        return caller;
    }
}
