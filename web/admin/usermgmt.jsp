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
                                    <li><a href="../admin/albummgmt.jsp"><span>Manage Albums</span></a></li>
                                    <li><a href="../admin/planmgmt.jsp"><span>Manage Plan</span></a></li>
                                    <li><a href="../admin/usermgmt.jsp" class="active"><span>Manage users</span></a></li>
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
                <input type="submit" value="Search" style="width:128px;" /><br>
                Username :  <input type="radio" name="radio" value="username" checked="checked"/>
                Email :     <input type="radio" name="radio" value="email" />
        </form>
                </div>
	
	
	<!-- Content -->
	<div id="content" class="shell">
		<h2 class="red">Manage Users</h2>		
		<div>
			<form action="../admin/listuser.do" method="get">
            <h3>List user by </h3> 
            
            First Name :<input type="radio" name="q" value="first_name" checked="checked" />
            Last Name : <input type="radio" name="q" value="last_name" />
            Username :  <input type="radio" name="q" value="username" />
            Email :     <input type="radio" name="q" value="email" />
            City :         <input type="radio" name="q" value="city" />
            
            <input type="submit" value="Go" />
        </form>
		</div>
		
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