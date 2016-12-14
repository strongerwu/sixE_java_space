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
		<link href="${basePath }common/images/favicon.png" rel="shortcut icon">
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/css/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/css/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/css/Hui-iconfont/1.0.7/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/icheck/icheck.css" />
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/css/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="${basePath }common/html/css/h-ui.admin/css/style.css" />
</head>
  
  <body style="overflow:hidden;">
  
  <header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="${basePath }myHome/goMyHome.do">老司机&nbsp;后台管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="${basePath }myHome/goMyHome.do">蜡笔分期</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">V1.0</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar ">
				<ul class="cl">
					<!-- <li>超级管理员</li> -->
					<li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">${user.eNikeName } <i class="Hui-iconfont">&#xe6d5;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<!-- <li><a href="#">个人信息</a></li> -->
							<li><a href="${basePath }home/exit.do">切换账户</a></li>
						<!-- 	<li onclick="updPw();"><a href="javascript:void(0);">修改密码</a></li> -->
							<li><a href="${basePath }home/exit.do">退出</a></li>
						</ul>
					</li>
					<!-- <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li> -->
					<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
						<ul class="dropDown-menu menu radius box-shadow">
							<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
							<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
							<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
							<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
							<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
							<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</header>
<aside class="Hui-aside">
	<input runat="server" id="divScrollValue" type="hidden" value="" />
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 栏目管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="${basePath }myHome/menuConfig.do" data-title="栏目管理" href="javascript:void(0)">栏目管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe622;</i> 世界综合<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
				<c:forEach items="${wd_list}" var="ls" varStatus="status">
						<li><a _href="${basePath }myHome/showList.do?type=${ls.id}" data-title="${ls.seName }" href="javascript:void(0)">${ls.seName }</a></li>
				</c:forEach>
					<%-- <li><a _href="${basePath }userHome/keywordReply1.do?num=2" data-title="首页" href="javascript:void(0)">首页</a></li>
					<li><a _href="${basePath }userHome/keywordReply2.do" data-title="华语" href="javascript:void(0)">华语</a></li>
					<li><a _href="${basePath }userHome/otherReply3.do" data-title="欧美" href="javascript:void(0)">欧美</a></li>
					<li><a _href="${basePath }userHome/keywordReply1.do?num=1" data-title="日语" href="javascript:void(0)">日语</a></li>
					<li><a _href="${basePath }userHome/otherReply.do" data-title="韩语" href="javascript:void(0)">韩语</a></li> --%>
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 资源<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
				<c:forEach items="${re_list}" var="ls1" varStatus="status">
						<li><a _href="${basePath }myHome/showList.do?type=${ls1.id}" data-title="${ls1.seName }" href="javascript:void(0)">${ls1.seName }</a></li>
				</c:forEach>
					<%-- <li><a _href="${basePath }userHome/attentionReply1.do" data-title="资源1" href="javascript:void(0)">资源1</a></li>
					<li><a _href="${basePath }userHome/attentionReply2.do" data-title="资源2" href="javascript:void(0)">资源2</a></li>
					<li><a _href="${basePath }userHome/attentionReply3.do" data-title="资源3" href="javascript:void(0)">资源3</a></li> --%>
				</ul>
			</dd>
		</dl>
		<!-- <dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a _href="system-base.html" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
					<li><a _href="system-category.html" data-title="密码管理" href="javascript:void(0)">密码管理</a></li>
				</ul>
			</dd>
		</dl> -->
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="${basePath }myHome/welcome.do">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" id="index_iframe" src="${basePath }myHome/welcome.do"></iframe>
		</div>
	</div>
</section>


<script type="text/javascript" src="${basePath }common/html/js/jquery.min.js"></script> 
<script type="text/javascript" src="${basePath }common/html/js/layer.js"></script> 
<script type="text/javascript" src="${basePath }common/html/css/h-ui/js/H-ui.js"></script> 
<script type="text/javascript" src="${basePath }common/html/css/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}

</script> 
<script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s)})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>