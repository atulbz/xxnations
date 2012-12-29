<%-- 
    Document   : categories
    Created on : Jan 2, 2012, 1:44:53 PM
    Author     : Shaishav
--%>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@page errorPage="./oops.jsp" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.displaytag.export.ExcelView" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
        <title><%out.print(request.getParameter("q")); %></title>
         <script src="../js/RowHandlers.js" language="javascript" type="text/javascript" /></script>
       <script src="js/jquery-min.js"></script>
                <script type="text/javascript" src="js/tooltip.jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$(".tooltip").tooltip({
							folderurl : 'trial.jsp'
							});
				
			});
		</script>
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
      <script type="text/javascript" src="../js/tooltip.jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.tooltip').tooltip({
							folderurl : 'trial.jsp'
							});
								
			});
		</script>
    <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
       
        
        <%
    
    
  
List listcategories=(List)request.getAttribute("List");  
request.setAttribute("listcategories", listcategories); 

 System.out.print("categories.jsp listcategories"+listcategories.size());
if(listcategories.isEmpty())
       {
    out.print("<i>No Albums or Songs in this category will be added soon...</i><br>");
}
        %>
           <h1>Browse Albums by Category </h1>
            <hr align="left" style="width: 500px;">
           <table  style="width: 50%; border: #6666ff;" >
           <display:table   name="listcategories" class="dataTable" id="table" pagesize="5"  size="<%=listcategories.size() %>" requestURI="categories.do" >
             <display:setProperty name="paging.banner.placement" value="bottom" />       
                    <tr><td>
                         <display:column title="${table.album_name}" >
                         <br> <a href="../songs.do?Album_id=${table.album_id}&Album_name=${table.album_name}" id="?Album_id=${table.album_id}" class="tooltip"><img src="${table.img_url}" height="150" width="150"></a>
                         </td><td>
                         <br>     Album Name  : ${table.album_name}  
                         <br>     Description : ${table.album_info}
                         <br> <a href="../songs.do?Album_name=${table.album_name}&Album_id=${table.album_id}" id="?Album_id=${table.album_id}" class="tooltip">Details</a></td></tr>
               </display:column>
                                  <br>
                         
                </tr>
                 
                  
          
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
