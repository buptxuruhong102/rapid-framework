<#include "/macro.include"/>
<#include "/custom.include"/>
<#assign className = table.className>
<#assign classNameLowerCase = className?uncap_first>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/pages/common/include.jsp" %>
<script src="<@jspEl 'ctx'/>/pages/${classNameLowerCase}/${classNameLowerCase}.js"></script>
<div class="tabs-container">
    <div class="tab-pane active">
        <div class="panel-body">

            <div class="oper-bar">
                <div class="form-group">
                    <div class="col-sm-3">
                        <span class="input-group-btn">
                          	<button class="btn btn-success " type="button"  href="###" onclick="${classNameLowerCase}.add(this)"><i class="fa fa-plus"></i>&nbsp;&nbsp;<span class="bold">新建</span> </button>
                        </span>
                    </div>
                    <div class="col-sm-9">
                    <form id="queryForm">
                        <div class="input-group">
                            <#list table.columns as column>
                                <#if !column.htmlHidden>
                                    <input name="${column.sqlName}" type="text" class="form-control" placeholder="${column.columnAlias}"/>
                                    <span class="input-group-btn"></span>
                                </#if>
                            </#list>
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
                        <#list table.columns as column>
                            <#if !column.htmlHidden>
                                <th sortColumn="${column.sqlName}" >${column.columnAlias}</th>
                            </#if>
                        </#list>

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