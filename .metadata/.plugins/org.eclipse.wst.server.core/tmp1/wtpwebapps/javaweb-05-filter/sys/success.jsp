<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 如果沒有登入(USER_SESSION為空)，就直接回到Login.jsp --%>
<%-- 但其實這種交給過濾器比較好 --%>
<%--
<%
	Object userSession = request.getSession().getAttribute("USER_SESSION");
	if(userSession == null){
		pageContext.forward("/javaweb-05-filter/Login.jsp");
		response.sendRedirect("/javaweb-05-filter/Login.jsp");
	}
%>
--%>

<h1>主頁</h1>

<p><a href="${pageContext.request.contextPath}/servlet/logout">註銷</a></p>

</body>
</html>