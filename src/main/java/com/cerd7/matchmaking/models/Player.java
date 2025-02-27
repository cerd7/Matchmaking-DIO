package com.cerd7.matchmaking.models;

public class Player {
    //player info:
    String id;
    Integer skillLevel;
    String nickname;
    Integer gamePlayed;
    Integer victory;

    //Object player
    public Player(String id, String nickname, Integer skillLevel, Integer gamePlayed, Integer victory) {
        this.id = id;
        this.nickname = nickname;
        this.skillLevel = skillLevel;
        this.gamePlayed = gamePlayed;
        this.victory = victory;
    }
    //Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
