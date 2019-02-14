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

<title>机组管理 - 机组列表 - 故障诊断系统</title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<!-- 关于系统页面（aboutSys.html）跳转 -->
				<a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">H-ui.admin</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">v3.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
				<nav class="nav navbar-nav">
					<ul class="cl">
						<li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" onclick="unit_add('添加机组','unit_add.jsp')"><i class="Hui-iconfont">&#xe616;</i> 机组</a></li>
								<li><a href="javascript:;" onclick="meapoint_add('添加测点','mea_add.jsp')"><i class="Hui-iconfont">&#xe613;</i> 测点</a></li>
								<li><a href="javascript:;" onclick="problem_add('添加故障','pro_add.jsp')"><i class="Hui-iconfont">&#xe613;</i> 故障</a></li>
								<li><a href="javascript:;" onclick="rules_add('添加规则','rules_add.html')"><i class="Hui-iconfont">&#xe613;</i> 规则</a></li>
								<li><a href="javascript:;" onclick="feature_add('添加特征','feature_add.html')"><i class="Hui-iconfont">&#xe620;</i> 特征</a></li>
								<li><a href="javascript:;" onclick="member_add('添加用户','member_add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
							</ul>
						</li>
					</ul>
				</nav>
				<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li>超级管理员</li>
						<li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${user.username }<i class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="user/information">个人信息</a></li>
								<li><a href="#">切换账户</a></li>
								<li><a href="user/exit">退出</a></li>
							</ul>
						</li>
						<li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
						<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
								<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
								<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
								<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
								<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
								<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-unit">
			<dt><i class="Hui-iconfont">&#xe616;</i> 基础信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="unitMan" title="机组管理">机组管理</a></li>
					<li><a href="meapointMan" title="测点管理">测点管理</a></li>
					
				</ul>
			</dd>
		</dl>
		<dl id="menu-knowledge">
			<dt><i class="Hui-iconfont">&#xe613;</i> 知识库管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="problemMan" title="故障管理">故障管理</a></li>
					<li><a href="ruleMan" title="规则管理">规则管理</a></li>
					<li><a href="featureMan" title="特征管理">特征管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-problem">
			<dt><i class="Hui-iconfont">&#xe620;</i> 故障诊断管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="runMan" title="运行管理">运行管理</a></li>
					<li><a href="result" title="诊断管理">诊断管理</a></li>		
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="information">角色管理</a></li>
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs">
	<a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		规则管理
		<span class="c-gray en">&gt;</span>
		规则列表
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
            <div class="text-l">
                机组编号：
				<span class="select-box inline">
				<select name="" class="select" style="width:150px">
					<option value="0">1001</option>
					<option value="1">1002</option>
					<option value="2">1003</option>
				</select>
				</span>
                <button name="" id="" style="float:right" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i> 导出</button>
                <button name="" id="" style="float:right" class="btn btn-success" type="button"><i class="Hui-iconfont">&#xe665;</i> 导入</button>
            </div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
				<a class="btn btn-primary radius" data-title="添加规则" _href="rules_add.html" onclick="rules_add('添加规则','rules_add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加规则</a>
				</span>
				<span class="r">共有数据：<strong>54</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th widh="25"><input type="checkbox" name="" value=""/></th>
							<th width="80">ID</th>
							<th width="80">规则编号</th>
							<th width="80">规则名称</th>
                            <th width="200">规则描述</th>
                            <th width="350">条件</th>
                            <th width="120">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td></td>
							<td></td>
							<td></td>
                            <td></td>
                            <td></td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="rules_edit('规则编辑','rules_add.html','10001')" href="javascript:;" title="规则-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="rules_del(this,'10001')" href="javascript:;" title="规则-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
                        </tr>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,6]}// 不参与排序的列
	]
});
/*规则-添加*/
function rules_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*规则-编辑*/
function rules_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*规则-删除*/
function rules_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>