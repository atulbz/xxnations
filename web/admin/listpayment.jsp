<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<link rel="stylesheet" type="text/css" href="../css/x.css">
<%
paymentservice obj=new paymentservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List listpayment=obj.getAllPayment();
request.setAttribute("listpayment", listpayment);
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
                                    <li><a href="../admin/planmgmt.jsp" ><span>Manage Plan</span></a></li>
                                    <li><a href="../admin/usermgmt.jsp"><span>Manage users</span></a></li>
                                    <li><a href="../admin/genremgmt.jsp"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
				     <li><a href="../admin/paymentmgmt.jsp" class="active"><span>Manage Payment</span></a></li>
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
	<div id="help-nav">
			<a href="planmgmt.jsp">Manage Payment</a> &gt; List Plan
		</div>

	
	
	<%
int listi=0;        
%>
	<!-- Content -->
	<div align="center">
            <display:table  name="listpayment" pagesize="10" id="table" requestURI="listpayment.jsp" export="true" >
                    <display:setProperty name="paging.banner.placement" value="bottom" />     
                    
                    <display:column title="Sr No" value="<%=++listi %>"></display:column>
                    <display:column title="Username" property="username"></display:column>
                    <display:column title="Payer" property="name"></display:column>
                    <display:column title="E-mail" property="email" autolink="true"></display:column>
                     <display:column title="Plan Name" property="plan_name"></display:column>
                    <display:column title="Amount" property="amount"></display:column>
                    <display:column title="Songs" property="no_of_songs"></display:column>
                    <display:column title="Payment Date" property="paymentdate"></display:column>
                    <display:column title="Valid Upto" property="valid_upto"></display:column>
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