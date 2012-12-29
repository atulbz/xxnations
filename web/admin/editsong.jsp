
<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
        <%
        String song_id1=request.getParameter("song_id");
        int song_id=Integer.parseInt(song_id1);
           Songservice obj=new Songservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
           List list=obj.getSongDetails(song_id);
            albumservice obj2=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List list1=obj2.getAlbumlist();
            Iterator it=list1.iterator();  
           //int i=list.size();
           modelsong obj1=(modelsong)list.get(0);
           
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
%>     
 <link rel="stylesheet" type="text/css" href="../css/x.css">  
           <head>
            <br>
            <title>Edit Song</title>  
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

	<!-- End Header -->
        <div align="center">
                <form action="../admin/editsong.do" method="get">
                         <table  width=700 border="0">

            <%
                out.println("<tr><td>Song id   : </td><td><input type=\"text\" name=\"song_id\" value="+obj1.getSong_id()+" readonly=\"readonly\" /></td></tr>");
            out.print("<br>");
//            out.println("<tr><td>Album Name  : </td><td><input type=\"text\" name=\"Album_id\" value="+obj1.getAlbum_id()+" size=\"50\"/></td> </tr>");
//            out.print("<br>");
            %>
            <tr><td>Album Name : </td><td><select name="Album_id" onChange="album(document.form1.album_id.options[document.form1.album_id.options.selectedIndex].value)">    
              
            
                <%
       while(it.hasNext())
            {
            modelalbum res=(modelalbum)it.next();
            if(res.getAlbum_id()==obj1.getAlbum_id())
                               {
                out.println("<option value =\""+res.getAlbum_id()+"\" selected=\"selected\">"+res.getAlbum_name()+"</option>");
            }
            else
                               {
            out.println("<option value =\""+res.getAlbum_id()+"\">"+res.getAlbum_name()+"</option>");
            
}
}
%>
            </select></td></tr><br>
            
            
            <%
            out.println("<tr><td>Song Name : </td><td><input type=\"text\" name=\"Song_name\" value=\""+obj1.getSong_name()+"\" size=\"50\"/></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>Artist Name : </td><td><input type=\"text\" name=\"Artist_name\" value=\""+obj1.getArtist_name()+"\" size=\"50\"/></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>song url  : </td><td><input type=\"text\" name=\"song_url\" value=\""+obj1.getSong_url()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>Bitrate  : </td><td><input type=\"text\" name=\"bitrate\" value=\""+obj1.getBitrate()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>Frequency  : </td><td><input type=\"text\" name=\"frequency\" value=\""+obj1.getFrequency()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>Duration  : </td><td><input type=\"text\" name=\"duration\" value=\""+obj1.getDuration()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.println("<tr><td>Release_year  : </td><td><input type=\"text\" name=\"release_year\" value=\""+obj1.getRelease_year()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.print("<br>");
            out.println("<tr><td>Size  : </td><td><input type=\"text\" name=\"len\" value=\""+obj1.getLen()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            //out.println("<tr><td>Genre  : </td><td><input type=\"text\" name=\"genre\" value="+obj1.getGenre()+" size=\"70\" /></td> </tr>");
            
            %>
            
            
            <tr><td>Genre  </td><td><select id="genre" name="genre"><option value="">Select Genre</option>
            
<%       
genreservice obj3=new genreservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List list2=obj3.getGenre();
Iterator it1=list2.iterator();

   while(it1.hasNext())
             {
            modelgenre res=(modelgenre)it1.next();
            if(!obj1.getGenre().toLowerCase().equals(res.getGenre().toLowerCase()))
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
            
            
            <%
            out.print("<br>");
            out.println("<tr><td>Demo url  : </td><td><input type=\"text\" name=\"demo_url\" value=\""+obj1.getDemo_url()+"\" size=\"70\" /></td> </tr>");
            out.print("<br>");
            out.print("<input type=\"hidden\" name=\"redirect\" value=\""+request.getParameter("redirect") +"\">");
            out.println("<tr><td><input type=\"submit\" value=\"Update\"/></td><td>");
            %>
            <br>
           </table>
            
            
            </form>
            
            
      <script type="text/javascript" src="../js/pagination.js"></script>   
      
      
       
            
    <br><strong><i> Comments </i></strong></br>  
       <% 
commentservice obj4=new commentservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List comments=obj4.getComments(song_id);       
            request.setAttribute("list", comments);
            String s=request.getQueryString();

%>
 
</table>
        
        <display:table   name="list" class="dataTable" id="table" pagesize="5"  size="<%=list.size() %>" requestURI="editsong.jsp" keepStatus="true">
                 <display:column title="Username" property="username"></display:column>
                 <display:column title="Comments" property="comment"></display:column>
                 <display:column title="Time" property="time"></display:column>
                 <display:column title="Remove"><a href="../admin/removecomment.do?cid=${table.comment_id}&<%=s %>">Remove</a></display:column>
                 <display:setProperty name="paging.banner.placement" value="bottom" />   </display:table>
</div>
<!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
            </body>
            </html>
           

