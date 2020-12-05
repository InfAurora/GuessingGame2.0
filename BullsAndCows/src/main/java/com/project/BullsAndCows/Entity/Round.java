package com.project.BullsAndCows.Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Round {
  private int roundId;
  private int partialCount;
  private int exactCount;
  private String guess;
  private LocalDate timePlayed;
  private Game game;


  public Round() {
  }

  public Round(int roundId, int partialCount, int exactCount, String guess, LocalDate timePlayed, Game game) {
    this.roundId = roundId;
    this.partialCount = partialCount;
    this.exactCount = exactCount;
    this.guess = guess;
    this.timePlayed = timePlayed;
    this.game = game;
  }

  public int getRoundId() {
    return this.roundId;
  }

  public void setRoundId(int roundId) {
    this.roundId = roundId;
  }

  public int getPartialCount() {
    return this.partialCount;
  }

  public void setPartialCount(int partialCount) {
    this.partialCount = partialCount;
  }

  public int getExactCount() {
    return this.exactCount;
  }

  public void setExactCount(int exactCount) {
    this.exactCount = exactCount;
  }

  public String getGuess() {
    return this.guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }

  public LocalDate getTimePlayed() {
    return this.timePlayed;
  }

  public void setTimePlayed(LocalDate timePlayed) {
    this.timePlayed = timePlayed;
  }

  public Game getGame() {
    return this.game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public Round roundId(int roundId) {
    this.roundId = roundId;
    return this;
  }

  public Round partialCount(int partialCount) {
    this.partialCount = partialCount;
    return this;
  }

  public Round exactCount(int exactCount) {
    this.exactCount = exactCount;
    return this;
  }

  public Round guess(String guess) {
    this.guess = guess;
    return this;
  }

  public Round timePlayed(LocalDate timePlayed) {
    this.timePlayed = timePlayed;
    return this;
  }

  public Round game(Game game) {
    this.game = game;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Round)) {
            return false;
        }
        Round round = (Round) o;
        return roundId == round.roundId && partialCount == round.partialCount && exactCount == round.exactCount && Objects.equals(guess, round.guess) && Objects.equals(timePlayed, round.timePlayed) && Objects.equals(game, round.game);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roundId, partialCount, exactCount, guess, timePlayed, game);
  }

  @Override
  public String toString() {
    return "{" +
      " roundId='" + getRoundId() + "'" +
      ", partialCount='" + getPartialCount() + "'" +
      ", exactCount='" + getExactCount() + "'" +
      ", guess='" + getGuess() + "'" +
      ", timePlayed='" + getTimePlayed() + "'" +
      ", game='" + getGame() + "'" +
      "}";
  }

}
