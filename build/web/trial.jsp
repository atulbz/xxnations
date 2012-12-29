
<%@page import="model.modelsong"%>
<%@page import="model.Songservice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>



<%
Songservice objx=new Songservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
           List listsongs=objx.getSongsName(Integer.parseInt(request.getParameter("Album_id")));
           out.print("<i>List of Songs</i><br><br>");
           
           if(listsongs.isEmpty())
                             {
               out.print("No song is added..");
           }
           
           Iterator songiterator=listsongs.iterator();
           int sizeinsongname=1;
           while(songiterator.hasNext())
                             {
               modelsong songobj=(modelsong)songiterator.next();
               out.print(sizeinsongname+". "+songobj.getSong_name()+"<br>");
              sizeinsongname++;
               
           }
           
           

%>
