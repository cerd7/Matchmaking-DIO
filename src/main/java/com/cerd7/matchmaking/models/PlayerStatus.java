package com.cerd7.matchmaking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatus
{
    private Double winRate;
    private Integer QtyGamePlayed;
    private Integer victory;
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
        return QtyGamePlayed;
    }

    public void setQtyGamePlayed(Integer qtyGamePlayed) {
        QtyGamePlayed = qtyGamePlayed;
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
