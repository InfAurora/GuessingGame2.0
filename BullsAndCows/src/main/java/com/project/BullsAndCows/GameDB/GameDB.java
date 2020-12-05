package com.project.BullsAndCows.GameDB;

import com.project.BullsAndCows.Entity.Game;

public interface GameDB {
  public Game addGame(Game game);
  public Game findGameById(int gameId);
  public Game getAllGames();
}
