<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	
	<form action="toregister" method="post">
		<p>
			用户名： <input name="uname" type="text">
		</p>
		<p>
			密&nbsp;&nbsp;码： <input name="upasswd" type="password">
		</p>
		<p>
			确认密码： <input name="uspasswd" type="password">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<font color="red">${message}</font>
	

</body>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
(function(){
})();

</script>
</html>