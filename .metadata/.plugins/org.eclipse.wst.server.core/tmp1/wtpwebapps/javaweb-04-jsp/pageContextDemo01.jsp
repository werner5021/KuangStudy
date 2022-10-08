<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 內置對象 --%>

	<%
	pageContext.setAttribute("name1", "測試一號"); //保存的數據，只在一個頁面中有效
	request.setAttribute("name2", "測試二號"); //保存的數據，只在一次請求中有效，請求轉發會攜帶著
	session.setAttribute("name3", "測試三號"); //保存的數據，只在一次會話中有效，從打開瀏覽器到關閉瀏覽器
	application.setAttribute("name4", "測試四號"); //保存的數據，在服務器中有效，從打開服務器到關閉服務器
	%>

	<%-- 腳本片段中的代碼，會被原封不動的生成到JSP.java 
		 要求: 這裡的代碼必須要求Java語法的正確性--%>
	<%
	//通過pageContext取出我們保存的值，用.getAttribute

	//從pageContext取出，這裡使用尋找findAttribute的方式
	//findAttribute的尋找機制-> 從底層到高層(作用域): page -> request -> session -> application，都沒有就null
	//JVM 雙親委派機制-> 找類能不能用: 類 -> 根加載器 -> rt.jar，都沒有就ClassNoFound
	String name1 = (String) pageContext.findAttribute("name1");
	String name2 = (String) pageContext.findAttribute("name2");
	String name3 = (String) pageContext.findAttribute("name3");
	String name4 = (String) pageContext.findAttribute("name4");
	String name5 = (String) pageContext.findAttribute("name5");  //不存在
	
	pageContext.forward("/pageContextDemo02.jsp");  
	//把請求轉發給Demo02，所以在Demo02才能取出name2
	//直接訪問Demo02取不到name2
	//這時候Demo01已經轉發Demo02，所以看不到pageContext設定的name1
	
	%>

	<%-- 使用EL表達式${} --%>

	<h1>取出的值為:</h1>
	<h3>${name1}</h3>
	<h3>${name2}</h3>
	<h3>${name3}</h3>
	<h3>${name4}</h3>
	<h3>${name5}</h3>
	<%-- EL表達式即使取不到東西，也不會顯示出來 --%>
	<hr>
	<h3><%=name5%></h3>
	<%-- JSP表達式取不到東西會顯示null --%>

</body>
</html>