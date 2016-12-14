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

		<script type="text/javascript" src="${basePath }common/js/jquery-1.10.0.min.js"></script>
		<script type="text/javascript" src="${basePath }common/js/jquery-form.js"></script>
		<%-- <script type="text/javascript" src="${basePath }common/dataTables/Buttons/js/buttons.bootstrap.min.js"></script> --%>
		<script type="text/javascript" src="${basePath }common/bootstrap/js/bootstrap.min.js"></script>
		<%-- <link rel="stylesheet" href="${basePath }common/dataTables/Buttons/css/buttons.bootstrap.min.css" type="text/css"></link> --%>
		<link rel="stylesheet" href="${basePath }common/bootstrap/css/bootstrap.min.css" type="text/css"></link>