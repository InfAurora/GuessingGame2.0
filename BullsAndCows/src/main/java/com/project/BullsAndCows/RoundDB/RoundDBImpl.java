package com.project.BullsAndCows.RoundDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.project.BullsAndCows.Entity.Game;
import com.project.BullsAndCows.Entity.Round;
import com.project.BullsAndCows.GameDB.GameDBImpl.GameMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoundDBImpl implements RoundDB {

  @Autowired
  JdbcTemplate jdbc;

  @Override
  @Transactional
  public Round addRound(int gameId, Round round) {
    Game game = getGameForRound(gameId);
    final String ADD_ROUND = "Insert Into Round(partialCount, exactCount, guess, timePlayed, gameId) Values(?,?,?,?,?)";
    jdbc.update(ADD_ROUND, round.getPartialCount(), round.getExactCount(), round.getGuess(),
        Timestamp.valueOf(round.getTimePlayed()), game.getGameId());

    final String FIND_LAST_ID = "Select LAST_INSERT_ID()";
    int newId = jdbc.queryForObject(FIND_LAST_ID, Integer.class);
    round.setRoundId(newId);
    return round;
  }

  @Override
  public Round getAllRounds() {
    // TODO Auto-generated method stub
    return null;
  }

  private Game getGameForRound(int gameId) {
    final String FIND_GAME_BY_ID = "Select * From Game Where id = ?";
    return jdbc.queryForObject(FIND_GAME_BY_ID, new GameMapper(), gameId);
  }

  public static final class RoundMapper implements RowMapper<Round> {

    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
      Round round = new Round();
      round.setRoundId(rs.getInt("id"));
      round.setPartialCount(rs.getInt("PartialCount"));
      round.setExactCount(rs.getInt("ExactCount"));
      round.setGuess(rs.getString("Guess"));
      round.setTimePlayed(rs.getTimestamp("TimePlayed").toLocalDateTime());
      return round;
    }

  }
}
