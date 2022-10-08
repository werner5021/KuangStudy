<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
		<title>$Title$</title>
		<!-- 導入jquery包 -->
		<script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
		
		<!-- js是一個隨便的語言 -->
		<script>
			function a(){
				<!-- $相當於jQuery -->				
				$.post({
					url:"${pageContext.request.contextPath}/a1",
					data:{"name":$("#username").val()},  
						//必須以鍵值對的方式傳數據
						//後端是從ajax的name取數據，而不是從表單的username取數據
					success:function(data, status){
						console.log("data="+data);
						console.log("status="+status);
					}
				})
			}			
		</script>
	</head>
<body>
	
	<!-- 失去焦點的時候，發起一個請求(攜帶訊息)到後台 -->
<!-- 	<a href="/t1"></a>  a標籤的href可以直接指向請求，但是無法使用失焦的功能 -->
	用戶名:<input type="text" id="username" onblur="a()">
	
	
</body>
</html>
