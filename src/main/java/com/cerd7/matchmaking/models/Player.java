package com.cerd7.matchmaking.models;

public class Player {
    /*-- player info: --*/
    Integer skillLevel;
    Integer gamePlayed;
    Integer victory;

    /*-- Object player --*/
    public Player(Integer skillLevel, Integer gamePlayed, Integer victory)
    {
        this.skillLevel = skillLevel;
        this.gamePlayed = gamePlayed;
        this.victory = victory;
    }

    /*-- Getters and setters --*/
    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Integer getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(Integer gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    public Integer getVictory() {
        return victory;
    }

    public void setVictory(Integer victory) {
        this.victory = victory;
    }
}
