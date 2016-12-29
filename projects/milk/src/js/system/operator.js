/**
 * Created by luopan on 12/28/2016.
 */
layui.use(['jquery', 'layer', 'element', 'laydlt'], function () {
    var $ = layui.jquery, layer = layui.layer, element = layui.element(), laydlt = layui.laydlt;
// 加载头部和菜单数据
    $.ajax({
        type: 'get',
        url: '/api/operator',
        success: function (data) {
            var operatorInfo = JSON.parse(data);
            if (operatorInfo.success && operatorInfo.results) {
                <!--加载主页面头部导航信息-->
                laydlt.render({
                    url: '/html/system/operatorList.html',
                    data: operatorInfo,
                    tsn: 'app_template',
                    ln: 'operatorList'
                });
            }
        }
    });
});