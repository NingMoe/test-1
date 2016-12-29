/**
 * Dynamic loading template
 * 动态加载模板
 *
 * Created by suanmilk on 12/23/2016.
 */
layui.define(['jquery', 'laytpl'], function (exports) {
    var $ = layui.jquery,
        hint = layui.hint(),
        laytpl = layui.laytpl;

    var Laydlt = function () {
        this.config = {};
    };

    Laydlt.prototype.set = function (options) {
        var that = this;
        that.config = options || {};
        return that;
    };

    /**
     * 加载模板
     *
     * @param options
     * @param fn
     */
    Laydlt.prototype.render = function (options, callback) {
        var conf = this.config;
        /**
         * @type options {
         * @param  模板url
         * @param data 模板数据
         * @param tsn   模板临时存放位置(Temporary storage node)：dom节点id
         * @param ln   模板加载位置(loading node)：dom节点id
         * @param asyn  默认异步
         * @param method html添加方式
         * }
         */
        options = options || {};
        // 模板url必须定义
        if (!options.url)
            return;
        // 加载位置必须定义
        var LN, TSN;
        // LN为选择器选择第一个符合的dom节点
        options.ln && typeof options.ln === 'string' && (LN = $('#' + options.ln));
        options.tsn && typeof options.tsn === 'string' && (TSN = $('#' + options.tsn) || LN);
        if (LN && TSN) {
            TSN.load(options.url, function (template) {
                var tpl = laytpl(template);
                if(!options.method)
                    options.method='replace'
                // 异步加载
                if (options.asyn === undefined || options.asyn === true) {
                    tpl.render(options.data || {}, function (html) {
                        renderHtml[options.method].call(this, options.ln, html);
                    });
                }
                // 同步加载
                else {
                    var html = tpl.render(options.data || {});
                    renderHtml[options.method].call(this, options.ln, html);
                }
                // 这样element对动态生成的元素才会重新有效
                conf.elem.init();
                // 回调函数
                if (typeof callback === "function"){
                    callback();
                }
            });


            // if (!options.method)
            //     options.method = 'replace';
            // // 异步加载
            // if (options.asyn === undefined || options.asyn === true) {
            //     TSN.load(options.url, function (template) {
            //         laytpl(template).render(options.data || {}, function (html) {
            //             renderHtml[options.method].call(this, options.ln, html);
            //             // 这样element对动态生成的元素才会重新有效
            //             conf.elem.init();
            //         });
            //     });
            // }
            // // 同步加载
            // else {
            //     TSN.load(options.url, function (template) {
            //         var tpl = laytpl(template);
            //         var html = tpl.render(options.data || {});
            //         renderHtml[options.method].call(this, options.ln, html);
            //         // 这样element对动态生成的元素才会重新有效
            //         conf.elem.init();
            //     });
            // }

        } else {
            return hint.error('laydlt 没有找到id为' + options.ln + '的元素');
        }
    };

    var renderHtml = {
        before: function (ln, html) {
            $('#' + ln).before(html);
        }
        , after: function (ln, html) {
            $('#' + ln).append(html);

        }
        , replace: function (ln, html) {
            $('#' + ln)[0].innerHTML = html;
        }
    };

    var laydlt = new Laydlt();
    exports('laydlt', laydlt);
});