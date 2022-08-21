<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona do logowania</title>
    <%@include file="sheets.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>
    <form method="post" class="menu" action="j_security_check">
        <p>Username: <input name="j_username" type="text"></p>
        <p>Password: <input name="j_password" type="password"></p>
        <p><input type="submit" value="Log In"/></p>
        <p name="error" id="error"></p>
    </form>
    <%@include file="footer.jsp"%>
</body>
</html>
