<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>

<title>My JSP 'regist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/style/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/style/register.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/regist-validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/register.js"></script>

</head>

<body>
    <input id="contextPath" type="hidden" value="${pageContext.request.contextPath }">
	<!-- 头部 -->
	<div class="header">
		<nav class="main text-right">
			<span> 已经注册，马上&nbsp;<a href="#">登录</a> </span>
		</nav>
	</div>
	<div class="title">
		<div class="reg_step1_reg">
		   <span class="reg_step_label" style="background-color: red;">1</span>
			<span class="">设置登录账户</span>
		</div>
		<div class="reg_step2_basicinfor">
		  <span class="reg_step_label">2</span>
			<span class="">填写基本信息</span>
		</div>
		<div class="reg_step3_regok">
		  <span class="reg_step_label">3</span>
			<span class="">注册成功</span>
		</div>
		<div class="reg_indicator" style="left:25px;"></div>
	</div>
	<!-- 内容 -->
	<div class="content">
		<div class="main">
			<div class="reg-con">
				<div class="reg-header">注册新账号</div>
				<nav class="tab">
					<ul id="reg_mode_nav" class="clearfix">
						<li id="reg_mode_email" mode="email"><i class="fa fa-envelope-o" style="color: rgb(0,124,195);"></i><span>邮箱注册</span></li>
						<li id="reg_mode_mobile" mode="mobile"><i class="fa fa-mobile" style="font-size: 34px;"></i><span>手机注册</span></li>
					</ul>
					<div class="indicator" style="left:10px; right: 270px;"></div>
				</nav>
				<div class="reg-form">
					<form action="${pageContext.request.contextPath }/user/regist" method="post" onsubmit="return checkForm()">
						<div id="reg_mode_item" class="form-item">
							<label>邮箱地址</label><input type="text" name="email"
								class="input-max" placeholder="请输入邮箱地址" error="" onblur="validateEmail(this)" /><i class="user-ico"></i>
						    <span data="email" class="validate-tips"></span>
						</div>
						
						<div class="form-item">
							<label>新密码</label><input type="password" name="passw" class="input-max" 
								placeholder="密码应由6-20个字符组成" error="" onfocus="validatePassw(this)"  /><i class="lock-ico"></i>
								<span data="passw" class="validate-tips"></span>
						</div>
						
						<div class="form-item">
							<label>验证码</label><input type="text" maxlength="4" id="input_captcha" class="input-max wid-130"
								placeholder="请输入验证码" error=""  />
								<img alt=" " src="${pageContext.request.contextPath }/user/getCaptcha" class="img-captcha"><i class="reg-no-ico"></i>
								<span data="captcha" class="validate-tips" style="width: 140px;" ></span>
								<a class="a-change-captcha"  href="#none"  onclick="changeCaptcha()" >看不清，换一张</a>
						</div>
						<div class="form-item">
							<button type="submit">完成注册</button>
						</div>
					</form>
				</div>
			</div>
			<div></div>
		</div>
	</div>

	<!-- 底部 -->
	<div class=""></div>

</body>
<script type="text/javascript">		
	 //表单提交检查验证
    function checkForm() {
		var error = $("input[error]");	
		if (error.length > 0) {
		alert("信息填写不正确无法提交！");
			return false;
		} else {
			return true;
		}
	};
	function changeCaptcha(){
	  var img=$(".img-captcha")[0];
	  //加时间戳，防止使用缓存
	  img.src=$("#contextPath").val()+"/user/getCaptcha?i="+new Date().getTime();
	};
</script>
</body>
</html>
