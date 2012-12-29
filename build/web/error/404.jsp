<%-- 
    Document   : 404
    Created on : Feb 9, 2012, 12:40:55 AM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
    </head>
  <style>
    *{margin:0;padding:0}html,code{font:15px/22px arial,sans-serif}html{background:#fff;color:#222;padding:15px}body{margin:7% auto 0;max-width:390px;min-height:180px;padding:30px 0 15px}* > body{background:url(//www.google.com/images/errors/robot.png) 100% 5px no-repeat;padding-right:205px}p{margin:11px 0 22px;overflow:hidden}ins{color:#777;text-decoration:none}a img{border:0}
  </style>
  <body>
      <a href="../index.jsp"><img src="images/home.jpg"></a><br><br>
  <p><b>404.</b> <ins>That’s an error.</ins>

  <p>The requested URL was not found on this server.We tried very hard   <ins>That’s all we know.</ins>
  <br><br><br>
  <br>But still you can look for many things like...
  <br>
  <br>
  
   
  <div style="position: absolute; top:300px; left: -100px">   
      <%@include file="../home/top_songs.jsp" %></div>
      <div style="position: absolute; top:-100px; left: 600px">   
                   <%@include file="../home/latest_albums.jsp" %>
      </div>      
  </body>
</html>