package com.kuier.tool.core.Convert.Impl;

import com.kuier.tool.core.Convert.AbstractConverter;

/**
 * @ClassName StringConverter
 * @Description StringConverter 字符串转换器实现
 * @Author LiuQi
 * @Date 2024/8/8 10:53
 * @Version 1.0
 */
public class StringConverter extends AbstractConverter<String> {
    private static final long serialVersionUID = 1L;

    @Override
    protected String convertInternal(Object value) {
        System.out.println(" StringConverter.convertInternal 内部转换 .... ");
        return null;
    }
}
