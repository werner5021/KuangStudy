<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.werner.pojo.Person"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="people" class="com.werner.pojo.Person" scope="page"></jsp:useBean>

<jsp:setProperty property="name" name="people" value="IU"/>
<jsp:setProperty property="" name=""/>

<jsp:getProperty property="" name=""/>

</body>
</html>