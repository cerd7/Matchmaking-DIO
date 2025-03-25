package com.cerd7.matchmaking.service;

import com.cerd7.matchmaking.models.Player;

import java.util.List;

public interface MatchService
{
    void createPlayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory);

    String calculateElo(Integer gamePlayed, Integer victory);

    Double calculateWinRate(Integer gamePlayed, Integer victory);

    List<List<Player>> createMatches();
}
/*
    //----> create match <----\\
    public List<List<Player>> createMatches(List<Player> queue)
    {
        for(Player player: queue)
        {
            calculateScore(player);
        }

        queue.sort((p1, p2) -> Integer.compare(p2.getSkillLevel(), p1.getSkillLevel()));

        List<List<Player>> matches = new ArrayList<>();

        while (!queue.isEmpty())
        {
            List<Player> match = new ArrayList<>(queue.subList(0, 1));
            matches.add(match);
            queue.subList(0, 1).clear();
        }
        return matches;
    }*/
