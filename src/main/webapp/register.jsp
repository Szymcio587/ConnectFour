<%--
  Created by IntelliJ IDEA.
  User: Szef
  Date: 01.08.2022
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona do rejestracji</title>
    <script src="https://kit.fontawesome.com/8868c41994.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap" rel="stylesheet">
</head>
<body>
    <%@include file="header.jsp"%>
    <form method="post" class="menu">
        <p>Nickname: <input type="text"/></p>
        <p>Password: <input type="password"/></p>
        <p>Repeat Password: <input type="password"/></p>
        <p>E-mail: <input type="text"/></p>
        <p><input type="submit" value="Register"/></p>
    </form>
</body>
</html>
