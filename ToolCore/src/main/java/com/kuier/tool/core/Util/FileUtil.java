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
     * isAbsolutePath 是否是绝对路径
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
}
