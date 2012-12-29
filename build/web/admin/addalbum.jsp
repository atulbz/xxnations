<%@page import="model.*" %>
<%@page import="java.util.*" %>

    
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
            <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
            
</head>
<body>
<%
genreservice obj=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getGenre();
Iterator it=list.iterator();

%>
	
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
	<div id="help-nav">
			<a href="albummgmt.jsp">Manage Album</a> &gt; Add Album
		</div>
	
	
	<!-- Content -->
	<div align="center">
            <%
           // albumservice obj1=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
           // List list1=obj1.getAlbumlist();
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
 

String Album_name=request.getParameter("Album_name");
if(Album_name==null || Album_name.isEmpty())
{
    Album_name="";
}                          
else
       {
    Album_name=Album_name;
}

String Genre=request.getParameter("Genre");
if(Genre==null || Genre.isEmpty())
{
    Genre="";
}                          
else
       {
    Genre=Genre;
}


String Artist_name=request.getParameter("Artist_name");
if(Artist_name==null || Artist_name.isEmpty())
{
    Artist_name="";
}                          
else
       {
    Artist_name=Artist_name;
}

String img_url=request.getParameter("img_url");
if(img_url==null || img_url.isEmpty())
{
    img_url="";
}                          
else
       {
    img_url=img_url;
}

String Featuring_artists=request.getParameter("Featuring_artists");
if(Featuring_artists==null || Featuring_artists.isEmpty())
{
    Featuring_artists="";
}                          
else
       {
    Featuring_artists=Featuring_artists;
}
  
  String Album_info=request.getParameter("Album_info");
if(Album_info==null || Album_info.isEmpty())
{
    Album_info=" ";
}                          
else
       {
    Album_info=Album_info;
}                                                                                                                  
  %>
		<table>
                         <form action="../admin/addalbum.do" name="form1">
                   <tr><td> Album name </td><td><input type="text" name="Album_name" value="<%=Album_name %>" /></td></tr>
                    <br>
                   
                    <tr><td>Select Genre</td><td>
                    <select name="Genre">    
                <option value="">Select Genre</option>
            
<%            while(it.hasNext())
             {
            modelgenre res=(modelgenre)it.next();
            if(!Genre.equals(res.getGenre()))
                               {
            out.println("<option value =\""+res.getGenre()+"\">"+res.getGenre()+"</option>");
                       }
            else
                               {
                out.println("<option value =\""+res.getGenre()+"\" selected=\"selected\">"+res.getGenre()+"</option>");
            }
            }
%>
				 </select>
                    
              </td></tr>      
    <br>
                    <tr><td>Release date    </td><td>
                    <select name="d">
      <%          
                         
            {
            for(int i=1;i<=31;i++)
            out.println("<option value =\""+i+"\">"+i+"</option>");
            }
%></select>
<select name="m">
                        <%          
                         
            {
            for(int i=1;i<=12;i++)
            out.println("<option value =\""+i+"\">"+i+"</option>");
            }
%>
					</select>
<input type="text" size="4" maxlength="4" name="y" >
                    <br>
                    </td><tr><td>Artist name</td><td>
                            
                            
                            <input type="text" name="Artist_name" value="<%=Artist_name %>" /></td></tr>
                    <br>
                    <tr><td>Album info</td><td><textarea name="Album_info" rows="4" cols="20" ><%=Album_info %></textarea></td></tr>
                    
                    <br>
                    <tr><td>Image url    </td><td><input type="text" name="img_url" value="<%=img_url %>" /></td></tr>
                    <br>
                    <tr><td>Featuring Artist</td><td><input type="text" name="Featuring_artists" value="<%=img_url %>" /></td></tr>
                    <br>
            </td><td><input type='submit' id="submit_btn" value='Add Album'>
            </form>
                    <div id="i"></div>
                </table>
		
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
