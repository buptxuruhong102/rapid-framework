<#include "/macro.include"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>通用管理系统</title>
    <%@ include file="/pages/common/html_include.jsp"%>
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <h3>欢迎使用通用管理系统</h3>

        <form class="m-t" role="form" method="post" action="<@jspEl 'ctx'/>/login/validate">
            <div class="form-group">
                <input type="text" name="user" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="pass" class="form-control" placeholder="密码" required="">
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <input type="text" name="code" class="form-control" placeholder="验证码" required="">
                </div>
                <div class="col-xs-6">
                    <a href='#' onclick="javascript:changeImg()">
                        <img id="img" src="<@jspEl 'ctx'/>/login/authImage" />
                    </a>
                </div>
            </div>

            <!-- 触发JS刷新-->
            <script type="text/javascript">
                function changeImg(){
                    var img = document.getElementById("img");
                    img.src = "<@jspEl 'ctx'/>/login/authImage?date=" + new Date();;
                }
            </script>

            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-center text-danger">
                <@jspEl 'msg'/>
            </p>
        </form>
    </div>
</div>
</body>
</html>
