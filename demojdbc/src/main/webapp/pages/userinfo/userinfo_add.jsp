<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/include.jsp" %>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight">

        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                    class="sr-only">关闭</span>
            </button>
            <h4 class="modal-title">${title}</h4>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" id="commentForm">
                <input type="hidden" name="id" value="${userinfo.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>名称 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="name" value="${userinfo.name}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>年龄 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="age" value="${userinfo.age}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
            </form>

        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
            <button type="submit" class="btn btn-primary" id="btn-save">保存</button>
        </div>
    </div>
</div>
<script>
    $(function () {
        var validator = $("#commentForm").validate();
        $("#btn-save").click(function(){
            if(validator.form()){
                userinfo.save();
            }
        });
    });
</script>