/*控制enter键提交登录*/
document.onkeydown = function (e) { 
	var theEvent = window.event || e; 
	var code = theEvent.keyCode || theEvent.which; 
	if (code == 13) { 
		$("#loginBtn").click(); 
	} 
}

function login(){
	var userName = $('#userName').val();
	var password = $('#password').val();
	var code = $('#code').val();
	$("#errMsg").empty();
	$("#errMsg").attr("class","msg");
	if(userName.length == 0 || userName == ''){
		$("#errMsg").html("请输入用户名");
		return false;
	}
	if(password.length == 0 || password == '') {
		$("#errMsg").html("请输入密码");
		return false;
	}
	if(code.length == 0 || code == '') {
		$("#errMsg").html("请输入验证码");
		return false;
	}
	$("#errMsg").empty();
	
	$.ajax({
		type : "POST",
		url:$("#basePath").val()+"home/checkCode.do",
		data : {
			code : code
		},
		success:function(data){
			var result = eval('(' + data + ')');
			if(result == 'SUC'){
				$("#isOk").show();
				/* 执行登录*/
				$.ajax({
					type : "POST",
					url:$("#basePath").val()+"home/doLogin.do",
					data : {
						userName : userName,
						password : password
					},
					success:function (data){
						var result = eval('(' + data + ')');
						if(result == 'SUC'){
							suc(1);
							window.location.href=$("#basePath").val()+"myHome/goMyHome.do";
							return false;
						}else{
							$("#errMsg").html(result);
							return false;
						}
					}
				});
				return false;
			}else{
				$("#isOk").hide();
				$("#errMsg").html("验证码输入有误！请重新输入.");
				return false;
			}
		}
	});
	
}

function checkCode(){
	var code = $('#code').val();
	$("#isOk").hide();
	$("#errMsg").empty();
	$("#errMsg").attr("class","msg");
	if(code.length == 0 || code == '') {
		$("#errMsg").html("请输入验证码");
		return false;
	}
	$.ajax({
		type : "POST",
		url:$("#basePath").val()+"home/checkCode.do",
		data : {
			code : code
		},
		success:function(data){
			var result = eval('(' + data + ')');
			if(result == 'SUC'){
				$("#isOk").show();
				return false;
			}else{
				$("#errMsg").html("验证码输入有误！请重新输入.");
				return false;
			}
		}
	});
}

function suc(v){
	$("#errMsg").empty();
	$("#errMsg").attr("class","success");
	if(v == 1){
		$("#errMsg").html("登录成功,正在跳转(2).");
		setTimeout("suc(2);",500);
	}else if(v == 2){
		$("#errMsg").html("登录成功,正在跳转(1)..");
		setTimeout("suc(3);",500);
	}else if(v == 3){
		$("#errMsg").html("登录成功,正在跳转(0)...");
		//setTimeout("suc(4);",500);
		return false;
	}
}

/*刷新验证码*/
function loadimage(){
	$("#rCode").attr("src", $("#basePath").val()+"home/randomImg.do?"+Math.random());
}