<%-- 
    Document   : editprofile
    Created on : Jan 21, 2012, 12:31:03 AM
    Author     : Shaishav
--%>

<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page errorPage="./oops.jsp" %>
<%
if(session.getAttribute("role")!="user")
{
    
response.sendRedirect("../login.jsp");
return;
}

 List listeditprofile=null;
 String user_id=null;
  
    //String username=(String)session.getAttribute("username");
try
{         
   // user_id=(String)request.getParameter("userid");
    user_id=(String)session.getAttribute("user");
    registerservice obj=new registerservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
    int int_user_id=Integer.parseInt(user_id);
    listeditprofile=obj.editUser(int_user_id); 
               }
catch(Exception e)
{
    System.out.print("Error in editprofile "+e);
}         //int i=listeditprofile.size();
           modelregister obj1=(modelregister)listeditprofile.get(0);
              

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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
       
    </head>
    <body>
        <%
    if ((String)session.getAttribute("role")== "user") {
  %>
  <%@include file="./common/globalheaderuser.jsp" %>
  
  <%
    }
                else
                    {
%>
                    
<%@include file="./common/globalheaderguest.jsp" %>
     <% } %>
<div style="position: absolute; margin-top: 25px; margin-left: 450px; ">
         <h3>Edit profile</h3>
         <hr align="left" style="width: 500px;"><br><br>
     <form action="../edituser.do" method="get">
            <table width=700 >
            <%
                out.println("<tr><td>First Name   : </td><td><input type=\"text\" name=\"fname\" value=\""+obj1.getFname()+"\"  /></td></tr>");
           // out.print("<br>");
            out.println("<tr><td>Last Name  : </td><td><input type=\"text\" name=\"lname\" value=\""+obj1.getLname()+"\" size=\"50\"/></td> </tr>");
           // out.print("<br>");
            out.println("<tr><td>Username : </td><td><input type=\"text\" name=\"username\" id=\"username\" value=\""+obj1.getUsername()+"\"><div id=\"usernamemessage\"></div></td> </tr>");
           // out.print("<br>");
            out.println("<tr><td>Password : </td><td><input type=\"password\" name=\"password\" value=\""+obj1.getPassword()+"\" size=\"50\"/></td> </tr>");
           // out.print("<br>");
            out.println("<tr><td>E-mail  : </td><td><input type=\"email\" name=\"email\" id=\"email\" value=\""+obj1.getEmail()+"\"><div id=\"emailmessage\"></div></td> </tr>");
           // out.print("<br>");
            out.println("<tr><td>DOB  : </td><td><input type=\"text\" name=\"dob\" value=\""+obj1.getDob()+"\" size=\"70\" /></td> </tr>");
           // out.print("<br>");
            out.println("<tr><td>City  : </td><td><input type=\"text\" name=\"city\" value=\""+obj1.getCity()+"\" size=\"70\" /></td> </tr>");
          //  out.print("<br>");
            if(obj1.getSex().toLowerCase().equals("female"))
{
            out.println("<tr><td>Sex  : </td><td>Male<input type=\"radio\" name=\"sex\" value=\"Male\" />  Female<input type=\"radio\" name=\"sex\" value=\"Female\" checked=\"checked\" /></td> </tr>");
}
            else
{
            out.println("<tr><td>Sex  : </td><td>Male<input type=\"radio\" name=\"sex\" value=\"Male\" checked=\"checked\" />  Female<input type=\"radio\" name=\"sex\" value=\"Female\"/></td> </tr>");    
}
//            out.print("<br>");
  //          out.print("<br>");
            
            out.println("<tr><td><input type=submit name=submit id=submit value=\"Update\" /> </td><td>");

    
%>
            <br>
           </table><br>
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
%>     </form></div>
<%@include file="./common/Footer.jsp" %>
            </body>
              <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
