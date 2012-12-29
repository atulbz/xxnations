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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title> search result</title>  
        	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

</head>  
  
<script type="text/javascript" src="js/pagination.js"></script>   
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
  
<%  
    List list = (List) request.getAttribute("list");  
%>  
  
 <div align="center">
    <display:table   name="list" class="dataTable" id="table" pagesize="2"  size="<%=list.size() %>" requestURI="searchadmin.do" keepStatus="true">
          <display:setProperty name="paging.banner.placement" value="bottom" />     
          <display:column title="Song Name" property="song_name"></display:column>
          <display:column title="Artist Name" property="artist_name"></display:column>
          <display:column title="action" style="text-align: justified">
                   <a href="../admin/editsong.jsp?redirect=song&song_id=${table.song_id}">Edit</a>
                   <a href="../admin/removesong.do?song_id=${table.song_id}">Remove</a>
                   
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