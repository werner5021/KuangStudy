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
	<h4>if測試</h4>
	<hr>
	<%-- 把數據提交到本來的頁面，再自己獲取數據 --%>
	<form action="coreif.jsp" method="get">
		<%-- 
		 EL表達式獲取表單中的數據 -> ${param.參數名}
		 直接用 ${參數名} 無效
		 --%>
		<input type="text" name="username" value="${param.username}">
		<input type="submit" value="登入">
	</form>
	
	<%-- 判斷如果提交的用戶名是管理員，則登入成功 --%>
	<c:if test="${param.username=='admin'}" var="isAdmin" >
		<c:out value="管理員歡迎你"></c:out>
	</c:if>
	
	<%-- 自閉合標籤 --%>
	<c:out value="${isAdmin}"/>	
</body>
</html>