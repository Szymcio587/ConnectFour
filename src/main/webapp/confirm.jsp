<%--
  Created by IntelliJ IDEA.
  User: Szef
  Date: 03.08.2022
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie</title>
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
