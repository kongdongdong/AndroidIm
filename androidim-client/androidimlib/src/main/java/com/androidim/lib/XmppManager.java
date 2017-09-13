package com.androidim.lib;

import com.androidim.lib.thread.ConnectionThread;

/**
 * Created by ddkong on 2017/9/13.
 */

public class XmppManager {


    private static  XmppManager xmppManager;

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


    public static void startConnection(){

        new ConnectionThread().start();

    }

}
