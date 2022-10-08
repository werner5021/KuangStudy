<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="common/header.jsp" %>
	<h1>Subject</h1>
	<%@ include file="common/footer.jsp" %>
	
	<hr>
	
	<jsp:include page="/common/header.jsp"></jsp:include>
	<h1>DSubject</h1>
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>