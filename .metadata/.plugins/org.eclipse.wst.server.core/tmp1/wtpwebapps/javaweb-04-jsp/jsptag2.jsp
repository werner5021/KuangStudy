<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>2</h1>


<%-- 取出參數 --%> <%-- 這裡不用EL表達式是因為EL裡面只能使用requestScope，而不能用request --%>
名字: <%=request.getParameter("name") %>
年齡: <%=request.getParameter("age") %>




</body>
</html>