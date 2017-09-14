package com.androidim.lib.thread;

import com.androidim.lib.net.Connection;

/**
 * Created by ddkong on 2017/9/14.
 */

public class AuthenThread extends Thread {

    private Connection connection;

    public AuthenThread() {
        connection = Connection.getConnection();
    }

    @Override
    public void run() {
        connection.sendMessage("");
    }



}
