<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="static/css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="static/css/loginregister.css" type="text/css" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
 
<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
<div class="container aside-xxl">
	<a class="navbar-brand block">实验室低值易耗品管理系统</a>
	<section class="panel panel-default m-t-lg bg-white"> <header
		class="panel-heading text-center"> <strong>登录</strong> </header>
	<form action="login" class="panel-body wrapper-lg" method="post" onsubmit="return check()">
		<div class="form-group">
			<label class="control-label">用户名</label> <input type="text"
				placeholder="" name="uname" id="uname" class="form-control input-lg">
		</div>
		<div class="form-group">
			<label class="control-label">密码</label> <input type="password"
				id="upasswd" name="upasswd" placeholder=""
				class="form-control input-lg">
		</div>
		<font class="warming">${message}</font>
		<button type="submit" class="btn btn-primary">登录</button>
		<div class="line line-dashed"></div>
		<p class="text-muted text-center">
			<small>Do not have an account?</small>
		</p>
		<a href="register" class="btn btn-default btn-block">注册</a>
	</form>
	</section>
</div>
</section>
<!-- footer -->
<footer id="footer">
<div class="text-center padder clearfix">
	<p>
		<small>网络141 陈庆杰<br> &copy;
			2017
		</small>
	</p>
</div>
</footer>
<!-- / footer -->
<script src="static/js/app.v2.js"></script>
<!-- Bootstrap -->
<!-- App -->
</html>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
 
	function check() {
		 
		if ($('#uname').val() == "") {
			alert("用户名不得为空");
			return false;
		} else if ($("#upasswd").val() == "") {
			alert("密码不得为空");
			return false;
		} else if ($("#good_num").val() > num) {
			alert("填写数目超过最大额度");
			return false;
		}
		return true;
	}

</script>