package com.androidim.lib.handler;

import android.util.Log;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/13.
 */

public class MinaClientHandler extends IoHandlerAdapter {

    public static final String TAG = "minaClientHandler";

    public MinaClientHandler() {
        super();
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        Log.i(TAG,"会话创建=="+session.getId());
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        Log.i(TAG,"会话打开=="+session.getId());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        Log.i(TAG,"会话关闭=="+session.getId());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        Log.i(TAG,"会话闲置=="+session.getId());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Log.i(TAG,"接收到消息=="+message.toString());
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        Log.i(TAG,"发送消息=="+message.toString());
    }
}
