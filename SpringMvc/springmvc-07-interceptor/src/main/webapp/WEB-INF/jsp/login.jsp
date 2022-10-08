<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 在WEB-INF下的所有頁面或資源，只能通過controller，或servlet進行訪問，無法直接訪問 --%>

<h1>登入頁面</h1>

<form action="${pageContext.request.contextPath}/user/login" method="post">
	用戶名:<input type="text" name="username">
	密碼:<input type="password" name="password">
	<input type="submit" value="提交">
</form>

</body>
</html>