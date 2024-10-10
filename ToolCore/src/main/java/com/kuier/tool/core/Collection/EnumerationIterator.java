package com.kuier.tool.core.Collection;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * @ClassName EnumerationIterator
 * @Description EnumerationIterator 枚举迭代器
 * @Author LiuQi
 * @Date 2024/10/10 15:50
 * @Version 1.0
 */
public class EnumerationIterator<E> implements Iterator<E>, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 枚举
     */
    private final Enumeration<E> enumeration;

    /**
     * 构造方法
     * @param enumeration
     * @author LiuQi
     */
    public EnumerationIterator(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * hasNext 是否还有下一个元素
     * @return {@link boolean}
     * @author LiuQi
     */
    @Override
    public boolean hasNext() {
        // 是否含有更多元素
        return enumeration.hasMoreElements();
    }

    /**
     * next 获取下一个元素
     * @return {@link E}
     * @author LiuQi
     */
    @Override
    public E next() {
        // 获取下一个元素
        return enumeration.nextElement();
    }

    /**
     * remove 移除元素
     * @author LiuQi
     */
    @Override
    public void remove() {
        // 不支持的操作异常
        throw new UnsupportedOperationException();
    }
}
