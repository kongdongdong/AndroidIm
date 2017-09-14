package com.androidim.lib.net;

import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/13.
 */

public class Connection {

    private IoSession session;
    private static Connection connection=null;

    private Connection() throws Exception {
        if(connection!=null){
            throw new Exception();
        }
    }

    public static Connection getConnection(){
        if(connection==null){
            synchronized (Connection.class){
                if(connection==null){
                    try {
                        connection = new Connection();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    public IoSession getSession() {
        return session;
    }

    public void setSession(IoSession session) {
        this.session = session;
    }

    public boolean isConnection(){
        if(session!=null && session.isConnected()){
            return true;
        }
        return false;
    }

    public void disConnection(){
        try {
            if(session!=null && session.isConnected()){
                session.close(true);
                session=null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        if(session!=null && session.isConnected()){
            session.write(message);
        }
    }

}
