package com.androidim.lib.factory;

import android.util.Log;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

/**
 * Created by ddkong on 2017/9/13.
 */

public class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {

    public static final String TAG = "minaClientHandler";

    /** 心跳包内容 */
    public static final String HEARTBEATREQUEST = "1112";
    public static final String HEARTBEATRESPONSE = "1111";

    @Override
    public Object getRequest(IoSession session) {
        return HEARTBEATREQUEST;
    }

    @Override
    public Object getResponse(IoSession session, Object request) {
        return HEARTBEATRESPONSE;
    }
    @Override
    public boolean isRequest(IoSession session, Object message) {
        Log.i(TAG,"请求心跳包=="+message.toString());

        if (message.equals(HEARTBEATREQUEST))
            return true;
        return false;
    }

    @Override
    public boolean isResponse(IoSession session, Object message) {
        Log.i(TAG,"回复心跳包=="+message.toString());

        if(message.equals(HEARTBEATRESPONSE))
            return true;
        return false;
    }


}
