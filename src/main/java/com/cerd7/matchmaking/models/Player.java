package com.cerd7.matchmaking.models;

public class Player {
    //player info:
    final private String sId;
    private int iSkillLevel;
    final private String sNickname;
    final private int iGamePlayed;
    final private int iVictory;

    //Object player
    public Player(String sId, String sNickname, int iSkillLevel, int iGamePlayed, int iVictory) {
        this.sId = sId;
        this.sNickname = sNickname;
        this.iSkillLevel = iSkillLevel;
        this.iGamePlayed = iGamePlayed;
        this.iVictory = iVictory;
    }
    //Getters and setters
    public int getIgamePlayed()
    {
        return iGamePlayed;
    }

    public int getIvictory()
    {
        return iVictory;
    }

    public String getId() {
        return sId;
    }

    public String getNickname() {
        return sNickname;
    }

    public int getSkillLevel() {
        return iSkillLevel;
    }

    public void setiskillLevel(int iSkillLevel)
    {
        this.iSkillLevel = iSkillLevel;
    }
}
