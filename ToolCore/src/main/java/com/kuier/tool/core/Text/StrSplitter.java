package com.kuier.tool.core.Text;

import com.kuier.tool.core.Text.Finder.CharFinder;
import com.kuier.tool.core.Util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName StrSplitter
 * @Description StrSplitter 字符串分割器 统一静态方法封装类
 * @Author LiuQi
 * @Date 2024/8/6 9:11
 * @Version 1.0
 */
public class StrSplitter {

    /**
     * split 字符串分割处理
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
        // 返回split 字符串分割 非空
        return split(charStr, separator, limit, isTrim, ignoreEmpty, false);
    }

    /**
     * split 字符串分割处理
     *
     * @param charStr
     * @param separator
     * @param limit
     * @param isTrim
     * @param ignoreEmpty
     * @param ignoreCase
     * @return {@link List<String>}
     * @author LiuQi
     */
    public static List<String> split(CharSequence charStr, char separator, int limit, boolean isTrim, boolean ignoreEmpty, boolean ignoreCase) {
        // 返回split 字符串分割
        return split(charStr, separator, limit, ignoreEmpty, ignoreCase, trimFunc(isTrim));
    }

    /**
     * split 字符串分割处理
     *
     * @param charStr
     * @param separator
     * @param limit
     * @param ignoreEmpty
     * @param ignoreCase
     * @param func
     * @param <R>
     * @return {@link List<R>}
     * @author LiuQi
     */
    public static <R> List<R> split(CharSequence charStr, char separator, int limit, boolean ignoreEmpty, boolean ignoreCase, Function<String, R> func) {
        if (null == charStr) { // 字符串参数 为空
            // 返回 空集合列表
            return new ArrayList<>(0);
        }
        // 创建字符串分割迭代器对象
        SplitIter splitIter = new SplitIter(charStr,
                // 创建字符查找器对象
                new CharFinder(separator, ignoreCase), limit, ignoreEmpty);
        // 返回分割后的列表
        return splitIter.toList(func);
    }

    /**
     * trimFunc 空白字符串/空格函数处理
     *
     * @param isTrim
     * @return {@link Function<String,String>}
     * @author LiuQi
     */
    private static Function<String, String> trimFunc(boolean isTrim) {
        // isTrim = true 返回空白字符串/空格函数处理后的字符串 isTrim = false 返回原字符串
        return (str) -> isTrim ? StrUtil.trim(str) : str;
    }
}
