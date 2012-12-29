

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
if ((String)session.getAttribute("role") != "user") {
        response.sendRedirect("../login.jsp");
    }
String userid;

userid=(String)session.getAttribute("user");

%>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
        <title>Manage Account</title>
    </head>
    <body style="background-color: #EEEEEF">
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
     <div style="position: absolute; margin-top: 120px; margin-left: 550px; color: #2875DE "><h3>
         <a href="editprofile.jsp"><label>Edit your Profile</label></a><br><br>  
        <a href="payementinfo.jsp"><label>Payment Info</label></a><br><br>
        <a href="downloadhistory.jsp"><label>Download History</label></a><br><br>
        <a href="requesthistory.jsp"><label>Request History</label></a><br>
         </h3></div>
     <%@include file="./common/Footer.jsp" %>
    </body>
    <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
