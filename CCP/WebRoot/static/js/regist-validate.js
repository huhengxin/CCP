/* 自定义数据校验  */

// 规则：
//  1. 提示信息用<span>标签
//  2. 错误添加error属性，规则:  1-为空， 2-格式不对

// 一、 input框校验：
//  1. Chinese:汉字校验
//  2. loginName:登录名校验
//  3. password:密码校验
//  4. empty:非空校验

var realNameFormat = /^[\u4e00-\u9fa5]{1,6}$/;  //姓名：匹配 1-6 位汉字
//var companyNameFormat=/^[\u4e00-\u9fa5]{1,12}$/;//公司名：匹配1-12位汉字
//var loginNameFormat = /^[_a-zA-Z0-9\u4e00-\u9fa5]{3,16}$/;  //登录名：只能是汉字、数字、字母和下划线,3-15位
var passwordFormat = /^(\d+[a-zA-z.,_!@#$^%&*?]+)|([a-zA-z]+[0-9.,_!@#$^%&*?]+)|([.,_!@#$^%&*?]+[0-9a-zA-z]+)$/;  //密码：数字、字母和特殊字符至少包含2种
var chineseFormat = /^[\u4e00-\u9fa5]+$/;  //汉字：汉字多于一个
//var IdCardFormat=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/; //18位身份证号
var mobileFormat = /^[1]{1}[3-8]{1}[0-9]{9}$/; //手机号
var mailFormat = /^[a-zA-Z]{1}([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; //邮箱格式
var numberMail = /^[1-9]{1}[0-9]{5,10}\@([q]{2}|[1]{1}[26]{1}[36]{1}){1}\.[com]{3}$/; //数字邮箱格式 如：手机邮箱、qq邮箱

	//邮箱校验
	function validateEmail(element){
		if($(element).val().length < 1){
			$("span[data='email']").html("输入不能为空！");
			$(element).attr("error", "1");
			$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
			//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
		} else if(!mailFormat.test($(element).val()) && !numberMail.test($(element).val())){	
			//$(element).parent().find("span[data='email']").html("邮箱格式不正确");
			$("span[data='email']").html("邮箱格式不正确");
			$(element).attr("error", "2");
			//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
			$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");

		} else {
			//异步提交 判断  查重 
			var email=$(element).val();
			$.ajax({
  				url:$("#contextPath").val()+"/user/checkReg",  //请求的地址，我的struts配置的后面需要加上 .action
  				type:"post", //请求方式 
  				data:{loginName:email},  //参数，Json格式的数据， ：前是变量名，跟后台接收的参数名相同即可，：后是变量
  				success:function(data){  //后台处理成功的处理函数
  				  var ajaxobj=eval(data); //解析json数据   
  				   console.log("----"+ajaxobj);
  				    //已经绑定
  					if(ajaxobj==true){	
  					  $(element).attr("error", "3");
  					  $(element).focus();
  					  $("span[data='email']").html("该邮箱已经绑定，不能注册！");	
  					  $(element).parent().parent().find("span[data!='email']").html("");
  					 // $(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
  					$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");

  					}else{
  						//OK
  						$("span[data='email']").html("");
  						$(element).removeAttr("error");
  						//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yes.png)");
  						$(element).parent().find("i").removeClass("img-ico-wrong").addClass("img-ico-right");
  					}
  				}
  			});
			
		}
	};
	function validateMobile(element){
		$("span[data='telephone']").html("请输入11位手机号");
		$(element).focusout(function(){
			if($(element).val().length < 1){
				$("span[data='telephone']").html("输入不能为空！");
				$(element).attr("error", "1");
				$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
				//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
			}else if(!mobileFormat.test($(element).val())){
				
				$("span[data='telephone']").html("手机号格式不正确！");
				$(element).attr("error", "2");
				$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
				//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
			} else {
				//异步提交 判断  查重 
				var telephone=$(element).val();
				$.ajax({
	  				url:$("#contextPath").val()+"/user/checkReg",  //请求的地址，我的struts配置的后面需要加上 .action
	  				type:"post", //请求方式 
	  				data:{loginName:telephone},  //参数，Json格式的数据， ：前是变量名，跟后台接收的参数名相同即可，：后是变量
	  				success:function(data){  //后台处理成功的处理函数
	  				  var ajaxobj=eval(data); //解析json数据     
	  				    //已经绑定
	  					if(ajaxobj==true){
	  					  $(element).attr("error", "3");
	  					  $(element).focus();
	  					  $("span[data='telephone']").html("该手机号已经绑定，不能注册！");
	  					  $(element).parent().parent().find("span[data!='telephone']").html("");
	  					$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
	  					 // $(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yesandon.png)");
	  					}else{
	  						//OK
	  						$("span[data='telephone']").html("");
	  						$(element).removeAttr("error");
	  						$(element).parent().find("i").removeClass("img-ico-wrong").addClass("img-ico-right");
	  						//$(element).parent().find("i").css("background-image","url("+$("#contextPath").val()+"/static/images/reg_yes.png)");
	  					}
	  				}
	  			});
			}
		});
	};
	function validatePassw(element){
		$("span[data='passw']").html('&nbsp;数字、字母和特殊字符至少包含2种');
		$(element).focusout(function(){
			var val = $(element).val();
			if($(element).val().length < 1){
				$("span[data='passw']").html("输入不能为空！");
				$(element).attr("error", "1");
				$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
			}else if(val.length < 6 || !passwordFormat.test(val) || chineseFormat.test(val)){
				$("span[data='passw']").html("密码格式不正确！");
				$(element).attr("error", "2");
				$(element).parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");
			} else {
				$("span[data='passw']").html("");
				$(element).removeAttr("error");
				$(element).parent().find("i").removeClass("img-ico-wrong").addClass("img-ico-right");


			}
		});
		
	};
	// 真实姓名校验
	function validateName(element) {

		if ($(element).val().length < 1) {
			$("span[data='realName']").html("输入不能为空！");
			$(element).attr("error", "2");
		} else if (!realNameFormat.test($(element).val())) {
			$("span[data='realName']").html("格式不正确");
			$(element).attr("error", "2");
		} else {
			$("span[data='realName']").html("");
			$(element).removeAttr("error");
		}
   };
	
	function validateEmpty(element){
		if($(element).val().length < 1){
			$(element).siblings("span[data='empty']").html("输入不能为空！");
			$(element).attr("error", "2");
		} else {
			$(element).siblings("span[data='empty']").html("");
			$(element).removeAttr("error");
		}
	};
//	$("input[name='realName']").focus(function(){
//		$("span[data='realName']").html('&nbsp;请输入1-6位汉字');
//	}).focusout(function(){
//		if(!realNameFormat.test($(this).val())){
//			$("span[data='realName']").html("格式不正确");
//			$(this).attr("error", "2");
//		} else {
//			$("span[data='realName']").html("");
//			$(this).removeAttr("error");
//		}
//	});

//// 公司名校验
//$("input[data='companyName']").focus(function(){
//	$("span[data='companyName']").html('&nbsp;请输入公司名称，且与营业执照一致');
//}).focusout(function(){
//	if(!companyNameFormat.test($(this).val())){
//		$("span[data='companyName']").html("非1-12位汉字输入！");
//		$(this).attr("error", "2");
//	} else {
//		$("span[data='companyName']").html("");
//		$(this).removeAttr("error");
//	}
//});
//

// 非空校验
//$("input[data='empty']").focusout(function(){
//	alert("ri");
//	if($(this).val().length < 1){
//		$(this).siblings("span[data='empty']").html("输入不能为空！");
//		//$("span[data='empty']").html("输入不能为空！");
//		$(this).attr("error", "2");
//	} else {
//		$(this).siblings("span[data='empty']").html("");
//		//$("span[data='empty']").html("");
//		$(this).removeAttr("error");
//	}
//});

//
//// 重复密码校验
//$("input[data='verifyPwd']").focusout(function(){
//	var pwd1 = $("input[data='password']").val();
//	var pwd2 = $(this).val();
//	if(pwd2 == ""){
//		$("span[data='verifyPwd']").html("请输入确认密码！");	
//		$(this).attr("error", "1");
//	} else if (pwd1 != pwd2){
//		$("span[data='verifyPwd']").html("两次输入不一致");	
//		$(this).attr("error", "2");
//	} else {
//		$("span[data='verifyPwd']").html("");	
//		$(this).removeAttr("error");
//	}
//});
//// 身份证号校验
//$("input[data='IDCard']").focus(function(){
//	$("span[data='IDCard']").html("请输入18位身份证号");
//}).focusout(function(){
//	if(!IdCardFormat.test($(this).val())){
//		$("span[data='IDCard']").html("身份证号格式不正确！");
//		$(this).attr("error", "2");
//	} else {
//		$("span[data='IDCard']").html("");
//		$(this).removeAttr("error");
//	}
//});
//
//
//// 登录名校验
//$("input[data='loginName']").focusout(function(){
//	if(!loginNameFormat.test($(this).val())){
//		$("span[data='loginName']").html("输入格式不正确，只能是3-16位汉字，数字，字母和下划线");
//		$(this).attr("error", "2");
//	} else {
//		$("span[data='loginName']").html("");
//		$(this).removeAttr("error");
//	}
//});

