package com.androidim.client;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jivesoftware.smack.AbstractConnectionClosedListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends Activity {

    private Socket socket;
    private BufferedReader in = null;
    private PrintWriter out = null;

    private Button btSend;
    private Button btConn;
    private EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSend = (Button) findViewById(R.id.bt_send);
        btConn = (Button) findViewById(R.id.bt_conn);
        etMsg = (EditText) findViewById(R.id.et_msg);

        btConn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConnection();
            }
        });

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etMsg.getText().toString();
                sendMessage(msg);
            }
        });
    }

    private void startConnection() {
        new Thread(){
            @Override
            public void run() {
                try {
                    XMPPTCPConnectionConfiguration.Builder config = XMPPTCPConnectionConfiguration.builder();
                    config.setHost(Config.IP_HOST);              //设置ejabberd主机IP
                    config.setPort(Config.IP_PORT);                   //设置端口号：默认5222
                    config.setUsernameAndPassword("admin", "111111");    //设置用户名与密码
                    config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);      //禁用SSL连接
                    config.setSendPresence(true);
                    config.setDebuggerEnabled(true);
                    XMPPTCPConnection  xmppConnection = new XMPPTCPConnection(config.build());


                    xmppConnection.addConnectionListener(new AbstractConnectionClosedListener() {
                        @Override
                        public void connectionTerminated() {

                        }

                        @Override
                        public void connected(XMPPConnection connection) {
                            super.connected(connection);
                        }

                        @Override
                        public void authenticated(XMPPConnection connection, boolean resumed) {
                            super.authenticated(connection, resumed);
                        }

                        @Override
                        public void reconnectingIn(int seconds) {
                            super.reconnectingIn(seconds);
                        }

                        @Override
                        public void reconnectionFailed(Exception e) {
                            super.reconnectionFailed(e);
                        }

                        @Override
                        public void reconnectionSuccessful() {
                            super.reconnectionSuccessful();
                        }
                    });
                    xmppConnection.connect();
                    boolean isConnection  = xmppConnection.isConnected();

                    /*socket = new Socket(Config.IP_HOST, Config.IP_PORT);
                    in = new BufferedReader(new InputStreamReader(socket
                            .getInputStream()));
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())), true);*/
                    receiveMsg();
                    sendHeartBeat();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void sendHeartBeat(){
        new Thread(){
            @Override
            public void run() {
                while (true){
                    sendMessage("1111");
                    try {
                        Thread.sleep(20*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    private void receiveMsg(){
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        if (!socket.isClosed()) {
                            if (socket.isConnected()) {
                                if (!socket.isInputShutdown()) {
                                    String content=null;
                                    if ((content = in.readLine()) != null) {
                                        content += "\n";
                                        System.out.println(content);
                                    } else {

                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void sendMessage(String msg){
        if (socket!=null && socket.isConnected()) {
            if (!socket.isOutputShutdown()) {
                out.println(msg);
            }
        }
    }

}
