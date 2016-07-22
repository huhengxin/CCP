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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/echarts/build/dist/echarts.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	   //动态过渡效果
	   $(".reg_indicator").css({
			    left : "670px",
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
		  <span class="reg_step_label">2</span>
			<span class="">填写基本信息</span>
		</div>
		<div class="reg_step3_regok">
		  <span class="reg_step_label" style="background-color: red;">3</span>
			<span class="">注册成功</span>
		</div>
		<div class="reg_indicator" style="left:350px;"></div>
	</div>
	<!-- 内容 -->
	<div class="content">
		<%@ include file="/WEB-INF/view/publicTool/success.jsp"  %>
	</div>
	<!-- 地图 -->
    <div id="mymap" class="mymap" style="margin: 40px auto; height: 500px;width: 850px;z-index: 2;"></div>
	<!-- 底部 -->
	<div class=""></div>
    
</body>
<script type="text/javascript">	
	
</script>

</body>
 <script type="text/javascript">
     $(document).ready(function(){
		$.ajax({
	  		url:$("#contextPath").val()+"/statistic/getStatistic",  //请求的地址，我的struts配置的后面需要加上 .action
	  		type:"post", //请求方式 
	  		data:{},  //参数，Json格式的数据， ：前是变量名，跟后台接收的参数名相同即可，：后是变量
	  		success:function(data){  //后台处理成功的处理函数
	  			var statisticData=eval(data); //解析json数据    
	  			var value=0;
	  			for(var d in statisticData){
	  				 delete statisticData[d].id;
	  				 delete statisticData[d].code;
	  				 (value<statisticData[d].value)&&(value=statisticData[d].value);
	  		    }
	  		// 路径配置
			require.config({
				paths: {
					echarts: $("#contextPath").val()+'/static/echarts/build/dist'
				}
			});
			require(
				[
					'echarts',
					'echarts/chart/map'
				],
				function(ec){
					var myChart = ec.init(document.getElementById('mymap'));
					var option = {
						title : {
							text: '网站注册用户分布图',
							subtext: 'Campus Communication Platform',
							x:'center'
						},
						tooltip : {
							trigger: 'item'
						},
						legend: {
							orient: 'vertical',
							x:'left',
							data:['注册人数']
						},
						dataRange: {
							min: 0,
							max: value,
							x: 'left',
							y: 'bottom',
							text:['高','低'],           // 文本，默认为数值文本
							calculable : true
						},
						
						series : [
							{
								name: '注册人数',
								type: 'map',
								mapType: 'china',
								roam: false,
								itemStyle:{
									normal:{label:{show:true}},
									emphasis:{label:{show:true}}
								},
								data:statisticData
							}
						]
					};
					myChart.setOption(option);
				}
			); 
	  		 },
	  		 error:function(){
	  		   alert("error");
	  		 }
	  	});
		setTimeout(function(){
			$(".sweet-shadow").hide();
			$(".sweet-register-success").hide();
		}, 3000);
	 });
  </script>
</html>
