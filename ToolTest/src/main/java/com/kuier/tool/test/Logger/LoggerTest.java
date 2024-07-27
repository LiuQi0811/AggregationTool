package com.kuier.tool.test.Logger;

import com.kuier.tool.logger.Logger;
import com.kuier.tool.logger.LoggerFactory;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @ClassName LoggerTest
 * @Description LoggerTest 日志门面 单元测试
 * @Author LiuQi
 * @Date 2024/7/27 16:03
 * @Version 1.0
 */
public class LoggerTest extends TestCase {

    /**
     *  Log单元测试
     * @author LiuQi
     */
    @Test
    public void testLog() {
        System.out.println(" ...... .. LoggerTest 单元测试 开始 ........");
        Logger logger = LoggerFactory.instance();
        System.out.println(" ..... " + logger);
    }
}
