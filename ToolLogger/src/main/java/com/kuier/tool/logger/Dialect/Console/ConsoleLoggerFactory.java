package com.kuier.tool.logger.Dialect.Console;

import com.kuier.tool.logger.Logger;
import com.kuier.tool.logger.LoggerFactory;

/**
 * @ClassName ConsoleLoggerFactory
 * @Description ConsoleLoggerFactory 控制台日志工厂类
 * @Author LiuQi
 * @Date 2024/7/29 13:03
 * @Version 1.0
 */
public class ConsoleLoggerFactory extends LoggerFactory {
    /**
     * 构造方法
     */
    public ConsoleLoggerFactory() {
        super("Console.LOG");
        System.out.println(" Console 控制台 日志框架");
    }

    @Override
    public Logger createLogger(Class<?> clazz) {
        System.out.println(" create console logger ......  ");
        return null;
    }
}
