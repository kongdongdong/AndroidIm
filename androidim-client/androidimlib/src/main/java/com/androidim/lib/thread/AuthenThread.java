package com.androidim.lib.thread;

import android.util.Log;

import com.androidim.lib.factory.IoMessageFactory;
import com.androidim.lib.handler.MinaClientHandler;
import com.androidim.lib.listener.IoChangeListener;
import com.androidim.lib.net.Connection;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/14.
 */

public class AuthenThread implements IoChangeListener {

    private static String TAG = "AuthenThread";

    private Connection connection;
    private MinaClientHandler minaClientHandler;

    public AuthenThread() {
        connection = Connection.getConnection();
        minaClientHandler = new MinaClientHandler();
        minaClientHandler.addIoChangeListener(this);
    }

    public void start(){
        new Thread(){
            @Override
            public void run() {
                connection.sendMessage(IoMessageFactory.createStream());
            }
        }.start();
    }



    @Override
    public void sessionCreated(IoSession session) {

    }

    @Override
    public void sessionOpened(IoSession session) {

    }

    @Override
    public void sessionClosed(IoSession session) {

    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {

    }

    @Override
    public void messageReceived(IoSession session, Object message) {
        Log.i("TAG",message.toString());
    }

    @Override
    public void messageSent(IoSession session, Object message) {

    }
}
