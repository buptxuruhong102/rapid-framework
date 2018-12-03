$(function(){
    //当modal关闭时，清楚拖动的定位,统一清除需要清空的弹出框的数据
    $(document).on('hidden.bs.modal', '.modal.remove-data', function () {
        $(this).css({
            'left': '0px',
            'top': '0px'
        }).removeData("bs.modal").find(".remove-data").html("");
    });

    //菜单点击
    $(".J_menuItem").on('click',function(){
        $("#side-menu").find(".active").removeClass("active");
        $(this).parent("li").addClass("active");

        var url = $(this).attr('href');
        $("#content-main").load(url);
        return false;
    });

    //加载首页
    $(".J_home").click();

});
