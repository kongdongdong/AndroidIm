package com.kdd.androidim.xmpp;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ddkong on 2017/9/7.
 */
public class MyKeepAliveMessageFactory implements KeepAliveMessageFactory {

    public static Logger logger = LoggerFactory.getLogger(KeepAliveMessageFactory.class);


    /** 心跳包内容 */
    private static final String HEARTBEATREQUEST = "1111";
    private static final String HEARTBEATRESPONSE = "1112";
    public Object getRequest(IoSession session) {
        logger.warn("请求预设信息: " + HEARTBEATREQUEST);
        return HEARTBEATREQUEST;
    }
    public Object getResponse(IoSession session, Object request) {
        logger.warn("响应预设信息: " + HEARTBEATRESPONSE);
        /** 返回预设语句 */
        return HEARTBEATRESPONSE;
    }
    public boolean isRequest(IoSession session, Object message) {
        logger.warn("请求心跳包信息: " + message);
        if (message.equals(HEARTBEATREQUEST))
            return true;
        return false;
    }
    public boolean isResponse(IoSession session, Object message) {
        logger.warn("响应心跳包信息: " + message);
        if(message.equals(HEARTBEATRESPONSE))
            return true;
        return false;
    }
}