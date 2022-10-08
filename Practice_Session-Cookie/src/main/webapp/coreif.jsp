<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 引入JSTL核心標籤，我們才能使用JSTL標籤core --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>COREIF TEST</h4>	
	<hr>
	<form action="coreif.jsp" method="get">
		<input type="text" name="username" value="${param.username}">
		<input type="submit" value="登入">
	</form>
	<c:if test="${param.username=='admin'}" var="isAdmin">
		<c:out value="WELCOME"></c:out>
	</c:if>
	
<c:out value="${isAdmin} "></c:out>
	
	
	
	
	
	
	
</body>
</html>