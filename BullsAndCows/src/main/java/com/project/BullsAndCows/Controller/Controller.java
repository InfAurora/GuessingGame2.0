package com.project.BullsAndCows.Controller;

import java.util.List;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.Entity.Round;
import com.project.BullsAndCows.Service.BullCowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class Controller {

  @Autowired
  BullCowService service;

  @PostMapping()
  public Game addGame() {
    Game game = service.addGame();

    return game;
  }

  @PostMapping("/play/{gameId}/{guess}")
  public Round playGame(@PathVariable int gameId, @PathVariable String guess) {
    Round round = service.playGame(gameId, guess);
    return round;
  }

  @GetMapping("{gameId}")
  public Game playGame(@PathVariable int gameId) {
    Game game = service.findGameById(gameId);
    return game;
  }

  @GetMapping()
  public List<Game> playGame() {
    List<Game> games = service.getAllGames();
    return games;
  }
  
}
