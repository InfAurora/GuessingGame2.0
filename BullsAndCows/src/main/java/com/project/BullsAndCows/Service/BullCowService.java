package com.project.BullsAndCows.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.Entity.Round;
import com.project.BullsAndCows.GameDB.GameDB;
import com.project.BullsAndCows.RoundDB.RoundDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BullCowService {

  @Autowired
  GameDB gameDB;

  @Autowired
  RoundDB roundDB;

  public Game addGame() {
    Game game = new Game();
    game.setStatus(false);
    game.setAnswer(answerGenerator());
    game = gameDB.addGame(game);
    game.setAnswer("****");
    return game;
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

  public Round playGame(int gameId, String guess) {
    LocalDateTime dateTime = LocalDateTime.now();
    Game game = gameDB.findGameById(gameId);
    Round round = new Round();
    int[] countArray = counts(gameId, guess);
    round.setPartialCount(countArray[0]);
    round.setExactCount(countArray[1]);
    round.setGuess(guess);
    round.setTimePlayed(dateTime);
    Round addedRound = roundDB.addRound(gameId, round);
    if(game.getStatus() == false) {
      game.setStatus(updateStatus(game, addedRound));
      gameDB.updateStatus(game);
    }

    return addedRound;
  }

  private int[] counts(int gameId, String guess) {
    Game game = gameDB.findGameById(gameId);
    String gameAnswer = game.getAnswer();
    int[] counts = new int[2];
    int exactCounter = 0;
    int partialCounter = 0;
    for (int i = 0; i < guess.length(); i++) {
      boolean isExact = guess.charAt(i) == gameAnswer.charAt(i);
      if (gameAnswer.contains(String.valueOf(guess.charAt(i))) && !isExact) {
        partialCounter++;
        counts[0] = partialCounter;
      } else if (isExact) {
        exactCounter++;
        counts[1] = exactCounter;
        if (partialCounter > 0) {
          partialCounter--;
          counts[0] = partialCounter; 
        }
      }
    }
    return counts;
  }

  private boolean updateStatus(Game game, Round round) {
    if (round.getExactCount() == 4) {
      return true;
    }
    return false;
  }

  public Game findGameById(int gameId) {
    Game game = gameDB.findGameById(gameId);
    if (game.getStatus() == false) {
      game.setAnswer("****");
    }
    return game;
  }

  public List<Game> getAllGames() {
    List<Game> games = gameDB.getAllGames();
    for (Game game : games) {
      if (game.getStatus() == false) {
        game.setAnswer("****");
      }
    }
    return games;
  }
}
