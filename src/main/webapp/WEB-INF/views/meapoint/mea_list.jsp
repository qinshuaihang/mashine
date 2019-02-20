<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8">
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
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
//点击上传
$(document).ready(function(){
	$('#file_copy').click(function(){
		$('#file_excel').click();
	})
	 $("#file_excel").bind("change",function(){
		 $("#filename").attr("value",$("#file_excel").val());
	 });	
	//点击提交
	$('#download').click(function(){
		
		$("#form_excel").submit();
	})
});
</script>

<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>测点管理 - 测点列表 - 故障诊断系统</title>
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
					<li><a href="jizu/unitList" title="机组管理">机组管理</a></li>
					<li><a href="meaPoint/meaList" title="测点管理">测点管理</a></li>
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
		测点管理
		<span class="c-gray en">&gt;</span>
		测点列表
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="Hui-article">
		<article class="cl pd-20">
            <div class="text-l">
                机组编号：
				<span class="select-box inline">
				<select name="" class="select">
					<option value="0">1001</option>
					<option value="1">1002</option>
					<option value="2">1003</option>
				</select>
				</span>
				测点编号：
				<input type="text" name="" id="" placeholder="测点编号" style="width:250px" class="input-text">
                测点名称：
                <input type="text" name="" id="" placeholder="测点名称" style="width:250px" class="input-text">
				<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 查看</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
				<a class="btn btn-primary radius" data-title="添加测点" _href="meapoint_add.html" onclick="meapoint_add('添加测点','meapoint_add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加测点</a>
				</span>
				
				<button name="file_copy" id="file_copy" class="btn btn-success" type="button"><i class="Hui-iconfont"></i> 选择文件</button>
				<button name="download" id="download" class="btn btn-success" type="button"><i class="Hui-iconfont"></i> 提交文件</button>
                <div id="hidden_file_div" style="display: none;">
                	<form action="meaPoint/readExcel" method="post" enctype="multipart/form-data"  id="form_excel" name="form_excel">
                		<input type="file" id="file_excel" name="file_excel" />
    	 				<input type="submit"/>
                	</form>
                	<input type="text" name="filename" id="filename" />
               </div>
				
				<span class="r">共有数据：<strong>${pageInfo.total }</strong> 条</span>
			</div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""/></th>
							<th width="100">ID</th>
							<th width="100">测点编号</th>
							<th width="150">测点名称</th>
							<th width="600">测点信息</th>
							<th width="120">操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${meaList }" var="mea">
						<tr class="text-c">
							<td><input type="checkbox" value="" name=""/></td>
							<td>${mea.id }</td>
							<td>${mea.pointNum }</td>
							<td>${mea.pointName }</td>
							<td>${mea.pointDes }</td>
							<td class="f-14 td-manage">
								<a style="text-decoration:none" class="ml-5" onclick="meapoint_del(this,'10001')" href="javascript:;" title="测点-查看"><i class="Hui-iconfont">&#xe665;</i></a>
								<a style="text-decoration:none" class="ml-5" onclick="meapoint_edit('测点编辑','meapoint_add.html','10001')" href="javascript:;" title="测点-编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
								<a style="text-decoration:none" class="ml-5" href="meaPoint/deletePoint?id=${mea.id }" title="测点-删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
					<div>
				<div>
				当前第${pageInfo.pageNum }页，总共${pageInfo.pages }页
				</div>
				<!-- 点击分页 -->
				<div>
					<nav aria-label="Page navigation">
                	<ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/meaPoint/meaList?pageNum=1">首页</a></li>
                    <!--上一页-->
                    <li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/meaPoint/meaList?pageNum=${pageInfo.pageNum-1}"
                               aria-label="Previous">
                                <span aria-hidden="true">«</span>
                            </a>
                        </c:if>
                    </li>
                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                        <c:if test="${page_num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_num}</a></li>
                        </c:if>
                        <c:if test="${page_num != pageInfo.pageNum}">
                            <li>
                                <a href="${pageContext.request.contextPath}/meaPoint/meaList?pageNum=${page_num}">${page_num}</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <!--下一页-->
                    <li>
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/meaPoint/meaList?pageNum=${pageInfo.pageNum+1}"
                               aria-label="Next">
                                <span aria-hidden="true">»</span>
                            </a>
                        </c:if>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/meaPoint/meaList?pageNo=${pageInfo.pages}">尾页</a></li>
                	</ul>
            		</nav>
        		</div>
				</div>
				</table>
			</div>
		</article>
	</div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<!-- <script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> -->
<!-- <script src="${pageContext.request.contextPath}/static/h-ui.admin/js/layui.js"> -->

<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		{"orderable":false,"aTargets":[0,5]}// 不参与排序的列
	]
});

/*测点-添加*/
function meapoint_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*测点-编辑*/
function meapoint_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>