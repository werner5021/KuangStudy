<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 這裡只有name3、name4取的到值，因為1、2在Demo01用的是page、request設定--%>
	<%
	//pageContext取，使用尋找的方式
	//尋找機制:從底層到高層
	String name1 = (String) pageContext.findAttribute("name1");  
	String name2 = (String) pageContext.findAttribute("name2");
	String name3 = (String) pageContext.findAttribute("name3");
	String name4 = (String) pageContext.findAttribute("name4");
	String name5 = (String) pageContext.findAttribute("name5");  //不存在
	%>

	<%-- 使用EL表達式${} --%>

	<h1>取出的值為:</h1>
	<h3>${name1}</h3>
	<h3>${name2}</h3>
	<h3>${name3}</h3>
	<h3>${name4}</h3>
	<h3>${name5}</h3>
	<%-- EL表達式即使取不到東西，也不會顯示出來 --%>
	<hr>
	<h3><%=name5%></h3>
	<%-- JSP表達式取不到東西會顯示null --%>


</body>
</html>