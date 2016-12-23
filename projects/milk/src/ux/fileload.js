/**
 * Created by luopan on 12/23/2016.
 */
layui.define(['laytpl'], function (exports) {
    var laytpl = layui.laytpl;
    var obj = {
        add: function (url, data, src, des) {
            if(!url || !data)
                return;
            if(des && typeof des === 'object'){
                if(!src)
                    src = des;
                src.load(url, function (template) {1
                    laytpl(template).render(data, function (html) {
                        des.innerHTML = html;
                    });
                });
            }
        }
    };
    exports('fileload', obj);
});