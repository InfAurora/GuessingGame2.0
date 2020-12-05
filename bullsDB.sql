DROP DATABASE IF EXISTS BullsDB;

CREATE DATABASE IF NOT EXISTS BullsDB;

USE BullsDB;

CREATE TABLE Game (
    id int PRIMARY KEY AUTO_INCREMENT,
    Answer char(4) NOT NULL,
    Status tinyint NOT NULL
);

CREATE TABLE Round (
    id int PRIMARY KEY AUTO_INCREMENT,
    PartialCount char(4) NOT NULL,
    ExactCount char(4) NOT NULL,
    Guess char(4) NOT NULL,
    TimePlayed TimeStamp NOT NULL
);