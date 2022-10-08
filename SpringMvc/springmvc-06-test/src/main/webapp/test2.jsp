<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				console.log("按了btn");
				$.post("${pageContext.request.contextPath}/a2",function(data){
					var html="";
					for (let i = 0; i < data.length; i++) {
						html += "<tr>"+"<td>"+data[i].name+"</td>"
						+"<td>"+data[i].age+"</td>"
						+"<td>"+data[i].gender+"</td>"+"</tr>"
					}
					$("#content").html(html);
					
				});
			});
		});
	
	</script>
</head>
<body>

<input type="button" id="btn" value="加載數據">
<table>
	<tr>
		<td>姓名</td>
		<td>年齡</td>
		<td>性別</td>
	</tr>
	<tbody id="content"></tbody>
</table>

</body>
</html>