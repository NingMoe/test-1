/*globals $*/

$(function() {
	// 执行查询
	$.ajax({
        url: 'systemTask/masterSwitch',
        type: 'GET',
        dataType: 'text',
        success: function(data){
        	// 将json字符串转换为json对象
			var parsedJson = jQuery.parseJSON(data);
			$("#systemTask").html(parsedJson.results.flagName);
			$("#systemTask").val(parsedJson.results.flag);
        }
    });
	
	$.ajax({
        url: 'interfaceDetect/masterSwitch',
        type: 'GET',
        dataType: 'text',
        success: function(data){
        	// 将json字符串转换为json对象
			var parsedJson = jQuery.parseJSON(data);
			$("#interfaceDetect").html(parsedJson.results.flagName);
			$("#interfaceDetect").val(parsedJson.results.flag);
        }
    });
	
	$.ajax({
        url: 'databaseDetect/masterSwitch',
        type: 'GET',
        dataType: 'text',
        success: function(data){
        	// 将json字符串转换为json对象
			var parsedJson = jQuery.parseJSON(data);
			$("#databaseDetect").html(parsedJson.results.flagName);
			$("#databaseDetect").val(parsedJson.results.flag);
        }
    });

	"use strict";

	prettyPrint();
	var opts = {
		lines: 13, // The number of lines to draw
		length: 11, // The length of each line
		width: 5, // The line thickness
		radius: 17, // The radius of the inner circle
		corners: 1, // Corner roundness (0..1)
		rotate: 0, // The rotation offset
		color: '#FFF', // #rgb or #rrggbb
		speed: 1, // Rounds per second
		trail: 60, // Afterglow percentage
		shadow: false, // Whether to render a shadow
		hwaccel: false, // Whether to use hardware acceleration
		className: 'spinner', // The CSS class to assign to the spinner
		zIndex: 2e9, // The z-index (defaults to 2000000000)
		top: 'auto', // Top position relative to parent in px
		left: 'auto' // Left position relative to parent in px
	};


	$(document).on("click", ".masterSwitch", function(e) {
		var id = $(e.target).attr('id');
		var value = $(e.target).val();
		// 创建加载效果图
		var target = document.createElement("div");
		document.body.appendChild(target);
		var spinner = new Spinner(opts).spin(target);
		var overlay = iosOverlay({
			spinner: spinner
		});
		window.setTimeout(function() {
			// 执行切换
			$.ajax({
		        url: id+'/masterSwitch/'+(value=='true'?'false':'true'),
		        type: 'PUT',
	            dataType: 'text',
		        success: function(data){
		        	// 将json字符串转换为json对象
					var parsedJson = jQuery.parseJSON(data);
					overlay.update({
						text: parsedJson.results.flagName,
						icon: "img/check.png"
					});
					$('#'+id).html(parsedJson.results.flagName);
					$('#'+id).val(parsedJson.results.flag);
					window.setTimeout(function() {
						overlay.hide();
					}, 2e3);
		        },
				failure: function(data){
		        	// 将json字符串转换为json对象
					var parsedJson = jQuery.parseJSON(data);
					overlay.hide();
		        }
		    });
		}, 1e3);
		window.setTimeout(function() {
			overlay.hide();
		}, 10e3);
	});

	$(document).on("click", "#checkMark", function(e) {
		iosOverlay({
			text: "成功!",
			duration: 2e3,
			icon: "img/check.png"
		});
		return false;
	});

	$(document).on("click", "#loadToSuccess", function(e) {
		var target = document.createElement("div");
		document.body.appendChild(target);
		var spinner = new Spinner(opts).spin(target);
		var overlay = iosOverlay({
			text: "Loading",
			spinner: spinner
		});
		window.setTimeout(function() {
			overlay.update({
				icon: "img/check.png",
				text: "Success"
			});
		}, 1e3);

		window.setTimeout(function() {
			overlay.hide();
		}, 8e3);
		return false;
	});
	
});
