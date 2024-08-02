package com.kuier.tool.logger.Dialect.Jdk;


import com.kuier.tool.core.Util.StrUtil;
import com.kuier.tool.logger.AbstractLogger;

import java.util.logging.Logger;

/**
 * @ClassName JdkLogger
 * @Description JdkLogger JDK 日志类
 * @Author LiuQi
 * @Date 2024/8/2 13:07
 * @Version 1.0
 */
public class JdkLogger extends AbstractLogger {

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
}
