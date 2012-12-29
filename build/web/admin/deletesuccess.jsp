<%-- 
    Document   : deletesuccess
    Created on : Jan 19, 2012, 2:31:58 AM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
                                    <li><a href="../admin/genremgmt.jsp"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
        <div align="center">
        <%
        //String Album_id=request.getParameter("Album_id");
        String Album_id="1";
        //String redirect=(String)request.getAttribute("redirect");
        String redirect="xyz";
        if(redirect.equals("song"))
                       {
out.println("Delete Successfull click <a href=\"../admin/listsong.jsp?Album_id="+Album_id+"\">here</a> to go back or click <a href=\"../admin/home.jsp\">here to go to home</a>");        
        }
        else
                       {
            out.println("Delete Successfull click <a href=\"../admin/albummgmt.jsp?Album_id="+Album_id+"\">here</a> to go to Manage Albums or click <a href=\"../admin/home.jsp\">here to go to home</a>");  
        }

%>
</div>
<!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
    </body>
</html>
