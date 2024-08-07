package com.kuier.tool.core.Text.Finder;

import com.kuier.tool.core.Lang.Assert;

import java.io.Serializable;

/**
 * @ClassName TextFinder
 * @Description TextFinder 文本查找抽象类
 * @Author LiuQi
 * @Date 2024/8/6 10:57
 * @Version 1.0
 */
public abstract class TextFinder implements Finder, Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * text 被查找的文本
     */
    protected CharSequence text;
    /**
     * negative 是否是反向查找
     */
    protected boolean negative;
    /**
     * endIndex 结束查找的索引
     */
    protected int endIndex = -1;

    /**
     * setText 设置被查找的文本
     *
     * @param text
     * @return {@link TextFinder}
     * @author LiuQi
     */
    public TextFinder setText(CharSequence text) {
        // 断言 设置被查找的文本
        this.text = Assert.notNull(text, "Text must be not null!");
        return this;
    }

    /**
     * getValidEndIndex 获取有效结束位置
     *
     * @return {@link  int}
     */
    protected int getValidEndIndex() {
        if (negative && -1 == endIndex) { // 反向查找模式下 -1表示0前面的位置 即字符串反向末尾的位置
            return -1;
        }
        // 分页数量
        final int limit;
        if (endIndex < 0) { // 结束查找的索引 < 0
            // 更新分页数量 结束查找的索引 + 文本长度 + 1
            limit = endIndex + text.length() + 1;
        } else {
            // 更新分页数量 结束查找的索引 文本长度 最小值
            limit = Math.min(endIndex, text.length());
        }
        // 返回分页数量
        return limit;
    }
}
