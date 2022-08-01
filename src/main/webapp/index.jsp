<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://kit.fontawesome.com/8868c41994.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <i class="fa-solid fa-circle" id="blue"></i>
        <i class="fa-solid fa-circle" id="red"></i>
        <i class="fa-solid fa-circle" id="green"></i>
        <i class="fa-solid fa-circle" id="yellow"></i>
        <h1>Connect Four</h1>
    </header>

    <div id="menu">
        <h3>Welcome to my game! Choose whether you want to sign in or create a new account</h3>
        <p><input type="submit" id="log-in" class="button" value="Log in"/></p>
        <p><input type="submit" id="register" class="button" value="Create an account"/></p>
    </div>

    <script> src="menu.js"</script>
</body>
</html>