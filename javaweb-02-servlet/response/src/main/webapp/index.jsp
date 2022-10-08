<html>
<body>
<h2>Hello World!</h2>

<%-- 這裡提交的路徑，需要尋找到項目的類路徑 --%>
<%-- ${pageContext.request.contextPath}代表當前項目 --%>
<form action="${pageContext.request.contextPath}/login" method="get">
	用戶名:<input type="text" name="username"><br>
	密碼<input type="password" name="password"><br>
	<input type="submit">
</form>



</body>
</html>
