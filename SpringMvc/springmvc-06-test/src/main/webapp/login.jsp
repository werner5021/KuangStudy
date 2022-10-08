<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
<script>
	function a1(){
		$.post({
			url:"${pageContext.request.contextPath}/a3",
			data:{"name":$("#name").val()},
			success:function(dataN){
				console.log("dataN="+dataN);
				
				if(dataN==="用戶正確"){
					$("#userInfo").css("color","blue");
				}else{
					$("#userInfo").css("color","red");
				}
				$("#userInfo").html(dataN);
			}
		})
	}
	
	
</script>
</head>
<body>


	<p>
		用戶名:<input type="text" id="name" onblur="a1()"> 
		<span id="userInfo"></span>
	</p>
	<p>
		密碼:<input type="text" id="pwd" onblur="a2()"> 
		<span id="pwdInfo"></span>
	</p>


</body>
</html>