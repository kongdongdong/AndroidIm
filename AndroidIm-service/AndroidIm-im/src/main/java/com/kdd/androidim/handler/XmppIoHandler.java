package com.kdd.androidim.handler;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ddkong on 2017/9/7.
 */
public class XmppIoHandler implements IoHandler {

    public static Logger logger = LoggerFactory.getLogger(XmppIoHandler.class);


    public void sessionCreated(IoSession ioSession) throws Exception {
        logger.info("会话创建",ioSession.getId());
    }

    public void sessionOpened(IoSession ioSession) throws Exception {
        logger.info("会话打开",ioSession.getId());
    }

    public void sessionClosed(IoSession ioSession) throws Exception {
        logger.info("会话关闭",ioSession.getId());
    }

    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        logger.info("会话闲置",ioSession.getId());
    }

    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {
        logger.info("会话异常",ioSession.getId());
    }

    public void messageReceived(IoSession ioSession, Object o) throws Exception {
        logger.info("接收到消息",ioSession.getId()+"==="+o.toString());

    }

    public void messageSent(IoSession ioSession, Object o) throws Exception {
        logger.info("发送消息",ioSession.getId()+"==="+o.toString());
    }
}
