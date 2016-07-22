<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<style type="text/css">
		.sa-icon.sa-success {
			border: 4px solid rgba(255,255,255,0);
			border-radius: 50%;
			box-sizing: content-box;
			height: 80px;
			width: 80px;
			margin: 20px auto;
			position: relative;
		}
		
		.sa-icon.sa-success .sa-line{
			background-color: #A5DC86;
			border-radius: 3px;
			height: 5px;
			position: absolute;
			z-index: 10;
		}
		
		.sa-icon.sa-success .sa-line.sa-tip{
			left: 14px;
			top: 46px;
			transform: rotate(45deg);
		}
		
		.sa-icon.sa-success .sa-line.sa-long{
			right: 8px;
			top: 38px;
			transform: rotate(-45deg);
		}
		
		.sa-icon.sa-success .sa-placeholder{
			border: 4px solid rgba(165, 220, 134, 0.2);
			border-radius: 50%;
			box-sizing: content-box;
			height: 80px;
			width: 80px;
			position: absolute;
			top: -4px;
			left: -4px;
			z-index: 10;
		}
		
		/* 动画效果 */
		.animateSuccessTip {
		  -webkit-animation-delay: 1s;
		  -webkit-animation-duration: 0.75s;
		  -webkit-animation-name: animateSuccessTip;
		  -webkit-animation-fill-mode: forwards; /*当动画完成后，保持最后一个属性值 */
		  
		  animation-delay: 1s;
		  animation-duration: 0.75s;
		  animation-name: animateSuccessTip;
		  animation-fill-mode: forwards; /* 当动画完成后，保持最后一个属性值 */
		}

		.animateSuccessLong {
		  -webkit-animation-delay: 1s;
		  -webkit-animation-duration: 0.75s;
		  -webkit-animation-name: animateSuccessLong;
		  -webkit-animation-fill-mode: forwards; /*当动画完成后，保持最后一个属性值*/
		  
		  animation-delay: 1s;
		  animation-duration: 0.75s;
		  animation-name: animateSuccessLong;
		  animation-fill-mode: forwards; /* 当动画完成后，保持最后一个属性值 */
		}
		
		@-webkit-keyframes animateSuccessTip {
		  0% {
			width: 0;
			left: 1px;
			top: 19px; }
		  54% {
			width: 0;
			left: 1px;
			top: 19px; }
		  70% {
			width: 50px;
			left: -8px;
			top: 37px; }
		  84% {
			width: 17px;
			left: 21px;
			top: 48px; }
		  100% {
			width: 25px;
			left: 14px;
			top: 45px; }
		}

		@keyframes animateSuccessTip {
		  0% {
			width: 0;
			left: 1px;
			top: 19px; }
		  54% {
			width: 0;
			left: 1px;
			top: 19px; }
		  70% {
			width: 50px;
			left: -8px;
			top: 37px; }
		  84% {
			width: 17px;
			left: 21px;
			top: 48px; }
		  100% { 
			width: 25px;
			left: 14px;
			top: 45px; }
		}

		@-webkit-keyframes animateSuccessLong {
		  0% {
			width: 0;
			right: 46px;
			top: 54px; }
		  65% {
			width: 0;
			right: 46px;
			top: 54px; }
		  84% {
			width: 55px;
			right: 0px;
			top: 35px; }
		  100% {
			width: 47px;
			right: 8px;
			top: 38px; }
		}

		@keyframes animateSuccessLong {
		  0% {
			width: 0;
			right: 46px;
			top: 54px; }
		  65% {
			width: 0;
			right: 46px;
			top: 54px; }
		  84% {
			width: 55px;
			right: 0px;
			top: 35px; }
		  100% {
			width: 47px;
			right: 8px;
			top: 38px; }
		}
		
		
		/* ----------------------- */
		.wrapper {
		  width: 88px;
		  height: 88px;
		  position: absolute;
		  top: -4px;
		  left: -4px;
		  clip: rect(0px, 88px, 88px, 44px);
		}
		.circle {
		  width: 80px;
		  height: 80px;
		  border: 4px solid #A5DC86;
		  border-radius: 50%;
		  position: absolute;
		  clip: rect(0px, 44px, 88px, 0px);
		}
		
		div[data-anim~=base] {
		  -webkit-animation-iteration-count: 1;  /* 动画播放的次数 */
		  -webkit-animation-fill-mode: forwards; /* 当动画完成后，保持最后一个属性值 */
		  -webkit-animation-timing-function:linear; /* 动画从头到尾的速度是相同的 */
		  
		  animation-iteration-count: 1;  /* 动画播放的次数 */
		  animation-fill-mode: forwards; /* 当动画完成后，保持最后一个属性值 */
		  animation-timing-function:linear; /* 动画从头到尾的速度是相同的 */
		}
		
		.wrapper[data-anim~=wrapper] {
		  -webkit-animation-duration: 0.01s; /* 规定完成动画所花费的时间，以秒或毫秒计 */
		  -webkit-animation-delay: 0.5s; /* 规定在动画开始之前的延迟 */
		  -webkit-animation-name: close-wrapper; /* 规定需要绑定到选择器的 keyframe 名称 */
		  
		  animation-duration: 0.01s; /* 规定完成动画所花费的时间，以秒或毫秒计 */
		  animation-delay: 0.5s; /* 规定在动画开始之前的延迟 */
		  animation-name: close-wrapper; /* 规定需要绑定到选择器的 keyframe 名称 */
		}
		@-webkit-keyframes close-wrapper {
		  to {
			clip: rect(auto, auto, auto, auto);
		  }
		}
		@keyframes close-wrapper {
		  to {
			clip: rect(0px, 88px, 88px, 0px);
		  }
		}
		
		.circle[data-anim~=right] {
		  -webkit-animation-duration: 0.5s;
		  -webkit-animation-name: right-spin;
		  
		  animation-duration: 0.5s;
		  animation-name: right-spin;
		}
		@-webkit-keyframes right-spin {
		  from {
			-webkit-transform: rotate(0deg);
		  }
		  to {
			-webkit-transform: rotate(180deg);
		  }
		}
		@keyframes right-spin {
		  from {
			transform: rotate(0deg);
		  }
		  to {
			transform: rotate(180deg);
		  }
		}
		
		.circle[data-anim~=left] {
		  -webkit-animation-duration: 1s;
		  -webkit-animation-name: left-spin;
		  
		  animation-duration: 1s;
		  animation-name: left-spin;
		}
		@-webkit-keyframes left-spin {
		  from {
			-webkit-transform: rotate(0deg);
		  }
		  to {
			-webkit-transform: rotate(360deg);
		  }
		}
		@keyframes left-spin {
		  from {
			transform: rotate(0deg);
		  }
		  to {
			transform: rotate(360deg);
		  }
		}
		
		/* -------------------------------------------------------------------------------- */
		.sweet-register-success{
			background-color:#fff;
			position:absolute;
			top:50%;
			left:50%;
			width:300px;
			height:220px;
			z-index:10;
			margin: -100px 0 0 -150px;
			border-radius:8px;
			overflow:hidden;
		}
		.sweet-message{
			margin: 20px 0;
			text-align:center;
			font-size:18px;
		}
		.sweet-shadow{
			width:100%;
			height:100%;
			background-color:rgba(0,0,0,0.3);
			position:fixed;
			top:0;
			left:0;
			z-index:8;
		}
		
	</style>
  </head>
  
  <body>
  <div class="sweet-shadow"></div>
  <div class="sweet-register-success">
	<div class="sa-icon sa-success animate">
		<span class="sa-line sa-tip animateSuccessTip"></span>
		<span class="sa-line sa-long animateSuccessLong"></span>
		<div class="sa-placeholder"></div>
		<div class="wrapper" data-anim="base wrapper">
		    <div class="circle" data-anim="base left"></div>
		    <div class="circle" data-anim="base right"></div>
		</div>
	</div>
	<div class="sweet-message">注册成功</div>
	<div class="sweet-message">恭喜您成为网站第 ${userSum } 个用户！</div>
  </div>
  </body>
  
 

</html>