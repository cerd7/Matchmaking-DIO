package com.cerd7.matchmaking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatus
{

    @JsonProperty("winRate")
    private Double winRate;

    @JsonProperty("qtyGamePlayed")
    private Integer qtyGamePlayed;

    @JsonProperty("victory")
    private Integer victory;

    @JsonProperty("elo")
    private String elo;

    public PlayerStatus()
    {}

    public Double getWinRate() {
        return winRate;
    }

    public void setWinRate(Double winRate) {
        this.winRate = winRate;
    }

    public Integer getQtyGamePlayed() {
        return qtyGamePlayed;
    }

    public void setQtyGamePlayed(Integer qtyGamePlayed) {
        this.qtyGamePlayed = qtyGamePlayed;
    }

    public Integer getVictory() {
        return victory;
    }

    public void setVictory(Integer victory) {
        this.victory = victory;
    }

    public String getElo() {
        return elo;
    }

    public void setElo(String elo) {
        this.elo = elo;
    }
}
