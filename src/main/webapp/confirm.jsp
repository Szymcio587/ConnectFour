<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie</title>
    <%@include file="segments/sheets.jsp"%>
</head>
<body>
<%@include file="segments/header.jsp"%>
<div class="menu">
    <h3>Registration succeded!</h3>
    <p id="congrats">Click button below to log in to your new account</p>
    <input type="button" id="confirm" value="Log in"/></br>
    <script type="text/javascript">
        document.getElementById("confirm").onclick = function () {
            location.href = "login.jsp";
        };
    </script>
</div>

<%@include file="segments/footer.jsp"%>
</body>
</html>
