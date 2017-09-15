package com.kdd.androidim.enums;

import com.kdd.androidim.common.Content;
import com.kdd.androidim.net.Connection;

/**
 * Created by ddkong on 2017/9/15.
 */
public enum ConnStatus {

    STATUS_CONNECTED(Content.STATUS_CONNECTED),
    STATUS_AUTHED(Content.STATUS_AUTHED),
    STATUS_CLOSED(Content.STATUS_CLOSED);

    private String status;

    ConnStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
