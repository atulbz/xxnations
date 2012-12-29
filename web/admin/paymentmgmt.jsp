<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
				    <li><a href="../admin/songmgmt.jsp"><span>Manage Songs</span></a></li>
                                    <li><a href="../admin/albummgmt.jsp" ><span>Manage Albums</span></a></li>
                                    <li><a href="../admin/planmgmt.jsp"><span>Manage Plan</span></a></li>
                                    <li><a href="../admin/usermgmt.jsp"><span>Manage users</span></a></li>
                                    <li><a href="../admin/genremgmt.jsp"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp" class="active"><span>Manage Payment</span></a></li>
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->

	
	
	<!-- Content -->
	<div id="content" class="shell">
		<h2 class="red">Manage Albums</h2>	
		<h4><a href="../admin/listpayment.jsp">List Payment</a>
              <br> <br><br>
                    Select Range for Payment</h4>
                <br>
                    <form method="post" action="rangepayment.jsp">
                    From
                    <select name="frommonth">
	<option value="1">January
	<option value="2">February
	<option value="3">March
	<option value="4">April
	<option value="5">May
	<option value="6">June
	<option value="7">July
	<option value="8">August
	<option value="9">September
	<option value="10">October
	<option value="11">November
	<option value="12">December
</select>
<select name="fromday">
	<option value="1">1
	<option value="2">2
	<option value="3">3
	<option value="4">4
	<option value="5">5
	<option value="6">6
	<option value="7">7
	<option value="8">8
	<option value="9">9
	<option value="10">10
	<option value="11">11
	<option value="12">12
	<option value="13">13
	<option value="14">14
	<option value="15">15
	<option value="16">16
	<option value="17">17
	<option value="18">18
	<option value="19">19
	<option value="20">20
	<option value="21">21
	<option value="22">22
	<option value="23">23
	<option value="24">24
	<option value="25">25
	<option value="26">26
	<option value="27">27
	<option value="28">28
	<option value="29">29
	<option value="30">30
	<option value="31">31
</select>
<select name="fromyear">
	<%
        for (int years=2010;years<2050;years++)
                       {
out.print("<option value=\""+years+"\"> "+years+" ");
}
%>
	
</select>
                    
                <br>  <br>
                    To&nbsp;&nbsp;&nbsp;&nbsp; <select name="tomonth">
	<option value="1">January
	<option value="2">February
	<option value="3">March
	<option value="4">April
	<option value="5">May
	<option value="6">June
	<option value="7">July
	<option value="8">August
	<option value="9">September
	<option value="10">October
	<option value="11">November
	<option value="12">December
</select>
<select name="today">
	<option value="1">1
	<option value="2">2
	<option value="3">3
	<option value="4">4
	<option value="5">5
	<option value="6">6
	<option value="7">7
	<option value="8">8
	<option value="9">9
	<option value="10">10
	<option value="11">11
	<option value="12">12
	<option value="13">13
	<option value="14">14
	<option value="15">15
	<option value="16">16
	<option value="17">17
	<option value="18">18
	<option value="19">19
	<option value="20">20
	<option value="21">21
	<option value="22">22
	<option value="23">23
	<option value="24">24
	<option value="25">25
	<option value="26">26
	<option value="27">27
	<option value="28">28
	<option value="29">29
	<option value="30">30
	<option value="31">31
</select>
<select name="toyear">
	<%
        for (int years=2010;years<2050;years++)
                       {
out.print("<option value=\""+years+"\"> "+years+" ");
}
%>
	
</select>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Fetch"></input>
                  
                </form>
        	<br />
		
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