/**
 * Created by luopan on 12/23/2016.
 */
layui.use(['jquery', 'layer', 'form'], function () {
    var form = layui.form(), $ = layui.jquery, layer = layui.layer;

    form.on('submit(*)', function (data) {
        $.ajax({
            type: 'post',
            url: '/api/login',
            data: JSON.stringify(data.field),
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);
                var loginInfo = JSON.parse(data);
                if(loginInfo.success){
                    console.log(loginInfo.msg);
                    console.log(loginInfo.token);
                    var login = {
                        key: 'token'
                        ,value: loginInfo.token
                    }
                    layui.data('login', login);
                    login = {
                        key: 'user'
                        ,value: loginInfo.results
                    }
                    layui.data('login', login);
                    layer.msg('登录成功', {
                        icon: 6,
                        time: 3000
                    }, function () {
                        location.href = '/html/main.html';
                    });
                }
            }
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    /*    layer.confirm('is not?', {icon: 3, title:'提示'}, function(index){
     //do something
     $.ajax({
     type: 'POST',
     url: url,
     dataType: 'json',
     success: function(data){
     layer.close(index);
     },
     error: function(xhr){
     layer.msg('error');
     }
     });
     });*/

    //各种基于事件的操作，下面会有进一步介绍
});