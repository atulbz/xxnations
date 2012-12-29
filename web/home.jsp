


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page errorPage="oops.jsp" %>

<%
try
               {
if(session.getAttribute("role")!="user")
{
response.sendRedirect("../login.jsp");
}
else
{
    response.sendRedirect("../index.jsp");
}}
catch(Exception e)
               {
    
}
  %>
