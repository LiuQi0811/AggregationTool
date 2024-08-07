package com.kuier.tool.core.Convert;

import java.lang.reflect.Type;

/**
 * @ClassName Convert
 * @Description Convert 类型转换器
 * @Author LiuQi
 * @Date 2024/8/7 14:30
 * @Version 1.0
 */
public class Convert {
    /**
     * convertWithCheck 转换值为指定类型 可选是否不抛异常转换
     *
     * @param type
     * @param value
     * @param defaultValue
     * @param quietly
     * @param <T>
     * @return {@link T}
     * @author LiuQi
     */
    public static <T> T convertWithCheck(Type type, Object value, T defaultValue, boolean quietly) {
        System.out.println(" Convert with check " + type);
        System.out.println(" Convert with check " + value);
        System.out.println(" Convert with check " + defaultValue);
        System.out.println(" Convert with check " + quietly);
        // 获取ConverterRegistry 单例实例
        ConverterRegistry registry = ConverterRegistry.getInstance();
        // 转换值为指定类型
        registry.convert(type, value, defaultValue);
        System.out.println(" Convert with check " + registry);

        return null;
    }

    static class F {
        String name;
        String address;

        F(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    static class K {
        String name;
        String address;

        K() {

        }
    }

    public static void main(String[] args) {
        convertWithCheck(F.class, new F("江小白", "北京-东城区"), new K(), true);
    }
}
