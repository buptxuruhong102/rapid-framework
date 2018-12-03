<%--
  Created by IntelliJ IDEA.
  User: xuruhong
  Date: 2017/3/6
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${ctx}/assets/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/assets/static/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
<link href="${ctx}/assets/static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${ctx}/assets/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/assets/static/css/animate.css" rel="stylesheet">
<link href="${ctx}/assets/static/css/style.css?v=4.1.0" rel="stylesheet">
<link href="${ctx}/assets/static/css/imagecollect.css" rel="stylesheet">
<link href="${ctx}/assets/static/js/plugins/treeview/bootstrap-treeview.css" rel="stylesheet">

<!-- 全局js -->
<script src="${ctx}/assets/static/js/jquery/jquery-1.10.2.min.js"></script>
<script src="${ctx}/assets/static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctx}/assets/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/assets/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctx}/assets/static/js/plugins/layer/layer.min.js"></script>
<script src="${ctx}/assets/static/js/plugins/dataTables/jquery.dataTables.min.js"></script>
<script src="${ctx}/assets/static/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="${ctx}/assets/static/js/plugins/sweetalert/sweetalert.min.js"></script>

<script src="${ctx}/assets/static/js/common.js"></script>

<!-- 自定义js -->
<script src="${ctx}/assets/static/js/ipdadmin.js?v=4.1.0"></script>
<script type="text/javascript" src="${ctx}/assets/static/js/index.js"></script>

<!-- 第三方插件 -->
<script src="${ctx}/assets/static/js/plugins/pace/pace.min.js"></script>
<!-- jQuery Validation plugin javascript-->
<script src="${ctx}/assets/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/assets/static/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/assets/static/js/plugins/treeview/bootstrap-treeview.js"></script>

<script type="text/javascript">
    jQuery.ctx='${ctx}';
    $.ajaxSetup({"error":myfunc});
    function myfunc(XMLHttpRequest, textStatus, errorThrown){
        if(XMLHttpRequest.status==401){
            var loginUrl= XMLHttpRequest.getResponseHeader("Location");
            window.top.location = loginUrl;
        }
    }

</script>