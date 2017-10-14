<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="static/css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="static/css/loginregister.css" type="text/css" />
</head>
<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
  <div class="container aside-xxl"> <a class="navbar-brand block" href="index.html">实验室低值易耗品管理系统--用户注册</a>
    <section class="panel panel-default m-t-lg bg-white">
      <header class="panel-heading text-center"> <strong>注册</strong> </header>
      <form action="toregister" class="panel-body wrapper-lg" method="post">
        <div class="form-group">
          <label class="control-label">用户名</label>
          <input type="text" name="uname" id="uname"  class="form-control input-lg">
        </div>
        <div class="form-group">
          <label class="control-label">密码</label>
          <input type="password" id="upasswd" name="upasswd" class="form-control input-lg">
        </div>
        <div class="form-group">
          <label class="control-label">确认密码</label>
          <input type="password" id="uspasswd" name="uspasswd" class="form-control input-lg">
        </div>
        <font class="warming">${message}</font>
        <button type="submit" class="btn btn-primary">注册</button>
        <div class="line line-dashed"></div>
        <p class="text-muted text-center"><small>Already have an account?</small></p>
        <a href="/bighomework_system/" class="btn btn-default btn-block">登录</a>
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
<!-- / footer --> <script src="static/js/app.v2.js"></script> <!-- Bootstrap --> <!-- App -->

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
		} else if($("#upasswd").val() != $("#uspasswd").val()) {
			alert("两次密码不一致");
			return false;
		}
		return true;
	}

</script>