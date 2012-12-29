<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page errorPage="oops.jsp" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>
           Features
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
            <h2> Features</h2></br>
            <h3 style="font-style:agency FB"><ul>
                <li>More Than 1000+ songs</li></ul></br>
                <ul><li>QR Code For Android </li></ul>
                </br>
                <ul><li>Favourite Song Request</li></ul></br>
                <ul><li>Pay Per Plan</li></ul></br>
                <ul><li></li></ul></br>
                <ul><li></li></ul></br>
                <ul><li></li></ul></br>
            </ul></h3>
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>       
      <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


