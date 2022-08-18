<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona do rejestracji</title>
    <%@include file="sheets.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>
    <form method="post" class="menu" action="${pageContext.request.contextPath}/confirm.jsp">
        <p>Username: <input type="text" name="username"/></p>
        <p>Password: <input type="password" name="password"/></p>
        <p>Repeat Password: <input type="password" name="password2"/></p>
        <p>E-mail: <input type="text" name="email"/></p>
        <p><input type="submit" value="Register"/></p>
        <p name="error" id="error"></p>
    </form>

    <%@include file="footer.jsp"%>
</body>
</html>
