<%-- 
    Document   : cancelorder
    Created on : Feb 14, 2012, 11:53:21 PM
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
             <div style="position: absolute; margin-top: 25px; margin-left: 450px; ">
                 <h1>:( We are sad you canceled the transaction click <a href="../home.jsp">here</a> to got to Home</h1>
             </div>
         </body>
</html>
