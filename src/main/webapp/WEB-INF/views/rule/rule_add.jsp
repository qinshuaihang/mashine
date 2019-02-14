<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="favicon.ico" >
<link rel="Shortcut Icon" href="favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>新增规则 - 规则管理 - 故障诊断系统</title>
<meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add">
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>规则编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入规则编号" id="rule_num" name="rule_num">
			</div>
        </div>
        <div class="row cl">
                <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>规则描述：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <textarea name="rule_des" cols="" rows="" class="textarea"  placeholder="简单描述一下该规则。。。" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea>
                    <p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
                </div>
            </div>
        <div class="row cl">
            <div>
                <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>特征项：</label>
			    <div class="formControls col-xs-8 col-sm-9">
                    <span class="select-box">
				    <select name="feaobj" class="select">
					    <option value="0"></option>
					    <option value="1"></option>
					    <option value="2"></option>
				    </select>
                    </span>
                </div>
                <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>特征值：</label>
			    <div class="formControls col-xs-8 col-sm-9">
                    <span class="select-box">
				    <select name="feavalue" class="select">
					    <option value="0"></option>
					    <option value="1"></option>
					    <option value="2"></option>
				    </select>
                    </span>
                </div>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span></label>
            <a class="btn btn-primary radius" data-title="添加特征" _href="rules_add.html" onclick="rules_add('添加规则','rules_add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加特征</a>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span></label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="说明" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
        </div>
        <div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
				<button onClick="removeIframe();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script> 
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>   
<script>
/*特征-添加*/
function rules_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
//表单验证
$("#form-article-add").validate({
		rules:{
			rule_num:{
				required:true,
			},
			rule_des:{
				required:true,
			},
			feaobj:{
				required:true,
			},
			feavalue:{
				required:true,
			},
            description:{
                required:false,
            },
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html><!--_meta 作为公共模版分离出去-->