package com.cerd7.matchmaking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    @JsonProperty("Name")
    private String nickname;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("In the queue")
    private boolean inQueue;
    @JsonProperty("Status player")
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

    public boolean isInQueue() {
        return inQueue;
    }

    public boolean setInQueue(boolean inQueue) {
        return this.inQueue = inQueue;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }
}
