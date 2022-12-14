<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <%@include file="segments/sheets.jsp"%>
    <link rel="stylesheet" href="styles/menu.css" type="text/css"/>
</head>
<body>
<%@include file="segments/header.jsp"%>
    <div id="user-info">
        <p>Welcome ${requestScope.username}!</p>
        <a href="profile_settings.jsp">Edit your profile here</a></br>
        <a href="login.jsp">Logout</a>
    </div>

    <div id="game-menu">
        <input type="button" id="game-start" value="Start a game!"/>
    </div>
<%@include file="segments/footer.jsp"%>
</body>
</html>
