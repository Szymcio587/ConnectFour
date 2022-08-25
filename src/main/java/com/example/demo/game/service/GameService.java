package com.example.demo.game.service;

import com.example.demo.game.exceptions.NotFoundException;
import com.example.demo.game.exceptions.InvalidGameException;
import com.example.demo.game.exceptions.InvalidParameterException;
import com.example.demo.game.models.*;
import com.example.demo.game.storage.GameStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    public Game CreateGame(Player player) {
        Game game = new Game();
        game.setBoard(new int[6][7]);
        game.setGameID(UUID.randomUUID().toString());
        game.setPlayer1(player);
        game.setStatus(GameStatus.NEW);
        GameStorage.getInstance().setGame(game);
        return game;
    }

    public Game ConnectToGame(Player player2, String gameID) throws InvalidGameException, InvalidParameterException{
        if(!GameStorage.getInstance().getGames().containsKey(gameID))
            throw new InvalidGameException("Dame with provided ID does not exist");

        Game game = GameStorage.getInstance().getGames().get(gameID);

        if(game.getPlayer2() != null) {
            throw new InvalidParameterException("Game is not valid anymore");
        }

        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        GameStorage.getInstance().setGame(game);
        return game;
    }
    public Game ConnectToRandomGame(Player player) {
        Optional<Game> game = GameStorage.getInstance().getGames()
                .values().stream().filter(it -> it.getStatus().equals(GameStatus.NEW)).findFirst();

        if(game.isPresent()) {
            game.get().setPlayer2(player);
            game.get().setStatus(GameStatus.IN_PROGRESS);
            GameStorage.getInstance().setGame(game.get());
            return game.get();
        }
        else
            return CreateGame(player);

    }

    public Game GamePlay(GamePlay gamePlay) throws NotFoundException, InvalidGameException {
        if(!GameStorage.getInstance().getGames().containsKey(gamePlay.getGameID()))
            throw new NotFoundException("Game not found");

        Game game = GameStorage.getInstance().getGames().get(gamePlay.getGameID());
        if(game.getStatus().equals(GameStatus.FINISHED))
            throw new InvalidGameException("Game not found");

        int [][] board = game.getBoard();

        board[gamePlay.getCoordinateX()][gamePlay.getCoordinateY()] = gamePlay.getType().getValue();

        int isWinner = checkWinner(game.getBoard());

        if(isWinner == Color.RED.getValue())
            game.setWinner(Color.RED);
        if(isWinner == Color.BLUE.getValue())
            game.setWinner(Color.BLUE);

        GameStorage.getInstance().setGame(game);

        return game;
    }

    private int checkWinner(int[][] board) {
        int[] boardArray = new int[board.length * board[0].length];
        for(int q=0; q< board.length; q++)
            for(int w=0; w<board[0].length; w++)
                boardArray[q * board.length + w] = board[q][w];

        for(int q=0; q<((board.length - 3) * board[0].length); q++) {
            if( (boardArray[q] == boardArray[q+board[0].length] && boardArray[q] == boardArray[q+2*board[0].length] && boardArray[q] == boardArray[q+3*board[0].length]) ||
                    (boardArray[q] == boardArray[q+board[0].length-1] && boardArray[q] == boardArray[q+2*(board[0].length-1)] && boardArray[q] == boardArray[q+3*(board[0].length-1)] &&
                            q%board[0].length != 0 && (q+board[0].length-1)%board[0].length != 0 && (q+2*(board[0].length-1))%board[0].length != 0)) {
                if(boardArray[q] == Color.RED.getValue()) return Color.RED.getValue();
                if(boardArray[q] == Color.BLUE.getValue()) return Color.BLUE.getValue();
            }
        }

        for(int q=0; q<((board.length - 3) * board[0].length - 3); q++) {
            if(boardArray[q] == boardArray[q+board[0].length+1] && boardArray[q] == boardArray[q+2*(board[0].length+1)] && boardArray[q] == boardArray[q+3*(board[0].length+1)] &&
            q%board[0].length != (board[0].length-1) && (q+board[0].length+1)%board[0].length != (board[0].length-1) && (q+2*(board[0].length+1))%board[0].length != (board[0].length-1)) {
                if(boardArray[q] == Color.RED.getValue()) return Color.RED.getValue();
                if(boardArray[q] == Color.BLUE.getValue()) return Color.BLUE.getValue();
            }
        }
        return 0;
    }
}
