<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
		
		<script>
			function a1(){
				$.post({
					url:"${pageContext.request.contextPath}/a3",
					data:{"name": $("#name").val()},
					success:function(data){
						console.log(data.toString());  //如果亂碼就加過濾器
						
						if(data.toString()==='用戶正確'){
							$("#userInfo").css("color","green");
						}else{
							$("#userInfo").css("color","red");
						}
						$("#userInfo").html(data);	//返回一個消息				
					}
				})
			}
			function a2(){
				$.post({
					url:"${pageContext.request.contextPath}/a3",
					data:{"pwd": $("#pwd").val()},
					success:function(data){
						console.log(data.toString());
						
						if(data.toString()==="密碼正確"){
							$("#pwdInfo").css("color","green");
						}else{
							$("#pwdInfo").css("color","red");
						}
						$("#pwdInfo").html(data);
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