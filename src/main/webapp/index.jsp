<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Strona główna</title>
    <script src="https://kit.fontawesome.com/8868c41994.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap" rel="stylesheet">
    <script> src="menu.js"</script>
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
</body>
</html>