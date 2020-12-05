package com.project.BullsAndCows.Service;

import java.util.Random;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.GameDB.GameDB;
import com.project.BullsAndCows.RoundDB.RoundDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  GameDB gameDB;
  RoundDB roundDB;
  
  public Game addGame() {
    Game game = new Game();
    game.setStatus(false);
    game.setAnswer(answerGenerator());
    return gameDB.addGame(game);
  }

  private String answerGenerator() {
    Random rng = new Random();
    String answer = "";

    while (answer.length() != 4) {
      int number = rng.nextInt(10);

      if (!answer.contains(String.valueOf(number))) {
        answer += number;
      }
    }
    
    return answer;
  }
}
