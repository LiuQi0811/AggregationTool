package com.kuier.tool.core.Io.Exception;

import com.kuier.tool.core.Util.ExceptionUtil;

/**
 * @ClassName IORuntimeException
 * @Description IORuntimeException IO 运行异常类
 * @Author LiuQi
 * @Date 2024/10/10 15:37
 * @Version 1.0
 */
public class IORuntimeException extends RuntimeException {

    public IORuntimeException(String message) {
        super(message);
    }

    /**
     * IORuntimeException 有参构造函数
     * @param throwable
     * @author LiuQi
     */
    public IORuntimeException(Throwable throwable){
        super(ExceptionUtil.getMessage(throwable));
    }
}
