package com.kuier.tool.core.Text;

import com.kuier.tool.core.Util.ArrayUtil;
import com.kuier.tool.core.Util.ObjUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

/**
 * @ClassName StrJoiner
 * @Description StrJoiner 字符串连接器（拼接器）
 * @Author LiuQi
 * @Date 2024/8/7 11:30
 * @Version 1.0
 */
public class StrJoiner implements Appendable, Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 连接器
     */
    private Appendable appendable;

    /**
     * 连接符
     */
    private CharSequence delimiter;

    /**
     * 前缀
     */
    private CharSequence prefix;

    /**
     * 后缀
     */
    private CharSequence suffix;

    /**
     * 构造方法
     *
     * @param delimiter
     * @author LiuQi
     */
    public StrJoiner(CharSequence delimiter) {
        this(null, delimiter);
    }

    /**
     * 构造方法
     *
     * @param appendable
     * @param delimiter
     * @author LiuQi
     */
    public StrJoiner(Appendable appendable, CharSequence delimiter) {
        this(appendable, delimiter, null, null);
    }

    /**
     * 构造方法
     *
     * @param appendable
     * @param delimiter
     * @param prefix
     * @param suffix
     * @author LiuQi
     */
    public StrJoiner(Appendable appendable, CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        if (null != appendable) { // 连接器不为空
            // 设置连接器
            this.appendable = appendable;
        }
        // 设置连接符
        this.delimiter = delimiter;
        // 设置前缀
        this.prefix = prefix;
        // 设置后缀
        this.suffix = suffix;
    }

    /**
     * of 指定分隔符创建StrJoiner
     *
     * @param delimiter
     * @return {@link StrJoiner}
     * @author LiuQi
     */
    public static StrJoiner of(CharSequence delimiter) {
        // 返回 创建StrJoiner对象
        return new StrJoiner(delimiter);
    }

    /**
     * append 追加元素到拼接器中
     *
     * @param iterator
     * @param <T>
     * @return {@link StrJoiner}
     * @author LiuQi
     */
    public <T> StrJoiner append(Iterator<T> iterator) {
        if (null != iterator) { // 迭代器不为空
            while (iterator.hasNext()) { // 循环迭代
                // 追加元素到拼接器中
                append(iterator.next());
            }
        }
        // 返回 当前对象
        return this;
    }

    /**
     * append 追加元素到拼接器中
     *
     * @param data
     * @return {@link StrJoiner}
     * @author LiuQi
     */
    public StrJoiner append(Object data) {
        if (null == data) { // 对象参数为空
            //TODO .....
            System.out.println(" 对象参数为空");
        } else if (ArrayUtil.isArray(data)) { // 对象参数类型为数组
            //TODO .....
            System.out.println(" 对象参数类型为数组");
        } else if (data instanceof Iterator) { // 对象参数类型为Iterator 迭代器
            //TODO .....
            System.out.println(" 对象参数类型为Iterator 迭代器");
        } else if (data instanceof Iterable) { // 对象参数类型为Iterable 迭代器
            //TODO .....
            System.out.println(" 对象参数类型为Iterable 迭代器");
        } else {// 对象参数不为空
            // 追加元素到拼接器中 对象转字符串
            append(ObjUtil.toString(data));
        }
        // 返回 当前对象
        return this;
    }

    @Override
    public Appendable append(CharSequence csq) {
        System.out.println(" ......... ???????????? ");
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }
}
