package com.androidim.lib;

import android.util.Log;

import com.androidim.lib.exception.ConnectionException;
import com.androidim.lib.listener.ConnectionListener;
import com.androidim.lib.net.Connection;
import com.androidim.lib.thread.AuthenThread;
import com.androidim.lib.thread.ConnectionThread;
import com.androidim.lib.thread.HeartBeatThread;

import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/13.
 */

public class XmppManager {

    public static final String TAG = "XmppManager";
    private static XmppManager xmppManager;
    private Connection connection;
    private ConnectionThread connectionThread;

    private XmppManager() throws Exception {
        if(xmppManager!=null){
            throw new Exception();
        }
    }

    public static XmppManager getXmppManager(){
        if(xmppManager==null){
            synchronized (XmppManager.class) {
                if (xmppManager == null) {
                    try {
                        xmppManager = new XmppManager();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return xmppManager;
    }


    public void startConnection(){
        if(connectionThread==null){
            connectionThread = new ConnectionThread();
        }
        connectionThread.addConnectionListener(new ConnectionListener() {
            @Override
            public void ConnectSuccess(IoSession session) {
                Log.i(TAG,"客户端连接成功...");
                getConnection().setSession(session);
                startAuthenThread();
                new HeartBeatThread().start();
            }
            @Override
            public void ConnectFail(ConnectionException e) {
                Log.i(TAG,"客户端连接失败..."+e.getMessage());
            }
        });
        connectionThread.start();
    }

    public void startAuthenThread(){
        new AuthenThread().start();
    }

    public Connection getConnection() {
        if(connection==null){
            connection = Connection.getConnection();
        }
        return connection;
    }

}
