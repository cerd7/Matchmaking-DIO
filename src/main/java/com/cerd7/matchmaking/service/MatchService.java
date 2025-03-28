package com.cerd7.matchmaking.service;

public interface MatchService
{
    void createPlayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory);

    String calculateElo(Integer gamePlayed, Integer victory);

    Double calculateWinRate(Integer gamePlayed, Integer victory);
}