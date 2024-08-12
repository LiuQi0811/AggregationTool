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
        // 调取debug方法 （含类全限定名）
        debug(FQCN, throwable, format, params);
    }

    @Override
    public void info(String format, Object... params) {
        // 调取info方法
        info(null, format, params);
    }

    @Override
    public void info(Throwable throwable, String format, Object... params) {
        // 调取info方法（含类全限定名）
        info(FQCN, throwable, format, params);
    }

    @Override
    public void warn(String format, Object... params) {
        // 调取warn方法
        warn(null, format, params);
    }

    @Override
    public void warn(Throwable throwable, String format, Object... params) {
        // 调取warn方法（含类全限定名）
        warn(FQCN, throwable, format, params);
    }

    @Override
    public void error(String format, Object... params) {
        // 调取error方法
        error(null, format, params);
    }

    @Override
    public void error(Throwable throwable, String format, Object... params) {
        // 调取error方法（含类全限定名）
        error(FQCN, throwable, format, params);
    }


    @Override
    public boolean isEnabled(Level level) {
        switch (level) { // 日志级别匹配
            case DEBUG -> {
                // 是否启用DEBUG级别日志 返回true启用则不启用
                return isDebugEnabled();
            }
            case INFO -> {
                // 是否启用INFO级别日志 返回true启用则不启用
                return isInfoEnabled();
            }
            case WARN -> {
                // 是否启用WARN级别日志 返回true启用则不启用
                return isWarnEnabled();
            }
            case ERROR -> {
                // 是否启用ERROR级别日志 返回true启用则不启用
                return isErrorEnabled();
            }
            default -> {
                // error异常抛出
                throw new Error(StrUtil.format("无法识别日志级别: {}", level));
            }
        }
    }
}
