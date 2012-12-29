<%-- 
    Document   : verificationsend
    Created on : Jan 10, 2012, 1:02:04 AM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
    if ((String)session.getAttribute("role")== "user") {
  %>
  <%@include file="./common/globalheaderuser.jsp" %>
  
  <%
    }
                else
                    {
%>
                    
<%@include file="./common/globalheaderguest.jsp" %>
     <% } %>
        <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
       
             A verification mail has been send to your E-mail.<br>If you have not received click <a href="verificationpending.jsp">here</a>
        </div>
             <%@include file="./common/Footer.jsp" %>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
