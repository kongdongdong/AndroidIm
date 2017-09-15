package com.kdd.androidim.handler;

import com.kdd.androidim.enums.ConnStatus;
import com.kdd.androidim.net.Connection;
import com.kdd.androidim.pocket.XMPPPacketParser;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ddkong on 2017/9/7.
 */
public class XmppIoHandler implements IoHandler {

    public static Logger logger = LoggerFactory.getLogger(XmppIoHandler.class);
    public static final String XMLPACKETPARSER = "XMLPACKETPARSER";

    private static final String CONNECTION = "CONNECTION";


    private Map<Integer,Connection> connectionMap = new ConcurrentHashMap<Integer, Connection>();

    public void sessionCreated(IoSession ioSession) throws Exception {
        logger.info("会话创建"+ioSession.getId());
    }

    public void sessionOpened(IoSession ioSession) throws Exception {
        logger.info("会话打开"+ioSession.getId());


        Connection connection= new Connection(ioSession, ConnStatus.STATUS_CONNECTED);
        XMPPPacketParser xmppPacketParser = new XMPPPacketParser(connection);
        ioSession.setAttribute(XMLPACKETPARSER,xmppPacketParser);
        ioSession.setAttribute(CONNECTION,connection);

        int hashCode = Thread.currentThread().hashCode();
        connectionMap.put(hashCode,connection);
    }

    public void sessionClosed(IoSession ioSession) throws Exception {
        logger.info("会话关闭"+ioSession.getId());
        Connection connection = (Connection) ioSession.getAttribute(CONNECTION);
        connection.close();
    }

    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        logger.info("会话闲置"+ioSession.getId());
        Connection connection = (Connection) ioSession.getAttribute(CONNECTION);
        connection.close();
    }

    public void exceptionCaught(IoSession ioSession, Throwable throwable) throws Exception {
        logger.info("会话异常"+ioSession.getId());
    }

    public void messageReceived(IoSession ioSession, Object o) throws Exception {
        logger.info("接收到消息"+ioSession.getId()+"==="+o.toString());

        XMPPPacketParser xmppPacketParser = (XMPPPacketParser) ioSession.getAttribute(XMLPACKETPARSER);
        xmppPacketParser.parserPacket(o.toString());

    }

    public void messageSent(IoSession ioSession, Object o) throws Exception {
        logger.info("发送消息"+ioSession.getId()+"==="+o.toString());
    }
}
