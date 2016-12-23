/**
 * Created by luopan on 12/23/2016.
 */
layui.config({
    base: '/ux/'
});
layui.use(['jquery', 'element', 'fileload'], function () {
    var $ = layui.jquery, element = layui.element(), fileload = layui.fileload;

    var data = {
        "title": "Layui常用模块"
        , "list": [{"modname": "弹层", "alias": "layer", "site": "layer.layui.com"}, {"modname": "表单", "alias": "form"}]
    };

    fileload.add('/html/milk_head.html', data, $('#milk_head'), milk_top);
    /*    $('#milk_head').load('/html/milk_head.html', function () {
     var getTpl = milk_head.innerHTML;
     laytpl(getTpl).render(data, function (html) {
     milk_top.innerHTML = html;
     });
     });*/

    // 一些事件监听
    element.on('nav(demo)', function (data) {
        console.log(data);
    });
});