/**
 * Created by luopan on 12/23/2016.
 */
layui.config({
    base: '/ux/'
});
layui.use(['jquery', 'layer', 'element', 'laydlt'], function () {
    var $ = layui.jquery, layer = layui.layer, element = layui.element(), laydlt = layui.laydlt;
    laydlt.set({
        'elem': element
    });
    // 加载头部和菜单数据
    $.ajax({
        type: 'get',
        url: '/api/system/menu',
        success: function (data) {
            // console.log(data);
            var menuInfo = JSON.parse(data);
            if(menuInfo.success && menuInfo.results){
                <!--加载主页面头部导航信息-->
                laydlt.read({
                    url: '/html/app_head.html',
                    data: menuInfo,
                    tsn: 'app_template',
                    ln: 'app_top'
                });
                // 监听头部导航点击
                element.on('nav(top-menu)', function (elem) {
                    var head_elem_id = elem.context.id;
                    if(head_elem_id){
                        layui.each(menuInfo.results, function(index, item){
                            if(item.id === head_elem_id && item.children && item.children.length !== 0){
                                <!--加载主页面左侧菜单信息-->
                                laydlt.read({
                                    url: '/html/app_menu.html',
                                    data: item.children,
                                    tsn: 'app_template',
                                    ln: 'app_left'
                                });
                                return;
                            }
                        });
                    }
                    layer.msg('头部导航点击:' + elem.text());
                });
                // 监听左侧菜单点击
                element.on('nav(menu)', function (elem) {
                    if(elem.context.url){
                    }
                    layer.msg('左侧菜单点击:' + elem.text());
                });

                /*layer.msg('菜单加载成功', {
                    icon: 6,
                    time: 3000
                }, function () {
                    console.log(loginInfo.results);
                });*/
            }
        }
    });
});