package com.androidim.lib.factory;

import com.androidim.lib.common.Content;

/**
 * Created by ddkong on 2017/9/15.
 */

public class IoMessageFactory {

    public static String createStream(){
        StringBuilder sb = new StringBuilder();
        sb.append("<stream:stream xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' to='");
        sb.append(Content.IP_HOST+":"+ Content.IP_PORT);
        sb.append("' version='1.0'>");
        return sb.toString();
    }
}
