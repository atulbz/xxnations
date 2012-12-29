<%-- 
    Document   : requesthistory
    Created on : Feb 14, 2012, 7:18:13 PM
    Author     : Shaishav
--%>

<%@page import="model.requestservice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List "%>

<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
         <head>
                  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                  <title>Request History</title>
                         <link rel="stylesheet" type="text/css" href="../css/x.css">
                         <link rel="stylesheet" type="text/css" href="../css/avoidcss.css">
         </head>
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
   
     <body style="background-color: #EEEEEF">
                  <%
                  String user_id=null;
                  if((String)session.getAttribute("role")!="user")
                                                     {
                           response.sendRedirect("../login.jsp");
                  }
                  else
                                                  
                                                     {
                           try
                                                                     {
                           user_id=(String)session.getAttribute("user");
                                                     }
                           catch(Exception e)
                                                                     {
                                    System.out.print("Error in reqhistory jsp"+e);
                           }
requestservice obj=new requestservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
List listrequesthistory=obj.getRequestuser(user_id);
request.setAttribute("list", listrequesthistory);

%>
<div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
     <h1 align="center">Request History</h1><br>
          <display:table   name="list" class="dataTable" id="table" pagesize="2"  size="<%=listrequesthistory.size() %>" requestURI="requesthistory.jsp" keepStatus="true">
          <display:setProperty name="paging.banner.placement" value="bottom" />    
          <display:column title="Username" property="username"></display:column>
          <display:column title="Album Requested" property="album"></display:column>
          <display:column title="Song Requested" property="song"></display:column>
          <display:column title="Time of Request" property="rtime"></display:column>
          <display:column ><a href="../removerequest.do?reqid=${table.request_id}">Remove</a></display:column>
          </display:table>

</div>
<%@include file="./common/Footer.jsp" %>
         </body>
            <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>
<%
                  }
                  %>