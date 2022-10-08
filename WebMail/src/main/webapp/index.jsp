<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>註冊</title>
	</head>
	<body>
	
	<form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post">
		用戶名:<input type="text" name="username"></br>
		密碼:<input type="password" name="password"></br>
		郵箱:<input type="text" name="email"></br>
		<input type="submit" value="註冊">
	</form>
	
	</body>
</html>
