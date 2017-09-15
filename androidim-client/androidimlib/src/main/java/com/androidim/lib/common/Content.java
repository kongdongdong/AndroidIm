package com.androidim.lib.common;

/**
 * Created by ddkong on 2017/9/7.
 */

public class Content {

    public static final String STATUS_CONNECTED="connected";
    public static final String STATUS_AUTHED="authed";
    public static final String STATUS_CLOSED="closed";

    public static final String IP_HOST="172.17.6.66";
    public static final int IP_PORT=5222;

    //心跳频率
    public static final int INTERVAL=50;
    //心跳超时时间
    public static final int INTERVAL_TIMEOUT=60;
    //读取数据大小
    public static final int BUFFERSIZE=1024;
    //连接超时时间
    public static final int CONNECTION_TIMEOUT=3*1000;



}
