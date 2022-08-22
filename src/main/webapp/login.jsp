<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona do logowania</title>
    <%@include file="segments/sheets.jsp"%>
</head>
<body>
    <%@include file="segments/header.jsp"%>
    <form method="post" class="menu" action="${pageContext.request.contextPath}/menu.jsp">
        <p id="login-top">Username: <input name="username" type="text"></p>
        <p>Password: <input name="password" type="password"></p>
        <p><input type="submit" value="Log In"/></p>
        <p name="error" id="error"></p>
    </form>
    <%@include file="segments/footer.jsp"%>
</body>
</html>
