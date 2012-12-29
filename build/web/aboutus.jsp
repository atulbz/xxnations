<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page errorPage="oops.jsp" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>
           Error
        </title>
    </head>
    <body style="background-color: #EEEEEF">
        
        
    
        <div>

                    
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

                   
                    
        <div style="position: absolute; top: 280px; left: 380px;" align="center">
            <h2> About Us (Team-Achievers)</h2>
            <img src="../images/male.jpg"><h3>Shaishav Patel<br>patelshaishav11@gmail.com<br>080390107041</h3><br>
            <img src="../images/female.jpg" height="170" width="196"><h3>Jhanvi Vaghela<br>jhanvipv90@gmail.com<br>080390107055</h3><br>
            <img src="../images/male.jpg"><h3>Atul Zalavadiya<br>atulzalavadiya@aol.in<br>080390107060</h3>
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>       
    <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


