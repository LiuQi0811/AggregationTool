package com.kuier.tool.core.Util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TypeUtil
 * @Description TypeUtil 参数和返回值类型相关 工具类
 * @Author LiuQi
 * @Date 2024/8/7 16:09
 * @Version 1.0
 */
public class TypeUtil {
    /**
     * isUnknown 是否为未知类型
     *
     * @param type
     * @return {@link Boolean}
     * @author LiuQi
     */
    public static Boolean isUnknown(Type type) {
        // 类型参数为空 或者 类型参数是 TypeVariable 返回true 则返回false
        return null == type || type instanceof TypeVariable;
    }

    /**
     * getClass 获取Type对应的映射类
     *
     * @param type
     * @return {@link Class<?>}
     * @author LiuQi
     */
    public static Class<?> getClass(Type type) {
        if (null != type) { // 类型参数不为空
            if (type instanceof Class) { // 类型参数是Class
                // 返回 类型参数类型
                return ((Class<?>) type);
            }
            // TODO other type .....
        }
        return null;
    }

    /**
     * toParameterizedType 获取当前类或父类中泛型参数化后的类型
     *
     * @param type
     * @return {@link ParameterizedType}
     * @author LiuQi
     */
    public static ParameterizedType toParameterizedType(final Type type) {
        // 获取当前类或父类中泛型参数化后的类型
        return toParameterizedType(type, 0);
    }

    /**
     * toParameterizedType 获取当前类或父类中泛型参数化后的类型
     *
     * @param type
     * @param interfaceIndex
     * @return {@link ParameterizedType}
     * @author LiuQi
     */
    public static ParameterizedType toParameterizedType(final Type type, final int interfaceIndex) {
        if (type instanceof ParameterizedType) { // 类型参数是ParameterizedType类型
            return ((ParameterizedType) type);
        }
        if (type instanceof Class) { // 类型参数是Class类型
            // 获取指定类所有泛型父类和泛型接口数组
            ParameterizedType[] generics = getGenerics(((Class<?>) type));
            if (generics.length > interfaceIndex) { // 接口数组长度 > 接口索引（第几个接口）
                return generics[interfaceIndex];
            }
        }
        return null;
    }

    /**
     * getGenerics 获取指定类所有泛型父类和泛型接口
     *
     * @param clazz
     * @return {@link  ParameterizedType[]}
     * @author LiuQi
     */
    public static ParameterizedType[] getGenerics(final Class<?> clazz) {
        // 创建ParameterizedType列表集合
        final List<ParameterizedType> parameterizedTypeList = new ArrayList<>();
        // 获取泛型父类（父类及祖类优先级高）
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (null != genericSuperclass && !Object.class.equals(genericSuperclass)) { // 泛型父类不为空 并且不是Object
            // 获取当前类或父类中泛型参数化后的类型
            ParameterizedType parameterizedType = toParameterizedType(genericSuperclass);
            if (null != parameterizedType) { // 获取当前类或父类中泛型参数化后的类型不为空
                // 添加到列表集合
                parameterizedTypeList.add(parameterizedType);
            }
        }
        // 返回泛型接口（接口及接口实现类优先级高）列表转数组
        return parameterizedTypeList.toArray(new ParameterizedType[0]);
    }
}
