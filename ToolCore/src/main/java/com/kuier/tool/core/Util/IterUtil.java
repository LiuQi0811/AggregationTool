package com.kuier.tool.core.Util;

import com.kuier.tool.core.Text.StrJoiner;

import java.util.Iterator;

/**
 * @ClassName IterUtil
 * @Description IterUtil 迭代器相关工具类
 * @Author LiuQi
 * @Date 2024/8/7 11:17
 * @Version 1.0
 */
public class IterUtil {
    /**
     * join 集合拆解拼接组合字符串处理
     *
     * @param iterator
     * @param charMark
     * @param <T>
     * @return {@link String}
     * @author LiuQi
     */
    public static <T> String join(Iterator iterator, CharSequence charMark) {
        // 返回指定分隔符创建StrJoiner 并追加元素到拼接器中
        return StrJoiner.of(charMark).append(iterator).toString();
    }

}
