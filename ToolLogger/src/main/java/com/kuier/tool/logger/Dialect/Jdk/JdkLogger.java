package com.kuier.tool.logger.Dialect.Jdk;


import com.kuier.tool.core.Util.StrUtil;
import com.kuier.tool.logger.AbstractLogger;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @ClassName JdkLogger
 * @Description JdkLogger JDK 日志类
 * @Author LiuQi
 * @Date 2024/8/2 13:07
 * @Version 1.0
 */
public class JdkLogger extends AbstractLogger {
    private static final long serialVersionUID = -6843151523380063975L;

    /**
     * transient 成员变量在对象序列化时被忽略
     * logger 日志对象
     */
    private final transient Logger logger;

    /**
     * 构造方法 logger
     *
     * @param logger
     * @author LiuQi
     */
    public JdkLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * 构造方法 clazz
     *
     * @param clazz
     * @author LiuQi
     */
    public JdkLogger(Class<?> clazz) {
        // 类加载对象为空返回 null 字符串 否则返回类加载对象全限定名
        this((null == clazz) ? StrUtil.NULL : clazz.getName());
    }

    /**
     * 构造方法 name
     *
     * @param name
     * @author LiuQi
     */
    public JdkLogger(String name) {
        this(Logger.getLogger(name));
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public void debug(String fullyQualifiedClassName, Throwable throwable, String format, Object... params) {
        // 调取loggerIfEnable 方法 打印对应等级的日志
        loggerIfEnable(fullyQualifiedClassName, Level.FINE, throwable, format, params);
    }

    /**
     * loggerIfEnable 打印对应等级的日志
     *
     * @param callerFullyQualifiedClassName
     * @param level
     * @param throwable
     * @param format
     * @param params
     * @author LiuQi
     */
    private void loggerIfEnable(String callerFullyQualifiedClassName, Level level, Throwable throwable, String format, Object... params) {
        if (logger.isLoggable(level)) {
            // 创建日志记录对象
            final LogRecord logRecord = new LogRecord(level, StrUtil.format(format, params));
            // 设置日志记录对象 类加载对象全限定名
            logRecord.setLoggerName(getName());
            // 设置日志记录对象 throwable 异常
            logRecord.setThrown(throwable);
            // 调用日志类的信息 类加载对象全限定名
            fillCallerFullyQualifiedClass(callerFullyQualifiedClassName, logRecord);
            // 打印日志
            logger.log(logRecord);
        }
    }

    /**
     * fillCallerFullyQualifiedClass  调用日志类的信息 类加载对象全限定名
     *
     * @param callerFullyQualifiedClassName
     * @param logRecord
     * @author LiuQi
     */
    private void fillCallerFullyQualifiedClass(String callerFullyQualifiedClassName, LogRecord logRecord) {
        // 获取当前线程堆栈信息
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 声明查找索引
        int found = -1;
        // 声明类名
        String className;
        for (int i = stackTrace.length - 2; i > -1; i--) { // 反向遍历堆栈数组信息数据 此处初始值为length-2 表示从倒数第二个堆栈开始检查 如果是倒数第一个 那调用者就获取不到
            // 获取类名
            className = stackTrace[i].getClassName();
            if (callerFullyQualifiedClassName.equals(className)) {// 全限定名等于声明类名
                found = i; // 赋值查找索引
                // 若找到终止执行
                break;
            }
        }
        if (found > -1) { // 查找索引大于-1 表示找到
            /**
             * 获取调用者信息
             * @see  LoggerFactory.create()
             */
            final StackTraceElement stackTraceElement = stackTrace[found + 1];
            // 设置日志记录对象 资源加载类名称
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            // 设置日志记录对象 资源加载方法名称
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }

    }
}
