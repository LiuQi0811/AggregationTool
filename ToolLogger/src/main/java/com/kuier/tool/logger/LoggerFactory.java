package com.kuier.tool.logger;

import com.kuier.tool.core.Caller.CallerHandler;
import com.kuier.tool.core.Map.SafeConcurrentHashMap;
import com.kuier.tool.core.Util.ResourceUtil;
import com.kuier.tool.core.Util.ServiceLoaderUtil;
import com.kuier.tool.logger.Dialect.Console.ConsoleLoggerFactory;
import com.kuier.tool.logger.Dialect.Jdk.JdkLoggerFactory;

import java.net.URL;
import java.util.Map;

/**
 * @ClassName LoggerFactory
 * @Description LoggerFactory 日志工厂类
 * @Author LiuQi
 * @Date 2024/7/27 16:33
 * @Version 1.0
 */
public abstract class LoggerFactory {
    /**
     * 日志框架名称
     */
    protected final String name;
    /**
     * 日志缓存
     */
    private final Map<Object, Logger> loggerCache;

    /**
     * 参数构造
     *
     * @author LiuQi
     */
    public LoggerFactory(String name) {
        this.name = name;
        loggerCache = new SafeConcurrentHashMap();
    }

    /**
     * get 获取当前LoggerFactory
     *
     * @param clazz
     * @return
     * @author LiuQi
     */
    public static Logger get(Class<?> clazz) {
        return getCurrentLoggerFactory().getLogger(clazz);
    }

    /**
     * get 获取当前LoggerFactory
     *
     * @return
     * @author LiuQi
     */
    public static Logger get() {
        // 获取调用者的调用者 反射类类型
        return get(CallerHandler.callerCallerInstance());
    }

    /**
     * getName 获取日志框架名称
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * loggerInstance 获取LoggerFactory
     *
     * @param clazz
     * @return
     * @author LiuQi
     */
    public Logger getLogger(Class<?> clazz) {
        return loggerCache.computeIfAbsent(clazz, logger -> createLogger((Class<?>) logger));
    }

    /**
     * createLogger 创建Logger日志对象
     *
     * @param clazz
     * @return {@link Logger}
     * @author LiuQi
     */
    public abstract Logger createLogger(Class<?> clazz);

    /**
     * getCurrentLoggerFactory 当前使用的LoggerFactory日志工厂
     *
     * @return
     * @author LiuQi
     */
    public static LoggerFactory getCurrentLoggerFactory() {
        return GlobalLoggerFactory.getInstance();
    }

    /**
     * create 创建LoggerFactory日志工厂
     *
     * @return
     * @author LiuQi
     */
    public static LoggerFactory create() {
        // 创建LoggerFactory日志工厂决定日志实现
        LoggerFactory loggerFactory = doCreate();
        loggerFactory.getLogger(LoggerFactory.class);
        return loggerFactory;
    }

    /**
     * doCreate 创建LoggerFactory日志工厂决定日志实现
     *
     * @return
     * @author LiuQi
     */
    private static LoggerFactory doCreate() {
        // loadFirstAvailable 加载第一个可用的服务
        LoggerFactory loggerFactory = ServiceLoaderUtil.loadFirstAvailable(LoggerFactory.class);
        if (null != loggerFactory) { // 日志工厂对象不为空
            // 返回日志工厂对象
            return loggerFactory;
        }
        System.out.println(" 未找到LoggerFactory日志工厂实现");
        URL resourceUrl = ResourceUtil.getResource("logger.properties");
        //  返回默认的日志工厂对象
        //  如果资源地址不为空 返回 JdkLoggerFactory jdk日志工厂 则返回 ConsoleLoggerFactory 控制台日志工厂
        return (null != resourceUrl) ? new JdkLoggerFactory() : new ConsoleLoggerFactory();
    }

}
