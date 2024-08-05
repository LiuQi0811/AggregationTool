package com.kuier.tool.core.Io.Resource;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName UrlResource
 * @Description UrlResource URL资源访问类
 * @Author LiuQi
 * @Date 2024/8/2 15:14
 * @Version 1.0
 */
public class UrlResource implements Resource {
    /**
     * 资源URL
     */
    protected URL url;

    /**
     * 参数构造 url
     *
     * @param url
     */
    public UrlResource(URL url) {
        this(url, null);
    }

    /**
     * 参数构造 url name
     *
     * @param name
     * @param url
     */
    public UrlResource(URL url, String name) {
        this.url = url;
    }

    static {
        try {
            UrlResource urlResource = new UrlResource(new URL("https://www.baidu.com"));
            System.out.println(urlResource.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
