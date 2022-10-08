<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.werner.pojo.People" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	//原型如下
//	People people = new People();
//	people.setId(1);
//	people.setName("李知恩");
//	people.setAge(29);
//	people.setAddress("首爾");
 %>
 
<%-- 使用一個對象 --%>
<jsp:useBean id="people" class="com.werner.pojo.People" scope="page"/>

<%-- 賦值用setProperty --%>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="李知恩"/>
<jsp:setProperty name="people" property="age" value="29"/>
<jsp:setProperty name="people" property="address" value="首爾"/>

<%-- 相當於使用people.getXXX() --%>
ID:  <jsp:getProperty name="people" property="id"/>
姓名: <jsp:getProperty name="people" property="name"/>
年齡: <jsp:getProperty name="people" property="age"/>
地址: <jsp:getProperty name="people" property="address"/>


</body>
</html>