package com.androidim.lib.listener;

import android.util.Log;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/15.
 */

public interface IoChangeListener {

    public void sessionCreated(IoSession session);

    public void sessionOpened(IoSession session);

    public void sessionClosed(IoSession session);

    public void sessionIdle(IoSession session, IdleStatus status);

    public void exceptionCaught(IoSession session, Throwable cause);

    public void messageReceived(IoSession session, Object message);

    public void messageSent(IoSession session, Object message);


}
