<%-- 
    Document   : editalbum
    Created on : Jan 20, 2012, 5:58:53 PM
    Author     : Shaishav
--%>

<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
         <script src="../js/jquery-1.7.1.min.js"></script>>
         <script src="../js/validateGenre.js" language="javascript" type="text/javascript" ></script>
            <style type="text/css">
 .bp_invalid {
    color:red;
   
    
 }
 .bp_valid {
    color:green;
 }
</style>
        <title>JSP Page</title>
    </head>
    <body>
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
                                    <li><a href="../admin/albummgmt.jsp" class="active"><span>Manage Albums</span></a></li>
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
        String id=request.getParameter("Album_id");
        albumservice obj=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
        List list=obj.getDetails(id);
        modelalbum obj1=(modelalbum)list.get(0);
        genreservice obj3=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
        List list1=obj3.getGenre();
        Iterator it=list1.iterator();

%>
<form action="../admin/editalbum.do" method="get">
    <table width="700">  
        <%
        
out.println("<tr><td>Album id : </td><td><input type=\"text\" name=\"Album_id\" value=\""+obj1.getAlbum_id()+"\" readonly=\"readonly\"></td></tr><br>");
out.println("<tr><td>Album name : </td><td><input type=\"text\" name=\"Album_name\" value=\""+obj1.getAlbum_name()+"\" ></td></tr><br>");


out.println("<tr><td>Genre :</td><td><select name=\"Genre\">");
            
         while(it.hasNext())
            {
            modelgenre res=(modelgenre)it.next();
            if(!obj1.getGenre().equals(res.getGenre()))
                               {
            out.println("<option value =\""+res.getGenre()+"\">"+res.getGenre()+"</option>");
                       }
            else
                               {
                out.println("<option value =\""+res.getGenre()+"\" selected=\"selected\">"+res.getGenre()+"</option>");
            }
            }

       
           
//out.println("<tr><td>Genre : </td><td><input type=\"text\" name=\"Genre\" id=\"genre\" value="+obj1.getGenre()+" onblur=\"validateGenre(this.value)\" ><div id=\"genremessage\"> </div></td></tr><br>");

out.println("<tr><td>Release Date : </td><td><input type=\"text\" name=\"Release_date\" value=\""+obj1.getRelease_date()+"\"></td></tr><br>");
out.println("<tr><td>Artist Name : </td><td><input type=\"text\" name=\"Artist_name\" value=\""+obj1.getArtist_name()+"\"></td></tr><br>");
out.println("<tr><td>Album Info : </td><td><textarea name=\"Album_info\" rows=\"4\" cols=\"20\" >"+obj1.getAlbum_info()+"</textarea></td></tr><br>");
out.println("<tr><td>Image Location : </td><td><input type=\"text\" name=\"img_url\" value=\""+obj1.getImg_url()+"\"></td></tr><br>");
out.println("<tr><td>Featuring Artists : </td><td><input type=\"text\" name=\"Featuring_artists\" value=\""+obj1.getFeaturing_artists()+"\"></td></tr><br>");
out.println("<tr><td><input type=\"submit\" value=\"Update\" id=\"submit_btn\"><br>");
   
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
