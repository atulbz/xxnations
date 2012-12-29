
<%@page import="model.modelcomments"%>
<%@page import="model.commentservice"%>
<%@page import="model.modelalbum"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

                  <table id="results" width="700">  
                      
                 <%

try
               {
    
            commentservice objy=new commentservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List comments=objy.getLatestComments();
         for(int i=0;i<comments.size();i++)
                            {    
modelcomments com = (modelcomments) comments.get(i);
               
                out.print(com.getUsername().toUpperCase()+" commented on "+com.getSong_name());
                out.print("<br>");
                out.print("comment : <i>" + com.getComment()+"</i>");
                out.print("<br>");
                out.print("<br>");
                }
             out.print("</td>");
            out.print("</tr></table>");
           }
 
            
    catch(Exception e)
               {
    out.print(e);
}


%>