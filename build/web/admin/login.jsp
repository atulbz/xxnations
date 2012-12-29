<%@page pageEncoding="windows-1252"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html>

<%
if((String)session.getAttribute("role")=="admin")
       {
response.sendRedirect("../admin/home.jsp");
} %>



<html>
    <head>
        <link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1250">
        <title>
            Login
        </title>
    </head>
 <body>
     <div id="header">
		<div class="shell">
			
			<div id="head">
				<h1><a href="home.jsp">Xxnations</a></h1>
                        </div>
                </div>
			</div>
     <div id="a" align="center" style="margin-top: 200px">
         <%
try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<font color='red'");
        out.println("<p>Please correct following errors:</p>");
   Iterator msgs=errormsgs.iterator();
        out.println("<ul>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ul>");
        
        out.println("</font>");
}
}
catch(Exception e)
               {
    
}

%>
     <h3>Login</h3>
    
     <form method="post" action="../admin/loginadmin.do">
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td> 
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="password" /> </td> 
                    </tr>
                    <tr><td></td><td>
                <input type="submit" value="login" /></td></tr>
                </table>
     </form>     
                      <br />
     <a href="../admin/forgotpassword.jsp" style="text-decoration: none">Forgot your password ?</a>
     </div>
                  </body>
</html>
