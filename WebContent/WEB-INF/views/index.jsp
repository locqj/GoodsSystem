<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="static/css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="static/css/mycss.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="static/css/iconfont.css">

<link rel="stylesheet" href="static/css/loginregister.css"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户首页</title>
</head>
<body>
	<section class="vbox"> <header
		class="bg-dark dk header navbar navbar-fixed-top-xs">
	<div class="navbar-header aside-md">
		<a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen"
			data-target="#nav"> <i class="fa fa-bars"></i>
		</a> <a href="#" class="navbar-brand" data-toggle="fullscreen"> <img
			class="m-r-sm">低值易耗品管理系统
		</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
			data-target=".nav-user"> <i class="fa fa-cog"></i>
		</a>
	</div>
	<ul class="nav navbar-nav hidden-xs">
		<li class="dropdown"><a href="#" class="dropdown-toggle dker"
			data-toggle="modal" data-target="#addgood"><span
				class="font-bold">添加易耗品</span> </a></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle dker"
			data-toggle="modal" data-target="#addcategory"><span
				class="font-bold">添加易耗品类别</span>
				<li class="dropdown"><a href="#userstable"
					class="dropdown-toggle dker"><span class="font-bold">用户管理</span>
				</a></li> </a></li>
		<li class="dropdown"><a href="#goodlogstable"
			class="dropdown-toggle dker"><span class="font-bold">用户申请管理</span>
		</a></li>

	</ul>
	<ul class="nav navbar-nav navbar-right hidden-xs nav-user">


		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <span class="thumb-sm avatar pull-left">
					<img src="static/images/avatar.jpg">
			</span> <%
 	String ls_str = null;
 	ls_str = (String) session.getAttribute("username");
 	out.println(ls_str);
 %>
		</a></li>
		<li><a href="logout">登出</a></li>
	</ul>
	</header> <section> <section class="hbox stretch"> <section
		id="content"> <section class="vbox"> <section
		class="scrollable padder">
	<ul class="breadcrumb no-border no-radius b-b b-light pull-in">

	</ul>
	<div class="m-b-md">
		<h3 class="m-b-none">
			<%
				out.println(ls_str);
			%>
		</h3>
		<small>欢迎您！</small>
	</div>

	<section class="panel panel-default" id="goodstable"> <header
		class="panel-heading">易耗品管理</header>

	<div class="table-responsive">
		<table class="table table-striped b-t b-light text-sm">
			<thead>
				<tr>
					<th class="th-sortable" data-toggle="class"><i
						class="iconfont icon-ide"></i>ID</th>
					<th><i class="iconfont icon-leimu"></i>易耗品名</th>
					<th><i class="iconfont icon-suobanxin"></i>易耗品剩余数量</th>
					<th><i class="iconfont icon-suobanxin"></i>易耗品数量</th>
					<th><i class="iconfont icon-time"></i>易耗品类目</th>
					<th><i class="iconfont icon-time"></i>录入时间</th>
					<th width=50><i class="iconfont icon-chulizhuangtai"></i>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${goods}" varStatus="status">
					<tr class="G${list.id }">
						<td>${ status.index + 1}</td>
						<td>${list.name}</td>
						<td>${list.num}</td>
						<td>${list.num1}</td>
						<td>${list.time}</td>
						<td>${list.category.name}</td>
						<td><a href="#" class="btn  btn-danger"
							onclick="delgood(${list.id})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="panel-footer"> </footer> </section> <!-- 易耗品类别管理--> <section
		class="panel panel-default" id="categorytable"> <header
		class="panel-heading">易耗品类别管理</header>

	<div class="table-responsive">
		<table class="table table-striped b-t b-light text-sm">
			<thead>
				<tr>
					<th class="th-sortable" data-toggle="class"><i
						class="iconfont icon-ide"></i>ID</th>
					<th><i class="iconfont icon-leimu"></i>类目名</th>
					<th width=50><i class="iconfont icon-chulizhuangtai"></i>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${categorys}" varStatus="status">
					<tr class="C${list.id }">
						<td>${ status.index + 1}</td>
						<td>${list.name}</td>
						<td><a href="#" class="btn  btn-danger"
							onclick="delcategory(${list.id})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="panel-footer"> </footer> </section> <!-- 用户管理 --> <section
		class="panel panel-default" id="userstable"> <header
		class="panel-heading">用户管理</header>

	<div class="table-responsive">
		<table class="table table-striped b-t b-light text-sm">
			<thead>
				<tr>
					<th class="th-sortable" data-toggle="class"><i
						class="iconfont icon-ide"></i>ID</th>
					<th><i class="iconfont icon-leimu"></i>用户名</th>
					<th><i class="iconfont icon-leimu"></i>申请数量</th>
					<th width=50><i class="iconfont icon-chulizhuangtai"></i>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${users}" varStatus="status">
					<tr class="U${list.id }">
						<td>${ status.index + 1}</td>
						<td>${list.name}</td>
						<td>10</td>
						<td><a href="#" class="btn btn-danger"
							onclick="deluser(${list.id})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="panel-footer"> </footer> </section> 
	<!-- 用户申请管理-->
	 <section
		class="panel panel-default" id="goodlogstable">
		<header class="panel-heading">用户申请管理</header>
		
	<div class="table-responsive">
		<table class="table table-striped b-t b-light text-sm" id="tableExcel">
			<thead>

				<tr>
					<th class="th-sortable" data-toggle="class"><i
						class="iconfont icon-ide"></i>ID</th>
					<th><i class="iconfont icon-leimu"></i>用户名</th>
					<th><i class="iconfont icon-leimu"></i>申请易耗品</th>
					<th><i class="iconfont icon-leimu"></i>申请数量</th>

					<th><i class="iconfont icon-leimu"></i>申请时间</th>
					<th><i class="iconfont icon-leimu"></i>申请状态</th>
					<th><i class="iconfont icon-chulizhuangtai"></i>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${goodlogs}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td>${list.user.name}</td>
						<td>${list.good.name}</td>
						<td>${list.num}</td>
						<td>${list.time}</td>
						<td><c:choose>
								<c:when test="${list.status == 1}">
									<i class="iconfont icon-chenggong1"></i>已通过
   							</c:when>
								<c:when test="${list.status == 2}">
									<i class="iconfont icon-zhuangtai_weichuli"></i>被驳回
   							</c:when>
								<c:otherwise>
									<i class="iconfont icon-chulizhuangtai1"></i>待审核
   							</c:otherwise>
							</c:choose></td>
						<td width="200">
							<div class="btn-group">
								<c:choose>
									<c:when test="${list.status == 1}">
										<button type="button" class="btn btn-success" disabled
											onclick="goodLogsCheck(${list.status}, ${list.id}, 1, ${list.num }, '${list.good.code }')">通过</button>
										<button type="button" class="btn btn-warning" disabled
											onclick="goodLogsCheck(${list.status}, ${list.id}, 2, ${list.num }, '${list.good.code }')">驳回</button>
										<button type="button" class="btn btn-default"
											onclick="goodLogsCheck(${list.status}, ${list.id}, 0, ${list.num }, '${list.good.code }')">撤销</button>
									</c:when>
									<c:when test="${list.status == 0 }">
										<button type="button" class="btn btn-success"
											onclick="goodLogsCheck(${list.status}, ${list.id}, 1, ${list.num }, '${list.good.code }')">通过</button>
										<button type="button" class="btn btn-warning"
											onclick="goodLogsCheck(${list.status}, ${list.id}, 2, ${list.num }, '${list.good.code }')">驳回</button>
										<button type="button" class="btn btn-default" disabled
											onclick="goodLogsCheck(${list.status}, ${list.id}, 0, ${list.num }, '${list.good.code }')">撤销</button>

									</c:when>
									<c:otherwise>
										<button type="button" class="btn btn-success"
											onclick="goodLogsCheck(${list.status}, ${list.id}, 1, ${list.num }, '${list.good.code }')">通过</button>
										<button type="button" class="btn btn-warning" disabled
											onclick="goodLogsCheck(${list.status}, ${list.id}, 2, ${list.num }, '${list.good.code }')">驳回</button>
										<button type="button" class="btn btn-default" disabled
											onclick="goodLogsCheck(${list.status}, ${list.id}, 0, ${list.num }, '${list.good.code }')">撤销</button>

									</c:otherwise>
								</c:choose>
							</div>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	
	<footer class="panel-footer"><button class="btn btn-defalut" type="button" onclick="download('tableExcel')">导出表格</button> </footer> </section> <!--Modal添加消耗品弹出框-->
	<div class="modal fade" id="addgood" tabindex="-1" role="dialog"
		aria-labelledby="addgood">
		<div class="col-sm-6 model-center">
			<section class="panel panel-default"> <header
				class="panel-heading font-bold">添加易耗品</header>
			<div class="panel-body">
				<form action="goodsadmin/toaddgoods" class="form-horizontal"
					onsubmit="return goodcheck();" method="post">
					<div class="form-group">

						<label class="col-sm-2 control-label">易耗品名</label>
						<div class="col-sm-6">
							<input name="good_name" class="form-control" type="text"
								id="good_name">
						</div>

					</div>
					<div class="line line-dashed line-lg pull-in"></div>

					<div class="form-group">
						<label class="col-sm-2 control-label">数目</label>
						<div class="col-sm-6">
							<input name="good_num" class="form-control" type="number"
								id="good_num">
						</div>
					</div>

					<div class="line line-dashed line-lg pull-in"></div>
					<div class="form-group">
						<label class="col-sm-2 control-label">易耗品类目</label>
						<div class="col-sm-6">
							<select name="category_code" class="form-control m-b"
								id="good_category">
								<option value="0">请选择</option>
								<c:forEach var="list" items="${categorys}">
									<option value="${list.code}">${list.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="line line-dashed line-lg pull-in"></div>
					<button type="submit" class="btn btn-sm btn-default">提交</button>
				</form>
			</div>
			</section>
		</div>
	</div>
	<!-- end Modal添加消耗品弹出框 --> <!--Modal弹出框-->
	<div class="modal fade" id="addcategory" tabindex="-1" role="dialog"
		aria-labelledby="addcategory">
		<div class="col-sm-6 model-center">
			<section class="panel panel-default"> <header
				class="panel-heading font-bold">添加易耗品类别</header>
			<div class="panel-body">
				<form action="categoryadmin/toaddcategory" class="form-horizontal"
					onsubmit="return categorycheck();" method="post">
					<div class="form-group">
						<label class="col-sm-2 control-label">类别名</label>
						<div class="col-sm-6">
							<input name="category_name" class="form-control" type="text"
								id="category_name">
						</div>
					</div>
					<div class="line line-dashed line-lg pull-in"></div>
					<button type="submit" class="btn btn-sm btn-default">Submit</button>
				</form>
			</div>
			</section>
		</div>
	</div>
	<!-- end Modal弹出框 --> </section> </section> <a href="#" class="hide nav-off-screen-block"
		data-toggle="class:nav-off-screen" data-target="#nav"></a> </section> <aside
		class="bg-light lter b-l aside-md hide" id="notes">
	<div class="wrapper">Notification</div>
	</aside> </section> </section> </section>
	<!-- Bootstrap -->
	<!-- App -->

</body>
<!-- / footer -->
<script src="static/js/app.v2.js"></script>
</html>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	 
	 
	
	function goodcheck() {
		if ($('#good_name').val() == "") {
			alert("请填写易耗品");
			return false;
		} else if ($("#good_num").val() == "") {
			alert("请输入数目");
			return false;
		} else if($('#good_category').val() == 0) {
			alert("请选择易耗品类目");
			return false;
		}
		return true;
	}
	
	function categorycheck() {
		if($("#category_name").val() == ""){
			alert("请填写类别名");
			return false;
		}
		return true;
	}
	function deluser(id){
		var r = confirm("确定删除吗？");
		if(r){
			$.post('useradmin/del', {id: id}, function(data){
				if (data == "ok") {
					alert('删除成功');
					$('.U'+id).hide();	
				} else {
					alert("网络问题，请稍后重试!");
				}
			});	
		}
	}
	
	function delgood(id){
		var r = confirm("确定删除吗？");
		if(r){
			$.post('goodsadmin/del', {id: id}, function(data){
				if (data == "ok") {
					alert('删除成功');
					$('.G'+id).hide();	
				} else {
					alert("网络问题，请稍后重试!");
				}
			});	
		}
	}
	
	function delcategory(id){
		var r = confirm("确定删除吗？");
		if(r){
			$.post('categoryadmin/del', {id: id}, function(data){
				if (data == "ok") {
					alert('删除成功');
					$('.C'+id).hide();	
				} else {
					alert("网络问题，请稍后重试!");
				}
				
			});	
		}
	}
	//提交操作状态
	function goodLogsCheck(pre_status, id, status, num, good_code){
		if(pre_status == status) {
			alert("非法操作");
		} else if (pre_status == 1 && status == 2) {
			alert("非法操作，该申请已通过，不得驳回");
		} else if (pre_status == 0 && status == 0) {
			alert("非法操作，该申请未通过，不得撤销");
		} else if (pre_status == 2 && status == 0) {
				alert("非法操作，该申请已驳回，不得撤销");
		}else {
			var msg = "";
			if (status == 1) {
				msg = "确定通过吗?";
			} else if (status == 2){
				msg = "确定驳回吗？";
			} else {
				msg = "确定撤销吗？";
			}
			if(confirm(msg)){
				$.post("goodlogscheck", {id: id, status: status, num: num, good_code: good_code}, function(data){
					if(data == "ok") {
						alert("操作成功");
						window.location.reload();
					} else if (data == "full") {
						alert("处理失败，该消耗品不足");
					} else {
						alert("网络问题，请稍后重试!");
					}
					window.location.reload();
				});
			}	
		}
		
	}
	
	$("#goods").change(function(){
		var arr = $(this).val().split('T');
		num = arr[1];
		$("#good_code").val(arr[0]);
		$("#goodsnum").val(arr[1]);
		$(".goodsnum").show();
	});
</script>
<script type="text/javascript">

    var idTmr;  
        function  getExplorer() {  
            var explorer = window.navigator.userAgent ;  
            //ie  
            if (explorer.indexOf("MSIE") >= 0) {  
                return 'ie';  
            }  
            //firefox  
            else if (explorer.indexOf("Firefox") >= 0) {  
                return 'Firefox';  
            }  
            //Chrome  
            else if(explorer.indexOf("Chrome") >= 0){  
                return 'Chrome';  
            }  
            //Opera  
            else if(explorer.indexOf("Opera") >= 0){  
                return 'Opera';  
            }  
            //Safari  
            else if(explorer.indexOf("Safari") >= 0){  
                return 'Safari';  
            }  
        }  
        function download(tableid) {  
            if(getExplorer()=='ie')  
            {  
                var curTbl = document.getElementById(tableid);  
                var oXL = new ActiveXObject("Excel.Application");  
                var oWB = oXL.Workbooks.Add();  
                var xlsheet = oWB.Worksheets(1);  
                var sel = document.body.createTextRange();  
                sel.moveToElementText(curTbl);  
                sel.select();  
                sel.execCommand("Copy");  
                xlsheet.Paste();  
                oXL.Visible = true;  
  
                try {  
                    var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");  
                } catch (e) {  
                    print("Nested catch caught " + e);  
                } finally {  
                    oWB.SaveAs(fname);  
                    oWB.Close(savechanges = false);  
                    oXL.Quit();  
                    oXL = null;  
                    idTmr = window.setInterval("Cleanup();", 1);  
                }  
  
            }  
            else  
            {  
                tableToExcel(tableid)  
            }  
        }  
        function Cleanup() {  
            window.clearInterval(idTmr);  
            CollectGarbage();  
        }  
        var tableToExcel = (function() {  
            var uri = 'data:application/vnd.ms-excel;base64,',  
                    template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',  
                    base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },
                    
                    format = function(s, c) {  
                        return s.replace(/{(\w+)}/g,  
                                function(m, p) { return c[p]; }) }  
            return function(table, name) {
                if (!table.nodeType) table = document.getElementById(table)  
                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}  
                window.location.href = uri + base64(format(template, ctx))  
            }  
        })()  
  
    </script>
