<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>登入</h1>

<form action="${pageContext.request.contextPath}/servlet/login.do" method="post">
	<input type="text" name="username">
	<input type="submit" value="提交">
</form>

</body>
</html>