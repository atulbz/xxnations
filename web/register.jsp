<%-- 
    Document   : signup
    Created on : Jan 7, 2012, 2:40:10 AM
    Author     : Shaishav
--%>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="STYLESHEET" type="text/css" href="css/pwdwidget.css" />
<script src="js/pwdwidget.js" type="text/javascript"></script>

<style>
    
.formcontainer
{
text-align:left;
width:330px;
border-top: 1px solid;
border-bottom: 1px solid;
padding:10px;
margin: auto;
}
.para
{
margin-bottom: 10px;
}
</style>
<%
if((String)session.getAttribute("role")!="user")
       {
  
    
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
       
        <script type="text/javascript" src="js/checkregister.js"></script>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/css" src="css/notify.css"></script>
    </head>
    <body style="background-color: #EEEEEF">

                    
<%@include file="./common/globalheaderguest.jsp" %>
   <div align="center" style="position: absolute; margin-top: 60px; margin-left: 450px; min-width: 700px; ">
<form action="../register.do" method="post" style="float: left; margin-left: 20%; margin-top: 1%;">
            
            <table border="0" cellspacing="20" cellpadding="1" align="justify">
                <thead>
                    <tr>
                        <h1>Registration Form</h1>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
 
          
    try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<div style='text-align: left '><font color='red'");
   Iterator msgs=errormsgs.iterator();
        out.println("<ol>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ol>");
        
        out.println("</font><div>");
}
}
catch(Exception e)
               {
    
}
 %>
                    <tr>
 
                        <td><label>First Name :</label></td>
                        <td><input type="text" name="fname" value="<%=fname %>" /></td>
                    </tr>
                    <tr>
                        <td><label>Second Name :</label></td>
                        <td><input type="text" name="lname" value="<%=lname %>" /></td>
                    </tr>
                    <tr>
                        <td><label>Username :</label></td>
                        <td><input type="text" name="username" value="<%=username %>" onblur="checkUsername(this.value)" ><div id="usernamemessage"></div></td>
                    </tr>
                    <tr>
                        <td><label>Password :</label></td>
                         <td><div class='para'>
		<div class='pwdwidgetdiv' id='thepwddiv'></div>
		<script  type="text/javascript" >
		var pwdwidget = new PasswordWidget('thepwddiv','password');
		pwdwidget.MakePWDWidget();
		</script>
		<noscript>
		<div><input type="password" id='regpwd' name="password" value="<%=password %>" /></div>		
		</noscript>
	</div></td>

                        
                    </tr>
                    
                     <tr>
                         <td><label>Confirm Password :</label></td>
                        <td><input type="password" name="cpassword" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Sex :</label></td>
                        <td><label>Male</label><input type="radio" name="sex" value="Male" />
                            <label>Female</label><input type="radio" name="sex" value="Female" checked="checked" /></td>
                    </tr>
                    <tr>
                        <td><label>Date of Birth :</label></td>
                        <td><input type="text" name="dob" value="<%=dob %>" /></td>
                    </tr>
                    <tr>
                        <td><label>City :</label></td>
                        <td><input type="text" name="city" value="<%=city %>" /></td>
                    </tr>
                    <tr>
                        <td><label>Email :</label></td>
                        <td><input type="email" name="email" value="<%=email %>" onblur="checkEmail(this.value)" ><div id="emailmessage"></div></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="submit" id="submit" value="Submit" /></td>
                    </tr>
                </tbody>
            </table>
         
       </form> 
        <%
        
  
    
%>
        
        
   </div>
         <%@include file="./common/Footer.jsp" %>
    </body>
       <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
<%
}
else
       {
    response.sendRedirect("../index.jsp");
}


%>





