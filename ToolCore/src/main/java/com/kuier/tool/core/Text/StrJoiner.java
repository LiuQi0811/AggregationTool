package com.kuier.tool.core.Text;

import com.kuier.tool.core.Util.ArrayUtil;
import com.kuier.tool.core.Util.ObjUtil;
import com.kuier.tool.core.Util.StrUtil;

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
     * 是否包含内容
     */
    private boolean hasContent;

    /**
     * 前缀和后缀是否包装每个元素 true表示包装每个元素 false包装整个字符串
     */
    private boolean wrapElement;

    /**
     * 当结果为空时默认返回的拼接结果
     */
    private String emptyResult = StrUtil.EMPTY;

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
     * prepare 准备连接器
     *
     * @return
     * @throws IOException
     */
    private Appendable prepare() throws IOException {
        if (hasContent) { // appendable中 包含内容
            // 追加连接符/分隔符
            appendable.append(delimiter);
        } else { // appendable中 不包含内容
            if (null == appendable) { // 连接器为空
                // 创建StringBuilder对象
                appendable = new StringBuilder();
            }
            if (false == wrapElement && StrUtil.isNotEmpty(prefix)) { // 前缀和后缀 包装整个字符串 并且 前缀不为空
                // 追加前缀
                appendable.append(prefix);
            }
            // appendable中内容状态为true包含内容
            hasContent = true;
        }
        // 返回处理后的连接器
        return appendable;
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
    public StrJoiner append(CharSequence sequence) {
        // 调取append方法 追加元素到拼接器中
        return append(sequence, 0, StrUtil.length(sequence));
    }

    @Override
    public StrJoiner append(CharSequence sequence, int startInclude, int endExclude) {
        if (null == sequence) { //  字符参数为空
            // TODO 字符参数为空.....
            System.out.println(" ..字符参数为空 ...");
        }
        try {
            // 准备连接器
            final Appendable prepare = prepare();
            if (wrapElement && StrUtil.isNotEmpty(prefix)) { // 前缀和后缀 包装每个元素 并且前缀不为空
                // 连接器追加前缀
                prepare.append(prefix);
            }
            // 连接器追加元素
            prepare.append(sequence, startInclude, endExclude);
            if (wrapElement && StrUtil.isNotEmpty(suffix)) { // 前缀和后缀 包装每个元素 并且后缀不为空
                // 连接器追加后缀
                prepare.append(suffix);
            }
        } catch (IOException e) {
            //IGNORE
        }
        return this;
    }

    @Override
    public StrJoiner append(char char_) throws IOException {
        // 调取append方法 追加元素到拼接器中
        return append(String.valueOf(char_));
    }

    @Override
    public String toString() {
        if (null == appendable) { // 连接器为空
            return emptyResult;
        }
        // 连接器字符串
        String result = appendable.toString();
        if (false == wrapElement && StrUtil.isNotEmpty(suffix)) { // 前缀和后缀 包装整个字符串 并且 后缀不为空
            // 连接器字符串 拼接处理
            result += suffix;
        }
        // 返回连接器处理后的字符串
        return result;
    }

    public static void main(String[] args) {
        try {
            final Appendable prepare = new StrJoiner("/").prepare();
            prepare.append("I ");
            prepare.append("Love ");
            prepare.append("!");
            System.out.println(prepare);
        } catch (Exception e) {

        }
    }
}
