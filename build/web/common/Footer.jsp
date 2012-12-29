<%@ page import="controller.SessionCounter" %>
      
        <div id="siteInfo" style="padding-bottom: 2px; background-color: #364F86; top: 1300px; height:220px; position: absolute; width: 100%; min-height: 220px; min-width: 1300px;"> 
           
            
            <div style="position: absolute; left: 150px">
                        <h2 align="center" style="color:#CCCCCC">Request A Song</h2>
        <% 
if(session.getAttribute("role")=="user")
{           

%>
<%@include file="../home/request.jsp" %>
        
        <%
}
else
{          
%>
<%@include file="../home/indexrequest.jsp" %>
<%
}
%>
                    </div>
                    <div style="position: absolute; left: 520px">
                            <h2 style="color:#CCCCCC">Latest Comments</h2><br>
<marquee onMouseOver="this.scrollAmount=0" onMouseOut="this.scrollAmount=2" scrollamount="2" direction="up" loop="true" width="30%" height="100px">

     
            <%@include file="../home/latest_comments.jsp" %>

</marquee>
</div>
            <div style="position: absolute; left:750px">
                <h2 align="center" style="color: #CCCCCC"> Our Music</h2>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="../aboutus.jsp" style="color: #CCCCCC">About Us</a><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="../contactus.jsp" style="color: #CCCCCC">Contact Us</a><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="../policy.jsp" style="color: #CCCCCC">Privacy Policy</a><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="../sitemap.jsp" style="color: #CCCCCC">Site Map</a><br>
            </div>
            <div style="position: absolute; left:900px">
                <h2 align="center" style="color: #CCCCCC">Follow Us On</h2><br>
               &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://www.facebook.com/#!/groups/289612247797322/" target="_blank"><img src="../images/facebook.png"></a>
                &nbsp;&nbsp;<a href="https://twitter.com/#!/atulbz" target="_blank"><img src="../images/twitter.png"></a>
                <br><br>
              &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<a href="https://plus.google.com/u/0/?tab=mX" target="_blank"><img src="../images/google+1.jpg"></a>
                &nbsp;&nbsp;<a href="#" ><img src="../images/feed-icon32x32.png"></a>
            </div>
            <div style="position: absolute; left:1150px">
        <%
    SessionCounter counteronlineuser = (SessionCounter) session
            .getAttribute("counteronlineuser");
%>
            <h2>Online user(s): <%= counteronlineuser.getActiveSessionNumber() %></h2>
        </div>
        </div>
