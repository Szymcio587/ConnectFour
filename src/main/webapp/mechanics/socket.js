
const url = "http://localhost:8080";
let stompClient;
let gameID;
let playerType;

function ConnectToSocket(gameID) {
    console.log("Connecting to the game...");
    let Socket = new SockJS(url + "/gameplay");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log("Connected to the frame: " + frame);
        stompClient.subscribe("/topic/game-progress" + gameID, function(response) {
            let data = JSON.parse(response.body);
            console.log(data);
            displayResponse(data);
        });
    })
}

function CreateGame() {
    let login = document.getElementById("username").value();
    $.ajax({
        url: url + "/game/start",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "login": login
        }),

        success: function(data) {
            gameID = data.gameID;
            playerType = "RED";
            reset();
            ConnectToSocket(gameID);
            alert("You created a game. Your game ID is: " + data.gameID);
            gameOn = true;
        },

        error: function(error) {
            console.log(error);
        }
    })

}

function ConnectToRandom() {
        $.ajax({
            url: url + "/game/connect",
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                "gameID": gameID
            }),

            success: function(data) {
                gameID = data.gameID;
                playerType = "BLUE";
                reset();
                ConnectToSocket(gameID);
                alert("You succesfully joined a game");
            },

            error: function(error) {
                console.log(error);
            }
        })

}

function ConnectToChosen() {
    $.ajax({
        url: url + "/game/connect/random",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",

        success: function(data) {
            gameID = data.gameID;
            playerType = "BLUE";
            reset();
            ConnectToSocket(gameID);
            alert("You succesfully joined a game");
        },

        error: function(error) {
            console.log(error);
        }
    })
}