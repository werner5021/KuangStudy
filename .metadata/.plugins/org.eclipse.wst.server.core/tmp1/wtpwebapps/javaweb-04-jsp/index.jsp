<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%-- JSP表達式 → 用來將程序輸出，輸出到客戶端 
 <%= 變量 or 表達式%> 
 --%>
<%=  new java.util.Date()%>

<hr>
<%-- JSP腳本片段 --%>
<% 
	int sum = 0;
	for(int i=0; i<=100; i++){
	sum += i;	
	}
	out.println("<h1>Sum=" + sum +"</h1>"); 
%>

<%-- 腳本片段的再實現 --%>
<%
	int x = 10;
	out.print(x);
%>
<p>這是一個jsp</p>
<%
	int y = 2;
	out.print(y);
%>

<hr>

<%--在代碼中嵌入HTML元素 --%>
<%
	for(int i=0; i<5; i++){
%>
	<h1>Hello,World <%= i%> </h1>
<%	
	}
%>


<hr>

<%! 
	static{
		System.out.println("Loading Servlet");
	} 
	private int globalVar = 0;
	public void globalTest(){
		System.out.println("進入了方法globalTest()");
	}
%>

<!-- 我是HTML的註釋 -->
<%-- 我是JSP的註釋 --%>

</body>
</html>
