<%@ page isErrorPage = "true"%>
<%@ page import = "java.io.*" %>

<HTML>
    <HEAD>
        <TITLE> custom error page </TITLE>
    </head>
    <body>
       <h2>Your application has generated an error</h2>
       <h3>Please check for the error given below</h3>
       <b>Exception:</b><br> 
       <font color="red"><%= exception.toString() %></font>
       <a href="../admin/home.jsp">Home</a>
    </body>
</html>