$(document).ready(function(){
	$("#reg_mode_nav").find("li").click(function() {
		var mode = $(this).attr("mode");
		if (mode == "email") {
		   $(".indicator").css({
			    left : "10px",
				right : "270px",
				"transition-property" : "left, right",
				"transition-duration" : "0.5s, 0.5s",
				"transition-timing-function" : "ease, ease-in-out"});
			$("#reg_mode_item").html(
				'<label>邮箱地址</label><input type="text" name="email" class="input-max" placeholder="请输入邮箱地址" error="" onblur="validateEmail(this)"/><i class="user-ico"></i><span data="email" class="validate-tips"></span>');
			$(this).find("i").css("color","rgb(0,124,195)");
			$(this).next().find("i").css("color","#ccc");
			console.log($(".reg-form").find("i"));
			$(".reg-form").find("i").removeClass("img-ico-right").removeClass("img-ico-wrong");
			//清空 所有 提示 输入框
			$(".reg-form").find("input").val("");
			$(".reg-form").find("span").html("");
		} else {
		   $(".indicator").css({
			    left : "270px",
				right : "10px",
				"transition-property" : "left, right",
				"transition-duration" : "0.5s, 0.5s",
				"transition-timing-function" : "ease-in-out, ease"});
		   $("#reg_mode_item").html(
				'<label>手机号码</label><input type="text" name="telephone" class="input-max" placeholder="请输入手机号码" error="" onfocus="validateMobile(this)"/><i class="user-ico"></i><span data="telephone" class="validate-tips"></span>');
			//$("#reg_mode_item").next().children("span").attr("data","telephone");
			$(this).find("i").css("color","rgb(0,124,195)");
			$(this).prev().find("i").css("color","#ccc");
			$(".reg-form").find("i").removeClass("img-ico-right").removeClass("img-ico-wrong");
			//清空 所有提示 输入框
			$(".reg-form").find("input").val("");
			$(".reg-form").find("span").html("");
	     }
    });
    $("#input_captcha").keyup(function(){
	   var vcode=$("#input_captcha").val();
	   if(vcode.length==$("#input_captcha").attr("maxlength")){
	       $.ajax({
				url:$("#contextPath").val()+"/user/checkCaptcha",
				type:"post", //请求方式 
				data:{vcode:vcode},  //参数，Json格式的数据， ：前是变量名，跟后台接收的参数名相同即可，：后是变量
				success:function(data){  //后台处理成功的处理函数
				  var ajaxobj=eval(data); //解析json数据   
					if(ajaxobj==false){	
					  $("#input_captcha").attr("error", "2");
					  $("#input_captcha").focus();
					  $("span[data='captcha']").html("验证码输入错误，请重新获取");	
					  $("#input_captcha").parent().find("i").removeClass("img-ico-right").addClass("img-ico-wrong");

					}else{
						//OK
						$("span[data='captcha']").html("");
						$("#input_captcha").removeAttr("error");
						$("#input_captcha").parent().find("i").removeClass("img-ico-wrong").addClass("img-ico-right");
					}
				}
			});
	  }
	 
    });
    
});
	
//根据年月日获取星座
function getConstellation(element){ 
	var date=$(element).val();
	if(date.length<1){
		$(element).siblings("span[data='empty']").html("输入不能为空");
		$(element).attr("error", "2");
	}else{
		$(element).siblings("span[data='empty']").html("");
		var inputtime=new Date(date.replace(/-/g,"/"));
		var now=new Date();
		if(inputtime>now){
			$(element).siblings("span[data='empty']").html("输入的日期不能大于今天！");
			$(element).attr("error", "3");
		}else{
			$(element).siblings("span[data='empty']").html("");
			$(element).removeAttr("error");
			//2016-01-01
			var month=date.substring(5,7);
			var day=date.substring(8);
		    var s="魔羯水瓶双鱼牡羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
		    var arr=[20,19,21,21,21,22,23,23,23,23,22,22];
		    $(".constellation-tip").html(s.substr(month*2-(day<arr[month-1]?2:0),2)+"座");
		}
	}
}

