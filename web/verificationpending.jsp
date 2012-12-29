<%-- 
    Document   : verificationpending
    Created on : Jan 8, 2012, 5:06:56 PM
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
        <%@include file="./common/globalheaderguest.jsp" %>
        <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
        <h3>Please verify your Account if you have not received confirmation mail resend it</h3>
        <br><br>
        <form action="../resend.do" method="GET">
            Email Address <input type="text" name="email">
            <input type="submit" value="Resend" />
        </form>
        <br><br>
  

        <a href="index.jsp">Home </a>
    
  
                    

</div>
<%@include file="./common/Footer.jsp" %>
          
    <%
session.invalidate();    
%>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
