<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {//$()页面加载完毕，加载的函数
		//判断用户名是否被占用
		$("input[name='username']").blur(function() {
			//alert(this.value);
			$.ajax({
				url : "./user/checkUserName.action",
				data : {
					"username" : this.value
				},
				contentType : "application/json;charset=utf-8",
				success : function(result) {
					$("#unsp").empty();
					if (result.isExist == true) {
						$("#unsp").append("<font color='red'>用户名已占用</font>");
					} else {
						$("#unsp").append("<font color='green'>用户名可用</font>");
					}
				},
				dataType : "json",
			});
		});
	});
	//加载省级信息
	$.post("./loc/findAllProvince.action", //"application/json;charset=utf-8",
	function(result) {
		console.log(result);
		var pselect = $("select[name='loc.province']");
		var pchild = "";
		for (var i = 0; i < result.length; i++) {
			console.log(result.length);
			pchild += "<option value='"+result[i].id+"'>" + result[i].pname
					+ "</option>";
		}
		pselect.html(pchild);
		var pid = $("select option:first-child").val();
		//加载城市信息
		$.ajax({
			url : "./loc/findCitiesByPId.action",
			data : {"pid" : pid},
			contentType : "application/json;charset=utf-8",
			success : function(msg) {
				// console.log(msg);
				var cselect = $("select[name='loc.city']");
				var cchild = "";
				for (var i = 0; i < msg.length; i++) {
					cchild += "<option value='"+msg[i].id+"'>" + msg[i].cname
							+ "</option>";
				}
				cselect.html(cchild);
				var cselect = $("select[name='loc.city'] option:first-child").val();
				console.log(cselect);
			},
			dataType : "json"
		});
		//加载地区信息
		$.ajax({
			url : "./loc/findAreaByCId.action",
			data : {"cid" : cid},
			contentType : "application/json;charset=utf-8",
			success : function(msg1) {
				console.log(msg1);
				var aselect = $("select[name='loc.area']");
				var achild = "";
				for (var i = 0; i < msg1.length; i++) {
					achild += "<option value='"+msg1[i].id+"'>" + msg1[i].aname
							+ "</option>";
				}
				aselect.html(achild);
				var aselect = $("select[name='loc.area'] option:first-child").val();
				console.log(aselect);
			},
			dataType : "json"
		});
		
	}, "json");
</script>
</head>
<body>
	<form action="./user/regist.action" method="post">
		用户名：<input type="text" name="username"><span id='unsp'></span><br />
		密码：<input type="password" name="pwd"><br /> 
		确认密码：<input type="password" name="repwd"><br />
		姓名：<input type="text" name="name"><br />
		生日：<input type="text" name="birthday"><br />
		地址：省/直辖市<select name="loc.province"></select>
		市<select name="loc.city"></select>
		区<select name="loc.area"></select><br />
		邮箱：<input type="text" name="email"><br />
		手机号：<input type="text" name="phone"><br />
		微信号：<input type="text" name="weixin"><br />
		QQ号：<input type="text" name="qq"><br />
		头像：<input type="file" name="img"><br />
		<button>注册</button>
	</form>
</body>
</html>