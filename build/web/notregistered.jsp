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

                   
                    
        <div style="position: absolute; top: 280px; left: 380px;">
            <h3> You are not Registered user click <a href="register.jsp">here</a> to register</h3>
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>    
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


