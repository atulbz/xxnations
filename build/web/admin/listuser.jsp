
<%-- 
    Document   : listsong
    Created on : Jan 18, 2012, 11:27:45 PM
    Author     : Shaishav
--%>

<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">

<%
List listuser=(List)request.getAttribute("list");
request.setAttribute("listuser", listuser);
int j=0;

%>
<html>
    <head>
        <title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
               <link rel="stylesheet" type="text/css" href="../css/x.css">
    </head>
    <body>
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
                                    <li><a href="../admin/usermgmt.jsp" class="active"><span>Manage users</span></a></li>
                                    <li><a href="../admin/genremgmt.jsp"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				    
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
        <div align="center">
   <display:table export="true"  name="listuser" id="table" class="datatable" pagesize="6" requestURI="listuser.jsp" >
             <display:setProperty name="paging.banner.placement" value="bottom"   />  
            
             <display:column title="Sr No." value="<%=++j %>"></display:column>
             <display:column title="Username" property="username" ></display:column>
             <display:column title="First Name" property="fname" ></display:column>
             <display:column title="Last Name" property="lname" ></display:column>
             <display:column title="Sex" property="sex"></display:column>
             <display:column title="Date of Birth" property="dob" ></display:column>
             <display:column title="City" property="city" ></display:column>
             <display:column title="E-mail" property="email" autolink="true" ></display:column>
             <display:column title="Acton" style="align: center;"><a href="../admin/removeuser.do?user_id=${table.user_id}">Remove</a>
                      <a href="../admin/commentsbyuser.jsp?user_id=${table.user_id}">Comments</a>
                      <a href="../admin/adminrequesthistory.jsp?user_id=${table.user_id}">Requests</a></display:column>
                      
   </display:table>
        </div>
        <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
    </body>
</html>
