<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <%@include file="segments/sheets.jsp"%>
    <link rel="stylesheet" href="styles/menu.css" type="text/css"/>

    <script
            src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
            crossorigin="anonymous"></script>
</head>
<body>
<%@include file="segments/header.jsp"%>
    <div id="user-info">
        <div> Welcome
            <div id="username">${requestScope.username}!</div>
        </div>
        <a href="profile_settings.jsp">Edit your profile here</a><br>
        <a href="login.jsp">Logout</a>
    </div>

    <div id="game">
        <div id="board">

        </div>
        <div id="menu">
            <p><input type="button" class="game" id="start-random" value="Start a random game!" onclick = "ConnectToRandom()"/></p>
            <p><input type="button" class="game" id="invite" value="Invite a friend!" onclick = "CreateGame()"/></p>
            <p><input type="button" class="game" id="join" value="Join the game!" onclick = "ConnectToChosen()"/></p>
            <p><input type="text" class="game" id="ID" placeholder="game ID"/></p>
        </div>
    </div>
<%@include file="segments/footer.jsp"%>
<script src = "mechanics/socket.js"></script>
<script src = "mechanics/game.js"></script>
<script src = "mechanics/load.js"></script>
</body>
</html>
