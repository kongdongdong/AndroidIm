package com.androidim.lib.thread;

import android.util.Log;

import com.androidim.lib.common.Content;
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
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddkong on 2017/9/8.
 */

public class ConnectionThread{

    public static final String TAG = "ConnectionThread";
    private List<ConnectionListener> connectionListenerList;

    public ConnectionThread() {
        this.connectionListenerList = new ArrayList<>();
    }

    public void addConnectionListener(ConnectionListener connectionListener){
        if(connectionListenerList==null){
            connectionListenerList = new ArrayList<ConnectionListener>();
        }
        if(connectionListener!=null && !connectionListenerList.contains(connectionListener)){
            connectionListenerList.add(connectionListener);
        }
    }

    public void removeConnectionListener(ConnectionListener connectionListener){
        if(connectionListener==null || connectionListenerList==null){
           return;
        }
        if(connectionListenerList.contains(connectionListener)){
            connectionListenerList.remove(connectionListener);
        }
    }

    public void start(){
        new Thread(){
            @Override
            public void run() {
                IoConnector connector = new NioSocketConnector();
                //设置链接超时时间
                connector.setConnectTimeoutMillis(Content.CONNECTION_TIMEOUT);
                //添加过滤器
                //connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory()));
                connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),LineDelimiter.WINDOWS.getValue())));

                connector.getSessionConfig().setReadBufferSize(Content.BUFFERSIZE);
                connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, Content.INTERVAL_TIMEOUT);
                //connector.getSessionConfig().setKeepAlive(true);
                org.apache.mina.filter.keepalive.KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
                KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory);
                //是否回发
                heartBeat.setForwardEvent(true);
                // 发送频率
                heartBeat.setRequestInterval(Content.INTERVAL);
                connector.getFilterChain().addLast("heartbeat", heartBeat);

                connector.setHandler(new MinaClientHandler());
                try{
                    ConnectFuture future = connector.connect(new InetSocketAddress(Content.IP_HOST, Content.IP_PORT));//创建链接
                    future.awaitUninterruptibly();// 等待连接创建完成
                    IoSession session = future.getSession();//获得session
                    if(session.isConnected()){
                        Log.e(TAG,"客户端连接成功...");
                        connectionSuccess(session);

                    }else {
                        Log.e(TAG,"客户端连接失败...");
                        connectionFail("连接服务器失败");
                    }
                }catch (Exception e){
                    Log.e(TAG,"客户端链接异常...");
                    connectionFail(e.getMessage());
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void connectionSuccess(IoSession session){
        if(connectionListenerList!=null){
            for (ConnectionListener connectionListener:connectionListenerList){
                connectionListener.ConnectSuccess(session);
            }
        }
    }

    private void connectionFail(String message){
        if(connectionListenerList!=null){
            for (ConnectionListener connectionListener:connectionListenerList){
                connectionListener.ConnectFail(new ConnectionException(message));
            }
        }
    }
}
