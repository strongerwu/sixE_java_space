$(function(){
	$.ajax({
		type:"POST",
		url:$("#basePath").val()+"sectionData/getList.do",
		data:{
			"type":$("#type").val()
		},
		success:function(data){
			 var result = eval('(' + data + ')');
			 if(result=="FIL"){
				 $("#tb_show").empty();
				 return false;
			 }else{
				 $("#tb_show").empty();
				 $.each(result, function(index, content){
					 var con='<tr class="" width="100%">';
					 con+='<td width="5%">'+(index+1)+'</td>';
					 con+='<td width="20%">'+content.seName+'</td>';
					/* if(content.seType == '1'){
						 con+='<td width="20%">世界综合</td>';
					 }else{
						 con+='<td width="20%">资源</td>';
					 }*/
					 con+='<td width="30%">'+content.seDesc+'</td>';
					 if(content.seStatus == '1'){
						 con+='<td width="4%">启用</td>';
					 }else{
						 con+='<td width="4%">禁用</td>';
					 }
					 /*con+='<td width="8%">'+time1+'</td>';
					 con+='<td width="8%">'+time2+'</td>';*/
					 con+='<td width="5%"><button type="button" onclick="show('+content.id+');" class="btn btn-primary">修改</button></td>';
					 con+='</tr>';
					 $('#tb_show').append(con); 
				 });
			 }
		}
	});
	
	/**新增关键字回复*/
	$("#add_Btn").click(function(){
		//重置输入框
		$("#add_seName").val("");
		$("#add_seDesc").val("");
		
		$("#add_use_status").val("2");//启用状态改为禁用
		
		$("#add_type_l1").addClass("active");
		$("#add_type_l2").removeClass("active");
		
		$("#add_use_status_l2").addClass("active");
		$("#add_use_status_l1").removeClass("active");
		
		$('#addModal').modal('show');
	});
	
	$("#ok_Btn").click(function(){
		$("#ok_text").empty();
		$("#ok_text").html("您确认发布刚刚修改的内容吗?");
		$('#okModal').modal('show');
	});
	
});

function show(num){
	$("#upd_err_msg").empty();
	$.ajax({
		type : "POST",
		url : $("#basePath").val()+"sectionData/queryOne.do",
		data : {
			id : num
		},
		success:function(data){
			var result = eval('(' + data + ')');
			$("#upd_id").val(result.id);
			$("#upd_seName").val(result.seName);
			$("#upd_seType").val(result.seType);
			
			$("#upd_seDesc").val(result.seDesc);
			$("#upd_use_status").val(result.seStatus);
			
			$("#upd_type").html("");
			if(result.seType == '1'){
				$("#upd_type").html('世界资源&nbsp;<span class="caret"></span>');
			}else{
				$("#upd_type").html('资源&nbsp;<span class="caret"></span>');
			}
			if(result.seStatus == '1'){
				$("#upd_user_l1").addClass("active");
				$("#upd_user_l2").removeClass("active");
			}else{
				$("#upd_user_l1").removeClass("active");
				$("#upd_user_l2").addClass("active");
			}
			$('#myModal').modal('show');
			return false;
		}
	});
}


/*选择图片回显*/
function readImg(num){
	if(num ==1){
		var inputID="upd_pic_img";
	    var file = document.getElementById(inputID).files[0];  
	     
	     var reader = new FileReader();
	     reader.readAsDataURL(file);
		 reader.onload = function(e){
		      var divID="img_DIV";
		      var f=document.getElementById(divID);  
		      //显示文件  
		      f.innerHTML='<img width="400" height="220" src="'+this.result+'"/>';
		 };
	}else{
		var inputID="add_pic_img";
	    var file = document.getElementById(inputID).files[0];  
	    var reader = new FileReader();
	    reader.readAsDataURL(file);
		reader.onload = function(e){
			var divID="img_DIV_add";
			var f=document.getElementById(divID);  
		    //显示文件  
			f.innerHTML='<img width="400" height="220" src="'+this.result+'"/>';
		};
	}
}

