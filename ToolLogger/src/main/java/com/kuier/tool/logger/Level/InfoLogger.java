package com.kuier.tool.logger.Level;

/*
 *@ClassName InfoLogger
 *@Description InfoLogger INFO级别日志接口
 *@Author LiuQi
 *@Date 2024/8/12 13:12
 *@Version 1.0
 */
public interface InfoLogger {
    /**
     * info  INFO 等级的日志
     *
     * @param format
     * @param params
     * @author LiuQi
     */
    void info(String format, Object... params);

    /**
     * info  INFO 等级的日志
     *
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void info(Throwable throwable, String format, Object... params);

    /**
     * info  INFO 等级的日志
     *
     * @param fullyQualifiedClassName
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void info(String fullyQualifiedClassName, Throwable throwable, String format, Object... params);

    /**
     * isInfoEnabled 是否启用INFO级别日志
     *
     * @author LiuQi
     */
    boolean isInfoEnabled();
}
