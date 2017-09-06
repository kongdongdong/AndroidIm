<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <%@include file="/WEB-INF/jsp/common/meta.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/user/userlist.css" />
    <title>用户列表</title>
</head>
<body>

<%@include file="/WEB-INF/jsp/common/head.jsp" %>

<%@include file="/WEB-INF/jsp/common/menu.jsp" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a>
        <span class="c-999 en">&gt;</span>
        <span class="c-666">用户管理</span>
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <table class="table table-bordered table-border table-bordered table-bg mt-20">
                <thead>
                    <tr>
                        <th colspan="7" scope="col" class="th_head">用户列表</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td >用户名</td>
                        <td >昵称</td>
                        <td >性别</td>
                        <td >邮箱</td>
                        <td >电话</td>
                        <td >生日</td>
                        <td >操作</td>
                    </tr>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.nickname}</td>
                        <td>
                            <c:choose>
                                <c:when test="${user.sex == 'm'}">
                                    女
                                </c:when>
                                <c:otherwise>
                                    男
                                </c:otherwise>
                            </c:choose>

                        </td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.birthday}</td>
                        <td >
                            <input id="update" class="btn btn-primary radius size-S" type="button" value="修改">
                            <input id="delete" class="btn radius btn-danger size-S" type="button" value="删除">
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </article>


    </div>
</section>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=basePath%>static/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="<%=basePath%>js/user/userlist.js"></script>

<!--/_footer /作为公共模版分离出去-->



</body>
</html>