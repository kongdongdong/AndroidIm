package com.androidim.lib.handler;

import android.util.Log;

import com.androidim.lib.listener.IoChangeListener;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddkong on 2017/9/13.
 */

public class MinaClientHandler extends IoHandlerAdapter {

    public static final String TAG = "minaClientHandler";

    private List<IoChangeListener> ioChangeListenerList;

    public MinaClientHandler() {
        super();
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        Log.i(TAG,"会话创建=="+session.getId());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.sessionCreated(session);
            }
        }
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        Log.i(TAG,"会话打开=="+session.getId());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.sessionOpened(session);
            }
        }
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        Log.i(TAG,"会话关闭=="+session.getId());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.sessionClosed(session);
            }
        }
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        Log.i(TAG,"会话闲置=="+session.getId());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.sessionIdle(session,status);
            }
        }
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.exceptionCaught(session,cause);
            }
        }
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Log.i(TAG,"接收到消息=="+message.toString());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.messageReceived(session,message);
            }
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        Log.i(TAG,"发送消息=="+message.toString());
        if(ioChangeListenerList !=null){
            for (IoChangeListener ioChangeListener:ioChangeListenerList){
                ioChangeListener.messageSent(session,message);
            }
        }
    }

    public void addIoChangeListener(IoChangeListener messageListener){
        if(ioChangeListenerList ==null){
            ioChangeListenerList = new ArrayList<IoChangeListener>();
        }
        if(messageListener!=null && !ioChangeListenerList.contains(ioChangeListenerList)){
            ioChangeListenerList.add(messageListener);
        }
    }

    public void removeIoChangeListener(IoChangeListener messageListener){
        if(ioChangeListenerList ==null || messageListener==null){
            return;
        }
        if(ioChangeListenerList.contains(ioChangeListenerList)){
            ioChangeListenerList.remove(messageListener);
        }
    }

}
