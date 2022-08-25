<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
    <%@include file="segments/sheets.jsp"%>
    <link rel="stylesheet" href="styles/game.css" type="text/css"/>
</head>
<body>
<%@include file="segments/header.jsp"%>
    <div id = "board"></div>
<%@include file="segments/footer.jsp"%>
<script src="mechanics/game.js"></script>
</body>
</html>
