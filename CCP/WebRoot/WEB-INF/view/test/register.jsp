<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>用户登录</title>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.10.1.min.js"></script>
  	<style type="text/css">
  	
  	</style>

  </head>
  
  <body>
  <h1></h1>
	  <form action="${pageContext.request.contextPath }/test/add" method="post" onsubmit="return check()">
	  	<input type="text" name="name"><br>
	  	<input type="text" name="password"><br>
	  	<input type="submit" value="注册">
	  </form>
  </body>
  
  <script type="text/javascript">
  $(function() {
	  
  });
  
  function check(){
	  var loginNameFormat = /^[_a-zA-Z0-9\u4e00-\u9fa5]{3,10}$/;  //登录名：只能是汉字、数字、字母和下划线
	  var passwordFormat = /^(\d+[a-zA-z.,_!@#$^%&*?]+)|([a-zA-z]+[0-9.,_!@#$^%&*?]+)|([.,_!@#$^%&*?]+[0-9a-zA-z]+)$/;  //密码：数字、字母和特殊字符自少包含2种
	  
	  var name = $("input[name='name']").val();
	  var pwd = $("input[name='password']").val();
	  
	  if(loginNameFormat.test(name) && passwordFormat.test(pwd))
		  return true;
	  alert("输入格式有误，请重新数据");
	  return false;
  }
  </script>
</html>
