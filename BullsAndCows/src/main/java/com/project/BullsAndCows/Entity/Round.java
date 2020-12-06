package com.project.BullsAndCows.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Round {
  private int roundId;
  private int partialCount;
  private int exactCount;
  private String guess;
  private LocalDateTime  timePlayed;


  public Round() {
  }

  public Round(int roundId, int partialCount, int exactCount, String guess, LocalDateTime timePlayed) {
    this.roundId = roundId;
    this.partialCount = partialCount;
    this.exactCount = exactCount;
    this.guess = guess;
    this.timePlayed = timePlayed;
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

  public LocalDateTime getTimePlayed() {
    return this.timePlayed;
  }

  public void setTimePlayed(LocalDateTime timePlayed) {
    this.timePlayed = timePlayed;
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

  public Round timePlayed(LocalDateTime timePlayed) {
    this.timePlayed = timePlayed;
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
        return roundId == round.roundId && partialCount == round.partialCount && exactCount == round.exactCount && Objects.equals(guess, round.guess) && Objects.equals(timePlayed, round.timePlayed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roundId, partialCount, exactCount, guess, timePlayed);
  }

  @Override
  public String toString() {
    return "{" +
      " roundId='" + getRoundId() + "'" +
      ", partialCount='" + getPartialCount() + "'" +
      ", exactCount='" + getExactCount() + "'" +
      ", guess='" + getGuess() + "'" +
      ", timePlayed='" + getTimePlayed() + "'" +
      "}";
  }
}
