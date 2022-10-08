<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<title>$Title$</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
		<input type="file" name="file" /> 
		<input type="submit" value="upload">
	</form>
	
	<a href="${pageContext.request.contextPath}/statics/IU02.jpg">下載圖片</a>


</body>
</html>
