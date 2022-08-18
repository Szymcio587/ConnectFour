<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Strona główna</title>
    <%@include file="sheets.jsp"%>
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="menu">
        <h3>Welcome to my game! Choose whether you want to sign in or create a new account</h3>
        <p><input type="button" id="log-in" value="Log in"/></p>
        <script type="text/javascript">
            document.getElementById("log-in").onclick = function () {
                location.href = "login.jsp";
            };
        </script>
        <p><input type="button" id="register" value="Create an account"/></p>
        <script type="text/javascript">
            document.getElementById("register").onclick = function () {
                location.href = "register.jsp";
            };
        </script>
    </div>

    <%@include file="footer.jsp"%>
</body>
</html>
