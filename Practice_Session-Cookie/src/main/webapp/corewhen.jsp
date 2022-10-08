<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="score" value="50"></c:set>
	
	<c:choose>
		<c:when test="${score>=90 }"></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>	
	</c:choose>


</body>
</html>