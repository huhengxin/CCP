<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>    
    <title>My JSP 'basicinfor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/style/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/style/register.css">

	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/regist-validate.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/register.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/My97DatePicker/WdatePicker.js"></script>

	<style type="text/css">
	.validate-tips{
	 padding-left: 135px;
	}
	</style>
	<script type="text/javascript">
	//动态过渡效果
	$(document).ready(function(){
	   $(".reg_indicator").css({
			    left : "350px",
				"transition-property" : "left",
				"transition-duration" : "0.5s",
				"transition-timing-function" : "ease"});
	});
	</script>
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
		   <span class="reg_step_label">1</span>
			<span class="">设置登录账户</span>
		</div>
		<div class="reg_step2_basicinfor">
		  <span class="reg_step_label" style="background-color: red;">2</span>
			<span class="">填写基本信息</span>
		</div>
		<div class="reg_step3_regok">
		  <span class="reg_step_label">3</span>
			<span class="">注册成功</span>
		</div>
		<div class="reg_indicator" style="left:25px;"></div>
	</div>
    <div class="content">
      <div class="main">
       <div class="basicinfor">
         <div class="infor-header">填写基本信息</div>
         <div class="infor-form">
          <form action="${pageContext.request.contextPath }/user/addBasicInfor" method="post" onsubmit="return checkInfor()">
            <input type="hidden" name="id" value="${user.id }">
            <div class="infor-item">
              <label class="infor-tip">真实姓名</label>
              <i class="input-tip">(必填):</i>
              <input class="input-max" type="text" name="realName" placeholder="请输入1-6个汉字" maxlength="6" onblur="validateName(this)" error="">
              <input class="gender-input" type="hidden" name="gender" value="1">
               <div class="gender-tip gender-checked">               
                <i class="fa fa-mars" style="color: white;"></i>
                <label style="color: white">男</label>
               </div>
               <div class="gender-tip" style="right:105px;"> 
               <i class="fa fa-venus" style="color: rgb(0,124,195);"></i>
               <label>女</label>
               </div>
               <span class="validate-tips" data="realName"></span>
            </div>
            <div class="infor-item">
              <label class="infor-tip">生日</label>
              <i class="input-tip">(必填):</i>
              <input id="abcde" type="text" name="birth" readonly="readonly" class="Wdate input-max" style="width: 130px;" onClick=" WdatePicker()" onblur="getConstellation(this)"  error="">
              <span class="constellation-tip"></span>
              <span class="validate-tips" data="empty"></span>
            </div>
            <div class="infor-item">
              <label class="infor-tip">家乡</label>
              <i class="input-tip">(必填):</i>
              <input class="city-mark" type="hidden" name="hometown">
              <input class="input-max"  type="text" readonly="readonly" style="width: 160px;" placeholder="点击选择城市" onclick="showCitySelector(this)"  error="">           
              <!-- 引入城市选择器 -->
              <%@ include file="/WEB-INF/view/publicTool/city-selector.jsp" %>
              <span class="validate-tips" data="empty"></span>
            </div>
            <div class="infor-item">
              <label class="infor-tip">所在地</label>
              <i class="input-tip">(必填):</i> 
              <input class="city-mark" type="hidden" name="location">
              <input class="input-max"  type="text"  readonly="readonly" style="width: 160px;" placeholder="点击选择城市" onclick="showCitySelector(this)"  error="">            
              <!-- 引入城市选择器 -->
              <%@ include file="/WEB-INF/view/publicTool/city-selector.jsp" %>
              <span class="validate-tips" data="empty"></span>
            </div> 
            <div class="infor-item">
              <button type="submit">保存并继续</button>
            </div>
          
          </form>
         </div>
       </div>
      
      </div>
    </div>
   
   
  </body>
  <script type="text/javascript">
   //表单提交检查验证
    function checkInfor() {
		var error = $("input[error]");	
		if (error.length > 0) {
		    alert("信息填写不正确无法提交！");
			return false;
		} else {
			return true;
		}
	};
  //性别操作
  $(".gender-tip").click(function(){
    $(this).addClass("gender-checked");
    $(this).siblings("div.gender-tip").removeClass("gender-checked");
    $(this).children("label").css("color","white");
    $(this).children("i").css("color","white");
    $(this).siblings("div.gender-tip").children("label").css("color","#808080");
    $(this).siblings("div.gender-tip").children("i").css("color","rgb(0,124,195)");
    if($(this).children("label").html()=="女"){   
      $(this).parent().children("input.gender-input").val("0");
    }else{
      $(this).parent().children("input.gender-input").val("1");
    } 
  });
  </script>
</html>
 