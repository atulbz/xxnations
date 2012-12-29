<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ page errorPage="oops.jsp" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>
           Error
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
            <h2> Privacy Policy</h2>
            <p><h3>This Privacy Policy does not address, and we are not responsible for, <br>
            the privacy, information or other practices of any third party, including <br>
            Facebook, Inc., our artists, our affiliates and any third party operating <br>
            any site or property to which the Site contains a link. In addition, the <br>
            inclusion of a link on the Site does not imply endorsement of, or affiliation <br>
            with, the linked site or property by us or by our artists or affiliates. <br>
            Please note that the Site may include the ability to access and submit <br>
            (including, for example, via a third-party software application or service <br>
            that is available through or in connection with the Site) certain information <br>
            directly to third parties such as Facebook. Such information is submitted by <br>
            you directly to such third parties; this Privacy Policy does not apply to any <br>
            information submitted by you to third parties.<br>
<br>
The Site is controlled and operated from the United States; accordingly,<br> 
this Privacy Policy, and our collection, use and disclosure of your Personal <br>
Information, is governed by U.S. law, and the Site is not intended to subject <br>
Company or any of its affiliates to the laws or jurisdiction of any state, <br>
country or territory other than that of the United States. If you are located <br>
in the European Union (EU), please note that we abide by the Safe Harbor framework <br>
agreed to by the U.S. Department of Commerce and the EU with respect to Personal <br>
Information collected by entities located in the European Economic Area and <br>
transferred to us in the United States.</h3></p>

            
        </div>
            </div>
                    
<%@include file="./common/Footer.jsp" %>
    </body>      
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


