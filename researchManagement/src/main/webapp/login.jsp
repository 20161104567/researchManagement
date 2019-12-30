<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./user/login.action" method="post">
	用户名：<input type="text" name="username"><br/>
	密码：<input type="password" name="pwd"><br/>
	<button>登录</button>
</form>
</body>
</html>