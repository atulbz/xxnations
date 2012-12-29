<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
<style type="text/css">
 .bp_invalid {
    color:red;
   
    
 }
 .bp_valid {
    color:green;
 }
 </style>
 
 
 

       
<script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="../js/checkplan.js" type="text/javascript" ></script>
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
			<a href="planmgmt.jsp">Manage Plan</a> &gt; Add Plan
		</div>
	
	<!-- Content -->
	<div style="margin-left:50px; margin-bottom:30px">
            <%
try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<font color='red'");
        out.println("<p>Please correct following errors:</p>");
   Iterator msgs=errormsgs.iterator();
        out.println("<ul>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ul>");
        
        out.println("</font>");
}
}
catch(Exception e)
               {
    
} 

String plan_name=request.getParameter("plan_name");


if(plan_name==null || plan_name.isEmpty())
{
    plan_name="";
}                          
else
       {
    plan_name=plan_name;
}

String amount=request.getParameter("amount");


if(amount==null || amount.isEmpty())
{
    amount="";
}                          
else
       {
    amount=amount;
}

String duration=request.getParameter("duration");


if(duration==null || duration.isEmpty())
{
    duration="";
}                          
else
       {
    duration=duration;
}
String noofsongs=request.getParameter("noofsongs");


if(noofsongs==null || noofsongs.isEmpty())
{
    noofsongs="";
}                          
else
       {
    noofsongs=noofsongs;
}
%>
		
		
		<form action="../admin/addplan.do">
              
          
            <table align="center" width="400">
                <tr><td>Plan Name </td><td><input type="text" name="plan_name" value="<%=plan_name %>" id="planname" value="" onblur="checkPlanName(this.value)"/></td><td><div id="planmessage"></div></td></tr><br>
                <tr><td>Amount </td><td><input type="text" name="amount" id="amount" value="<%=amount %>" onblur="checkAmount(this.value)" ></td><td><div id="amountmessage"></div></td></tr><br>
                 <tr><td>Duration</td><td><input type="text" name="duration" id="duration" value="<%=duration %>"></td></tr><br>
                 <tr><td>No of Songs</td><td><input type="text" name="noofsongs" id="noofsongs" value="<%=noofsongs %>"></td></tr><br>
                 <tr align="left"><td colspan="2"><input type="submit" name="submit" id="submit" value="Add Plan" ></td></tr>
            </table>
                 </form>
		
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