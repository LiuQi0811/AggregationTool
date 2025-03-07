package com.kuier.tool.core.Util;

import com.kuier.tool.core.Text.Finder.Finder;
import com.kuier.tool.core.Text.StrFormatter;
import com.kuier.tool.core.Text.StrSplitter;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName CharSequenceUtil
 * @Description CharSequenceUtil 字符工具类
 * @Author LiuQi
 * @Date 2024/8/2 11:01
 * @Version 1.0
 */
public class CharSequenceUtil {
    /**
     * 未找到返回 -1
     */
    public static final int INDEX_NOT_FOUND = Finder.INDEX_NOT_FOUND;

    /**
     * 空字符串
     */
    public static final String EMPTY = "";

    /**
     * null 字符串
     */
    public static final String NULL = "null";

    /**
     * nullToEmpty null转换为Empty
     *
     * @param charStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToEmpty(CharSequence charStr) {
        return nullToDefault(charStr, EMPTY);
    }

    /**
     * nullToDefault null转换默认字符串
     *
     * @param charStr
     * @param defaultStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String nullToDefault(CharSequence charStr, String defaultStr) {
        // 字符为空 设置默认字符串 则返回原字符
        return (charStr == null) ? defaultStr : charStr.toString();
    }

    /**
     * isNotBlank 字符串非空处理
     *
     * @param charStr
     * @return {@link boolean}
     */
    public static boolean isNotBlank(CharSequence charStr) {
        return !isBlank(charStr);
    }

    /**
     * isBlank 字符串为空处理
     *
     * @param charStr
     * @return {@link boolean}
     */
    public static boolean isBlank(CharSequence charStr) {
        // 定义字符长度变量
        final int len;
        if (charStr == null || (len = charStr.length()) == 0) { // 字符为空 或者字符长度等于0
            // 返回true
            return true;
        }
        for (int i = 0; i < len; i++) { // 遍历字符串长度
            if (false == CharUtil.isBlankChar(charStr.charAt(i))) { // 字符不为空
                // 返回false
                return false;
            }
        }
        // 返回true
        return true;
    }

    /**
     * isEmpty 字符串为空处理
     *
     * @param charStr
     * @return {@link  boolean}
     * @author LiuQi
     */
    public static boolean isEmpty(CharSequence charStr) {
        // 字符为空 或者字符长度等于0 返回true
        return charStr == null || charStr.length() == 0;
    }

    /**
     * isNotEmpty 字符串非空处理
     *
     * @param charStr
     * @return {@link  boolean}
     * @author LiuQi
     */
    public static boolean isNotEmpty(CharSequence charStr) {
        return !isEmpty(charStr);
    }

    /**
     * isEmptyIfStr 字符串为空处理
     *
     * @param data
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean isEmptyIfStr(Object data) {
        if (null == data) { // 参数为空
            // 返回 true
            return true;
        } else if (data instanceof CharSequence) { // 参数类型为CharSequence 字符类型
            // 参数字符串长度为0 返回 true
            return 0 == ((CharSequence) data).length();
        }
        // 返回 false
        return false;
    }

    /**
     * format 字符串格式化处理
     *
     * @param template
     * @param params
     * @return {@link String}
     * @author LiuQi
     */
    public static String format(CharSequence template, Object... params) {
        if (null == template) { // 字符串模板为空
            // 返回null 字符串
            return NULL;
        }
        if (ArrayUtil.isEmpty(params) || isBlank(template)) { // 数组参数为空 或者字符串模板为空
            // 返回字符串模板
            return template.toString();
        }
        // 返回格式化字符串
        return StrFormatter.format(template.toString(), params);
    }

