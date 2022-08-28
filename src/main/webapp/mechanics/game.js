    var turns = [[0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0]];
    var computerTurn = "";
    var turn = "";
    var gameOn = false;
    var count = 0;

    function playerTurn (turn, id){
        if(gameON) {
            var spotTaken = $("#"+id).text();
            if (spotTaken === 0){
                MakeAMove();
            }
        }
        else {

        }

    }

    function MakeAMove(type, coordinateX, coordinateY) {
        $.ajax({
            url: url + "/game/gameplay",
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                "type": type,
                "coordinateX": coordinateX,
                "coordinateY": coordinateY,
                "gameID": gameID
            }),

            success: function(data) {
                gameOn = false;
                displayResponse(data);
            },

            error: function(error) {
                console.log(error);
            }
        })
    }

    function displayResponse(data) {
        let board = data.board;

        for(let i=0; i<board.length; i++) {
            for(let j=0; j<board[0].length; j++) {
                if(board[i][j] === 1)
                    turns[i][j] = 1;
                else if(board[i][j] === 2)
                    turns[i][j] = 2;

                let id = i * board.length + j;
                $(id).text(turns[i][j]);
            }
        }

        if(data.winner != null)
            alert("The winner is " + data.winner);

        gameOn = true;
    }

    $(".tic").click(function(){
        var slot = $(this).attr('id');
        playerTurn(turn,slot);
    });

    function reset(){
        turns = [[0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0]];
        $(".tic").text("#");
    }

    $("#reset").click(function(){
        reset();
    });