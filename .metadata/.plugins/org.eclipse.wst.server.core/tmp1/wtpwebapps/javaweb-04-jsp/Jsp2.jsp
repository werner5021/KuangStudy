<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 訂製錯誤頁面 --%>
<%--<%@ page errorPage="error/500.jsp"%> --%>

<%-- 顯示的聲明這是一個錯誤頁面 (不常用) --%>
<%@ page isErrorPage="true" %>
<%@ page pageEncoding="UTF-8" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>	
		<% int x =1/0; %>		
	</body>
</html>