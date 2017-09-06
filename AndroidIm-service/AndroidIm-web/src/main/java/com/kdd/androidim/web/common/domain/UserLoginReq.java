package com.kdd.androidim.web.common.domain;

/**
 * Created by kdd on 17/8/31.
 */
public class UserLoginReq extends BaseBean{

    /**登陆账号*/
    private String loginName;
    /**登陆密码*/
    private String password;

    private boolean loginstatus;


    public boolean isLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(boolean loginstatus) {
        this.loginstatus = loginstatus;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
