package com.kuier.tool.logger;

/**
 * @ClassName LoggerFactory
 * @Description LoggerFactory 日志工厂
 * @Author LiuQi
 * @Date 2024/7/27 16:33
 * @Version 1.0
 */
public abstract class LoggerFactory {
    /**
     * 获取当前LoggerFactory
     *
     * @param clazz
     * @return
     * @author LiuQi
     */
    public static Logger instance(Class<?> clazz) {
        return useCurrentLoggerFactory().loggerInstance(clazz);
    }

    /**
     * 获取当前LoggerFactory
     *
     * @return
     * @author LiuQi
     */
    public static Logger instance() {
        return instance(App.class);
    }

    /**
     * 获取LoggerFactory
     *
     * @param clazz
     * @return
     * @author LiuQi
     */
    public static Logger loggerInstance(Class<?> clazz) {
        System.out.println("  ......  Clazz " + clazz);
        return null;
    }

    /**
     * 当前使用的LoggerFactory日志工厂
     * @return
     * @author LiuQi
     */
    public static LoggerFactory useCurrentLoggerFactory() {
        return GlobalLoggerFactory.getInstance();
    }

}
