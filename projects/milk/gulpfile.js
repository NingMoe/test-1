// 加载插件
var gulp = require('gulp');
var plugins = require('gulp-load-plugins')();
var through = require('through');
var proxy = require('proxy-middleware');
var url = require('url');
var fs = require('fs');
var paths = {
    js: ['src/app/**/*.js'],
    html: ['src/html/**/*.html'],
    css: ['src/css/*']
};

function count(taskName, message) {
    var fileCount = 0;

    function countFiles() {
        fileCount++;
    }

    function endStream() {
        var gutil = plugins.util;
        gutil.log(gutil.colors.cyan(taskName + ':') + fileCount + ' ' + message || 'files processed.')
    }
    return through(countFiles, endStream);
}

gulp.task('jshint', function () {
    return gulp.src(paths.js)
        .pipe(plugins.jshint())
        .pipe(plugins.jshint.reporter('jshint-stylish'))
        .pipe(plugins.jshint.reporter('fail'))
        .pipe(count('jshint', 'files lint free'));
});

gulp.task('jscs', function () {
    return gulp.src(paths.js)
        .pipe(plugins.jscs());
});

gulp.task('csslint', function () {
    return gulp.src(paths.css)
        .pipe(plugins.csslint('.csslintrc'))
        .pipe(plugins.csslint.reporter())
        .pipe(count('csslint', 'files lint free'));
});

gulp.task('watch', function () {
    gulp.watch(paths.js, ['jshint']);
    gulp.watch(paths.css, ['csslint']);
});

var proxies = JSON.parse(fs.readFileSync('proxy.json', 'utf-8'));
var connectTasks = [];
proxies.forEach(function (v) {
    var taskName = 'connect-' + v.name;
    connectTasks.push(taskName);
    gulp.task(taskName, function () {
        plugins.connect.server({
            root: 'src',
            host: 'localhost',
            port: v.port,
            fallback: 'src/login.html',
            middleware: function (connect, opt) {
                var con = connect().use(
                        '/bower_components',
                        connect.static('./bower_components')
                );
                var results = [con];
                for(var a in v.proxy) {
                    var options = url.parse(v.proxy[a]);
                    options.route = a;
                    results.push(proxy(options));
                }
                return results;
            }
        });
    });
});

gulp.task('connect', connectTasks);

//var defaultTasks = ['clean', 'jshint', 'csslint', 'watch', 'connect'];
var defaultTasks = ['jshint', 'connect'];

gulp.task('development', defaultTasks);