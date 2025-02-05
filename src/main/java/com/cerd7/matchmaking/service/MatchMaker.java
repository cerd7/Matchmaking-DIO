package com.cerd7.matchmaking.service;

import com.cerd7.matchmaking.models.Player;
import java.util.ArrayList;
import java.util.List;

public class MatchMaker
{
    //calculate score player
    private void calculateScore(Player player)
    {
        int gamePlayed = player.getIgamePlayed();
        int victory = player.getIvictory();
        int defeat = gamePlayed - victory;

        int scorePlayer = (victory * 10) - (defeat * 5);

        player.setiskillLevel(scorePlayer);
    }

    public List<List<Player>> createMatches(List<Player> queue)
    {
        for(Player player: queue)
        {
            calculateScore(player);
        }

        queue.sort((p1, p2) -> Integer.compare(p2.getSkillLevel(), p1.getSkillLevel()));

        List<List<Player>> matches = new ArrayList<>();

        while (queue.size() >= 2)
        {
            List<Player> match = new ArrayList<>(queue.subList(0, 2));
            matches.add(match);
            queue.subList(0, 2).clear();
        }
        return matches;
    }
}
