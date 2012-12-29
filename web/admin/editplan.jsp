<%-- 
    Document   : editplan
    Created on : Jan 27, 2012, 6:10:13 PM
    Author     : Shaishav
--%>

<%@page import="model.modelplan"%>
<%@page import="model.planservice"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

        <script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
        <script src="../js/checkPlan.js" type="text/javascript" ></script>
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
	
	<div align="center">
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
    try
                       {
planservice obj=new planservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));

String plan_id=request.getParameter("plan_id");
out.print(plan_id);
List list1=obj.getPlanDetails(plan_id);
modelplan obj1=(modelplan)list1.get(0);

    %>
    <form action="../admin/editplan.do">
        <table align="center" width="400">
            <%
   out.print("<tr><td>Plan id</td><td><input type=\"text\" name=\"plan_id\" value="+obj1.getPlanid()+" id=\"plan_id\" readonly=\"readonly\"></td></tr><br>\n");                   
   out.write("<tr><td>Plan Name </td><td><input type=\"text\" name=\"plan_name\" value="+obj1.getPlan_name()+" id=\"planname\" onblur=\"checkPlanName(this.value)\"/><div id=\"planmessage\"></div></td></tr><br>\n");
   out.write("<tr><td>Amount </td><td><input type=\"text\" name=\"amount\" id=\"amount\" value="+obj1.getAmount()+" onblur=\"checkAmount(this.value)\" ><div id=\"amountmessage\"></div></td></tr><br>\n");
   out.write("<tr><td>Duration</td><td><input type=\"text\" name=\"duration\" value="+obj1.getDuration()+" id=\"duration\" ></td></tr><br>\n");
   out.write("<tr><td>No of Songs</td><td><input type=\"text\" name=\"noofsongs\" id=\"noofsongs\" value="+obj1.getSongs()+" ></td></tr><br>\n");
   out.write("<tr align=\"left\"><td colspan=\"2\"><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Update Plan\" ></td></tr>\n");               
 }
 catch(Exception e)
                    {
     System.out.print(e);
 }
       
            %>
        </table>
    </form>
        </div>
        <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
    </body>
</html>
