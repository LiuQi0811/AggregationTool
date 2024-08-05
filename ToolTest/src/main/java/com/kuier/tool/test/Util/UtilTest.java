package com.kuier.tool.test.Util;

import com.kuier.tool.core.Util.*;
import junit.framework.TestCase;

/**
 * @ClassName UtilTest
 * @Description UtilTest 工具类 单元测试
 * @Author LiuQi
 * @Date 2024/7/29 14:19
 * @Version 1.0
 */
public class UtilTest extends TestCase {
    /**
     * 测试 Object 工具类
     *
     * @author LiuQi
     */
    public void testObjectUtil() {
        System.out.println(" 测试 Object 工具类: " + ObjUtil.defaultIfNull(null, Object::new));
        System.out.println(" 测试 Object 工具类 isNull 参数是否为空:  " + ObjUtil.isNull(null));
        System.out.println(" 测试 Object 工具类: " + ObjUtil.defaultIfNull(ClassLoader.class, null));
        System.out.println(" 测试 Object 工具类: " + ObjUtil.defaultIfNull(ClassLoader.class, null));
        System.out.println(" 测试 Object 工具类: " + ObjUtil.defaultIfNull(ClassLoader.class, null));
    }

    /**
     * 测试 ClassLoader 工具类
     *
     * @author LiuQi
     */
    public void testClassLoaderUtil() {
        System.out.println("测试 ClassLoader 工具类 获取加载类信息 :  " + ClassLoaderUtil.getClassLoader());
        System.out.println("测试 ClassLoader 工具类 获取上下文环境类加载器 : " + ClassLoaderUtil.getContextClassLoader());
        System.out.println("测试 ClassLoader 工具类: 获取系统类加载器 :  " + ClassLoaderUtil.getSystemClassLoader());
        System.out.println("测试 ClassLoader 工具类: ");
        System.out.println("测试 ClassLoader 工具类: ");
        System.out.println("测试 ClassLoader 工具类: ");
    }

    /**
     * 测试 CharSequence 工具类
     *
     * @author LiuQi
     */
    public void testCharSequenceUtil() {
        System.out.println("测试 CharSequence 工具类  null转换为Empty : " + CharSequenceUtil.nullToEmpty(null));
        System.out.println("测试 CharSequence 工具类  isNotBlank 字符串不为空处理 : " + CharSequenceUtil.isNotBlank("Is Not Null"));
        System.out.println("测试 CharSequence 工具类 isBlank 字符串为空处理 : " + CharSequenceUtil.isBlank(""));
        System.out.println("测试 CharSequence 工具类 format 字符串格式化 占位符处理 : " + StrUtil.format("字符串模板展示'{},{}!", "Hello", "World"));
        System.out.println("测试 CharSequence 工具类 format 字符串格式化 转义符处理 : " + StrUtil.format("字符串模板展示'{},\\ \\ {}!", "Hello", "World"));
        System.out.println("测试 CharSequence 工具类 utf8Str 字符串utf8编码处理 : " + StrUtil.utf8Str("Hello World"));
        System.out.println("测试 CharSequence 工具类 removePrefixIgnoreCase 移除字符串前缀（不区分大小写） : " + StrUtil.removePrefixIgnoreCase("Hello World", "Hello"));
        System.out.println("测试 CharSequence 工具类 startWithIgnoreCase 是否以指定字符串开头（不区分大小写） : " + StrUtil.startWithIgnoreCase("Hello World", "Hello"));
        System.out.println("测试 CharSequence 工具类 equals 字符串是否相等（含是否忽略字符串大小写）: " + StrUtil.equals("", "", false));
        System.out.println("测试 CharSequence 工具类 subSuf 截取指定位置后面的字符串 : " + StrUtil.subSuf("Hello World", 4));
        System.out.println("测试 CharSequence 工具类 trimStart   : " + StrUtil.trimStart(" Hello World ！"));
        System.out.println("测试 CharSequence 工具类 trimStart   : " + " Hello World ！");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
        System.out.println("测试 CharSequence 工具类   : ");
    }

    /**
     * 测试 FileUtil 工具类
     *
     * @author LiuQi
     */
    public void testFileUtil() {
        System.out.println("测试 file 工具类  normalize 修复路径 : " + FileUtil.normalize("classpath:application.properties"));
        System.out.println("测试 file 工具类  ~ : " + FileUtil.normalize("~\\application.properties"));
        System.out.println("测试 file 工具类   : ");
        System.out.println("测试 file 工具类   : ");
        System.out.println("测试 file 工具类   : ");
        System.out.println("测试 file 工具类   : ");
        System.out.println("测试 file 工具类   : ");
        System.out.println("测试 file 工具类   : ");
    }
}
