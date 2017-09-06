package com.kdd.androidim.web.common;


import com.kdd.androidim.web.common.domain.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserInfoSession {
    public static final String LOGIN_USER = "loginUser";
    public static final String TEMP_LOGIN_USER = "tempLoginUser";
    public static final String MENU_LIST = "menuList";

    private UserInfoSession() {
    }

    /**
     * 得到当前登录用户信息
     *
     * @return
     */
    public static UserInfo getCurrentUser() {
        HttpServletRequest request = ReqAndRespContext.getRequest();
        Object _sessionObj = request.getSession().getAttribute(LOGIN_USER);
        if (_sessionObj != null && _sessionObj instanceof UserInfo) {
            UserInfo userBean = (UserInfo) _sessionObj;
            return userBean;
        }
        return null;
    }

    /**
     * 保存当前登录用户信息
     *
     * @param userInfo
     */
    public static void setCurrentUser(UserInfo userInfo) {
        if (userInfo == null) return;
        HttpServletRequest request = ReqAndRespContext.getRequest();
        HttpSession session = request.getSession();
        //之前用登录过
        if (session.getAttribute(LOGIN_USER) != null) {
            session.removeAttribute(LOGIN_USER);
        }
        //放入request 属性中
        session.setAttribute(LOGIN_USER, userInfo);
    }

    /**
     * 保存临时用户信息
     *
     * @param userInfo
     */
    public static void setTempUser(UserInfo userInfo) {
        if (userInfo == null) return;
        HttpServletRequest request = ReqAndRespContext.getRequest();
        HttpSession session = request.getSession();
        //之前有登录过
        if (session.getAttribute(TEMP_LOGIN_USER) != null) {
            session.removeAttribute(TEMP_LOGIN_USER);
        }

        //放入request 属性中
        session.setAttribute(TEMP_LOGIN_USER, userInfo);
    }

    /**
     * 得到临时用户信息
     *
     * @return
     */
    public static UserInfo getTempUser() {
        HttpServletRequest request = ReqAndRespContext.getRequest();
        Object _sessionObj = request.getSession().getAttribute(TEMP_LOGIN_USER);
        if (_sessionObj != null && _sessionObj instanceof UserInfo) {
            UserInfo userBean = (UserInfo) _sessionObj;
            return userBean;
        }
        return null;
    }
    /**
     * 注销当前用户信息
     */
    public static void removeSession() {
        HttpServletRequest request = ReqAndRespContext.getRequest();
        request.getSession().removeAttribute(LOGIN_USER);
        request.getSession().removeAttribute(TEMP_LOGIN_USER);
    }
    public static <T>  void  save2Session(String key, T value) {
        HttpServletRequest request = ReqAndRespContext.getRequest();
        request.getSession().setAttribute(key,value);
    }
    public  static <T> T getFromSession(String key) {
        HttpServletRequest request = ReqAndRespContext.getRequest();
       return (T) request.getSession().getAttribute(key);
    }
    public  static void removeFromSession(String key) {
        HttpServletRequest request = ReqAndRespContext.getRequest();
        request.getSession().removeAttribute(key);
    }
}
