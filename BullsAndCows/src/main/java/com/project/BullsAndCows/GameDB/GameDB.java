package com.project.BullsAndCows.GameDB;

import java.util.List;

import com.project.BullsAndCows.Entity.Game;

public interface GameDB {
  public Game addGame(Game game);
  public Game findGameById(int gameId);
  public List<Game> getAllGames();
  public void updateStatus(Game game);
}
