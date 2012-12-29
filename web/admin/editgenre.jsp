<%-- 
    Document   : editgenre
    Created on : Jan 22, 2012, 9:43:18 PM
    Author     : Shaishav
--%>

<%@page import="model.genreservice"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

          <style type="text/css">
 .bp_invalid {
    color:red;
   
    
 }
 .bp_valid {
    color:green;
 }
</style>
            <script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
            <script src="../js/tester.js" type="text/javascript" ></script>
    </head>
    <%
    String s="";
String Genre=request.getParameter("Genre");
String Genre_id=request.getParameter("Genre_id");
genreservice obj=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
boolean result=obj.findgenre(Genre);
System.out.print(result);
if(result==true)
       {
    s=Genre;
}
else
       {
    response.sendRedirect("../admin/genremgmt.jsp");
}

try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<font color='red'>");
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
    <body>
        <!-- Header -->
	<div id="header">
		<div class="shell">
			
			<div id="head">
				<h1><a href="home.jsp">Xxnations</a></h1>
				<div class="right">
					<p>
						Welcome <strong>Administrator</strong> | 
						<a href="../admin/admineditprofile.jsp">Profile Settings</a> |
						<a href="../admin/logoutadmin.do">Logout</a>
					</p>
				</div>
			</div>
			
			<!-- Navigation -->
			<div id="navigation">
				<ul>
				    <li><a href="../admin/songmgmt.jsp"><span>Manage Songs</span></a></li>
                                    <li><a href="../admin/albummgmt.jsp"><span>Manage Albums</span></a></li>
                                    <li><a href="../admin/planmgmt.jsp"><span>Manage Plan</span></a></li>
                                    <li><a href="../admin/usermgmt.jsp"><span>Manage users</span></a></li>
                                    <li><a href="../admin/genremgmt.jsp" class="active"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
        <br><br><br><br>
        <div align="center">
            <form action="../admin/editgenre.do" method="get">
            <tr><td>Genre    </td><td><input type="text" name="Genre" value="<%=s %>" id="genre" onblur="validateGenre(this.value)" /><div id="genremessage"> </div></td></tr>
            <input type="hidden" name="Genre_id" value=<%=Genre_id %> />
            <input type='submit' id="submit_btn" value='Add Genre'></form>
        </div>
            <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
        </body>
</html>
