package com.kuier.tool.core.Caller;

import java.io.Serializable;

/**
 * @ClassName SecurityManagerCaller
 * @Description SecurityManagerCaller 安全管理器调用者
 * @Author LiuQi
 * @Date 2024/7/29 10:02
 * @Version 1.0
 */
public class SecurityManagerCaller extends SecurityManager implements Caller, Serializable {
    private static final long serialVersionUID = 1L;
    private static final int OFFSET = 1;

    @Override
    public Class<?> callerCallerInstance() {
        Class<?>[] context = getClassContext();
        if (null != context && (OFFSET + 2) < context.length) {
            return context[OFFSET + 2];
        }
        return null;
    }

    @Override
    public Class<?> callerInstance() {
        Class<?>[] context = getClassContext();
        if (null != context && (OFFSET + 1) < context.length) {
            return context[OFFSET + 1];
        }
        return null;
    }
}
