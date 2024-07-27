package com.kuier.tool.logger;

/**
 * @ClassName GlobalLoggerFactory
 * @Description GlobalLoggerFactory 全局日志工厂
 * @Author LiuQi
 * @Date 2024/7/27 16:56
 * @Version 1.0
 */
public class GlobalLoggerFactory {
    private static volatile LoggerFactory currentLoggerFactory;

    /**
     * 获取全局日志工厂实例
     *
     * @return
     * @author LiuQi
     */
    public static LoggerFactory getInstance() {
        return currentLoggerFactory;
    }
}
