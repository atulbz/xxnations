<html>
    <head>
        <title>
            Home
        </title>
    </head>
 <body style="background-color: #EEEEEF">
     <div id="a" align="center">
         
         
         
         <blockquote>
             <p>&nbsp;</p>
             <p ><strong>Thank you for logging in..</strong></p>
             
             <p class="smallfont"><a 
                     href="../index.jsp">Click here if your 
             browser does not automatically redirect you.</a></p>
             <div>&nbsp;</div>
             
             
         </blockquote>
     </div>






</body></html>
     
     </div>
     <%
HttpSession hs=request.getSession(false);
if((String)hs.getAttribute("role")=="user")
       {
//hs.getId();    
    
response.setHeader("Refresh", "2; " + "./index.jsp");
out.print("<a href="+response.encodeURL("../login.jsp")+">Go Back</a>");
}
else
       {
    response.sendRedirect("../index.jsp");
}
     %>
      </body>
         <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>