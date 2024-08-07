package com.kuier.tool.core.Collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName ComputeIter
 * @Description ComputeIter 计算属性迭代器
 * @Author LiuQi
 * @Date 2024/8/6 10:22
 * @Version 1.0
 */
public abstract class ComputeIter<T> implements Iterator<T> {

    /**
     * 下一个节点
     */
    private T next;

    /**
     * 完成标识
     */
    private boolean finished;

    /**
     * 计算下一个节点
     *
     * @return
     */
    protected abstract T computeNext();

    @Override
    public boolean hasNext() {
        if (null != next) { // 节点不为空
            // 用户读取了节点 但是没有使用
            return true;
        } else if (finished) { // finished = true 完成状态
            // 读取结束
            return false;
        }
        // 创建computeNext 计算节点对象
        T result = computeNext();
        if (null == result) { // 对象为空
            // 完成状态 finished = true
            this.finished = true;
            // 返回 false
            return false;
        } else { // 对象不为空
            // 节点赋值
            this.next = result;
            // 返回 true
            return true;
        }
    }

    @Override
    public T next() {
        if (false == hasNext()) { // 没有更多节点
            throw new NoSuchElementException("No more lines");
        }
        // 当前节点
        T result = this.next;
        // 清空cache 表示此节点读取完毕 下次计算新节点
        this.next = null;
        return result;
    }
}
