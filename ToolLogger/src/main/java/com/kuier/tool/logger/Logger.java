package com.kuier.tool.logger;

import com.kuier.tool.logger.Level.DebugLogger;

/**
 * @ClassName Logger
 * @Description Logger接口
 * @Author LiuQi
 * @Date 2024/7/27 16:45
 * @Version 1.0
 */
public interface Logger extends DebugLogger {
    /**
     * getName 获取日志名称
     *
     * @return {@link String}
     * @author LiuQi
     */
    String getName();
}
