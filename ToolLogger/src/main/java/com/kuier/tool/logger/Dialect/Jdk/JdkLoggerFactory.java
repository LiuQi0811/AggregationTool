package com.kuier.tool.logger.Dialect.Jdk;

import com.kuier.tool.core.Util.ResourceUtil;
import com.kuier.tool.logger.Logger;
import com.kuier.tool.logger.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * @ClassName JdkLoggerFactory
 * @Description JdkLoggerFactory JDK 日志工厂类
 * @Author LiuQi
 * @Date 2024/8/2 11:44
 * @Version 1.0
 */
public class JdkLoggerFactory extends LoggerFactory {
    /**
     * 构造方法
     */
    public JdkLoggerFactory() {
        super("Jdk.LOG");
        // 读取配置文件
        readConfig();
        System.out.println(" JDK 日志框架");
    }

    @Override
    public Logger createLogger(Class<?> clazz) {
        // 返回 JdkLogger对象实例
        return new JdkLogger(clazz);
    }

    /**
     * readConfig 读取配置文件
     *
     * @author LiuQi
     */
    private void readConfig() {
        System.out.println("读取配置文件 ");
        InputStream streamSafe = ResourceUtil.getStreamSafe("logger.properties");
        System.out.println("readConfig  " + streamSafe);
        if (null == streamSafe) { // stream输入流为空
            System.err.println("[WARN] Can not find [logging.properties], use [%JRE_HOME%/lib/logging.properties] as default!");
            return;
        }
        try {
            // 读取日志配置
            LogManager.getLogManager().readConfiguration(streamSafe);
        } catch (Exception e) {
            // TODO
            try {
                // 读取日志配置
                LogManager.getLogManager().readConfiguration();
            } catch (Exception e_) {
                // TODO
            }
        } finally {
            // TODO IoUtil.close();
            try {
                streamSafe.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
