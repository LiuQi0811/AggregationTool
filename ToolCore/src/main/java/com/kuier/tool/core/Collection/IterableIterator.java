package com.kuier.tool.core.Collection;

import java.util.Iterator;

/**
 * @ClassName IterableIterator
 * @Description IterableIterator 迭代处理器
 * @Author LiuQi
 * @Date 2024/10/10 16:20
 * @Version 1.0
 */
public interface IterableIterator<T> extends Iterable<T>, Iterator<T> {
    /**
     * 重写迭代器
     * @return {@link Iterator}
     * @author LiuQi
     */
    @Override
    default Iterator<T> iterator(){return this;}
}
