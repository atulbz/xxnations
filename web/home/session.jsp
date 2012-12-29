<%@ page import="controller.SessionCounter" %>
<html>
<head>
    <title>Session Counter</title>
</head>

<body>
<%
    SessionCounter counter = (SessionCounter) session
            .getAttribute("counter");
%>
Number of online user(s): <%= counter.getActiveSessionNumber() %>
</body>
</html>