<%--
    Document   : plan
    Created on : Jan 27, 2012, 9:59:36 PM
    Author     : Shaishav
--%>

<%@page import="model.modelplan"%>
<%@page import="model.planservice"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan</title>
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
     <div style="position: absolute; margin-top: 50px; margin-left: 450px; ">
        <h1>Plans Available</h1>
        <hr>
        <br><br><br>
        <%
         String user_id=(String)session.getAttribute("user");
            planservice obj1 = new planservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
            List listplan = obj1.getPlans();
            for (int i = 0; i < listplan.size(); i++) {
                modelplan obj2 = (modelplan) listplan.get(i);

                out.println("<table style=\"border-style: outset\" cellspacing=\"3\"cellpadding=\"3\" width=\"350px\">");
                
                out.println("<tr><td><a href=\"plandetails.jsp?planid=" + obj2.getPlanid() + "\"> Plan Name : " + obj2.getPlan_name() + "</a></td></tr>");
                out.println("<tr><td>");
                out.println("Amount :" + obj2.getAmount());
                out.println("<br>");
                out.println("No of Songs :" + obj2.getSongs());
               // out.println("<br>");
               // out.println("  And more Features...");
                out.println("</td></tr>");
                out.println("<tr><td>");
                out.print("<hr><form action=\"./plandetails.jsp\" method=\"post\">");
                out.print("<input type=\"image\" src=\"./images/details-button.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">");
                out.print("<img alt=\"\" border=\"0\" src=\"./images/buynow.gif\" width=\"1\" height=\"1\">");
                out.print("<input type=\"hidden\" name=\"planid\" id=\"planid\" value="+obj2.getPlanid()+">");
                out.print("</form>");
                out.println("</td></tr>");
                out.print("</table><br><br>");
            }
        %>
     </div>
     <%@include file="./common/Footer.jsp" %>
     </body>
        <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
