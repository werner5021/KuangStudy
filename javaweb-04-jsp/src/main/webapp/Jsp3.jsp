<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- @include會將兩個頁面合二為一 (把header、footer合進Jsp3) --%>
	<%@ include file="common/header.jsp"%>
	<h1>網頁主體</h1>
	<%@ include file="common/footer.jsp"%>
	
	<hr>
	
	<%-- JSP標籤 --%>
	<%-- jsp:include 拼接頁面，本質還是三個 (在Jsp3中去拿header、footer，並在靜態資源中加載進來) --%>
	<jsp:include page="/common/header.jsp"></jsp:include> <%-- page代表頁面，需要在前面加上當前目錄下 / --%>
	<h1>網頁主體</h1>
	<jsp:include page="/common/footer.jsp"></jsp:include>

</body>
</html>