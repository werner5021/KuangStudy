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
	String name1 = (String) pageContext.findAttribute("name1");
	String name2 = (String) pageContext.findAttribute("name2");
	String name3 = (String) pageContext.findAttribute("name3");
	String name4 = (String) pageContext.findAttribute("name4");
	String name5 = (String) pageContext.findAttribute("name5");
	
	%>

	<h3>${name1}</h3>
	<h3>${name2}</h3>
	<h3>${name3}</h3>
	<h3>${name4}</h3>
	<h3>${name5}</h3>



</body>
</html>