/*新增一个关键字回复*/
function addOne(){
	var add_seName = $("#add_seName").val();
	var add_seType = $("#add_seType").val();
	//var upd_seDesc = $("#upd_seDesc").val();
	var coSeType = $("#type").val();
	$("#add_coSeType").val(coSeType);
	if(add_seName == ""){
		$("#add_err_msg").html("请输入栏目名称");
		return false;
	}

	if(add_seType == ""){
		$("#add_err_msg").html("请选择栏目类型");
		return false;
	}
	
	$("#add_err_msg").empty();//清空提示
	var action=$("#basePath").val()+"sectionData/addOne.do";
	action = encodeURI(action);
	action = encodeURI(action); 
	$("#add_form").attr("action",action);
	$("#add_form").submit();
}

/*修改栏目 选择类型*/
function uSel(val,id){
	$("#upd_type").html("");
	$("#upd_type").html(val);
	$("#upd_seType").val(id);
}

/*新增栏目 选择类型*/
function aSel(val,id){
	$("#add_type").html("");
	$("#add_type").html(val);
	$("#upd_type").val(id);
}

/*修改某个关键字回复*/
function updOne(){
	var upd_seName = $("#upd_seName").val();
	var upd_seType = $("#upd_seType").val();
	//var upd_seDesc = $("#upd_seDesc").val();
	if(upd_seName == ""){
		$("#upd_err_msg").html("请输入栏目名称");
		return false;
	}

	if(upd_seType == ""){
		$("#upd_err_msg").html("请选择栏目类型");
		return false;
	}
	
	$("#upd_err_msg").empty();//清空提示
	var action=$("#basePath").val()+"sectionData/updateOne.do";
	action = encodeURI(action);
	action = encodeURI(action); 
	$("#upd_form").attr("action",action);
	$("#upd_form").submit();
}

/*查询关键字是否存在*/
/*function findKey(){
	var add_key = $("#add_key").val();
	if(add_key == ""){
		$("#add_err_msg").html("请输入关键字");
		return false;
	}
	$.ajax({
		type:"POST",
		url:$("#basePath").val()+"message/queryByKey.do",
		data:{
			replyKey:add_key
		},
		success:function(data){
			var result = eval('(' + data + ')');
			if(result == "FIL"){
				$("#is_have_key").val("1");
				$("#add_err_msg").html("该关键字已经存在");
				return false;
			}else{
				$("#is_have_key").val("2");
				$("#add_err_msg").html("该关键字可添加");
				return false;
			}
		}
	});
}*/

/*切换图文*/
function textORnews(num){
	if(num == 1){
		$("#upd_type").val("1");//回复类型改为文字
		$(".news_class").hide();
		$(".text_class").show();
	}else if(num == 2){
		$("#upd_type").val("2");//回复类型改为文字
		$(".news_class").show();
		$(".text_class").hide();
	}else if(num == 3){
		$("#add_err_msg").empty();
		$("#add_type").val("1");//回复类型改为文字
		$(".news_add_class").hide();
		$(".text_add_class").show();
	}else{
		$("#add_err_msg").empty();
		$("#add_type").val("2");//回复类型改为图文
		$(".news_add_class").show();
		$(".text_add_class").hide();
	}
}
/*切换启用禁用*/
function ban(num){
	if(num == 1){
		$("#upd_use_status").val("1");
	}else if(num == 2){
		$("#upd_use_status").val("2");
	}else if(num == 3){
		$("#add_use_status").val("1");//启用状态改为禁用
	}else if(num == 4){
		$("#add_use_status").val("2");//启用状态改为禁用
	}
}

function is_OK(){
	$.ajax({
		type:"POST",
		url:$("#basePath").val()+"userHome/reloadTextMap.do",
		success:function(data){
			var result = eval('(' + data + ')');
			if(result == 'SUC'){
				$('#okModal').modal('hide');
				return false;
			}else{
				$("#ok_text").empty();
				$("#ok_text").html("发布失败，请联系管理员");
				return false;
			}
		}
	});
}
