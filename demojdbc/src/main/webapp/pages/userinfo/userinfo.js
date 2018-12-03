var userinfo = function () {
    var userinfo = {
        //表格存放变量地址
        tableService : null,

        /**
         * 新增初始化
         * @param obj
         */
        add: function (obj) {
            var url = $.ctx + "/userinfo/add";
            $('#commonModal').modal("show").load(url);
        },
        /**
         * 保存或修改
         */
        save: function(){
            console.log($("#commentForm").serialize());
            $.ajax({
                "type" : "POST",
                "url" : $.ctx + "/userinfo/save",
                "data": $("#commentForm").serialize(),
                success: function (result) {
                    if(result.status == 200){
                        $('#commonModal').modal("hide");
                        userinfo.tableService.ajax.reload();
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
            var url = $.ctx + "/userinfo/edit?id=" + id;
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
                    "url" : $.ctx + "/userinfo/del?id=" + id,
                    success: function (result) {
                        if(result.status == 200){
                            userinfo.tableService.ajax.reload();
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
    return userinfo;
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
                "url" : $.ctx + "/userinfo/list",
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
                "sWidth": "40%",
                "render" : function(data, type, now) {
                    return now.name;
                }
            },
            {
                "targets" : [ 2 ],
                "sWidth": "40%",
                "render" : function(data, type, now) {
                    return now.age;
                }
            },
            {
                "targets" : [ 3 ],
                "sWidth": "15%",
                "render" : function(data, type, now) {
                    var str ='<a href="###" onclick="userinfo.edit('+ now.id +');">修改</a>'
                            +'&nbsp;&nbsp;<a href="###" onclick="userinfo.del('+ now.id +');">删除</a>';
                    return str;
                }
            }
        ],
        "fnRowCallback" : function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
            $('td:eq(0)', nRow).html(iDisplayIndexFull + 1);
        }
    };
    //表格初始化
    userinfo.tableService = CommonUtil.initTable(userinfo.tableService, $("#tableService"), dataTableServiceObj);

    $("#btn_search").click(function(){
        userinfo.tableService.ajax.reload();
    });
    $("#search").keyup(function(e){
        var keycode = window.event ? e.keyCode : e.which;
        if (keycode == 13) {
            userinfo.tableService.ajax.reload();
        }
    });
});
