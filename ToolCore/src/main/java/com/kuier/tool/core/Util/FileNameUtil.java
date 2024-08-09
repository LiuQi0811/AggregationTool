package com.kuier.tool.core.Util;

/*
 *@ClassName FileNameUtil
 *@Description FileNameUtil 文件名相关工具类
 *@Author LiuQi
 *@Date 2024/8/9 14:00
 *@Version 1.0
 */
public class FileNameUtil {

    /**
     * getName 获取返回文件名
     *
     * @param filePath
     * @return {@link String}
     * @author LiuQi
     */
    public static String getName(String filePath) {
        if (null == filePath) { // 文件路径为空
            // 返回null
            return null;
        }
        // 获取文件路径长度
        int len = filePath.length();
        if (0 == len) { // 文件路径长度为0
            // 返回文件路径
            return filePath;
        }
        if (CharUtil.isFileSeparator(filePath.charAt(len - 1))) {
            // 以分隔符结尾的去掉结尾分隔符
            len--;
        }
        // 开始索引
        int begin = 0;
        // 字符
        char char_;
        for (int i = len - 1; i > -1; i--) { // 文件路径长度 反向遍历
            // 获取文件路径字符
            char_ = filePath.charAt(i);
            if (CharUtil.isFileSeparator(char_)) { // 是Windows或者Linux（Unix）文件分隔符
                // 查找最后一个路径分隔符（/或者\）
                begin = i + 1;
                // 终止执行
                break;
            }
        }
        // 返回文件路径截取后的路径
        return filePath.substring(begin, len);
    }
}
