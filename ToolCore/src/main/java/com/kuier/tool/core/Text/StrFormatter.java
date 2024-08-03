package com.kuier.tool.core.Text;

import com.kuier.tool.core.Util.ArrayUtil;
import com.kuier.tool.core.Util.StrUtil;

/**
 * @ClassName StrFormatter
 * @Description StrFormatter 字符串格式化相关类
 * @Author LiuQi
 * @Date 2024/8/3 10:55
 * @Version 1.0
 */
public class StrFormatter {

    /**
     * format 格式化字符串处理
     *
     * @param patternStr
     * @param params
     * @return {@link String}
     * @author LiuQi
     */
    public static String format(String patternStr, Object... params) {
        // 格式化字符串处理
        return formatWith(patternStr, StrUtil.EMPTY_JSON, params);
    }

    /**
     * formatWith 格式化字符串处理
     *
     * @param patternStr
     * @param placeHolder
     * @param params
     * @return {@link String}
     * @author LiuQi
     */
    public static String formatWith(String patternStr, String placeHolder, Object... params) {
        if (StrUtil.isBlank(patternStr) || StrUtil.isBlank(placeHolder) || ArrayUtil.isEmpty(params)) { // 匹配参数为空
            // 返回匹配字符串
            return patternStr;
        }
        // 字符串模板长度
        final int patternStrLen = patternStr.length();
        // 占位符长度
        final int placeHolderLen = placeHolder.length();
        // 记录已经处理到的位置
        int handledPosition = 0;
        // 占位符所在位置
        int delimIndex;
        // 创建builder 初始化长度
        final StringBuilder builder = new StringBuilder(patternStrLen + 50);
        for (int i = 0; i < params.length; i++) { // 遍历可选参数列表
            // 获取占位符所在位置
            delimIndex = patternStr.indexOf(placeHolder, handledPosition);
            if (delimIndex == -1) { // 占位符不存在
                if (handledPosition == 0) { // 处理到的位置为0
                    // 返回匹配字符串
                    return patternStr;
                }
                // 拼接剩余部分
                builder.append(patternStr, handledPosition, patternStrLen);
                return builder.toString();
            }
            if (delimIndex > 0 && patternStr.charAt(delimIndex - 1) == StrUtil.C_BACKSLASH) { // 转义符
                if (delimIndex > 1 && patternStr.charAt(delimIndex - 2) == StrUtil.C_BACKSLASH) { // 双转义符
                    // 转义符之前还有一个转义符 占位符依旧有效
                    builder.append(patternStr, handledPosition, delimIndex - 1);
                    builder.append(StrUtil.utf8Str(params[i]));
                    handledPosition = delimIndex + placeHolderLen;
                } else {
                    // 转义符前一个字符
                    i--;
                    builder.append(patternStr, handledPosition, delimIndex - 1);
                    builder.append(placeHolder.charAt(0));
                    // 更新处理到的位置
                    handledPosition = delimIndex + 1;
                }
            } else { // 占位符
                builder.append(patternStr, handledPosition, delimIndex);
                // 数据拼接
                builder.append(StrUtil.utf8Str(params[i]));
                // 更新处理到的位置
                handledPosition = delimIndex + placeHolderLen;
            }
        }
        // 处理剩余部分
        builder.append(patternStr, handledPosition, patternStrLen);
        // 返回构建后的字符串
        return builder.toString();
    }
}
