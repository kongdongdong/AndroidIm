package com.kdd.androidim.net;

import com.kdd.androidim.enums.ConnStatus;
import org.apache.ibatis.annotations.Param;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ddkong on 2017/9/15.
 */
public class Connection {

    public static Logger logger = LoggerFactory.getLogger(Connection.class);


    private IoSession ioSession;
    private ConnStatus connStatus;

    public Connection(IoSession ioSession,ConnStatus connStatus) {
        this.ioSession = ioSession;
        this.connStatus =connStatus;
    }


    public void close(){
        connStatus = ConnStatus.STATUS_CLOSED;
        if(ioSession!=null){
            ioSession.close(false);
        }
    }



    public IoSession getIoSession() {
        return ioSession;
    }

    public void setIoSession(IoSession ioSession) {
        this.ioSession = ioSession;
    }

    public ConnStatus getConnStatus() {
        return connStatus;
    }

    public void setConnStatus(ConnStatus connStatus) {
        this.connStatus = connStatus;
    }
}
