<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
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
<link href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>复制新增机组 - 机组管理 - 故障诊断系统</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机组ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入机组ID" id="unit_id" name="unit_id">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机组编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入机组编号" id="unit_num" name="unit_num">
			</div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>选择复制机组编号：</label>
			<div class="formControls col-xs-8 col-sm-9">
                <span class="select-box">
				<select name="copyunit" class="select">
					<option value="0">一号机组</option>
					<option value="1">二号机组</option>
					<option value="2">三号机组</option>
				</select>
                </span>
            </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机组名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入机组名称" id="unit_name" name="unit_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机组描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="unit_des" cols="" rows="" class="textarea"  placeholder="简单描述一下机组。。。" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea>
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
//表单验证
$("#form-article-add").validate({
		rules:{
			unit_id:{
				required:true,
			},
			unit_num:{
				required:true,
			},
			unit_name:{
				required:true,
			},
			unit_des:{
				required:true,
            },
            copyunit:{
				required:true,
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