/* 城市选择器  */
/* 作者：胡恒心      */
/* 版本：1.0   */

//点击城市按钮，显示城市选择块
	function showCitySelector(element){
		var div = $(element);
		var x = div.position().left; //div的x坐标
		var y = div.position().top; //div的y坐标
		div.addClass("city_text_click");
		var height = div.height(); //div的高
		var city_div = div.next(".city-selector");
		city_div.css('left', x);
		city_div.css('top', y + height);  // +2: 加上边框的2个像素
		city_div.addClass("click");
		initTabStyle(element);
		initProvinceLink(element);
	}
	
	//选择完，自动隐藏城市选择块
	function closeCitySelector(element){
		var city_div = $(element).next(".city-selector");
		 $(element).removeClass("city_text_click");
		 city_div.removeClass("click");
		 //验证非空
		 validateEmpty(element);
		
	}
  	
	//点击关闭按钮，隐藏城市选择块
	function closeCitySelectorByBtn(element){
		$(element).parent().prev(".city-text").removeClass("city_text_click");
		$(element).parent().removeClass("click");
		//验证非空
		validateEmpty($(element).parent().prev());
	}
	
	//初始化tab样式
	function initTabStyle(element){
		var city_div = $(element).next(".city-selector");
	  	//给省、市、地区添加样式
		city_div.find(".tab").find("a").click(function(){
			city_div.find(".tab").find("li").removeClass("click");
	  		$(this).parent().addClass("click");
	  	});
	  	
		city_div.find(".tab").children("li").click(function(){
	  		var index = $(this).attr("data-index");
	  		switch(index){
	  			case '0':
	  				city_div.find(".stock_province_item").show();
	  				city_div.find(".stock_city_item").hide();
	  				city_div.find(".stock_area_item").hide();
			  		break;
	  			case '1':
	  				city_div.find(".stock_province_item").hide();
	  				city_div.find(".stock_city_item").show();
	  				city_div.find(".stock_area_item").hide();
			  		break;
			  	case '2':
			  		city_div.find(".stock_province_item").hide();
			  		city_div.find(".stock_city_item").hide();
			  		city_div.find(".stock_area_item").show();
			  		break;
	  		}
	  	});
	}
  	
	function initProvinceLink(element){
		var city_div = $(element).next(".city-selector");
		city_div.find(".stock_province_item").find("a").click(function(){
	  		var code = $(this).attr("data-value");
	  		var cityName = $(this).html();
	  		$.ajax({
				url:$("#contextPath").val()+"/region/citySelector",
				type:"post",
				data:{parentCode:code},
				success:function(data){
					var citys = eval(data);
					var lis = new Array;
					for(var i = 0; i< citys.length; i++){
						lis.push("<li><a data-value='"+citys[i].code+"' href='javascript:;'>"+citys[i].regionName+"</a></li>");
					}
					city_div.find(".stock_city_item").children("ul").html(lis.join(""));
	
					city_div.find(".em_prov").html(cityName);
					
					city_div.find(".stock_province_item").hide();
					city_div.find(".stock_area_item").hide();
					city_div.find(".stock_city_item").show();
					
					city_div.find(".tab").find("li[data-index=1]").show().addClass("click").siblings().removeClass("click");
					city_div.find(".tab").find("li[data-index=2]").hide(); //隐藏第三方地区选择
					city_div.find(".em_city").html("请选择"); //将市的显示修改为 请选择
					initCityLink(element);
				}
			});
	  	});
	}
  	
  	function initCityLink(element){
		var city_div = $(element).next(".city-selector");
  		city_div.find(".stock_city_item").find("a").click(function(){
	  		var code = $(this).attr("data-value");
	  		var cityName = $(this).html();
	  		$.ajax({
				url:$("#contextPath").val()+"/region/citySelector",
				type:"post",
				data:{parentCode:code},
				success:function(data){
					var citys = eval(data);
					var lis = new Array;
					for(var i = 0; i< citys.length; i++){
						lis.push("<li><a data-value='"+citys[i].code+"' href='javascript:;'>"+citys[i].regionName+"</a></li>");
					}
					city_div.find(".stock_area_item").children("ul").html(lis.join(""));
	
					city_div.find(".em_city").html(cityName);
					
					city_div.find(".stock_province_item").hide();
					city_div.find(".stock_city_item").hide();
					city_div.find(".stock_area_item").show();
					
					city_div.find(".tab").find("li[data-index=2]").show().addClass("click").siblings().removeClass("click");
					city_div.find(".em_county").html("请选择");
					initAreaLink(element);
				}
			});
	  	});
  	}
  	
  	function initAreaLink(element){
		var city_div = $(element).next(".city-selector");
  		city_div.find(".stock_area_item").find("a").click(function(){
	  		var code = $(this).attr("data-value");
	  		var cityName = $(this).html();
	  		var district = city_div.find(".em_prov").html() + " ";
	  		district += city_div.find(".em_city").html() + " ";
	  		district += cityName;
	  		city_div.find(".em_county").html(cityName);
	  		$(element).prev("input.city-mark").val(code);
	  		$(element).val(district);
	  		//$(element).siblings("span").html(district);
	  		//$(element).siblings("input").val(code);
	  		closeCitySelector(element);
	  	//	var data_val = $(element).siblings("input").attr("data");
	  		//if(data_val == "onchange"){
	  		//	initLink(element);
	  		//}
	  	});
  	}