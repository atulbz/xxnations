<%@page import="model.requestservice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List "%>

<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
 <link rel="stylesheet" type="text/css" href="../css/x.css">
</head>
<body>
<%
                  String user_id=null;
                  if((String)session.getAttribute("role")!="admin")
                                                     {
                           response.sendRedirect("../admin/login.jsp");
                  }
                  else
                                                     {
                           
requestservice obj=new requestservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getRequest();
request.setAttribute("list", list);
int j=0;

%>
	
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
                                    <li><a href="../admin/requestmgmt.jsp" class="active"><span>Manage Requests</span></a></li>
				    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
	
	
	<!-- Content -->
        <div align="center">
            <display:table export="true" name="list" class="dataTable" id="table" pagesize="10"  size="<%=list.size() %>" requestURI="requestmgmt.jsp" >
          <display:setProperty name="paging.banner.placement" value="bottom" />   
          <display:setProperty name="export.pdf" value="true"></display:setProperty>
          <display:column title="Sr No." value="<%=++j %>"></display:column>
          <display:column title="Username" property="username"></display:column>
          <display:column title="Album Requested" property="album"></display:column>
          <display:column title="Song Requested" property="song"></display:column>
          <display:column title="Time of Request" property="rtime"></display:column>
          <display:column title="Remove"><a href="../admin/adminremoverequest.do?reqid=${table.request_id}&user_id=${table.user_id}">Remove</a></display:column>
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
<%
}
%>
