<%-- 
    Document   : commentsbyuser
    Created on : Feb 14, 2012, 11:09:18 AM
    Author     : Shaishav
--%>

<%@page import="model.commentservice"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN" "http://www.w3.org/TR/REC-html40/frameset.dtd">
<html>
         <head>
                    <link rel="stylesheet" type="text/css" href="../css/x.css">
                  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                  <title>Comment by user</title>
                 
	<link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
         </head>
         <body>
             <!-- Header -->
	<div id="header">
		<div class="shell">
			
			<div id="head">
				<h1><a href="home.jsp">Xxnations</a></h1>
				<div class="right">
					<p>
						Welcome <strong>Administrator</strong> | 
						<a href="../admin/admineditprofile.jsp">Profile Settings</a> |
						<a href="../admin/logoutadmin.do">Logout</a>
					</p>
				</div>
			</div>
			
			<!-- Navigation -->
			<div id="navigation">
				<ul>
				    <li><a href="../admin/songmgmt.jsp"><span>Manage Songs</span></a></li>
                                    <li><a href="../admin/albummgmt.jsp"><span>Manage Albums</span></a></li>
                                    <li><a href="../admin/planmgmt.jsp"><span>Manage Plan</span></a></li>
                                    <li><a href="../admin/usermgmt.jsp" class="active"><span>Manage users</span></a></li>
                                    <li><a href="../admin/genremgmt.jsp"><span>Manage Genre</span></a></li>
                                    <li><a href="../admin/requestmgmt.jsp"><span>Manage Requests</span></a></li>
                                    <li><a href="../admin/paymentmgmt.jsp"><span>Manage Payment</span></a></li>
				    
				    
				</ul>
			</div>
			<!-- End Navigation -->
			
		</div>
	</div>
	<!-- End Header -->
             <div align="center">
                  <%
                  String user_id=request.getParameter("user_id");
commentservice obj=new commentservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
List list=obj.getCommentsUser(user_id);
request.setAttribute("list", list);
int j=0;
%>
        <display:table export="true" name="list" id="table" class="datatable" pagesize="6" requestURI="albumlist.jsp">
             <display:setProperty name="paging.banner.placement" value="bottom" />   
              <display:column title="Sr No." value="<%=++j %>"></display:column>
              <display:column title="Username" value="${table.username}"></display:column>
              <display:column title="Comment" value="${table.comment}"></display:column>
              <display:column title="Time" value="${table.time}"></display:column>
              <display:column title="Action"><a href="../admin/removecomment.do?cid=${table.comment_id}&user_id=${table.user_id}&redirect=x&song_id=${table.song_id}">Remove</a></display:column>
        </display:table>
         </div>
         <!-- Footer -->
<div id="footer" align="justify">
	<p>&copy; xxnations.com 2012</p>
</div>
<!-- End Footer -->
         </body>
</html>
