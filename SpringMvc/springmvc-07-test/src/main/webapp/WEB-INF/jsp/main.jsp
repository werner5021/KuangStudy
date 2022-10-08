<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>首頁</h1>
<h4>${username}</h4>

<h3><a href="${pageContext.request.contextPath}/user/logout">註銷</a></h3>

</body>
</html>