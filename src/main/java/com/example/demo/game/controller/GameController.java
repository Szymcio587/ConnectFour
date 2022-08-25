package com.example.demo.game.controller;

import com.example.demo.game.exceptions.InvalidGameException;
import com.example.demo.game.exceptions.NotFoundException;
import com.example.demo.game.controller.dto.ConnectRequest;
import com.example.demo.game.models.GamePlay;
import com.example.demo.game.service.GameService;
import com.example.demo.game.models.Game;
import com.example.demo.game.models.Player;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/start")
    public ResponseEntity<Game> Start(@RequestBody Player player) {
        log.info("Start game request: {}", player);
        return ResponseEntity.ok(gameService.CreateGame(player));
    }

    @PostMapping("/connect/random")
    public ResponseEntity<Game> ConnectRandom(@RequestBody Player player) {
        log.info("Connecting to the random game: {}", player);
        return ResponseEntity.ok(gameService.ConnectToRandomGame(player));
    }

    @PostMapping("/connect")
    public ResponseEntity<Game> Connect(@RequestBody ConnectRequest request) {
        log.info("Connecting to the chosen game: {}", request);
        return ResponseEntity.ok(gameService.ConnectToRandomGame(request.getPlayer()));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> GamePlay(@RequestBody GamePlay request) throws NotFoundException, InvalidGameException {
        log.info("GamePlay: {}", request);
        Game game = gameService.GamePlay(request);
        simpMessagingTemplate.convertAndSend("/topic/game-progress" + game.getGameID(), game);
        return ResponseEntity.ok(game);
    }
}
