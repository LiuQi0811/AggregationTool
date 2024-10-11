package com.kuier.tool.core.Text.Finder;

/**
 * @ClassName Finder
 * @Description Finder 字符串查找接口
 * @Author LiuQi
 * @Date 2024/8/6 13:51
 * @Version 1.0
 */
public interface Finder {
    /**
     * start 返回开始位置 即起始字符位置（包含） 未找到返回-1
     *
     * @param index_
     * @return {@link int}
     * @author LiuQi
     */
    int start(int index_);

    /**
     * end 返回结束位置 即结束字符位置（不包含） 未找到返回-1
     * @param index_
     * @return {@link int}
     * @author LiuQi
     */
    int end(int index_);

    /**
     * INDEX_NOT_FOUND 未找到返回-1
     */
    int INDEX_NOT_FOUND = -1;
}
