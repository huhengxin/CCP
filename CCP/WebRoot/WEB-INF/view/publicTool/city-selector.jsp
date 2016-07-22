<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
     <!-- <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.10.1.min.js"></script>
     <input id="contextPath" type="hidden" value="${pageContext.request.contextPath }">
     <div>
			<button type="button"  onclick="showCitySelector(this)">请选择故乡</button>
     </div> -->
	<div class="city-selector">
		<div class="city-content">
			<div class="m City-list" data-widget="tabs">
				<div class="mt">
					<ul class="tab">
						<li class="click" data-widget="tab-item" data-index="0">
							<a href="javascript:;"> <em class="em_prov">请选择</em><i></i></a>
						</li>
						<li class="" style="display: none;" data-widget="tab-item" data-index="1">
							<a href="javascript:;"> <em class="em_city">请选择</em><i></i></a>
						</li>
						<li class="" style="display: none;" data-widget="tab-item" data-index="2">
							<a href="javascript:;"> <em class="em_county">请选择</em><i></i></a>
						</li>
					</ul>
					<div class="stock-line"></div>
				</div>
				<div class="stock_province_item mc" data-widget="tab-content"
					data-area="0" style="display: block;">
					<ul class="area-list">
					<c:forEach items="${province }" var="p" varStatus="ds">
						<li><a data-value="${p.code }" href="javascript:;" title="${p.regionName }" onclick="initProvinceLink(this)">${p.regionName }</a></li>
					</c:forEach>
					</ul>
				</div>
				<div class="stock_city_item mc" data-widget="tab-content"
					data-area="1" style="display: none;">
					<ul class="area-list">
					</ul>
				</div>
				<div class="stock_area_item mc" data-widget="tab-content"
					data-area="2" style="display: none;">
					<ul class="area-list">
					</ul>
				</div>
			</div>
			<span class="clr"></span>
		</div>
		<div class="close" onclick="closeCitySelectorByBtn(this)"></div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/city-selector.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/style/city-selector.css">
<script type="text/javascript">
	
</script>

</html>
