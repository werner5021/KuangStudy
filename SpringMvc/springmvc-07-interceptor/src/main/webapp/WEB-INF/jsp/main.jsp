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

<span>${username}</span>

<p>
	<a href="${pageContext.request.contextPath}/user/goOut">註銷</a> <!-- 調一個請求去移除節點 -->
</p>

</body>
</html>