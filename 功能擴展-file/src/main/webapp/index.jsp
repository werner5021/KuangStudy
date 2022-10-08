<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>$Title$</title>
</head>
<body>
	
	<%-- 要上傳一定得透過表單
		get :上傳文件大小有限制
		post:上傳文件大小沒有限制
	 --%>
	<form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
	<%-- /upload.do 只能用在單機的IDE上跑，真實要發布的開發項目必須美服務器的地址
		 ${pageContext.request.contextPath} 獲取服務器的路徑 --%>
		上傳用戶:<input type="text" name="username"><br/> <%-- 會生成一個對應的uuid --%>
		上傳檔案1:<p><input type="file" name="file1"></p> <%-- 會生成一個對應的uuid --%>
		上傳檔案2:<p><input type="file" name="file1"></p> <%-- 會生成一個對應的uuid --%>
		<p><input type="submit" value="提交">|<input type="reset"></p>
	</form>



</body>
</html>