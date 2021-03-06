package com.androidim.client.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidim.client.R;
import com.androidim.lib.common.Content;
import com.androidim.lib.XmppManager;


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
                XmppManager.getXmppManager().startConnection();
                //startConnection();
                //startSocketConnection();
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

    private void startSocketConnection() {
        new Thread(){
            @Override
            public void run() {
                try {
                    socket = new Socket(Content.IP_HOST, Content.IP_PORT);
                    in = new BufferedReader(new InputStreamReader(socket
                            .getInputStream()));
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())), true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    private void startConnection() {
        new Thread(){
            @Override
            public void run() {
                try {
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
