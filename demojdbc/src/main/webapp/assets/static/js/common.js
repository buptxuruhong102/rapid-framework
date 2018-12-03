/**
 * Created by xuruhong on 2017/3/2.
 */
var CommonUtil = {};

/*
 * saveObj: dataTable实例存放的变量名,注意有的页面中有两个dataTable不要覆盖；
 * elemObj: 初始化dataTable的页面dom元素；
 * dataTableObj: dataTable实例化的对象，公用部分在此方法设置default
 */
CommonUtil.initTable = function (saveObj, elemObj, dataTableObj, callback) {
    var opt = {
        "destroy": true,
        // "pageSize": 10,
        // "pageIndex": 0,
        "bInfo": true,
        "paging": true,
        "bPaginate": true,
        "bSort": false,
        "iDisplayLength": 10,
        "iDisplayStart": 0,
        "bLengthChange": true,
        "sPaginationType": "full_numbers",
        "dom": 'C<"top">rt<"bottom"lip><"clear">',
        "language": {
            "sProcessing": "处理中...",
            "sLengthMenu": "每页显示 _MENU_ 条",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        },
        "initComplete": function () {
            var api = this.api();
        }
    };
    dataTableObj = $.extend({}, opt, dataTableObj);
    saveObj = elemObj.DataTable(dataTableObj);
    if (typeof callback == "function") {
        callback(saveObj);
    }
    return saveObj;
};
CommonUtil.confirm = function (text, okCallback, option) {
    swal({
        title: "",
        text: text,
        type: "warning",
        showCancelButton: true,
        confirmButtonText: "确定",
        cancelButtonText: "取消",
    }, function () {
        okCallback && okCallback(option);
    });
};

/**
 * 错误提示框
 * @param error 错误信息
 */
CommonUtil.errorAlert = function (error) {
    swal({
        title: "",
        text: error,
        type: "error",
        confirmButtonText: "确定"
    });
};

/**
 * 消息提示框
 * @param info 提示消息
 */
CommonUtil.msgAlert = function (info) {
    swal({
        title: "",
        text: info,
        type: "info",
        confirmButtonText: "确定"
    }, function () {
    });
};

/**
 * 成功提示框
 * @param info 提示消息
 */
CommonUtil.msgSuccess = function (info, callback) {
    swal({
        title: "",
        text: info,
        type: "success",
        confirmButtonText: "确定"
    }, function (isConfirm) {
        callback && callback();
    });
};

/**
 * 时间格式化 默认格式化为 yyyy-MM-dd hh:mm:ss
 * @param cellvalue
 * @param options
 * @returns {*}
 */

CommonUtil.dateTimeFormatter = function (cellvalue, options) {
    if (cellvalue == null) {
        return "--/--"
    }
    var format;
    try {
        format = options.dateTimeFormat || "yyyy-MM-dd hh:mm:ss";
    } catch (e) {
        format = "yyyy-MM-dd hh:mm:ss";
    }
    var time = new Date(parseFloat(cellvalue));
    return time.format(format)
};
/**
 * 重写Date格式化方法
 * @param format
 * @returns {*}
 */
Date.prototype.format = function (format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }
    return format;
};
