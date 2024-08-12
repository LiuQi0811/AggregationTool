package com.kuier.tool.logger.Level;

/*
 *@ClassName WarnLogger
 *@Description WarnLogger WARN级别日志接口
 *@Author LiuQi
 *@Date 2024/8/12 17:21
 *@Version 1.0
 */
public interface WarnLogger {
    /**
     * warn  WARN 等级的日志
     *
     * @param format
     * @param params
     * @author LiuQi
     */
    void warn(String format, Object... params);

    /**
     * warn  WARN 等级的日志
     *
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void warn(Throwable throwable, String format, Object... params);

    /**
     * warn  WARN 等级的日志
     *
     * @param fullyQualifiedClassName
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void warn(String fullyQualifiedClassName, Throwable throwable, String format, Object... params);

    /**
     * isWarnEnabled 是否启用WARN级别日志
     *
     * @author LiuQi
     */
    boolean isWarnEnabled();
}
