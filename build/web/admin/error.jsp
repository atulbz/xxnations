<%-- 
    Document   : error
    Created on : Feb 7, 2012, 7:22:53 PM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
String q=(String)request.getAttribute("message");
out.print(q);
%>
>   <h1>An unexpected error occurred go to <a href="../admin/home.jsp">home</a> and try again </h1>
    </body>
</html>
