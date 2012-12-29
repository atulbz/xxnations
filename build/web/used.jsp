<%-- 
    Document   : used
    Created on : Feb 11, 2012, 3:06:58 PM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
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
                  <h3>This download link has already been used click <a href="index.jsp">Here </a> to go to home</h3>
     </div>
     <%@include file="./common/Footer.jsp" %>
         </body>
            <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
