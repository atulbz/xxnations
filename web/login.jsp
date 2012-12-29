<%@page pageEncoding="windows-1252"%>

<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html>

<%
if((String)session.getAttribute("role")=="user")
       {
response.sendRedirect("../index.jsp");
}

     %>   
       


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>
            Login
        </title>
    </head>
    <body style="line-height: 1.166;	
	margin: 0px;
	padding: 0px;
        background-color: #EEEEEF">
           
<%@include file="./common/globalheaderguest.jsp" %>

<div id="a" style="position: absolute; left: 406px; top: 298px; width: 549px;">
    
     
     <form action="../login.do" method="post">
         
         <table cellspacing="20px" align="center">
             <thead>
                    <tr>
                        <h1 align="center">Login Form</h1>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> <label>Username  : </label></td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td><label> Password  :</label> </td><td> <input name="password" size=15 type="password" /> </td> 
                    </tr>
                    <tr><td colspan="2" style="text-align: center">
                            <input type="submit" value="login" /></td></tr>
                </tbody>             
         </table>
           </form>
  
                  
                         <%
try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<br><div style='postion: absolute; left: 200px;'><font color='red'>" );
        out.println("Please correct following errors:");
   Iterator msgs=errormsgs.iterator();
        out.println("<ol>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ol>");
        
        out.println("</font></div>");
}
}
catch(Exception e)
               {
    
}
%>
                    
              
   </div>              
     
<%@include file="./common/Footer.jsp" %>
 </body>
 
</html>
