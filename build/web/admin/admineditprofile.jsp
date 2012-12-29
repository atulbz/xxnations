<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*"%>

<%@page import="java.util.*"%>

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
	

	
	
	
	<!-- Content -->
	<div style="margin-left:50px; margin-bottom:30px" align="center">
            <%
if(session.getAttribute("role")!="admin")
{
response.sendRedirect("login.jsp");
}
 
  //String username=(String)session.getAttribute("username");
  String admin_id=(String)session.getAttribute("user");
  registerservice obj=new registerservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
  List admineditlist=obj.editAdmin(admin_id) ;
           //int i=list.size();
           modelregister admineditobj=(modelregister)admineditlist.get(0);
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
%> 

<%
String fname=request.getParameter("fname");
if(fname==null || fname.isEmpty())
{
    fname="";
}                          
else
       {
    fname=fname;
}
String lname=request.getParameter("lname");
if(lname==null || lname.isEmpty())
{
    lname="";
}                          
else
       {
    lname=lname;
}
String username=request.getParameter("username");
if(username==null || username.isEmpty())
{
    username="";
}                          
else
       {
    username=username;
}
String password=request.getParameter("password");
if(password==null || password.isEmpty())
{
    password="";
}                          
else
       {
    password=password;
}
String dob=request.getParameter("dob");
if(dob==null || dob.isEmpty())
{
    dob="";
}                          
else
       {
    dob=dob;
}
String city=request.getParameter("city");
if(city==null || city.isEmpty())
{
    city="";
}                          
else
       {
    city=city;
}
String email=request.getParameter("email");
if(email==null || email.isEmpty())
{
    email="";
}                          
else
       {
    email=email;
}
%>
		<form action="../admin/editadmin.do" method="get">
            <table>
            <tr><td>First Name   : </td><td><input type="text" name="fname" value="<% out.print(admineditobj.getFname()); %>" width="30px"/></td></tr>
<br><tr><td>Last Name  : </td><td><input type="text" name="lname" value="<% out.print(admineditobj.getLname()); %>" width="30px"/></td> </tr>
<br><tr><td>Username : </td><td><input type="text" name="username" value="<% out.print(admineditobj.getUsername()); %>" width="30px"/></td> </tr>
<br><tr><td>Password : </td><td><input type="password" name="password" value="<% out.print(admineditobj.getPassword()); %>" width="30px"/></td> </tr>

<br><tr><td>E-mail  : </td><td><input type="email" name="email" value="<% out.print(admineditobj.getEmail()); %>" width="30px"/></td> </tr>
<br><tr><td>DOB  : </td><td><input type="text" name="dob" value="<% out.print(admineditobj.getDob()); %>" width="30px"/></td> </tr>


<%

if(admineditobj.getSex().toLowerCase().equals("female"))
{
            out.println("<br><br><tr><td>Sex  : </td><td>Male<input type=\"radio\" name=\"sex\" value=\"Male\" />  Female<input type=\"radio\" name=\"sex\" value=\"Female\" checked=\"checked\" /></td> </tr>");
}
            else
{
            out.println("<br><br><tr><td>Sex  : </td><td>Male<input type=\"radio\" name=\"sex\" value=\"Male\" checked=\"checked\" />  Female<input type=\"radio\" name=\"sex\" value=\"Female\"/></td> </tr>");    
}
%>
<input type="hidden" name="admin_id" value="1"><tr><td><input type="submit" value="Update"/></td><td>

            <br>
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