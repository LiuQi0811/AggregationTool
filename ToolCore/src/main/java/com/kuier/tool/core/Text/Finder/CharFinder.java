package com.kuier.tool.core.Text.Finder;

import com.kuier.tool.core.Lang.Assert;
import com.kuier.tool.core.Util.NumberUtil;

/**
 * @ClassName CharFinder
 * @Description CharFinder 字符查找器
 * @Author LiuQi
 * @Date 2024/8/6 11:57
 * @Version 1.0
 */
public class CharFinder extends TextFinder {
    private static final long serialVersionUID = 1L;

    /**
     * 字符
     */
    private final char char_;

    /**
     * 是否忽略大小写
     */
    private final boolean caseInsensitive;

    /**
     * 构造方法
     *
     * @param char_
     * @param ignoreCase
     * @author LiuQi
     */
    public CharFinder(char char_, boolean ignoreCase) {
        // 设置字符
        this.char_ = char_;
        // 设置是否忽略大小写
        this.caseInsensitive = ignoreCase;
    }

    @Override
    public int start(int index_) {
        Assert.notNull(text, "Text to find must be not null!");
        // 获取有效结束位置
        int limit = getValidEndIndex();
        if (negative) { // 反向查找
            System.out.println("反向查找");
        } else { // 非反向查找
            for (int i = index_; i < limit; i++) {
                if (NumberUtil.equals(char_, text.charAt(i), caseInsensitive)) { // 字符相同处理
                    // 返回字符索引
                    return i;
                }
            }
        }
        // 返回 -1
        return -1;
    }

    @Override
    public int end(int index_) {
        if (index_ < 0) {
            return -1;
        }
        return index_ + 1;
    }
}
