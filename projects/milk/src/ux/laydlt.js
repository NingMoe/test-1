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
    Laydlt.prototype.read = function (options, fn) {
        var conf = this.config;
        /**
         * @type options {
         * @param  模板url
         * @param data 模板数据
         * @param tsn   模板临时存放位置(Temporary storage node)：dom节点id
         * @param ln   模板加载位置(loading node)：dom节点id
         * @param asyn  默认异步
         * }
         */
        options = options || {};
        // 模板url必须定义
        if (!options.url)
            return;
        // 加载位置必须定义
        var LN, TSN;
        // LN为选择器选择第一个符合的dom节点
        options.ln && typeof options.ln === 'string' && (LN = $('#' + options.ln)[0]);
        options.tsn && typeof options.tsn === 'string' && (TSN = $('#' + options.tsn) || LN);
        if (LN && TSN) {
            TSN.load(options.url, function (template) {
                var tpl = laytpl(template);
                // 异步加载
                if (options.asyn === undefined || options.asyn === true) {
                    tpl.render(options.data || {}, function (html) {
                        LN.innerHTML = html;
                    });
                }
                // 同步加载
                else {
                    var html = tpl.render(options.data || {});
                    LN.innerHTML = html;
                }
                // 这样element对动态生成的元素才会重新有效
                conf.elem.init();
            });
        } else {
            return hint.error('layui.laydlt 没有找到id为' + options.ln + '的元素');
        }
    };
    var laydlt = new Laydlt();
    exports('laydlt', laydlt);
});