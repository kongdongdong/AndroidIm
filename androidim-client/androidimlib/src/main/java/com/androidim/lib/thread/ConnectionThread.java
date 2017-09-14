package com.androidim.lib.thread;

import android.util.Log;

import com.androidim.lib.Config;
import com.androidim.lib.exception.ConnectionException;
import com.androidim.lib.factory.KeepAliveMessageFactoryImpl;
import com.androidim.lib.handler.MinaClientHandler;
import com.androidim.lib.listener.ConnectionListener;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by ddkong on 2017/9/8.
 */

public class ConnectionThread extends Thread{
    public static final String TAG = "ConnectionThread";

    private ConnectionListener connectionListener;

    public ConnectionThread() {
    }

    public ConnectionThread(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
    }

    public void setConnectionListener(ConnectionListener connectionListener){
        this.connectionListener = connectionListener;
    }

    @Override
    public void run() {
        IoConnector connector = new NioSocketConnector();
        //设置链接超时时间
        connector.setConnectTimeoutMillis(Config.CONNECTION_TIMEOUT);
        //添加过滤器
        //connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory()));
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),LineDelimiter.WINDOWS.getValue())));

        connector.getSessionConfig().setReadBufferSize(Config.BUFFERSIZE);
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, Config.INTERVAL_TIMEOUT);
        //connector.getSessionConfig().setKeepAlive(true);
        KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory);
        //是否回发
        heartBeat.setForwardEvent(true);
        // 发送频率
        heartBeat.setRequestInterval(Config.INTERVAL);
        connector.getFilterChain().addLast("heartbeat", heartBeat);

        connector.setHandler(new MinaClientHandler());
        try{
            ConnectFuture future = connector.connect(new InetSocketAddress(Config.IP_HOST,Config.IP_PORT));//创建链接
            future.awaitUninterruptibly();// 等待连接创建完成
            IoSession session = future.getSession();//获得session
            if(session.isConnected()){
                Log.e(TAG,"客户端连接成功...");
                if(connectionListener!=null){
                    connectionListener.ConnectSuccess(session);
                }
            }else {
                Log.e(TAG,"客户端连接失败...");
                if(connectionListener!=null){
                    connectionListener.ConnectFail(new ConnectionException("连接服务器失败"));
                }
            }
        }catch (Exception e){
            Log.e(TAG,"客户端链接异常...");
            if(connectionListener!=null){
                connectionListener.ConnectFail(new ConnectionException(e.getMessage()));
            }
            e.printStackTrace();
        }
    }
}
