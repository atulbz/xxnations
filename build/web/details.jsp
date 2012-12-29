<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page errorPage="./oops.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "org.displaytag.export.*" %>


<html>
    <head>
          
        <script type="text/javascript" src="js/player.js"></script>
    
  <link  rel="stylesheet"  type="text/css" href="../css/fixrating.css">      
   <link  rel="stylesheet"  type="text/css" href="../css/starrating.css">
    


    </head>
    <body style="background-color: #EEEEEF">
        <%@include file="./common/Footer.jsp" %>   
        <script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
         <script type="text/javascript" src="js/pagination.js"></script>  
         <script type="text/javascript" src="js/vote.js"> </script>
           <script type="text/javascript" src="js/player.js" > </script>
        
   </script>
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
     <div style="position: absolute; margin-top: 5px; margin-left: 450px; ">
        <h1>Song Details</h1>
        <%

                out.print("<a href=\"../songs.do?Album_id="+request.getParameter("Album_id")+"&Album_name=Album\">Go to Album</a>");             
            String song_id = request.getParameter("song_id");
            
            List Songdetail = (List) request.getAttribute("Songdetails");
             
if(Songdetail.isEmpty())
       {
    out.print("<i>No such song exists...</i><br>");
}
            Iterator it = Songdetail.iterator();
            albumservice obj2=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            String img_url=obj2.getUrl(request.getParameter("Album_id"));
            ratingservice ratingobj=new ratingservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            double rating=ratingobj.getRating(song_id);
            out.print("<table cellspacing=\"10\" cellpadding=\"10\">");
            out.print("<tr><td><img src="+img_url+" height=\"300\" width=\"300\"><br><br><br></td>");
            
            while (it.hasNext()) {
                modelsong obj = (modelsong) it.next();
                out.print("<title>"+obj.getSong_name()+"</title>");
                out.print("<div style=\"display: none\">"+"<a href="+obj.getDemo_url()+"></a>"+"</div>");
                out.println("<td><br><br>");
                out.print("<b>"+obj.getSong_name()+"</b>");
                out.print("<b> by "+obj.getArtist_name()+"</b><br><br>");
                out.print("<br><a href=\"../download_qr.do?song_id="+obj.getSong_id()+"\">Generate Bar Code</a>");
                out.println("<br><br>");
                out.print("<a href=\"../download_url.do?song_id=" + obj.getSong_id() + "\">Download Song</a></td></tr>");
            }
            out.println("</table>");
        %>

        Rate this song
        <ul class='star-rating'>
            <li class='current-rating' id='current-rating' style="width: <%=rating*20 %>px"></li>
            <li><a href="#" onclick="vote(1,<%=song_id%>); return false;"
                   title='1 star out of 5' class='one-star'>1</a></li>
            <li><a href="#" onclick="vote(2,<%=song_id%>); return false;"
                   title='2 star out of 5' class='two-stars'>2</a></li>
            <li><a href="#" onclick="vote(3,<%=song_id%>); return false;"
                   title='3 star out of 5' class='three-stars'>3</a></li>
            <li><a href="#" onclick="vote(4,<%=song_id%>); return false;"
                   title='4 star out of 5' class='four-stars'>4</a></li>
            <li><a href="#" onclick="vote(5,<%=song_id%>); return false;"
                   title='5 star out of 5' class='five-stars'>5</a></li>
        </ul>
        <div class="load" ></div>
        <div id='current-rating-result'></div>
        <br>
      
         
    <br><strong><i> Comments </i></strong></br>  
       <% List detcomments = (List) request.getAttribute("comments");
request.setAttribute("list", detcomments);       
%>
 
<display:table  cellspacing="5px" name="list" pagesize="3" id="x"  style="width:500px; " defaultorder="ascending" size="<%=detcomments.size() %>" requestURI="details.do">
        
                              <display:column style="border-style: inset; "><br>
        <i>${x.username}</i>&nbsp;&nbsp;commented at ${x.time}<br>
                 ${x.comment}<br>
                 <br>
        </display:column><br>
               
<display:setProperty  name="paging.banner.placement" value="bottom" />  <br>
    </display:table>
     
<%  
        //out.print("</td>");
        //    out.print("</tr>");
        //   }
 
    %>  

<div>Add Comment</div>        <form action="../comments.do" method="POST">
         <table>
                  <tr><td>            <input type="hidden" name="song_id" value="<%=song_id%>" id="song_id" /></td></tr>
                  <tr><td>            <textarea name="comment" value="" rows="3" cols="40" id="comment"  ></textarea></td></tr>
           
                  <tr><td align="right">            <input type="submit" value="Comment"  id="submit"></td></tr>
        </form>
        <div id="ct"> </div>
        
</div>
                  
    </body>
      <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>

