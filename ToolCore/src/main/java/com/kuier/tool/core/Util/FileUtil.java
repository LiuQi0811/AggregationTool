package com.kuier.tool.core.Util;

import java.util.LinkedList;
import java.util.List;
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
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isAbsolutePath(String path) {
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
            // 前缀拼接
            prefix += StrUtil.SLASH;
            // 截取路径的第一个斜杠
            pathToUse = pathToUse.substring(1);
        }
        // 路径列表
        List<String> pathList = StrUtil.split(pathToUse, StrUtil.C_SLASH);
        // 路径元素列表
        List<String> pathElementList = new LinkedList<>();
        // 路径元素
        String element;
        // 上级路径数量
        int tops = 0;
        for (int i = pathList.size() - 1; i >= 0; i--) { // 路径列表遍历
            // 路径元素赋值
            element = pathList.get(i);
            if (false == StrUtil.DOT.equals(element)) { // 路径元素 非.
                if (StrUtil.DOUBLE_DOT.equals(element)) { // 路径元素 是..
                    // 上级路径数量递增
                    tops++;
                } else {
                    if (tops > 0) { // 上级路径数量大于0
                        // 上级路径数量递减
                        tops--;
                    } else {
                        // 路径元素列表数据追加
                        pathElementList.add(0, element);
                    }
                }
            }
        }
        if (tops > 0 && StrUtil.isEmpty(prefix)) { // 上级路径数量大于0 且 前缀为空
            //TODO 上级路径数量大于0 且 前缀为空  逻辑待补充
            System.out.println(" 上级路径数量大于0 且 前缀为空 ___ ___");
        }
        // 返回 前缀 + 路径元素列表 拼接处理后的结果
        return prefix + CollUtil.join(pathElementList, StrUtil.SLASH);
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
