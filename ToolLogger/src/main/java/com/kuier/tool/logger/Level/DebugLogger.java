package com.kuier.tool.logger.Level;

/*
 *@ClassName DebugLogger
 *@Description DebugLogger DEBUG级别日志接口
 *@Author LiuQi
 *@Date 2024/8/9 16:46
 *@Version 1.0
 */
public interface DebugLogger {

    /**
     * debug  DEBUG 等级的日志
     *
     * @param format
     * @param params
     * @author LiuQi
     */
    void debug(String format, Object... params);

    /**
     * debug  DEBUG 等级的日志
     *
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void debug(Throwable throwable, String format, Object... params);

    /**
     * debug  DEBUG 等级的日志
     *
     * @param fullyQualifiedClassName
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void debug(String fullyQualifiedClassName, Throwable throwable, String format, Object... params);
}
