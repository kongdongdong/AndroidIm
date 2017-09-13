package com.androidim.lib.listener;

import com.androidim.lib.exception.ConnectionException;

import org.apache.mina.core.session.IoSession;

/**
 * Created by ddkong on 2017/9/13.
 */

public interface ConnectionListener {

    void ConnectSuccess(IoSession session);
    void ConnectFail(ConnectionException e);


}
