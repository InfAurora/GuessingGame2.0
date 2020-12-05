package com.project.BullsAndCows.Controller;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.Service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class Controller {

  @Autowired
  GameService service;

  @PostMapping()
  public Game addGame() {
    Game game = service.addGame();

    return game;
  }
  
}
