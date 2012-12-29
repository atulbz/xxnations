<%-- 
    Document   : listsong
    Created on : Jan 18, 2012, 11:27:45 PM
    Author     : Shaishav
--%>

<%@page import="model.*"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">

<%
String album_id=request.getParameter("Album_id");
Songservice obj=new Songservice();
List list=obj.getSongs(album_id);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <table bgcolor="orange" border="1" id="results" width="700">  
    <tr bgcolor="orange">  
        <br><strong>Album Name</strong></br>  
       
    </tr>  
    <%  
        for (int i = 0; i < list.size(); i++) {  
    %>  
    <tr> 
    
   
        <%  
          modelsong ls=(modelsong)list.get(i);
          out.print("<td>"+ls.getSong_name()+"</td>");
          out.print("<td><a href=\"editsong.jsp?song_id="+ls.getSong_id()+"\">Edit</a></td>");
          out.print("<td><a href=\"../removesong.do?song_id="+ls.getSong_id()+"&Album_id="+ls.getAlbum_id()+"\">Remove</a></td>");
        
        %>  
        </td> </tr>  
    
    <%  
        }  
    %>  
</table>


    <body>
        <h1>Hello World!</h1>
    </body>
</html>
