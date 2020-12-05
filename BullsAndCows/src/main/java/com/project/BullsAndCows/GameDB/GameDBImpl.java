package com.project.BullsAndCows.GameDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.BullsAndCows.Entity.Game;

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

  @Override
  public Game findGameById(int gameId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Game getAllGames() {
    // TODO Auto-generated method stub
    return null;
  }

  private static final class GameMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("id"));
        game.setAnswer(rs.getString("answer"));
        game.setStatus(rs.getBoolean("status"));
      return game;
    }

  }
  
}
