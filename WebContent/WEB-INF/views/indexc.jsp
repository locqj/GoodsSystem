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
			src="static/images/logo.png" class="m-r-sm">易耗品管理
		</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
			data-target=".nav-user"> <i class="fa fa-cog"></i>
		</a>
	</div>
	<ul class="nav navbar-nav hidden-xs">
		<li class="dropdown"><a href="#" class="dropdown-toggle dker"
			data-toggle="modal" data-target="#addgoodlog"><span
				class="font-bold" >申请易耗品</span>
		</a></li>
		
		<li class="dropdown"><a href="#" class="dropdown-toggle dker"
			data-toggle="dropdown"><span
				class="font-bold">|</span>
		</a></li>
		<li class="dropdown"><a href="#" class="dropdown-toggle dker"
			data-toggle="dropdown"><span
				class="font-bold">导出</span>
		</a></li>
	 
	</ul>
	<ul class="nav navbar-nav navbar-right hidden-xs nav-user">


		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"> <span class="thumb-sm avatar pull-left">
					<img src="static/images/avatar.jpg">
			</span>
			<%
				String ls_str=null;
				ls_str=(String)session.getAttribute("username");
				out.println(ls_str);
			%>
		</a></li>
		<li>
			<a href="logout">登出</a>
		</li>
	</ul>
	</header> <section> <section class="hbox stretch"> <section
		id="content"> <section class="vbox"> <section
		class="scrollable padder">
	<ul class="breadcrumb no-border no-radius b-b b-light pull-in">
		 
	</ul>
	<div class="m-b-md">
		<h3 class="m-b-none"><% out.println(ls_str); %></h3>
		<small>欢迎您！</small>
	</div>
	<section class="panel panel-default">
              <header class="panel-heading">个人申请记录</header>
        
              <div class="table-responsive">
                <table class="table table-striped b-t b-light text-sm">
                  <thead>
                    <tr>
                      <th class="th-sortable" data-toggle="class"><i class="iconfont icon-ide">ID</i></th>
                      <th><i class="iconfont icon-leimu">易耗品名</i></th>
                      <th><i class="iconfont icon-suobanxin">申请数量</i></th>
                      <th><i class="iconfont icon-time">申请时间</i></th>
                      <th><i class="iconfont icon-chulizhuangtai">状态</i></th>
                    </tr>
                  </thead>
                  <tbody>
                  	<c:forEach var="list" items="${goodlogs}">
                    <tr>
                      <td>${list.id}</td>
                      <td>${list.good.name}</td>
                      <td>${list.num}</td>
                      <td>${list.time}</td>
                      <td><c:choose>
   							<c:when test="${list.status == 1}">  
         						<i class="iconfont icon-chenggong1"></i>已通过
   							</c:when>
   							<c:when test="${list.status == 3}">  
         						<i class="iconfont icon-zhuangtai_weichuli"></i>被驳回
   							</c:when>
   							<c:otherwise> 
   								<i class="iconfont icon-chulizhuangtai1"></i>待审核
   							</c:otherwise>
							</c:choose>
					  </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
              <footer class="panel-footer">
                 
              </footer>
            </section>
	 
	<!--Modal职位调整弹出框-->
<div class="modal fade" id="addgoodlog" tabindex="-1" role="dialog" aria-labelledby="addgoodlog">
  <div class="col-sm-6 model-center">
                <section class="panel panel-default">
                  <header class="panel-heading font-bold">申请易耗品</header>
                  <div class="panel-body">
                    <form action="getgoods/toaddgoodlog" class="form-horizontal" onsubmit="return check();" method="post">
                      <div class="form-group">
                        <label class="col-sm-2 control-label">易耗品</label>
                        <div class="col-sm-6">
                        <select name="goods" class="form-control m-b" id="goods">
                        <option value="0">请选择</option>
						<c:forEach var="list" items="${good}">
							<option value="${list.code}T${list.num}">${list.name}</option>
						</c:forEach>
                      </select>
                      <input type="hidden" name="good_code" value="0" id="good_code">
                        </div>
                      </div>
                   		<div class="line line-dashed line-lg pull-in"></div>
                   		<div class="goodsnum" style="display: none">
                   		 	<div class="form-group">
                        	<label class="col-sm-2 control-label">易耗品总数</label>
                         	<div class="col-sm-6">
                        		<input  class="form-control" type="number" id="goodsnum" readOnly="true" >
                        	</div>
                      </div>
                   		<div class="line line-dashed line-lg pull-in"></div>
                   		</div>
                      <div class="form-group">
                        <label class="col-sm-2 control-label">数目</label>
                         <div class="col-sm-6">
                        	 <input name="good_num" class="form-control" type="number" id="good_num">
                        </div>
                      </div>
                 
                      <button type="submit" class="btn btn-sm btn-default">Submit</button>
                    </form>
                  </div>
                </section>
              </div>
</div>
<!-- end Modal职位调整弹出框 -->


	</section> </section> <a href="#" class="hide nav-off-screen-block"
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
var num = 0;
function check() {
	num = parseInt(num);
	if ($('#good_code').val() == 0) {
		alert("请选择消耗品");
		return false;
	} else if ($("#good_num").val() == "") {
		alert("请输入数目");
		return false;
	} else if($("#good_num").val() < 0){
		alert("数目不得大于零");
		return false;
	} else if ($("#good_num").val() > num) {
		alert("填写数目超过最大额度");
		return false;
	}
	return true;
}
	$("#goods").change(function(){
		var arr = $(this).val().split('T');
		num = arr[1];
		$("#good_code").val(arr[0]);
		$("#goodsnum").val(arr[1]);
		$(".goodsnum").show();
	})
</script>