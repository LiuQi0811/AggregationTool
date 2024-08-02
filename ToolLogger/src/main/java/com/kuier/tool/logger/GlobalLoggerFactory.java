package com.kuier.tool.logger;

/**
 * @ClassName GlobalLoggerFactory
 * @Description GlobalLoggerFactory 全局日志工厂
 * @Author LiuQi
 * @Date 2024/7/27 16:56
 * @Version 1.0
 */
public class GlobalLoggerFactory {
    // currentLoggerFactory 当前日志工厂实例
    private static volatile LoggerFactory currentLoggerFactory;
    private static final Object lock = new Object();

    /**
     * getInstance 获取全局日志工厂实例
     *
     * @return
     * @author LiuQi
     */
    public static LoggerFactory getInstance() {
        // currentLoggerFactory 当前日志工厂实例 为空
        if (null == currentLoggerFactory) {
            synchronized (lock) { // 添加锁
                // currentLoggerFactory 当前日志工厂实例 为空
                if(null == currentLoggerFactory){
                    // 创建LoggerFactory日志工厂
                    currentLoggerFactory = LoggerFactory.create();
                }
            }

        }
        // 返回当前日志工厂实例
        return currentLoggerFactory;
    }
}
