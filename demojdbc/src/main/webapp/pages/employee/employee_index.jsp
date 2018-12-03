<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/include.jsp" %>
<script src="${ctx}/pages/employee/employee.js"></script>
<div class="tabs-container">
    <div class="tab-pane active">
        <div class="panel-body">

            <div class="oper-bar">
                <div class="form-group">
                    <div class="col-sm-3">
                        <span class="input-group-btn">
                          	<button class="btn btn-success " type="button"  href="###" onclick="employee.add(this)"><i class="fa fa-plus"></i>&nbsp;&nbsp;<span class="bold">新建</span> </button>
                        </span>
                    </div>
                    <div class="col-sm-9">
                    <form id="queryForm">
                        <div class="input-group">
                                    <input name="employeename" type="text" class="form-control" placeholder="员工名称"/>
                                    <span class="input-group-btn"></span>
                                    <input name="workpostid" type="text" class="form-control" placeholder="工作岗位ID"/>
                                    <span class="input-group-btn"></span>
                                    <input name="workpostname" type="text" class="form-control" placeholder="工作岗位名称"/>
                                    <span class="input-group-btn"></span>
                                    <input name="entrytime" type="text" class="form-control" placeholder="入职时间"/>
                                    <span class="input-group-btn"></span>
                                    <input name="leavetime" type="text" class="form-control" placeholder="离职时间"/>
                                    <span class="input-group-btn"></span>
                                    <input name="phone" type="text" class="form-control" placeholder="电话号码"/>
                                    <span class="input-group-btn"></span>
                                    <input name="salary" type="text" class="form-control" placeholder="薪资"/>
                                    <span class="input-group-btn"></span>
                             <span class="input-group-btn">
                                <button id="btn_search" type="button" class="btn btn-primary">搜索</button>
                            </span>
                        </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="tables_wrapper">
                <table id="tableService"
                       class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>序号</th>
                                <th sortColumn="employeename" >员工名称</th>
                                <th sortColumn="workpostid" >工作岗位ID</th>
                                <th sortColumn="workpostname" >工作岗位名称</th>
                                <th sortColumn="entrytime" >入职时间</th>
                                <th sortColumn="leavetime" >离职时间</th>
                                <th sortColumn="phone" >电话号码</th>
                                <th sortColumn="salary" >薪资</th>

                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                    <!-- tbody是必须的 -->
                </table>
            </div>
        </div>
    </div>
</div>