<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/public.jsp" %>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<title>老司机</title>
		<link href="${basePath }common/images/favicon.png" rel="shortcut icon">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="${basePath }common/myJS/menuConfig.js?ran=<%=Math.random()%>"></script>
		
	<style type="text/css">
		.file_top{ position: absolute; z-index: 5; left:140px; display: block; background: url(${basePath }common/images/file_bg.jpg)no-repeat center center; width: 400px;height: 220px;border: 1px solid #ccc;}
		.file_box{position: absolute; z-index: 6; left:140px; width: 400px; height: 220px; opacity:0;  }
		#img_DIV img{ position: absolute;;z-index: 5;left:0px;}
	</style>	
</head>
<body style="font-family: '微软雅黑';">
	<input type="hidden" value="${basePath}" id="basePath" />
	
    <h3 style="padding-left:18px;">栏目配置</h3><hr/>
    
 <div style="clear:both; float:left; padding-left:28px; padding-right:18px; padding-bottom: 10px;width: 100%;"> 
 	<button type="button" id="add_Btn" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 新增</button>
 	<!-- <button type="button" id="ok_Btn" class="btn btn-default"><span class="glyphicon glyphicon-check"></span> 发布</button> -->
    <table class="table table-bordered table-striped" style=" padding-right:30px; margin-top: 8px; width:100%; word-break: break-all">
    			<thead >
    				<tr class="info" style="text-align: center;">
    					 <th width="5%">编号</th>
				         <th width="25%">栏目名称</th>
				         <!-- <th width="30%">所属类型</th> -->
				         <th width="30%">栏目描述</th>
				         <th width="5%">状态</th>
				        <!--  <th width="8%">创建时间</th>
				         <th width="8%">修改时间</th> -->
				         <th width="5%">操作</th>
    				</tr>
    			</thead>
    			<tbody id="tb_show">
    		   </tbody>
	</table>
 </div>   

<!-- 修改  -----------------------===========================--------------------------------------------------- -->
<form action="" name="upd_form" id="upd_form" method="post" >
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 150%; margin-left: -150px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改内容</h4>
      </div>
      <div class="modal-body" align="center">
      		<input type="hidden" id="upd_id" name="id" value=""/>
      		<input type="hidden" value="1" name="seType"/>
			<table class="table table-striped" style="text-align: center; ">
				<tr class="">
					<td width="20%">栏目名称：</td>
					<td width="80%"><textarea class="input-sm" rows="1" cols="60" name="seName" placeholder="请输入栏目名称" id="upd_seName"></textarea></td>
				</tr>
				
				<!-- <tr class="">
					<td>所属类型：</td>
					<td>
						<input type="hidden" value="" name="seType" id="upd_seType"  />
						<div class="dropdown">
						  <button class="btn btn-info dropdown-toggle" type="button" id="upd_type"
						  				 data-toggle="dropdown" aria-haspopup="true" 
						  				 aria-expanded="true">请选择<span class="caret"></span></button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu" id="uRole" style="left:300px;">
						  		<li onclick="uSel('世界综合',1);" ><a>世界综合</a></li>
						  		<li onclick="uSel('资源',2);" ><a>资源</a></li>
						  </ul>
						</div>
					</td>
				</tr> -->
				<tr class="">
					<td>状态：</td>
					<td id="other">
						<div class="btn-group" data-toggle="buttons">
						  <input type="hidden" value="2" name="seStatus" id="upd_use_status"/>
						  <label class="btn btn-default" id="upd_user_l1" onclick="ban(1);">
						    <input type="radio" name="options" id="option2" autocomplete="off" checked> 启用
						  </label>
						  <label class="btn btn-default active" id="upd_user_l2" onclick="ban(2);">
						    <input type="radio" name="options" id="option3" autocomplete="off"> 禁用
						  </label>
						</div>
					</td>
				</tr>
				<tr class="">
					<td>栏目描述：</td>
					<td id="work"><textarea class="input-sm" rows="3" name="seDesc" id="upd_seDesc" cols="60" placeholder="请输入描述内容"></textarea></td>
				</tr>
				<!-- <tr class="" style="display: none;">
					<td></td>
					<td></td>
				</tr> -->
				<tr>
					<td></td>
					<td><p id="upd_err_msg" style="font-size: 12px;color: red;"></p></td>
				</tr>
			</table>
      </div>
      <div class="modal-footer" style="text-align: center;">
      	<button type="button" class="btn btn-info" id="upd_Btn_save" onclick="updOne();" >保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</form>
<!-- 修改  -----------------------===========================--------------------------------------------------- -->

<!-- 新增  -----------------------===========================--------------------------------------------------- -->
<form action="" name="add_form" id="add_form" method="post" >
 <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 150%; margin-left: -150px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="addModalLabel">新增</h4>
      </div>
      <div class="modal-body" align="center">
      		<input type="hidden" value="1" name="seType" />
			<table class="table table-striped" style="text-align: center; ">
				<tr class="">
					<td width="20%">栏目名称：</td>
					<td width="80%" id="key"><textarea class="input-sm" rows="1" cols="60" name="seName" placeholder="请输入栏目名称" id="add_seName"></textarea></td>
				</tr>
				<!-- <tr class="">
					<td>所属类型：</td>
					<td>
						<input type="hidden" value="" name="seType" id="add_seType"  />
						<div class="dropdown">
						  <button class="btn btn-info dropdown-toggle" type="button" id="add_type"
						  				 data-toggle="dropdown" aria-haspopup="true" 
						  				 aria-expanded="true">请选择<span class="caret"></span></button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu" id="aType" style="left:300px;">
						  		<li onclick="uSel('世界综合',1);" ><a>世界综合</a></li>
						  		<li onclick="uSel('资源',2);" ><a>资源</a></li>
						  </ul>
						</div>
					</td>
				</tr> -->
				<tr class="">
					<td>状态：</td>
					<td id="other">
						<div class="btn-group" data-toggle="buttons">
						  <input type="hidden" value="2" name="seStatus" id="add_use_status"/>
						  <label class="btn btn-default active" id="add_use_status_l1" onclick="ban(3);" >
						    <input type="radio" name="options" id="add_use_status1" autocomplete="off" checked> 启用
						  </label>
						  <label class="btn btn-default" id="add_use_status_l2" onclick="ban(4);">
						    <input type="radio" name="options" id="add_use_status2" autocomplete="off"> 禁用
						  </label>
						</div>
					</td>
				</tr>
				<tr class="text_add_class">
					<td>栏目描述：</td>
					<td id="work"><textarea class="input-sm" rows="3" name="seDesc" id="add_seDesc" cols="60" placeholder="请输入描述内容"></textarea></td>
				</tr>
			</table>
      </div>
      
      <div class="modal-footer" style="text-align: center;">
      	<button type="button" class="btn btn-info" id="add_Btn_save" onclick="addOne();" >保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</form>
<!-- 新增  -----------------------===========================--------------------------------------------------- -->


<!-- 发布- -----------------------===========================----------------------------------------------------->
 <div class="modal fade" id="okModal" tabindex="-1" role="dialog" aria-labelledby="okModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 50%; margin-left: 50px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="okModalLabel">发布提醒</h4>
      </div>
      <div class="modal-body" align="center" id="ok_text">
			
      </div>
      <div class="modal-footer" style="text-align: center;">
      	<button type="button" class="btn btn-info" id="is_ok" onclick="is_OK();" >发布</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
<!-- 发布- -----------------------===========================----------------------------------------------------->

</body>
</html>
