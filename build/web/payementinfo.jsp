<%-- 
    Document   : downloadhistory
    Created on : Jan 23, 2012, 2:16:22 AM
    Author     : Shaishav
--%>

<%@page import="model.modelpayment"%>
<%@page import="model.paymentservice"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Info</title>
    </head>
    
    
    <script type="text/javascript" src="js/pagination.js"></script>  
         <link rel="stylesheet" type="text/css" href="../css/x.css">
            <link rel="stylesheet" type="text/css" href="../css/avoidcss.css">
   
    
    
        <%
        if(session.getAttribute("role")!="user")
{
response.sendRedirect("../login.jsp");
return;
}
       
   String user_id1=(String)session.getAttribute("user");
   int user_id=Integer.parseInt(user_id1);
 paymentservice obj1=new paymentservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));      
 List listpaymentinfo=obj1.getPayment(user_id);
 request.setAttribute("listpaymentinfo", listpaymentinfo);
 if(listpaymentinfo==null)
         {
     out.print("<i>Nothing Downloaded<i>");
     return;
 }
else
{}
  %>
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
     <div style="position: absolute; margin-top: 23px; margin-left: 300px; ">
         <h3>Payment Info</h3>
         <hr align="left" style="width: 500px;">
     <display:table  name="listpaymentinfo" pagesize="10" id="table" requestURI="payementinfo.jsp" >
                    <display:setProperty name="paging.banner.placement" value="bottom" />     
                    <display:column title="Id" property="payment_id"></display:column>
                    <display:column title="Payer" property="name"></display:column>
                    <display:column title="E-mail" property="email" autolink="true"></display:column>
                     <display:column title="Plan Name" property="plan_name"></display:column>
                    <display:column title="Amount" property="amount"></display:column>
                    <display:column title="Songs" property="no_of_songs"></display:column>
                    <display:column title="Payment Date" property="paymentdate"></display:column>
                    <display:column title="Valid Upto" property="valid_upto"></display:column>
           </display:table>
         </div>
     <%@include file="./common/Footer.jsp" %>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
