
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
String Genre_id=request.getParameter("Genre_id");
Songservice obj=new Songservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getSongByGenre(Genre_id);
request.setAttribute("list", list);
int j=0;
%>
<html>
       <head>
        <script type="text/javascript" src="../js/pagination.js"></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/x.css">
        <link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
        <title>List of Albums</title>
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
				    <li><a href="../admin/songmgmt.jsp" class="active"><span>Manage Songs</span></a></li>
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
<display:table export="true"  name="list" id="table" class="datatable" pagesize="6" requestURI="listsongbygenre.jsp">
             <display:setProperty name="paging.banner.placement" value="bottom" />   
              <display:column title="Sr No." value="<%=++j %>"></display:column>
             <display:column title="Song Name" property="song_name" style="width: 40%"> </display:column>
             <display:column ><a href="../admin/editsong.jsp?redirect=album&song_id=${table.song_id}">Edit</a>
             </display:column>
             <display:column ><a href="../admin/removesong.do?Album_id=${table.album_id}&song_id=${table.song_id}">Remove</a>
             </display:column>
             
             
             
</display:table></div>
             <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
 
    </body>
</html>
