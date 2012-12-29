<%-- 
    Document   : forgotpassword
    Created on : Jan 10, 2012, 1:38:33 AM
    Author     : Shaishav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../admin/css/style.css" type="text/css" media="all" />
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
		<div class="shell">
			
			<div id="head">
				<h1><a href="home.jsp">Xxnations</a></h1>
                        </div></div>
				</div>
			</div>
        <div align="center" style="margin-top: 200px">
        <h3>Enter the Email Address </h3>
        <br><br>
        <form action="../admin/adminforgotpassword.do" method="GET">
            Email Address <input type="text" name="email">
            <input type="submit" value="Resend" />
        </form>
        </div>
        <br><br>
        <a href="../admin/login.jsp" style="margin-left: 615px">Back to Home </a>
    </body>
</html>
