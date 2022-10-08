<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	ArrayList<String> people = new ArrayList<>();
	people.add(0, "李知恩");
	people.add(1, "金智秀");
	people.add(2, "潤娥");
	people.add(3, "妍雨");
	people.add(4, "全汝彬");
	request.setAttribute("list", people);
%>

<%-- 
var:   每一次歷遍出來的變量
items: 要歷遍的對象
begin: 起始，默認0
end:   結束，默認最後一個索引
step:  間隔，默認1
 --%>
 
<c:forEach var="people" items="${list}">
	<c:out value="${people}"></c:out></br>
</c:forEach>

<hr>

<c:forEach var="people" items="${list}" begin="1" end="3" step="2">
	<c:out value="${people}"></c:out></br>
</c:forEach>

</body>
</html>