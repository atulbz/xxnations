<%-- 
    Document   : paginationUsingJavaScript
    Created on : Jan 12, 2012, 10:24:19 PM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="java.util.*" %>
<%@page  import="model.*" %>
<!DOCTYPE html>
<html>  
<head>  
        	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title> search result</title>  
</head>  
  
 
 <link rel="stylesheet" type="text/css" href="../css/x.css">  
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
  
<h1>Search Album</h1>  
  
<%  
    List list = (List) request.getAttribute("list");  
    request.setAttribute("list", list);
%>  
  
    
         <display:table   name="list" class="dataTable" id="table" pagesize="2"  size="<%=list.size() %>" requestURI="searchadmin.do" keepStatus="true">
          <display:setProperty name="paging.banner.placement" value="bottom" />     
          <display:column title="Album art"><img src="${table.img_url}" height="150" width="150"></display:column>
          <display:column title="Album Name" property="album_name"></display:column>
          <display:column title="Artist" property="artist_name"></display:column>
          <display:column title="action" style="text-align: justified">
                   <a href="../admin/editalbum.jsp?redirect=album&Album_id=${table.album_id}">Edit</a>
                   <a href="../admin/removealbum.do?Album_id=${table.album_id}">Remove</a>
                   
          </display:column>
         </display:table>
</div>
<!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->

</body>  
</html> 