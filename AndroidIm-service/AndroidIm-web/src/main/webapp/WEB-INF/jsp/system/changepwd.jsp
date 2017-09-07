<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <%@include file="/WEB-INF/jsp/common/meta.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/system/changepwd.css" />
    <title>修改密码</title>
</head>
<body>

<%@include file="/WEB-INF/jsp/common/head.jsp" %>

<%@include file="/WEB-INF/jsp/common/menu.jsp" %>

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a>
        <span class="c-999 en">&gt;</span>
        <span class="c-666">修改密码</span>
        <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <form action="" method="post" class="form form-horizontal" id="form-admin-role-add">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"></label>
                    <div class="formControls col-xs-4 col-sm-2">
                        <h3>修改密码</h3>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-1">原始密码：</label>
                    <div class="formControls col-xs-4 col-sm-3">
                        <input name="oldpassword" type="text" placeholder="请输入原始密码" class="input-text radius size-M">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-1">新密码：</label>
                    <div class="formControls col-xs-4 col-sm-3">
                        <input name="newpassword" type="text" placeholder="请输入新密码" class="input-text radius size-M">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-1">新密码确认：</label>
                    <div class="formControls col-xs-4 col-sm-3">
                        <input name="newpasswordconfirm" type="text" placeholder="请再次输入新密码" class="input-text radius size-M">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-1"></label>
                    <div class="formControls col-xs-4 col-sm-3">
                        <input class="btn btn-success radius" type="button" value="提交"> <input class="btn btn-primary radius" type="button" value="重置">
                    </div>
                </div>
            </form>
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