    /**
     * utf8Str 字符串utf8编码处理
     *
     * @param data
     * @return {@link String}
     * @author LiuQi
     */
    public static String utf8Str(Object data) {
        // 对象转字符串处理
        return str(data, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * str CharSequence 转字符串处理
     *
     * @param charStr
     * @return
     * @author LiuQi
     */
    public static String str(CharSequence charStr) {
        return null == charStr ? null : charStr.toString();
    }

    /**
     * str 对象转字符串处理
     *
     * @param data
     * @param charset
     * @return {@link String}
     * @author LiuQi
     */
    public static String str(Object data, Charset charset) {
        if (null == data) { // 参数对象为空
            // 返回null
            return null;
        }
        // 类型转换
        if (data instanceof String) { // 参数对象类型是字符串
            // 返回字符串
            return ((String) data);
        } else if (data instanceof byte[]) { // 参数对象类型是字节数组
            //TODO
        } else if (data instanceof Byte[]) { // 参数对象类型是字节包装数组
            //TODO
        } else if (data instanceof ByteBuffer) { // 参数对象类型是ByteBuffer 字节缓冲区
            //TODO
        }
        // 返回字符串
        return data.toString();
    }

    /**
     * removePrefixIgnoreCase 移除字符串前缀处理（不区分大小写）
     *
     * @param charStr
     * @param prefix
     * @return {@link String}
     * @author LiuQi
     */
    public static String removePrefixIgnoreCase(CharSequence charStr, CharSequence prefix) {
        if (isEmpty(charStr) || isEmpty(prefix)) { //参数为空
            // CharSequence 转字符串处理 返回字符串
            return str(charStr);
        }
        // 参数转字符串
        String charStr_ = charStr.toString();
        if (startWithIgnoreCase(charStr, prefix)) { // 以指定字符串开头（不区分大小写）
            // 字符串截取 指定字符后面的部分
            return subSuf(charStr, prefix.length());
        }
        // 返回处理后的字符串
        return charStr_;
    }

    /**
     * startWithIgnoreCase 是否以指定字符串开头处理（不区分大小写）
     *
     * @param charStr
     * @param prefix
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean startWithIgnoreCase(CharSequence charStr, CharSequence prefix) {
        // 返回 是否以指定字符串开头（含是否忽略字符串大小写）
        return startWith(charStr, prefix, true);
    }

    /**
     * startWith 是否以指定字符开头处理
     *
     * @param charStr
     * @param char_
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean startWith(CharSequence charStr, char char_) {
        if (isEmpty(charStr)) { // 字符串参数为空
            // 返回 false
            return false;
        }
        // 返回字符参数 与字符串参数的第一个字符对比
        return char_ == charStr.charAt(0);
    }

    /**
     * startWith 是否以指定字符串开头处理（含是否忽略字符串大小写）
     *
     * @param charStr
     * @param prefix
     * @param ignoreCase
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean startWith(CharSequence charStr, CharSequence prefix, boolean ignoreCase) {
        // 返回 是否以指定字符串开头（含是否忽略字符串大小写 字符串相等）
        return startWith(charStr, prefix, ignoreCase, false);
    }

    /**
     * startWith 是否以指定字符串开头处理（含是否忽略字符串大小写 字符串相等）
     *
     * @param charStr
     * @param prefix
     * @param ignoreCase
     * @param ignoreEquals
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean startWith(CharSequence charStr, CharSequence prefix, boolean ignoreCase, boolean ignoreEquals) {
        if (null == charStr || null == prefix) {// 字符串 或者字符串开头 为空
            if (ignoreEquals) { // 不忽略字符串相等情况
                // 返回 false
                return false;
            }
            // 字符串 或者字符串开头 都为空返回
            return null == charStr && null == prefix;
        }
        // 参数转字符串 并匹配规则
        boolean isStartWith = charStr.toString().regionMatches(ignoreCase, 0, prefix.toString(), 0, prefix.length());
        if (isStartWith) { // 字符串开头匹配
            return (false == ignoreEquals) || (false == equals(charStr, prefix, ignoreCase));
        }
        return false;
    }

    /**
     * endWith 是否以指定字符串结尾处理
     * @param charStr
     * @param char_
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean endWith(CharSequence charStr, char char_){
        if(isEmpty(charStr)){ // 字符串参数为空
            return false;
        }
        // 返回字符参数 与字符串参数的最后一个字符对比
        return char_ == charStr.charAt(charStr.length() - 1);
    }

    /**
     * endWith 是否以指定字符串结尾处理 (不忽略大小写)
     * @param charStr
     * @param suffix
     * @return
     */
    public static boolean endWith(CharSequence charStr,CharSequence suffix){
        // 返回 是否以指定字符串结尾（不忽略大小写）
        return endWith(charStr,suffix,false);
    }

    /**
     * endWith 是否以指定字符串结尾处理 (不忽略相等)
     * @param charStr
     * @param suffix
     * @param ignoreCase
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean endWith(CharSequence charStr,CharSequence suffix,boolean ignoreCase){
        return endWith(charStr,suffix,ignoreCase,false);
    }

    /**
     * endWith 是否以指定字符串结尾处理
     * @param charStr
     * @param suffix
     * @param ignoreCase
     * @param ignoreEquals
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean endWith(CharSequence charStr,CharSequence suffix,boolean ignoreCase,boolean ignoreEquals){
        if(null == charStr || null == suffix){ // 字符串 或者字符串后缀 为空
            if(ignoreEquals){ // 忽略相等
                return false;
            }
            // 字符串 或者字符串后缀 都为空返回
            return null == charStr && null == suffix;
        }
        // 获取字符串偏移量 字符串长度 - 字符串后缀长度
        final int strOffset = charStr.length() - suffix.length();
        // 字符串 从偏移量开始 到 字符串长度 的字符串 是否与 字符串后缀 匹配
        boolean isEndWith = charStr.toString().regionMatches(ignoreCase, strOffset, suffix.toString(), 0, suffix.length());
        if(isEndWith){ // 字符串后缀匹配
            // 返回 是否忽略相等 或者 字符串相等
            return (false == ignoreEquals) || (false == equals(charStr,suffix,ignoreCase));
        }
        return false;
    }

    /**
     * equals 字符串是否相等初处理（含是否忽略字符串大小写）
     *
     * @param charStr
     * @param charStr_
     * @param ignoreCase
     * @return {@link boolean}
     * @author LiuQi
     */
    public static boolean equals(CharSequence charStr, CharSequence charStr_, boolean ignoreCase) {
        if (null == charStr) { // 第一个字符串参数为空
            // 第二个字符串参数为空 返回 true
            return charStr_ == null;
        }
        if (null == charStr_) {// 第二个字符串参数为空
            // 返回 false
            return false;
        }
        if (ignoreCase) { // 忽略大小写
            // 返回对比后结果
            return charStr.toString().equalsIgnoreCase(charStr_.toString());
        } else { // 内容比较
            // 返回对比后结果
            return charStr.toString().contentEquals(charStr_.toString());
        }
    }

    /**
     * subBefore 截取分隔字符串之前的字符串，不包括分隔字符串
     * @param charStr 被查找的字符串
     * @param separator 分隔字符串（不包括）
     * @param isLastSeparator 是否查找最后一个分隔字符串（多次出现分隔字符串时选取最后一个），true为选取最后一个
     * @return {@link String}
     * @author LiuQi
     */
    public static String subBefore(CharSequence charStr,CharSequence separator,boolean isLastSeparator){
        if(isEmpty(charStr) || null == separator){ // 字符串参数为空 或者 分隔字符串为空
            // 字符串 为空 返回null 则返回字符串
            return str(charStr);
        }
        // 字符串转字符串处理
        String charStr_ = charStr.toString();
        // 分隔字符串转字符串处理
        String separator_ = separator.toString();
        if(separator_.isEmpty()){ // 分隔字符串为空
            // 返回 ""
            return EMPTY;
        }
        // 分隔字符串位置 如果 isLastSeparator 为 true 则 查找最后一个分隔字符串的位置 否则 根据分隔字符串查找位置
        int position = isLastSeparator ? charStr_.lastIndexOf(separator_) : charStr_.indexOf(separator_);
        if(INDEX_NOT_FOUND == position){ // 分隔字符串位置 小于0
            // 返回字符串
            return charStr_;
        }
        if(0 == position){ // 分隔字符串位置 等于0
            // 返回 ""
            return EMPTY;
        }
        // 截取字符串 从 0 到 分隔字符串位置 返回字符串
        return charStr_.substring(0,position);
    }

    /**
     * subSuf 截取指定位置后面的字符串处理
     *
     * @param charStr
     * @param fromIndex
     * @return {@link String}
     * @author LiuQi
     */
    public static String subSuf(CharSequence charStr, int fromIndex) {
        if (isEmpty(charStr)) { // 字符串为空
            // 返回null
            return null;
        }
        // 字符串截取处理
        return sub(charStr, fromIndex, charStr.length());
    }

    /**
     * sub 字符串截取处理
     *
     * @param charStr
     * @param fromIndexInclude
     * @param toIndexExclude
     * @return {@link String}
     * @author LiuQi
     */
    public static String sub(CharSequence charStr, int fromIndexInclude, int toIndexExclude) {
        if (isEmpty(charStr)) { // 字符串为空
            // CharSequence 转字符串处理 返回字符串
            return str(charStr);
        }
        // 字符串长度
        int strLen = charStr.length();
        if (fromIndexInclude < 0) { // 开始的索引（包括）起始位置小于0
            // 更新开始的索引 字符串长度+ 开始索引
            fromIndexInclude = strLen + fromIndexInclude;
            if (fromIndexInclude < 0) { // 更新后开始的索引（包括）起始位置小于0
                // 更新开始的索引 0
                fromIndexInclude = 0;
            }
        } else if (fromIndexInclude > strLen) { // 开始的索引（包括）起始位置大于字符串长度
            // 更新开始的索引 字符串长度
            fromIndexInclude = strLen;
        }
        if (toIndexExclude < 0) { // 结束的索引（包括）起始位置小于0
            // 更新结束的索引 字符串长度+ 结束索引
            toIndexExclude = strLen + toIndexExclude;
            if (toIndexExclude < 0) { // 更新后结束的索引（包括）起始位置小于0
                // 更新结束的索引 0
                toIndexExclude = 0;
            }
        } else if (toIndexExclude > strLen) { // 结束的索引（包括）起始位置大于字符串长度
            // 更新结束的索引 字符串长度
            toIndexExclude = strLen;
        }
        if (toIndexExclude < fromIndexInclude) { // 结束的索引（包括）起始位置 < 开始的索引（包括）起始位置
            // 临时索引
            int tempIndex_ = fromIndexInclude;
            // 更新开始的索引 结束的索引（包括）起始位置
            fromIndexInclude = toIndexExclude;
            // 更新结束的索引 临时索引
            toIndexExclude = tempIndex_;
        }
        if (fromIndexInclude == toIndexExclude) { // 开始的索引（包括）起始位置  = 结束的索引（包括）起始位置
            // 返回空字符串
            return EMPTY;
        }
        // 返回 字符串截取 字符串
        return charStr.toString().substring(fromIndexInclude, toIndexExclude);
    }

    /**
     * trimStart 开头空白符处理
     *
     * @param charStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String trimStart(CharSequence charStr) {
        // 空白符/空格处理
        return trim(charStr, -1);
    }

    /**
     * trim 空白符/空格处理
     *
     * @param charStr
     * @return {@link String}
     * @author LiuQi
     */
    public static String trim(CharSequence charStr) {
        // 字符串参数为空 直接返回null 则空白符/空格处理
        return (null == charStr) ? null : trim(charStr, 0);
    }

    /**
     * trim 空白符/空格处理
     *
     * @param charStr
     * @param mode
     * @return {@link String}
     * @author LiuQi
     */
    public static String trim(CharSequence charStr, int mode) {
        // 空白符/空格处理（含断言是否过滤字符）
        return trim(charStr, mode, CharUtil::isBlankChar);
    }

    /**
     * trim 空白符/空格处理（含断言是否过滤字符）
     *
     * @param charStr
     * @param mode
     * @param predicate
     * @return {@link String}
     * @author LiuQi
     */
    public static String trim(CharSequence charStr, int mode, Predicate<Character> predicate) {
        // 字符串处理结果变量
        String resultStr;
        if (null == charStr) { // 参数字符串为空
            // 返回空字符
            resultStr = null;
        } else { // 参数字符串不为空
            // 获取字符串长度
            int strLen = charStr.length();
            // 开始索引
            int start = 0;
            // 结束索引
            int end = strLen;
            // mode  -1 表示trimStart  0 表示trim全部 1 表示trimEnd
            if (mode <= 0) { // trimStart trim全部
                while ((start < end) && predicate.test(charStr.charAt(start))) { // 开始索引 < 结束索引 并且过滤断言字符
                    // 开始索引递增
                    start++;
                }
            }
            if (mode >= 0) { // trimEnd trim全部
                while ((start < end) && (predicate.test(charStr.charAt(end - 1)))) {// 开始索引 < 结束索引 并且过滤断言字符
                    // 结束索引递减
                    end--;
                }
            }
            if ((start > 0) || (end < strLen)) { // 开始索引 > 0 或者 结束索引 < 字符串长度
                // 截取字符串处理
                resultStr = charStr.toString().substring(start, end);
            } else {
                // 转字符串处理
                resultStr = charStr.toString();
            }
        }
        // 返回字符串处理结果
        return resultStr;
    }

    /**
     * split 字符串分割（含默认分片）
     *
     * @param charStr
     * @param separator
     * @return {@link List<String>}
     * @author LiuQi
     */
    public static List<String> split(CharSequence charStr, char separator) {
        // 返回 字符串分割（含 非空白 非空处理）
        return split(charStr, separator, 0);
    }

    /**
     * split 字符串分割（含 非空白 非空处理）
     *
     * @param charStr
     * @param separator
     * @param limit
     * @return {@link List<String>}
     * @author LiuQi
     */
    public static List<String> split(CharSequence charStr, char separator, int limit) {
        // 返回字符串分割
        return split(charStr, separator, limit, false, false);
    }

    /**
     * split 字符串分割
     *
     * @param charStr
     * @param separator
     * @param limit
     * @param isTrim
     * @param ignoreEmpty
     * @return {@link List<String>}
     * @author LiuQi
     */
    public static List<String> split(CharSequence charStr, char separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        // 返回字符串分割
        return StrSplitter.split(charStr, separator, limit, isTrim, ignoreEmpty);
    }

    /**
     * length 获取字符串的长度
     *
     * @param sequence
     * @return {@link int}
     * @author LiuQi
     */
    public static int length(CharSequence sequence) {
        // 字符参数不为空 返回字符串长度 则返回0
        return null == sequence ? 0 : sequence.length();
    }

    /**
     * removePrefix 移除指定前缀
     *
     * @param charStr
     * @param prefix
     * @return {@link String}
     * @author LiuQi
     */
    public static String removePrefix(CharSequence charStr, CharSequence prefix) {
        if (isEmpty(charStr) || isEmpty(prefix)) { // 字符串参数 或者 前缀参数为空
            // 返回转字符串处理后的结果
            return str(charStr);
        }
        // 参数字符转字符串
        final String charStr_ = charStr.toString();
        if (charStr_.startsWith(prefix.toString())) { // 参数字符串开头以前缀开头
            // 返回移除前缀后的字符串
            return subSuf(charStr_, prefix.length());
        }
        // 返回转字符串处理后的结果
        return charStr_;
    }

    /**
     * addSuffixIfNot 添加后缀 如果不存在
     * @param charStr  字符串
     * @param suffix 后缀
     * @return {@link String}
     * @author LiuQi
     */
    public static String addSuffixIfNot(CharSequence charStr,CharSequence suffix){
        // 调用 appendIfMissing 方法添加结尾字符串 不忽略大小写
        return appendIfMissing(charStr,suffix);
    }

    /**
     * appendIfMissing 如果给定字符串不是以给定的一个或多个字符串为结尾，则在尾部添加结尾字符串 不忽略大小写
     * @param charStr 字符串
     * @param suffix 后缀
     * @param suffixes 后缀数组
     * @return {@link String}
     * @author LiuQi
     */
    public static String appendIfMissing(CharSequence charStr, CharSequence suffix, CharSequence... suffixes){
        // 返回添加后缀 如果不存在 不忽略大小写
        return appendIfMissing(charStr,suffix,false,suffixes);
    }

    /**
     * appendIfMissing 如果给定字符串不是以给定的一个或多个字符串为结尾，则在尾部添加结尾字符串
     * @param charStr 字符串
     * @param suffix 后缀
     * @param ignoreCase 是否忽略大小写
     * @param suffixes 后缀数组
     * @return {@link String}
     * @author LiuQi
     */
    public static String appendIfMissing(CharSequence charStr, CharSequence suffix, boolean ignoreCase, CharSequence... suffixes){
        if(charStr == null || isEmpty(suffix) || endWith(charStr,suffix,ignoreCase)){ // 字符串参数为空 或者 后缀参数为空 或者 字符串以给定的一个或多个字符串为结尾
            // 返回转字符串处理后的结果
            return str(charStr);
        }
        if(ArrayUtil.isNotEmpty(suffixes)){ // 后缀数组不为空
            for (CharSequence suffix_ : suffixes) { // 遍历后缀数组
                if (endWith(charStr, suffix_, ignoreCase)) { // 字符串以给定的一个或多个字符串为结尾
                    // 返回转字符串处理后的结果
                    return charStr.toString();
                }
            }
        }
        // 返回字符串拼接处理后的结果
        return charStr.toString().concat(suffix.toString());
    }
}
