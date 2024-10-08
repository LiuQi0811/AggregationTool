package com.kuier.tool.logger;

import com.kuier.tool.logger.Level.*;

/**
 * @ClassName Logger
 * @Description Logger接口
 * @Author LiuQi
 * @Date 2024/7/27 16:45
 * @Version 1.0
 */
public interface Logger extends DebugLogger, InfoLogger, WarnLogger, TraceLogger, ErrorLogger {
    /**
     * getName 获取日志名称
     *
     * @return {@link String}
     * @author LiuQi
     */
    String getName();

    /**
     * isEnabled 是否启用日志级别
     *
     * @param level
     * @return {@link boolean}
     * @author LiuQi
     */
    boolean isEnabled(Level level);
}
