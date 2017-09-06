package com.kdd.androidim.web.common.domain;

/**
 * Created by ddkong on 2017/9/6.
 */
public class WebGlobalVo {

    private String currentUrl;
    private String parentCurrentUrl;

    public String getParentCurrentUrl() {
        return parentCurrentUrl;
    }

    public void setParentCurrentUrl(String parentCurrentUrl) {
        this.parentCurrentUrl = parentCurrentUrl;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }
}
