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
                <input type="hidden" name="employeeid" value="${employee.employeeid}">
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>员工名称 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="employeename" value="${employee.employeename}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>工作岗位ID ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="workpostid" value="${employee.workpostid}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>工作岗位名称 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="workpostname" value="${employee.workpostname}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>入职时间 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="entrytime" value="${employee.entrytime}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>离职时间 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="leavetime" value="${employee.leavetime}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>电话号码 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="phone" value="${employee.phone}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"><span class="star">*</span>薪资 ：</label>
                    <div class="col-sm-8">
                        <input type="text"  name="salary" value="${employee.salary}" placeholder="" class="form-control" required="" aria-required="true" maxlength="20">
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
                employee.save();
            }
        });
    });
</script>