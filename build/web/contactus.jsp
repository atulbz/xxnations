<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page errorPage="oops.jsp" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>
           Contact
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
            <h3> Contact</h3>
            <img src="../images/contact.jpg"/><br>
            <h3>Someone finds it difficult to understand your creative idea?<br>
There is a better visualisation.<br>
Share your views with us...<h3><br>
<h2 font-color="red">support@xxnations.com<br>+91-9724057675<br>+91-9924723723<br>+91-9601156736</h2>
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>       
</html>


