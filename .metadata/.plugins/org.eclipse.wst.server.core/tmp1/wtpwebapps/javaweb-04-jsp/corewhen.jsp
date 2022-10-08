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
	<%-- set定義一個變量叫score，值為85 --%>
	<c:set var="score" value="85"></c:set>	
	<%-- choose+when 做條件判斷 --%>
	<c:choose>
		<c:when test="${score>=90}">你的成績為優秀</c:when>
		<c:when test="${score>=80}">你的成績為良好</c:when>
		<c:when test="${score>=70}">你的成績為一般</c:when>
		<c:when test="${score>=60}">你的成績為及格</c:when>
		<c:when test="${score<60}">你的成績為不及格</c:when>
	</c:choose>
</body>
</html>