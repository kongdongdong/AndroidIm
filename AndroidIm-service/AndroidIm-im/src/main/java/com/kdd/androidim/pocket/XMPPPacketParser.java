package com.kdd.androidim.pocket;

import com.kdd.androidim.enums.ConnStatus;
import com.kdd.androidim.net.Connection;
import org.springframework.util.StringUtils;

/**
 * Created by ddkong on 2017/9/15.
 */
public class XMPPPacketParser {

    private Connection connection;

    public XMPPPacketParser(Connection connection) {
        this.connection = connection;
    }

    public void parserPacket(String message){
        if(message==null || StringUtils.isEmpty(message)){
            return;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
