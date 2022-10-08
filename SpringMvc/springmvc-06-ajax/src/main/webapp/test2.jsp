<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
		<script>
			$(function() {
				$("#btn").click(function() {
					console.log("按了btn");
	
					//確定能加載數據後，再來寫請求
					/*
					$.post(url, param[可以省略], success)
					 */
					$.post("${pageContext.request.contextPath}/a2", function(data) { //也可以把url寫到參數中，簡寫的方式
						console.log(data);
						//把data解析，拚到<tbody>中，js操作DOM元素，動態增加節點
						var html = "";
						//數據有三個需要歷遍
						for (let i = 0; i < data.length; i++) {
							html += "<tr>" + "<td>" + data[i].name + "</td>"
									+ "<td>" + data[i].age + "</td>" + "<td>"
									+ data[i].gender + "</td>" + "</tr>"
						}
						//將數據加到content裡面
						$("#content").html(html);
					});
				});
			});
		</script>
	</head>
	<body>
		<%-- 寫事件來獲取數據 --%>
		<input type="button" value="加載數據" id="btn">
		<table>
			<tr>
				<td>姓名</td>
				<td>年齡</td>
				<td>性別</td>
			</tr>
			<tbody id="content">
				<%-- 數據來自後台 --%>
			</tbody>
		</table>
	</body>
</html>