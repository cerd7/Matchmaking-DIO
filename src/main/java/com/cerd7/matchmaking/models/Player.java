package com.cerd7.matchmaking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @JsonProperty("name")
    private String nickname;

    @JsonProperty("country")
    private String country;

    @JsonProperty("inQueue")
    private boolean inQueue;

    @JsonProperty("statusPlayer")
    private PlayerStatus playerStatus;

    public Player()
    {
    }

    public Player(String nickname, String country, boolean inQueue, PlayerStatus playerStatus)
    {
        this.nickname = nickname;
        this.country = country;
        this.inQueue = inQueue;
        this.playerStatus = playerStatus;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getInQueue() {
        return inQueue;
    }

    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
}
