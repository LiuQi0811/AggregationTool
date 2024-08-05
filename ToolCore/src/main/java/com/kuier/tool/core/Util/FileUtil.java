package com.kuier.tool.core.Util;

import java.util.regex.Pattern;

/**
 * @ClassName FileUtil
 * @Description FileUtil 文件操作工具类
 * @Author LiuQi
 * @Date 2024/8/2 16:22
 * @Version 1.0
 */
public class FileUtil {

    /**
     * 路径匹配
     */
    private static final Pattern PATTERN_PATH_ABSOLUTE = Pattern.compile("^[a-zA-Z]:([/\\\\].*)?");

    /**
     * isAbsolutePath 是否是绝对路径处理
     *
     * @param path
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static Boolean isAbsolutePath(String path) {
        if (StrUtil.isEmpty(path)) { // 路径为空
            // 返回 false
            return false;
        }
        return
                // 路径以 / 开头
                StrUtil.C_SLASH == path.charAt(0)
                        // 路径匹配
                        || ReUtil.isMatch(PATTERN_PATH_ABSOLUTE, path);
    }

    /**
     * normalize 修复路径处理
     *
     * @param path
     * @return {@link String}
     * @author LiuQi
     */
    public static String normalize(String path) {
        if (null == path) { // 路径为空
            // 返回null
            return null;
        }
        // 兼容Windows下的共享目录路径（原始路径如果以\\开头 则保留这种路径）
        if (path.startsWith("\\\\")) { // 路径以 \\ 开头
            // 返回路径
            return path;
        }
        // 移除classpath:前缀处理（不区分大小写）
        String pathToUse = StrUtil.removePrefixIgnoreCase(path, UrlUtil.CLASSPATH_URL_PREFIX);
        // 移除file:前缀处理（不区分大小写）
        pathToUse = StrUtil.removePrefixIgnoreCase(path, UrlUtil.FILE_URL_PREFIX);
        // home路径
        if (StrUtil.startWith(pathToUse, '~')) { // 路径以 ~ 开头
            pathToUse = getUserHomePath() + pathToUse.substring(1);
        }
        // 路径统一 使用/
        pathToUse = pathToUse.replaceAll("[/\\\\]+", StrUtil.SLASH);
        // 去除开头空白符
        pathToUse = StrUtil.trimStart(pathToUse);
        // 获取前缀
        String prefix = StrUtil.EMPTY;
        System.out.println(pathToUse);
        // 路径匹配 冒号: 所在的索引下标
        int prefixIndex = pathToUse.indexOf(StrUtil.COLON);
        if (prefixIndex > -1) { //  路径匹配到冒号 所在的索引下标
            // 截取前缀
            prefix = pathToUse.substring(0, prefixIndex + 1);
            if (StrUtil.startWith(prefix, StrUtil.C_SLASH)) { // 前缀以 / 开头
                // 去除前缀的第一个斜杠
                prefix = prefix.substring(1);
            }
            if (false == pathToUse.contains(StrUtil.SLASH)) { // 非window系统的路径风格
                pathToUse = pathToUse.substring(prefixIndex + 1);
            } else { // window系统的路径风格
                // 前缀置空字符
                prefix = StrUtil.EMPTY;
            }

        }
        if (pathToUse.startsWith(StrUtil.SLASH)) { // 路径以 / 开头
            // TODO
            System.out.println(" 路径以 / 开头 ___ ___");
        }
        //TODO
        return null;
    }

    /**
     * getUserHomePath 获取用户主目录路径
     *
     * @return {@link String}
     * @author LiuQi
     */
    public static String getUserHomePath() {
        // 返回 用户主目录路径
        return System.getProperty("user.home");
    }
}
