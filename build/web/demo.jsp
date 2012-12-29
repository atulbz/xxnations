 <!--
Design by Bryant Smith
http://www.bryantsmith.com
http://www.aszx.net
email: template [-at-] bryantsmith [-dot-] com
Released under Creative Commons Attribution 2.5 Generic.  In other words, do with it what you please; but please leave the link if you'd be so kind :)

Name       : Green Creative
Description: One column, with top naviagation
Version    : 1.0
Released   : 20081222
-->


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/try/style.css" />
<title>Green Creative by Bryant Smith</title>
</head>

<body>
    <div id="page">
		
        <div id="header">
        	
            <div id="headerSubText"><%@include file="./common/globalheaderguest.jsp" %></div>
            
        </div>
    
       
        <div class="contentText">
              <%@include file="./home/latest_albums.jsp" %>
        <%@include file="./home/top_songs.jsp" %>
                   
                    
        <div style="position: absolute; top: 1030px; left: 380px;">
            <h3 style="text-align: center">Featuring plans</h3>
            <%@include file="./home/plan.jsp" %>
        </div>
         </div>  
</div>
        <div id="footer"><%@include file="./common/Footer.jsp" %></div>
</body>
</html>
