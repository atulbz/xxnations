<%@page import="model.*" %>
<%@page import="java.util.*" %>


<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>xxnations.com-Admin panrl</title>
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
<script src="../js/jquery-1.7.1.min.js" type="text/javascript"></script>
            <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
            <script src="../js/checkgenre.js" type="text/javascript" ></script>
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
				    <li><a href="../admin/songmgmt.jsp" class="active"><span>Manage Songs</span></a></li>
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
	
	<div id="help-nav">
			<a href="songmgmt.jsp">Manage Songs</a> &gt; Add Songs
		</div>
	
	<!-- Content -->
	<div align="center">
		<%
            albumservice obj1=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List list1=obj1.getAlbumlist();
            Iterator it=list1.iterator(); 
            
             try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<font color='red'>");
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
            String song_name=request.getParameter("song_name");
if(song_name==null || song_name.isEmpty())
{
    song_name="";
}                          
else
       {
    song_name=song_name;
}
            
            String song_url=request.getParameter("song_url");
if(song_url==null || song_url.isEmpty())
{
    song_url="";
}                          
else
       {
    song_url=song_url;
}

            String album_id=request.getParameter("album_id");
if(album_id==null || album_id.isEmpty())
{
    album_id="";
}                          
else
       {
    album_id=album_id;
}
            
            String artist_name=request.getParameter("artist_name");
if(artist_name==null || artist_name.isEmpty())
{
    artist_name="";
}                          
else
       {
    artist_name=artist_name;
}
            String frequency=request.getParameter("frequency");
if(frequency==null || frequency.isEmpty())
{
    frequency="";
}                          
else
       {
    frequency=frequency;
}
            String bitrate=request.getParameter("bitrate");
if(bitrate==null || bitrate.isEmpty())
{
    bitrate="";
}                          
else
       {
    bitrate=bitrate;
}
            String release_year=request.getParameter("release_year");
if(release_year==null || release_year.isEmpty())
{
    release_year="";
}                          
else
       {
    release_year=release_year;
}
            
            String demo_url=request.getParameter("demo_url");
if(demo_url==null || demo_url.isEmpty())
{
    demo_url="";
}                          
else
       {
    demo_url=demo_url;
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
            
            String len=request.getParameter("len");
if(len==null || len.isEmpty())
{
    len="";
}                          
else
       {
    len=len;
}
            String genre=request.getParameter("genre");
if(genre==null || genre.isEmpty())
{
    genre="";
}                          
else
       {
    genre=genre;
}
  %>
		
		 <form action='../admin/addsong.do' name="form1">
                    <table align="center">
               <tr><td> <select name="album_id" onChange="album(document.form1.album_id.options[document.form1.album_id.options.selectedIndex].value)">    
                <option>Select Album</option>
<%            while(it.hasNext())
            {
            modelalbum res=(modelalbum)it.next();
            out.println("<option value =\""+res.getAlbum_id()+"\">"+res.getAlbum_name()+"</option>");
            }
%>
				</select></td></tr><br>
          <tr><td>  Name of the Song : </td><td><input type='text' name='song_name' value="<%=song_name %>"></td></tr>
                                                                        <br>
           <tr><td> Song location : </td><td><input type='text' name='song_url' value="<%=song_url %>"></td></tr>
                                                                        <br>
                                                                        

       <script language="javascript" type="text/javascript" src="../js/albumdisplayinaddsong.js" ></script>
           <tr><td> Artist Name</td><td> <input type='text' name='artist_name' id="artist_name" value="<%=artist_name %>"></td></tr><br>
           <tr><td> Frequency </td><td><input type='text' name='frequency' id="frequency" value="<%=frequency %>"></td></tr><br>
            <tr><td>Bitrate </td><td><input type='text' name='bitrate' id="bitrate" value="<%=bitrate %>"></td></tr><br>
           <tr><td> Release Year </td><td><input type='text' name='release_year' id="release_year" value="<%=release_year %>"></td></tr><br>
           <tr><td> Demo URL </td><td><input type='text' name='demo_url' id="demo_url" value="<%=demo_url %>"></td></tr><br>
           <tr><td> Duration </td><td><input type='text' name='duration' id="duration" value="<%=duration %>"></td></tr><br>
           <tr><td> Size  </td><td><input type='text' name='len' id="len" value="<%=len %>"></td></tr><br>
           <div id="gen">
           <tr><td>Genre  </td><td><select id="genre" name="genre"><option value="">Select Genre</option>
<%       
genreservice obj=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list=obj.getGenre();
Iterator it1=list.iterator();

   while(it1.hasNext())
             {
            modelgenre res=(modelgenre)it1.next();
            if(!genre.equals(res.getGenre()))
                               {
            out.println("<option id=\""+res.getGenre()+"\" value =\""+res.getGenre()+"\">"+res.getGenre()+"</option>");
                       }
            else
                               {
                out.println("<option id=\""+res.getGenre()+"\"value =\""+res.getGenre()+"\" selected=\"selected\">"+res.getGenre()+"</option>");
            }
            }
%>
		   </select>
            </td></tr><br>
           </div>
            <tr><td><input type='submit' name="submit_btn" id="submit_btn" value='Add Song'></td></tr>
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