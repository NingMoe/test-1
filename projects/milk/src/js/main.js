/**
 * Created by luopan on 12/23/2016.
 */
layui.config({
    base: '/ux/'
});
layui.use(['layer', 'element', 'laydlt'], function () {
    var layer = layui.layer, element = layui.element(), laydlt = layui.laydlt;
    laydlt.set({
        'elem': element
    });
    var app_head_data = {
        "service": [{"name": "最新活动", "serviceid": "1000"}, {
            "name": "产品",
            "serviceid": "2000",
            "child": [{"name": "选项1", "serviceid": "2001"}, {"name": "选项2", "serviceid": "2002"}, {
                "name": "选项3",
                "serviceid": "2003"
            }],
            "expend": true
        }, {"name": "大数据", "serviceid": "3000"}, {
            "name": "解决方案",
            "serviceid": "4000",
            "child": [{"name": "移动模块", "serviceid": "4001"}, {"name": "后台模版", "serviceid": "4002"}, {
                "name": "电商平台",
                "serviceid": "4003"
            }],
            "expend": false
        }, {"name": "社区", "serviceid": "5000"}]
    }
        , app_menu_data = {
        "title": "垂直导航菜单"

    };
    <!--加载主页面头部-->
    laydlt.read({
        url: '/html/app_head.html',
        data: app_head_data,
        tsn: 'app_template',
        ln: 'app_top'
    });
    <!--加载主页面菜单-->
    laydlt.read({
        url: '/html/app_menu.html',
        data: app_menu_data,
        tsn: 'app_template',
        ln: 'app_left'
    });
    // 一些事件监听
    element.on('nav(test)', function (elem) {
        layer.msg(elem.text());
    });
});