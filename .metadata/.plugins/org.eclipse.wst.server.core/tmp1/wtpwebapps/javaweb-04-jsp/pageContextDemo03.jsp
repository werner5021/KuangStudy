<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
 	
 	    public static final int PAGE_SCOPE		= 1;
 	    public static final int REQUEST_SCOPE	= 2;
 	    public static final int SESSION_SCOPE	= 3;
 	    public static final int APPLICATION_SCOPE	= 4;
 	
 	//scope 作用域
    public void setAttribute(final String name, final Object o, final int scope) {

        if (name == null) {
            throw new NullPointerException(Localizer.getMessage("jsp.error.attribute.null_name"));
        }

        if (o == null) {
            removeAttribute(name, scope);
        } else {
            switch (scope) {
            case PAGE_SCOPE:
                attributes.put(name, o);
                break;

            case REQUEST_SCOPE:
                request.setAttribute(name, o);
                break;

            case SESSION_SCOPE:
                if (session == null) {
                    throw new IllegalStateException(Localizer
                            .getMessage("jsp.error.page.noSession"));
                }
                session.setAttribute(name, o);
                break;

            case APPLICATION_SCOPE:
                context.setAttribute(name, o);
                break;

            default:
                throw new IllegalArgumentException("Invalid scope");
            }
        }
    }
 --%>





<% 
	pageContext.setAttribute("hello1", "hello1", PageContext.SESSION_SCOPE);
	//上面設定作用域為session，就等於 
	//session.setAttribute("hello1", "hello1");

%>


</body>
</html>