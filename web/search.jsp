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


<link rel="stylesheet" type="text/css" href="css/paging.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title> Search result</title>  
<script type="text/javascript">
			$(document).ready(function(){
				$('.tooltip').tooltip({
							folderurl : '../try/trial.jsp'
							});
						
			});
		</script>

<script type="text/javascript" src="../js/tooltip.jquery.js"></script>
	
 


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
  
<h1>Search Result</h1>  
<br>

  
<%  
    List listsearchresult = (List) request.getAttribute("listsearchresult");  
    request.setAttribute("listsearchresult", listsearchresult);
%>  
  
<table border="0" id="results" cellpadding="80" cellspaceing="800" style="text-align: left">  
    <tr bgcolor="orange">  
    <br>You have searched for <i>"<%=q %>"</i> in <i><%=r %></i></br>
       
    
    
    
    <display:table name="listsearchresult" id="table" cellpadding="10" cellspacing="10" frame="yes" requestURI="search.do" pagesize="5">
         <display:setProperty name="paging.banner.placement" value="bottom" />     
                 <display:column>
        <tr>
                          <td>
                                   <a href="../songs.do?Album_id=${table.album_id}">      <img src="${table.img_url}" width="300" height="300"></a>
                 </td>
                 <td>
                     <label>  Song Name : </label><a href="../details.do?Album_id=${table.album_id}&song_id=${table.song_id}">${table.song_name} by ${table.artist_name}</a><br>
                     <label>  Album     :</label> <a href="../songs.do?Album_id=${table.album_id}" id="?Album_id=${table.album_id}" class="tooltip"> ${table.album_name}</a><br>
                     <label> Genre     : </label><a href="../categories.do?q=${table.genre}"> ${table.genre}</a><br>
                 </td>
                 
        </tr>
             
             </display:column>
             
             
    </display:table>
    
    
    
</table>  
    
  
</body>  
   <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html> 


