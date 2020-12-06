package com.project.BullsAndCows.GameDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.Entity.Round;
import com.project.BullsAndCows.RoundDB.RoundDBImpl.RoundMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameDBImpl implements GameDB {

  @Autowired
  JdbcTemplate jdbc;

  @Override
  public Game addGame(Game game) {
    final String ADD_GAME = "Insert Into game(answer, status) Values(?,?)";
      jdbc.update(ADD_GAME,
      game.getAnswer(),
      game.getStatus());

    final String FIND_LAST_ID = "Select LAST_INSERT_ID()";
    int gameId = jdbc.queryForObject(FIND_LAST_ID, Integer.class);
    game.setGameId(gameId);
    return game;
  }

  private List<Round> getRoundForGame(int gameId) {
    final String GET_ROUNDS_FOR_GAME = "Select r.* From Round r "
    + "Join Game g On r.GameId = g.id Where r.GameId = ?";

    return jdbc.query(GET_ROUNDS_FOR_GAME, new RoundMapper(), gameId);
  }

  @Override
  public Game findGameById(int gameId) {
    final String FIND_GAME_BY_ID = "Select * From Game Where id = ?";
    Game game = jdbc.queryForObject(FIND_GAME_BY_ID, new GameMapper(), gameId);
    game.setRounds(getRoundForGame(gameId));
    return game;
  }

  @Override
  public List<Game> getAllGames() {
    final String GET_ALL_GAMES = "Select * From Game";
    List<Game> games = jdbc.query(GET_ALL_GAMES, new GameMapper());
    for (Game game : games) {
      game.setRounds(getRoundForGame(game.getGameId()));
    }
    return games;
  }

  @Override
  public void updateStatus(Game game) {
    final String UPDATE_STATUS = "Update Game "
      + "Set status = ? Where id = ?";
      jdbc.update(UPDATE_STATUS, game.getStatus(), game.getGameId());
  }

  public static final class GameMapper implements RowMapper<Game> {

    @Override
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("id"));
        game.setAnswer(rs.getString("answer"));
        game.setStatus(rs.getBoolean("status"));
      return game;
    }

  }
  
}
