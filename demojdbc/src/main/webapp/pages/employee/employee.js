var employee = function () {
    var employee = {
        //表格存放变量地址
        tableService : null,

        /**
         * 新增初始化
         * @param obj
         */
        add: function (obj) {
            var url = $.ctx + "/employee/add";
            $('#commonModal').modal("show").load(url);
        },
        /**
         * 保存或修改
         */
        save: function(){
            console.log($("#commentForm").serialize());
            $.ajax({
                "type" : "POST",
                "url" : $.ctx + "/employee/save",
                "data": $("#commentForm").serialize(),
                success: function (result) {
                    if(result.status == 200){
                        $('#commonModal').modal("hide");
                        employee.tableService.ajax.reload();
                    }else{
                        CommonUtil.errorAlert(result.message);
                    }
                }
            });
        },
        /**
         * 编辑页面初始化
         * @param id
         */
        edit: function (id) {
            var url = $.ctx + "/employee/edit?id=" + id;
            $('#commonModal').modal("show").load(url);
        },
        /**
         * 删除数据源
         * @param id
         */
        del : function (id) {
            CommonUtil.confirm("确定删除?", function () {
                $.ajax({
                    "type" : "GET",
                    "url" : $.ctx + "/employee/del?id=" + id,
                    success: function (result) {
                        if(result.status == 200){
                            employee.tableService.ajax.reload();
                        }else{
                            setTimeout(function(){
                                CommonUtil.errorAlert(result.message);
                            }, 100);
                        }
                    }
                });
            });
        }
    };
    return employee;
}();

//启动入口
$(function(){
    var dataTableServiceObj = {
        //后端分页
        "ajax" : function (data, callback, settings) {
            //封装请求参数
            var param = {};
            param.pageSize = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
            param.pageNumber = (data.start / data.length)+1;//当前页码
            $.ajax({
                "type" : "POST",
                "url" : $.ctx + "/employee/list",
                "data": $("#queryForm").serialize() + '&pageNumber=' + param.pageNumber + '&pageSize=' + param.pageSize,
                success: function (result) {
                    var returnData = {};
                    returnData.recordsTotal = result.totalCount;//返回数据全部记录
                    returnData.recordsFiltered = result.totalCount;//后台不实现过滤功能，每次查询均视作全部结果
                    returnData.data = result.result;//返回的数据列表
                    callback(returnData);
                }
            });
        },
        "bServerSide": true,
        "columnDefs" : [
            {
                "targets": [0],
                "className": "tc",
                "sWidth": "5%",
                "render": function (data, type,
                                    now) {
                    return "";
                }
            },

            {
                "targets" : [ 1 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.employeename;
                }
            },
            {
                "targets" : [ 2 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.workpostid;
                }
            },
            {
                "targets" : [ 3 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.workpostname;
                }
            },
            {
                "targets" : [ 4 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.entrytime;
                }
            },
            {
                "targets" : [ 5 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.leavetime;
                }
            },
            {
                "targets" : [ 6 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.phone;
                }
            },
            {
                "targets" : [ 7 ],
                "sWidth": "11%",
                "render" : function(data, type, now) {
                    return now.salary;
                }
            },
            {
                "targets" : [ 8 ],
                "sWidth": "15%",
                "render" : function(data, type, now) {
                    var str ='<a href="###" onclick="employee.edit('+ now.employeeid +');">修改</a>'
                            +'&nbsp;&nbsp;<a href="###" onclick="employee.del('+ now.employeeid +');">删除</a>';
                    return str;
                }
            }
        ],
        "fnRowCallback" : function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
        }
    };
    //表格初始化
    employee.tableService = CommonUtil.initTable(employee.tableService, $("#tableService"), dataTableServiceObj);

    $("#btn_search").click(function(){
        employee.tableService.ajax.reload();
    });
    $("#search").keyup(function(e){
        var keycode = window.event ? e.keyCode : e.which;
        if (keycode == 13) {
            employee.tableService.ajax.reload();
        }
    });
});
