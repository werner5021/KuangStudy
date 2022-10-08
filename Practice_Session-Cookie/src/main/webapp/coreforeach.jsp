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
	ArrayList<String> people = new ArrayList();
	people.add(0, "IU");
	people.add(1, "IU1");
	people.add(2, "IU2");
	people.add(3, "IU3");
	people.add(4, "IU4");
	people.add(5, "IU5");
	people.add(6, "IU6");
	session.setAttribute("list", people);
%>
	
	<c:forEach var="people" items="${list}">
		<c:out value="${people}"></c:out>
	</c:forEach>
	<hr>
	
	
	
	


</body>
</html>