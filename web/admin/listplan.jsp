<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<link rel="stylesheet" type="text/css" href="../css/x.css">
<%
planservice obj=new planservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getPlans();
request.setAttribute("list", list);
int j=0;
%>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
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
                                    <li><a href="../admin/planmgmt.jsp" class="active"><span>Manage Plan</span></a></li>
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
	<div id="help-nav">
			<a href="planmgmt.jsp">Manage Plan</a> &gt; List Plan
		</div>

	
	
	
	<!-- Content -->
	<div align="center">
		<display:table   export="true" name="list" class="dataTable" id="table" pagesize="6"  size="<%=list.size() %>" requestURI="listplan.jsp" >
          <display:setProperty name="paging.banner.placement" value="bottom" />     
                              

                               <display:column title="Number" value="<%=++j  %>" > </display:column>
                      <display:column title="Plane Name" autolink="true" > 
                      <a href="../plandetails.jsp?planid=${table.planid}" > ${table.plan_name}              </a>
                      </display:column>
                      <display:column title="Amount"  property="amount"></display:column>
                      <display:column title="No of Songs" property="songs"></display:column>
                      <display:column title="Duration(<i>No of Days</i>)" property="duration"></display:column>
                      <display:column> <a href="../admin/editplan.jsp?plan_id=${table.planid}">Edit</a></display:column>
                      <display:column><a href="../admin/removeplan.do?plan_id=${table.planid}">Remove</a></display:column>
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