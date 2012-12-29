<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page errorPage="oops.jsp" %>
<%@page import="model.genreservice"%>
<%@page import="model.modelgenre"%>
<%@page import="java.util.*"%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>
            Welcome to site
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
     
        <%@include file="./home/latest_albums.jsp" %>
        <%@include file="./home/top_songs.jsp" %>
                   
                    
        <div style="position: absolute; top: 1030px; left: 380px;">
            <h3 style="text-align: center">Featuring plans</h3>
            <%@include file="./home/plan.jsp" %>
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>       
    <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


