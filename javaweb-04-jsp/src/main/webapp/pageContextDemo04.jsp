<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//轉發的寫法	
	pageContext.forward("/index.jsp");  //在頁面的寫法
	//request.getRequestDispatcher("/index.jsp").forward(request,response);  //在Servlet後台的寫法
%>



</body>
</html>