package com.project.BullsAndCows.RoundDB;

import com.project.BullsAndCows.Entity.Round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoundDBImpl implements RoundDB {

  @Autowired
  JdbcTemplate jdbc;

  @Override
  public Round addRound(int gameId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Round getAllRounds() {
    // TODO Auto-generated method stub
    return null;
  }
}
