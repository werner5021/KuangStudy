<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登入</title>
	</head>
	<body>
		<h1>登入</h1>
		<div> 
			<%-- 這個表單的意思: 以post方式提交表單，提交到login請求 --%>
			<form action="${pageContext.request.contextPath}/login" method="post">
				用戶名:<input type="text" name="username"> <br>
				密碼:<input type="password" name="password"> <br>
				愛好:
				<input type="checkbox" name="hobbys" value="唱歌">唱歌
				<input type="checkbox" name="hobbys" value="戲劇">戲劇
				<input type="checkbox" name="hobbys" value="主持">主持
				<input type="checkbox" name="hobbys" value="綜藝">綜藝
				
				<br>
				<input type="submit">
			</form>
		</div> 
	</body>
</html>