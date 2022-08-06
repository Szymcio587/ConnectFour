<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie</title>
    <script src="https://kit.fontawesome.com/8868c41994.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap" rel="stylesheet">
</head>
<body>
    <%@include file="header.jsp"%>
    <div class="menu">
        <h3>Registration succeded!</h3>
        Click button below to log in to your new account
        <input type="button" id="log-in" value="Log in"/>
        <script>
            document.getElementById("log-in").onclick = function () {
                location.href = "login.jsp";
            };
        </script>
    </div>
</body>
</html>
