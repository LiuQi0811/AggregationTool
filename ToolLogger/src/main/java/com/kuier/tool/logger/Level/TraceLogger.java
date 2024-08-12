package com.kuier.tool.logger.Level;

/*
 *@ClassName TraceLogger
 *@Description TraceLogger TRACE级别日志接口
 *@Author LiuQi
 *@Date 2024/8/12 17:37
 *@Version 1.0
 */
public interface TraceLogger {
    /**
     * trace  TRACE 等级的日志
     *
     * @param format
     * @param params
     * @author LiuQi
     */
    void trace(String format, Object... params);

    /**
     * trace  TRACE 等级的日志
     *
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void trace(Throwable throwable, String format, Object... params);

    /**
     * trace  TRACE 等级的日志
     *
     * @param fullyQualifiedClassName
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void trace(String fullyQualifiedClassName, Throwable throwable, String format, Object... params);

    /**
     * isTraceEnabled 是否启用TRACE级别日志
     *
     * @author LiuQi
     */
    boolean isTraceEnabled();
}
