<%-- 
    Document   : passwordsend
    Created on : Jan 10, 2012, 3:42:30 AM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Send</title>
    </head>
    <body style="background-color: #EEEEEF">
               
<%@include file="./common/globalheaderguest.jsp" %>
 <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
             <h3>A email has been send to you with your username and password if you did not receive click <a href="forgotpassword.jsp">here</a>!</h3>
             <br>
             <a href="../login.jsp">Login</a>
    <br>
    <a href="./index.jsp">Home</a>
 </div>
 <%@include file="./common/Footer.jsp" %>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
