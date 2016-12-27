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
            var menuInfo = JSON.parse(data);
            if (menuInfo.success && menuInfo.results) {
                <!--加载主页面头部导航信息-->
                laydlt.read({
                    url: '/html/app_head.html',
                    data: menuInfo,
                    tsn: 'app_template',
                    ln: 'app_top'
                });
                // 监听头部导航点击
                element.on('nav(top-nav)', function (elem) {
                    layer.msg('头部导航点击:' + elem.text());
                    var head_elem_id = elem.context.id;
                    if (head_elem_id) {
                        layui.each(menuInfo.results, function (index, item) {
                            if (item.id === head_elem_id && item.children && item.children.length !== 0) {
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
                });
                // 监听左侧菜单点击
                element.on('nav(left-nav)', function (elem) {
                    var menu_elem_id = elem.context.id;
                    layer.msg('左侧菜单点击:' + menu_elem_id + elem.text());
                    if (menu_elem_id) {
                        <!--加载tab页面结构-->
                        <!--加载tab标题-->
                        laydlt.read({
                            url: '/html/app_task_title.html',
                            data: {
                                "id": menu_elem_id,
                                "text": elem.text()
                            },
                            tsn: 'app_template',
                            ln: 'app_task_title',
                            method: 'after'
                        });
                        <!--加载tab内容-->
                        laydlt.read({
                            url: '/html/app_task_content.html',
                            data: {
                                "id": menu_elem_id,
                                "text": elem.text()
                            },
                            tsn: 'app_template',
                            ln: 'app_task_content',
                            method: 'after'
                        });
                        return;
                    }
                });

                element.on('tab(milkTasks)', function(data){
                    console.log(this); //当前Tab标题所在的原始DOM元素
                    console.log(data.index); //得到当前Tab的所在下标
                    console.log(data.elem[0]); //得到当前的Tab大容器
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