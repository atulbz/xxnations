<%-- 
    Document   : forgotpassword
    Created on : Jan 10, 2012, 1:38:33 AM
    Author     : Shaishav
--%>

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
    if ((String)session.getAttribute("role")== "user") {
 
response.sendRedirect("../index.jsp");             
%>
 
  
  <%
    }
                else
                    {
%>
                    
<%@include file="./common/globalheaderguest.jsp" %>
     <% } %>
     <div style="position: absolute; margin-top: 125px; margin-left: 450px; ">
        <h3>Enter the email id given during the time of subscription </h3>
        <br><br>
        <form action="../forgotpassword.do" method="GET">
            <label>  Email Address:</label> <input type="email" name="email">
            <input type="submit" value="Resend" />
        </form>
        <br><br>
        
     </div>
     <%@include file="./common/Footer.jsp" %>
    </body>
      <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
