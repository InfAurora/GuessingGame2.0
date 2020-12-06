package com.project.BullsAndCows.RoundDB;

import com.project.BullsAndCows.Entity.Round;

public interface RoundDB {
  public Round addRound(int gameId, Round round);
  public Round getAllRounds();
}
