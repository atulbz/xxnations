<%-- 
    Document   : downloadhistory
    Created on : Jan 23, 2012, 2:16:22 AM
    Author     : Shaishav
--%>

<%@page import="model.modeldownload"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="model.downloadservice"%>
<%@page errorPage="./oops.jsp" %>

<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Download History</title>
    </head>
    
         <style type="text/css">  
.pg-normal {  
    color: #0000FF;  
    font-weight: normal;  
    text-decoration: none;  
    cursor: pointer;  
}  
  
.pg-selected {  
    color: #800080;  
    font-weight: bold;  
    text-decoration: underline;  
    cursor: pointer;  
}  
.odd
{
         background-color: #ffcc33
}
.even
{
         background-color: #ffcc00
}
</style> 
    <script type="text/javascript" src="js/pagination.js"></script>  
    <link rel="stylesheet" type="text/css" href="css/x.css">
       <link rel="stylesheet" type="text/css" href="../css/avoidcss.css">
   
    
    
        <%
       
        if(session.getAttribute("role")!="user")
{
response.sendRedirect("../login.jsp");
return;
}
 
                               try
                               {    
   String user_id1=(String)session.getAttribute("user");
 
   int user_id=Integer.parseInt(user_id1);
   
 downloadservice obj1=new downloadservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));   
  List listdownloadhistory=obj1.getDownloadhistory(user_id);
request.setAttribute("listdownloadhistory", listdownloadhistory);
 if(listdownloadhistory.isEmpty())
         {
     System.out.print("Nothing Downloaded.."+listdownloadhistory.size());
     return;
 }
else
{
         int i=listdownloadhistory.size();
  %>
  <body style="background-color: #EEEEEF">
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
    <h1 align="center">Download History</h1><br>
     

          <display:table  name="listdownloadhistory" id="table" class="datatable" pagesize="10" requestURI="downloadhistory.jsp">
                   <display:setProperty name="paging.banner.placement" value="bottom" />     
                   <display:caption title="Download History"></display:caption>
                   <display:column title="Download Number" value="<%=i-- %>"></display:column>
                   <display:column title="Song Name" property="song_name"> </display:column>
                   <display:column title="Time" property="dtime"></display:column>
                   <display:column title="Download Link"><a href="${table.url}">Retry</a></display:column>
          </display:table>
 
    
    <%  
 
              }
  
 }
 catch(Exception e)
                 {
          System.out.print("Error in downloadhistory.jsp"+e);
 }          
           
 
 
 
    %>  
</table>
 </div>
<%@include file="./common/Footer.jsp" %>
    </body>
      <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
