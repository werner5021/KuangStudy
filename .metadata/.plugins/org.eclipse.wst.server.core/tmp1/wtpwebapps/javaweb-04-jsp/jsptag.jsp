<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- jsp:include 包含，拼接頁面--%>

	<%-- 
	相當於 -> http://localhost:8080/javaweb-04-jsp/jsptag2.jsp?name=IU&age=29 
	--%>
	<jsp:forward page="/jsptag2.jsp">
		<jsp:param value="IU" name="name"/>
		<jsp:param value="29" name="age"/>
	</jsp:forward>
		
	

	
</body>
</html>