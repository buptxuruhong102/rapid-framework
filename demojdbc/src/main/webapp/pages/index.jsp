<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/include.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>通用管理系统</title>

    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="bookmark" href="favicon.ico"/>
    <%@ include file="/pages/common/html_include.jsp"%>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!--start 顶部导航-->
        <div class="row border-bottom">

            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">

                <div class="navbar-header">
                    <ul class="nav navbar-nav navbar-left" id="side-menu">
                        <li class="nav-header">
                            <div class="dropdown profile-element">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">

                                        <i class="logo-img"></i>

                                        <strong class="font-bold">通用管理系统</strong>
                                    </span>
                                </span>
                                </a>
                            </div>
                        </li>

                            <li>
                                <a href="${ctx}/userinfo/index" class="J_menuItem J_home"><i class="fa fa-file"></i> <span class="nav-label">userinfo</span></a>
                            </li>
                            <li>
                                <a href="${ctx}/employee/index" class="J_menuItem J_home"><i class="fa fa-file"></i> <span class="nav-label">employee</span></a>
                            </li>
                    </ul>

                </div>


                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-user"></i>admin<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="${ctx}/logout">退出系统</a></li>
                        </ul>
                    </li>


                </ul>


            </nav>
        </div>
        <!--end 顶部导航-->
        <!--start  iframe 内容切换-->
        <div class="gray-bg mainDashbard ng-scope">
            <div class="row J_mainContent" id="content-main">
            </div>
        </div>

        <!--end iframe 内容切换-->
    </div>
    <!--右侧部分结束-->
</div>

<!--通用modal-->
<div class="modal remove-data" id="commonModal" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" data-backdrop="static" data-keyboard="false">
</div>
<div class="modal remove-data" id="pathModal" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" data-backdrop="static" data-keyboard="false">
</div>

</body>

</html>
