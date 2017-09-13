package com.androidim.lib.thread;

import com.androidim.lib.factory.KeepAliveMessageFactoryImpl;

import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/13.
 */

public class HeartBeatThread extends Thread {

    private IoSession session;

    public HeartBeatThread(IoSession session) {
        this.session = session;
    }

    @Override
    public void run() {
        while (true){
            if(session!=null && session.isConnected()){
                session.write(KeepAliveMessageFactoryImpl.HEARTBEATRESPONSE);
            }else {

            }
            try {
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
