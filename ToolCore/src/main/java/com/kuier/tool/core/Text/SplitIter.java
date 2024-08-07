package com.kuier.tool.core.Text;

import com.kuier.tool.core.Collection.ComputeIter;
import com.kuier.tool.core.Lang.Assert;
import com.kuier.tool.core.Text.Finder.TextFinder;
import com.kuier.tool.core.Util.StrUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName SplitIter
 * @Description SplitIter 字符串分割迭代器
 * @Author LiuQi
 * @Date 2024/8/6 9:43
 * @Version 1.0
 */
public class SplitIter extends ComputeIter<String> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 文本内容
     */
    private final String text;

    /**
     * 文本查找器
     */
    private final TextFinder finder;

    /**
     * 分片数
     */
    private final int limit;

    /**
     * 是否忽略空字符串
     */
    private final boolean ignoreEmpty;

    /**
     * 计数器 用于判断是否超过limit
     */
    private int count;

    /**
     * 上一次结束 偏移量位置
     */
    private int offset;

    /**
     * 构造方法
     *
     * @param text
     * @param separatorFinder
     * @param limit
     * @param ignoreEmpty
     * @author LiuQi
     */
    public SplitIter(CharSequence text, TextFinder separatorFinder, int limit, boolean ignoreEmpty) {
        // 断言被查找的文本
        Assert.notNull(text, "Text must be not null!");
        this.text = text.toString();
        // 设置被查找的文本
        this.finder = separatorFinder.setText(text);
        this.limit = limit > 0 ? limit : Integer.MAX_VALUE;
        this.ignoreEmpty = ignoreEmpty;
    }

    /**
     * toList 获取分割后的列表
     *
     * @param func
     * @param <T>
     * @return {@link List<T>}
     * @author LiuQi
     */
    public <T> List<T> toList(Function<String, T> func) {
        // 创建结果集合列表
        List<T> resultList = new ArrayList<>();
        while (this.hasNext()) { // 遍历 hasNext 判断是否有下一个节点元素
            // 获取下一个节点元素
            T apply = func.apply(this.next());
            if (ignoreEmpty && StrUtil.isEmptyIfStr(apply)) { // 数据为空
                // 对于func之后依旧是String的情况 ignoreEmpty依旧有效 继续执行
                continue;
            }
            // 添加到结果集合列表
            resultList.add(apply);
        }
        if (resultList.isEmpty()) { // 结果集合列表为空
            // 返回空集合列表
            return new ArrayList<>(0);
        }
        // 返回结果集合列表
        return resultList;
    }

    @Override
    protected String computeNext() {
        //  达到数量上限或末尾 结束
        if ((count >= limit) || (offset > text.length())) { // 计数器数量 >= 分片数量 或者 偏移量 > 文本长度
            // 返回 null
            return null;
        }
        // 达到数量上限
        if (count == (limit - 1)) { // 计数器数量 = 分片数量 - 1 表示达到数量上限
            if (ignoreEmpty && offset == text.length()) {
                // 最后一个是空字符串 返回 null
                return null;
            }
            // 计算数量递增
            count++;
            // 返回当前偏移量位置的字符串
            return text.substring(offset);
        }
        // 返回开始位置 即起始字符位置
        int start = finder.start(offset);
        if (start < 0) { // 无分隔符 结束
            if (offset <= text.length()) {
                String result = text.substring(offset);
                if (false == ignoreEmpty || false == result.isEmpty()) {
                    offset = Integer.MAX_VALUE;
                    return result;
                }
            }
            return null;
        }
        // 找到新的分隔符位置
        String result = text.substring(offset, start);
        // 返回结束位置 即结束字符位置
        offset = finder.end(start);
        if (ignoreEmpty && result.isEmpty()) { // 忽略空 并且分隔符位置值为空
            // 返回当前方法
            return computeNext();
        }
        count++;
        return result;
    }
}
