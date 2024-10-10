package com.kuier.tool.core.Lang;

/**
 * @ClassName Filter
 * @Description Filter 过滤器接口
 * @Author LiuQi
 * @Date 2024/10/10 9:37
 * @Version 1.0
 */
@FunctionalInterface
public interface Filter <T>{

    /**
     * 是否接受对象
     * @param data
     * @return
     * @author LiuQi
     */
    boolean accept(T data);
}
