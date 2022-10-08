<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
	<head>
		<title>$Index$</title>
		<script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
		<script type="text/javascript">
			function a() {
				$.post({
					url:"${pageContext.request.contextPath}/a1",
					data:{"name":$("#username").val()},
					success:function(data, status){
						console.log("data="+data);
						console.log("status="+status);
					}
				})
			}		
		</script>		
	</head>
<body>
	
	用戶名:<input type="text" id="username" onblur="a()">
	
	
</body>
</html>
