<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
	<h1>當前有<span style="color:blue"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>人在線</h1>
</body>
</html>
