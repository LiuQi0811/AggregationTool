package com.kuier.tool.core.Io.Resource;

import java.io.InputStream;

/**
 * @ClassName Resource
 * @Description Resource 资源接口
 * @Author LiuQi
 * @Date 2024/8/2 14:04
 * @Version 1.0
 */
public interface Resource {
    
    /**
     * getStream 获取InputStream资源流
     *
     * @return {@link InputStream}
     * @author LiuQi
     */
    InputStream getStream();
}
