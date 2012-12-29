<%-- 
    Document   : rating
    Created on : Jan 5, 2012, 10:30:24 PM
    Author     : Shaishav
--%>




<sql:setDataSource var="ds" driver="org.sqlite.JDBC" url="jdbc:sqlite:c:\\sqllite\\try\\music.db"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="./oops.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
out.print(request.getParameter("rate"));        
%>



    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
