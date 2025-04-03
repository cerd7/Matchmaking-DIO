package com.cerd7.matchmaking.service;

public interface MatchService
{
    void createPlayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory);

    void clearFile();

    String calculateElo(Integer gamePlayed, Integer victory);

    Double calculateWinRate(Integer gamePlayed, Integer victory);
}