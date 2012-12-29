

<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%
genreservice obj=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getGenre();
request.setAttribute("list", list);
%>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
<style type="text/css">  
.pg-normal {  
    color: #0000FF;  
    font-weight: normal;  
    text-decoration: none;  
    cursor: pointer;  
}  
  
.pg-selected {  
    color: #800080;  
    font-weight: bold;  
    text-decoration: underline;  
    cursor: pointer;  
}  
</style> 
              <link rel="stylesheet" type="text/css" href="../css/x.css">
        <script type="text/javascript" src="../js/pagination.js"></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                                    <li><a href="../admin/genremgmt.jsp" class="active"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
	<div id="help-nav">
			<a href="genremgmt.jsp">Manage Genre</a> &gt; List Genre
		</div>
	
	
	<!-- Content -->
	<div align="center">
            <display:table  name="list" class="dataTable" id="table" pagesize="6" defaultsort="2" size="<%=list.size() %>" requestURI="listgenre.jsp" export="true">
          <display:setProperty  name="paging.banner.placement" value="bottom" />  
          <display:setProperty name="export.pdf" value="true"></display:setProperty>
           

          <display:column title="Genre" value="${table.genre}"></display:column>
          <display:column title="Edit"><a href="../admin/editgenre.jsp?Genre_id=${table.genre_id}&Genre=${table.genre}"> Edit</a></display:column>
          <display:column title="Remove"> <a href="../admin/removegenre.do?Genre=${table.genre}">Remove</a> </display:column>
    </display:table>
		
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