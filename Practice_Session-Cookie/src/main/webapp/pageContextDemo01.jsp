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
	pageContext.setAttribute("name1", "1. 測試page");
	request.setAttribute("name2", "2. 測試request");
	session.setAttribute("name3", "3. 測試session");
	application.setAttribute("name4", "4. 測試application");
%>

<%
	String name1 = (String) pageContext.findAttribute("name1");
	String name2 = (String) pageContext.findAttribute("name2");
	String name3 = (String) pageContext.findAttribute("name3");
	String name4 = (String) pageContext.findAttribute("name4");
	String name5 = (String) pageContext.findAttribute("name5"); 
	
	pageContext.findAttribute("/pageContextDemo02.jsp");
%>
<%
	String name1_1 = (String) pageContext.getAttribute("name1");
	String name2_1 = (String) pageContext.getAttribute("name2");
	String name3_1 = (String) pageContext.getAttribute("name3");
	String name4_1 = (String) pageContext.getAttribute("name4");
	String name5_1 = (String) pageContext.getAttribute("name5"); 
%>
<%
	String name6 = (String) request.getAttribute("name1");
	String name7 = (String) request.getAttribute("name2");
	String name8 = (String) request.getAttribute("name3");
	String name9 = (String) request.getAttribute("name4");
	String name10 = (String) request.getAttribute("name5"); 
%>
<%
	String name11 = (String) session.getAttribute("name1");
	String name12 = (String) session.getAttribute("name2");
	String name13 = (String) session.getAttribute("name3");
	String name14 = (String) session.getAttribute("name4");
	String name15 = (String) session.getAttribute("name5"); 
%>
<%
	String name16 = (String) application.getAttribute("name1");
	String name17 = (String) application.getAttribute("name2");
	String name18 = (String) application.getAttribute("name3");
	String name19 = (String) application.getAttribute("name4");
	String name20 = (String) application.getAttribute("name5"); 
%>

<h1>測試結果</h1>
<h2>pageContext</h2>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
<hr>
<h2>pageContext_1</h2>
<h3>${name1_1}</h3>
<h3>${name2_1}</h3>
<h3>${name3_1}</h3>
<h3>${name4_1}</h3>
<h3>${name5_1}</h3>
<hr>
<h2>request</h2>
<h3>${name6}</h3>
<h3>${name7}</h3>
<h3>${name8}</h3>
<h3>${name9}</h3>
<h3>${name10}</h3>
<hr>
<h2>session</h2>
<h3>${name11}</h3>
<h3>${name12}</h3>
<h3>${name13}</h3>
<h3>${name14}</h3>
<h3>${name15}</h3>
<hr>
<h2>application</h2>
<h3>${name16}</h3>
<h3>${name17}</h3>
<h3>${name18}</h3>
<h3>${name19}</h3>
<h3>${name20}</h3>
<hr>





</body>
</html>