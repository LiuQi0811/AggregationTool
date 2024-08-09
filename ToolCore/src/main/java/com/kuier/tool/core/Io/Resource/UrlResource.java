package com.kuier.tool.core.Io.Resource;

import com.kuier.tool.core.Util.UrlUtil;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

/**
 * @ClassName UrlResource
 * @Description UrlResource URL资源访问类
 * @Author LiuQi
 * @Date 2024/8/2 15:14
 * @Version 1.0
 */
public class UrlResource implements Resource, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 资源URL
     */
    protected URL url;
    /**
     * 名称
     */
    protected String name;

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
        if (null != url) {

        }
    }

    @Override
    public InputStream getStream() {
        if (null == url) { // url 为空
            throw new RuntimeException("Resource URL is null!");
        }
        // 返回流 从URL中获取流
        return UrlUtil.getStream(url);
    }
}
