<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String contextPath = request.getContextPath();
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath;
	String ctx = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
	request.setAttribute("path",  contextPath+"/");
	request.setAttribute("basePath",  path+"/");
%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>老司机</title>
		<link rel="stylesheet" type="text/css" href="${basePath }common/html5/dialog.css" />
		<!-- css3弹出动画样式 -->
		<link rel="stylesheet" type="text/css" href="${basePath }common/html5/dialog-wilma.css" />
    	<script type="text/javascript" src="${basePath }common/html5/modernizr.custom.js"></script>
    	
    	
		<script type="text/javascript" src="${basePath }common/myJS/login.js?ran=<%=Math.random()%>"></script>
		<link rel="stylesheet" href="${basePath }common/myCSS/main.css" type="text/css"></link>
		<link href="${basePath }common/images/favicon.png" rel="shortcut icon">
		<script type="text/javascript" src="${basePath }common/js/jquery-1.10.0.min.js"></script>
		<!-- 公共对话框样式 -->
		<style type="text/css">
			.msg {
				color : red;
			}
			.success {
				color : #00FFFF;
			}
		</style>
</head>
  <body class="lg_bg">
  <input id="basePath" value="${basePath }" type="hidden">
    <div class="lg_box">
    <div class="login_bar">
    <div class="lg_tit">欢迎登录老司机后台</div>
    <div class="lg_tit2">嘿嘿嘿  老司机</div>
    <!-- <div class="lg_img"></div>
    -->
  <%--   <div class="lg_list">
        <ul>
            <li><input type="text" placeholder="用户名" class="ipt1" autocomplete="off" id="userName"></li>
            <li><input type="password" placeholder="密码" class="ipt1 ipt_tit" autocomplete="off" id="password"></li>
            <li><input type="text" placeholder="验证码" class="ipt2" autocomplete="off" id="code" onblur="checkCode();">
	            <div class="yzm"><img src="${basePath}home/randomImg.do"  width="" height="42" alt="" id="rCode" onclick="loadimage();"></div>
	            <div class="yzm_ok" id="isOk"><img src="${basePath}common/images/yzm_ok.png" width="21" height="21" alt=""></div></li>
            <li><span class="msg" id="errMsg"></span></li>
            <li class="mar_tb"><input type="button" id="loginBtn" value="登录" onclick="login();" class="ipt1 ipt_btn" ></li>
            <li><a href="#"  target="_blank"></a><a href="JavaScript:void(0)"  data-dialog="somedialog" class="trigger">忘记密码？</a></li>
        </ul>
    </div> --%>
    </div>
   </div>
<!--弹窗-->
<!-- <div id="somedialog" class="dialog">
		<div class="dialog__overlay"></div>
		<div class="dialog__content">
			<div class="morph-shape">
				<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" viewBox="0 0 560 280" preserveAspectRatio="none">
					<rect x="3" y="3" fill="none" width="556" height="276"/>
				</svg>
			</div>
			<div class="dialog-inner">
				<h2> 请联系您的管理员重置密码</h2>
				<div><button class="action" data-dialog-close>关闭</button></div>
			</div>
		</div>
</div>    -->
<script type="text/javascript" src="${basePath }common/html5/classie.js"></script>
<script type="text/javascript" src="${basePath }common/html5/dialogFx.js"></script>
<script type="text/javascript">
(function() {
	var dlgtrigger = document.querySelector( '[data-dialog]' ),
		somedialog = document.getElementById( dlgtrigger.getAttribute( 'data-dialog' ) ),
		dlg = new DialogFx( somedialog );

	dlgtrigger.addEventListener( 'click', dlg.toggle.bind(dlg) );

})();
//控制session到期~
/* $(function(){
	//alert($("#myFrame",parent.document).attr("src"));
	if($("#myFrame",parent.document).attr("src") == undefined){
		//alert($("#myFrame",parent.document).attr("src"));
	}else{
		//alert(1);
		parent.window.location.href=$("#basePath").val()+"myHome/toHome";
	}
}); */
</script>
</body>
</html>
