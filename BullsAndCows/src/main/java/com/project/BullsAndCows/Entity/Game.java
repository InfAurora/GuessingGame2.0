package com.project.BullsAndCows.Entity;

import java.util.Objects;

public class Game {
  private int gameId;
  private String answer;
  private boolean status;
  

  public Game() {
  }

  public Game(int gameId, String answer, boolean status) {
    this.gameId = gameId;
    this.answer = answer;
    this.status = status;
  }

  public int getGameId() {
    return this.gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }

  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public boolean isStatus() {
    return this.status;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Game gameId(int gameId) {
    this.gameId = gameId;
    return this;
  }

  public Game answer(String answer) {
    this.answer = answer;
    return this;
  }

  public Game status(boolean status) {
    this.status = status;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return gameId == game.gameId && Objects.equals(answer, game.answer) && status == game.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameId, answer, status);
  }

  @Override
  public String toString() {
    return "{" +
      " gameId='" + getGameId() + "'" +
      ", answer='" + getAnswer() + "'" +
      ", status='" + isStatus() + "'" +
      "}";
  }
}
