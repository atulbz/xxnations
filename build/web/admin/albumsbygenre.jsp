
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
try
               {
String Genre_id1=request.getParameter("Genre_id");


int Genre_id=Integer.parseInt(Genre_id1);
genreservice getgen=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
String Genre=getgen.getGenreName(Genre_id);
albumservice obj=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getAlbumByGenre(Genre_id);
request.setAttribute("list", list);
%>
<html>
       <head>
           	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

        <script type="text/javascript" src="../js/pagination.js"></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
 <link rel="stylesheet" type="text/css" href="../css/x.css">
        <title>List of Albums of genre <%=Genre %></title>
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
                                    <li><a href="../admin/albummgmt.jsp" class="active"><span>Manage Albums</span></a></li>
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
	<!-- End Header -->
        <div align="center">
 <display:table  name="list" id="table" class="datatable" pagesize="6" requestURI="albumsbygenre.jsp">
             <display:setProperty name="paging.banner.placement" value="bottom" />   
             <display:column title="Album art"><img src="${table.img_url}" width="150" height="150"></display:column>
             <display:column title="Album Name" property="album_name" style="width: 40%"></display:column>
             <display:column ><a href="../admin/editalbum.jsp?redirect=album&Album_id=${table.album_id}">Edit</a>
             </display:column>
             <display:column ><a href="../admin/removealbum.do?Album_id=${table.album_id}">Remove</a>
             </display:column>
             
             
             
 </display:table></div>
        <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
 </body>
    <%
    
}
catch(Exception e)
{
    
}          
%>
</html>
