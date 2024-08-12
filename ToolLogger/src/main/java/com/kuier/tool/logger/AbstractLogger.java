package com.kuier.tool.logger;

import com.kuier.tool.core.Util.StrUtil;
import com.kuier.tool.logger.Level.Level;

import java.io.Serializable;

/**
 * @ClassName AbstractLogger
 * @Description AbstractLogger 日志抽象类
 * @Author LiuQi
 * @Date 2024/8/2 13:09
 * @Version 1.0
 */
public abstract class AbstractLogger implements Logger, Serializable {
    private static final long serialVersionUID = -3211115409504005616L;
    /**
     * 抽象类全限定名
     */
    private static final String FQCN = AbstractLogger.class.getName();

    @Override
    public void debug(String format, Object... params) {
        if (null != params && 1 == params.length && params[0] instanceof Throwable) { // 多参数值不为空 并且长度等于1 并且第一个参数是Throwable
            System.out.println(StrUtil.format(" DEBUG is {} {}", format, params));
        } else {
            // 调取debug方法
            debug(null, format, params);
        }
    }

    @Override
    public void debug(Throwable throwable, String format, Object... params) {
        // 调取debug方法 （含）
        debug(FQCN, throwable, format, params);
    }

    @Override
    public boolean isEnabled(Level level) {
        switch (level) { // 日志级别匹配
            case DEBUG -> {
                // 是否启用DEBUG级别日志 返回true启用则不启用
                return isDebugEnabled();
            }
            default -> {
                // error异常抛出
                throw new Error(StrUtil.format("无法识别日志级别: {}", level));
            }
        }
    }
}
