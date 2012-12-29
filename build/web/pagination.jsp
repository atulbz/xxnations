





<%-- 
    Document   : paginationUsingJavaScript
    Created on : Jan 12, 2012, 10:24:19 PM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page  import="model.*" %>
<%@page errorPage="./oops.jsp" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html>
<html>  
<head> 
    
               
	  
<title> Search result</title>  

         
    
</head>  

  <%
String q=request.getParameter("q")  ;
String r=request.getParameter("r");

%>
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
     
            <script type="text/javascript" src="../js/tooltip.jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.tooltip').tooltip({
							folderurl : 'trial.jsp'
							});
								
			});
		</script>
   <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
<h1>Search Result</h1>  
<br>

  
<%  
    List listsearchresult = (List) request.getAttribute("list");  
    request.setAttribute("listsearchresult", listsearchresult);
%>  
  
<table border="0" id="results" cellpadding="80" cellspaceing="800" style="text-align: left">  
    <tr bgcolor="orange">  
    <hr style="width: auto">
    <br>You have searched for <i>"<%=q %>"</i> in <i><%=r %></i>
       
    
    
    
    <display:table name="listsearchresult" id="table" cellpadding="5" cellspacing="5" frame="yes" requestURI="search.do" pagesize="4">
         <display:setProperty name="paging.banner.placement" value="bottom" />     
                 <display:column>
        <tr>
                          <td>
                                   <a href="../songs.do?Album_id=${table.album_id}" id="?Album_id=${table.album_id}" class="tooltip">      <img src="${table.img_url}" width="150" height="150"></a>
                 </td>
                 <td>
                        Song Name : <a href="../details.do?Album_id=${table.album_id}&song_id=${table.song_id}" id="?Album_id=${table.album_id}" class="tooltip">${table.song_name} by ${table.artist_name}</a><br>
                        Album     : <a href="../songs.do?Album_name=${table.album_name}&Album_id=${table.album_id}" id="?Album_id=${table.album_id}" class="tooltip"> ${table.album_name}</a><br>
                        Genre     : <a href="../categories.do?q=${table.genre}" > ${table.genre}</a><br>
                 </td>
                                  
        </tr>
             
             </display:column>
             
             
    </display:table>
    
    
    
</table>  

  </div>
    <%@include file="./common/Footer.jsp" %>
</body>  
   <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html> 