package com.kuier.tool.logger.Level;

/*
 *@ClassName ErrorLogger
 *@Description ErrorLogger ERROR级别日志接口
 *@Author LiuQi
 *@Date 2024/8/12 16:58
 *@Version 1.0
 */
public interface ErrorLogger {
    /**
     * error  ERROR 等级的日志
     *
     * @param format
     * @param params
     * @author LiuQi
     */
    void error(String format, Object... params);

    /**
     * error  ERROR 等级的日志
     *
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void error(Throwable throwable, String format, Object... params);

    /**
     * error  ERROR 等级的日志
     *
     * @param fullyQualifiedClassName
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    void error(String fullyQualifiedClassName, Throwable throwable, String format, Object... params);

    /**
     * isErrorEnabled 是否启用ERROR级别日志
     *
     * @author LiuQi
     */
    boolean isErrorEnabled();
}
