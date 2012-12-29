<%-- 
    Document   : plandetails
    Created on : Jan 27, 2012, 10:05:53 PM
    Author     : Shaishav
--%>
<%@page import="model.modelplan"%>
<%@page import="model.planservice"%>
<%@page import="java.util.*" %>
<%@page errorPage="./oops.jsp" %>

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
     <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
         <h3 >Plan Details</h3>
         <hr style="width: auto">
        <%
        
         planservice obj1 = new planservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
          String planid = request.getParameter("planid");
         List listplandetails = obj1.getPlanDetails(planid);
            
                modelplan obj2 = (modelplan) listplandetails.get(0);        
                  out.println("<table style=\"border-style: inset;\" color=\"blue\" width=\"400px\">");
                out.println("<tr><td><a href=\"../plandetails.jsp?planid=" + obj2.getPlanid() + "\"> Plan Name : " + obj2.getPlan_name() + "</a></td></tr>");
                out.println("<tr><td><br>");
                out.println("<b>Amount :" + obj2.getAmount());
                out.println("</td></tr>");
                out.println("<tr><td>");
                out.println("<br>");
                out.println("<b>No of Songs :" + obj2.getSongs());
                out.println("</td></tr>");
                out.println("<tr><td>");
                out.println("<br>");
                out.println("<b>Duration : "+ obj2.getDuration());
                out.println("</b></td></tr>");
                            
                out.println("<tr><td>");
                out.println("<br>");
                out.println("Demo for all songs");
                out.println("</td></tr>");
                out.println("<br>");
                out.println("<tr><td>");
                out.println("<br>");
                out.println("Genrate QR code for direct download");
                out.println("</td></tr>");
                out.println("<tr><td>");
                out.println("<br>");
                out.println("Request a Album/Song");
                out.println("</td></tr>");
                              out.println("<tr><td>");
                out.println("<br>");
                out.println("Song carry forward on renewal");
                out.println("</td></tr>");
               out.println("<tr><td>");
                out.println("<br>");
                out.println("No hassle Pay directly with Paypal");
                out.println("</td></tr>");
               
                out.println("<br>");
                out.println("<br>");
                out.println("<tr style=\"text-align: center\"><td><hr>");
                out.print("<form action=\"validate.do\" method=\"post\">");
                out.print("<input type=\"image\" src=\"../images/paypalpaynow.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">");
                
                out.print("<input type=\"hidden\" name=\"plan_id\" id=\"plan_id\" value=\""+planid+"\">");
                out.print("<input type=\"hidden\" name=\"custom\" id=\"\" value=\""+session.getAttribute("user") +"\">");
                out.print("</form>");
                out.println("</td></tr>");
                out.print("</table>"); 
  
%>
        </div>
        <%@include file="./common/Footer.jsp" %>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
