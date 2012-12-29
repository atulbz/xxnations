<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%

if((String)session.getAttribute("role")=="admin")
{
     String username=(String)session.getAttribute("username");
    String admin_id=(String)session.getAttribute("user");
   



  
%>  
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
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
	<!-- End Header -->
	<div style="text-align: right; margin-top:20px; margin-right:20px">
	<form action="../admin/searchadmin.do" method="get">
                 <input type="text" name="q" id="searchdiv" value="Search.." onfocus="this.style.opacity='1'; q.value=null " onblur="this.style.opacity='.5';"   style="opacity:0.5;"/>
                <input type="submit" value="Search" style="width:128px;" />
                <br>
	
             Song  :<input type="radio" name="radio" value="Song" checked="checked" />
             Album :<input type="radio" name="radio" value="Album" />
             Artist :<input type="radio" name="radio" value="Artist" />
             Both  :<input type="radio" name="radio" value="All"/>
             <input type="hidden" name="search" value="song" />
                </div>
	
	
	<!-- Content -->
	<div id="content" class="shell">
		<h2 class="red">Manage Songs</h2>		
		<a href="../admin/addsong.jsp"><h4>Add the Song</h4></a>
        <a href="../admin/songsbyalbum.jsp"><h4>List songs by Albums</h4></a>
        <a href="../admin/songsbyartist.jsp"><h4>List songs by Artist</h4></a>
        <a href="../admin/songsbygenre.jsp"><h4>List songs by Genre</h4></a>
	
		
	</div>
	
	<!-- End Content -->
</div>

<!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
</body>
</html>
<%
}
else
{
     response.sendRedirect("../admin/login.jsp");  
}

%>
