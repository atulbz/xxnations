<%--
    Document   : plan
    Created on : Jan 27, 2012, 9:59:36 PM
    Author     : Shaishav
--%>

<%@page import="model.modelplan"%>
<%@page import="model.planservice"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

       
<table cellspacing="18" >
   
            <tr >
              
            
            <%
         
            planservice obj1 = new planservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
            List list1 = obj1.getPlans();
           
            for (int i = 0; i < 3; i++) {
                modelplan obj2 = (modelplan) list1.get(i);

                 out.println("  <td><table style=\"border-style: outset;\"><td><table>");
                 
                out.println("<tr><td><a href=\"./plandetails.jsp?planid=" + obj2.getPlanid() + "\"> Plan Name : " + obj2.getPlan_name() + "</a></td></tr>");
                out.println("<tr><td><hr>");
                out.println("Amount :" + obj2.getAmount());
                out.println("<br>");
                out.println("No of Songs :" + obj2.getSongs());
                out.println("<br>");
                out.println("  And more Features...");
                out.println("</td></tr>");
                out.println("<tr><td>");
               // out.println("<a href=\"./plandetails.jsp?planid=" + obj2.getPlanid() + "\">more...</a>");
                out.print("<hr><form action=\"./plandetails.jsp\" method=\"post\">");
                out.print("<input type=\"image\" src=\"./images/details-button.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">");
                out.print("<img alt=\"\" border=\"0\" src=\"./images/buynow.gif\" width=\"1\" height=\"1\">");
                out.print("<input type=\"hidden\" name=\"planid\" id=\"planid\" value="+obj2.getPlanid()+">");
                out.print("</form>");
                out.println("</td></tr>");
               out.print("</td></table></table></td>");
            }
             
        %>
        <td><br><br><br><br><br><br><br><a href="../plan.jsp"><img src="../images/learn-more-button.png"></img></td>
            </tr>
        </table>
        