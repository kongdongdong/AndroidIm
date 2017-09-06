<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>

    <link rel="stylesheet" href="<%=basePath%>css/login/reset.css" />
    <link rel="stylesheet" href="<%=basePath%>css/login/login.css" />
    <title>登录</title>
</head>
<body>
<div class="page">
    <div class="loginwarrp">
        <div class="logo">AndroidIM后台管理系统</div>
        <div class="login_form">
            <form id="loginForm" name="Login" method="post">
                <ul>
                    <li class="login-error">
                        <div class="error" id="errMsg"></div>
                    </li>
                    <li class="login-item">
                        <span>用户名：</span>
                        <input type="text" id="username" name="loginName" placeholder="请输入用户名" class="login_input" autocomplete="off">
                    </li>
                    <li class="login-item">
                        <span>密　码：</span>
                        <input type="text" id="password" name="password" placeholder="请输入密码"  onfocus="$(this).attr('type','password');" class="login_input" autocomplete="off">
                    </li>
                    <%--<li class="login-item verify">
                    <span>验证码：</span>
                    <input type="text" name="CheckCode" class="login_input verify_input">
                    </li>
                    <img src="images/verify.png" border="0" class="verifyimg" />
                    <div class="clearfix"></div>--%>

                    <div class="check-box">
                        <input type="checkbox" id="checkbox-2" name="loginstatus">
                        <label for="checkbox-2">30天免登陆</label>
                    </div>

                    <li class="login-sub">
                        <input id="login" type="submit" name="Submit" value="登录" />
                        <input id="reset" type="reset" name="Reset" value="重置" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/jsp/common/jslib.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/login/login.js"></script>

</body>
</html>