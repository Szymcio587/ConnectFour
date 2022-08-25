package com.example.demo.game.storage;

import com.example.demo.game.models.Game;
import java.util.Map;
import java.util.HashMap;

public class GameStorage {

    private static Map<String, Game> games;
    private static GameStorage instance;

    private GameStorage() {
        games = new HashMap<String, Game>();
    }

    public static synchronized GameStorage getInstance() {
        if(instance==null)
            instance = new GameStorage();
        return instance;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGame(Game game) {
        games.put(game.getGameID(), game);
    }
}
