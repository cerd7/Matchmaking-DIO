package com.cerd7.matchmaking.service;

import com.cerd7.matchmaking.models.Player;

public interface MatchService
{
    void createPayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory);

    String calculateElo(Integer victory, Integer gamePlayed);

    public Double calculateWinRate(Integer gamePlayed, Integer victory);
}
   /*
    //----> calculate score player <----\\
    private void calculateScore(Player player)
    {
        int gamePlayed = player.getGamePlayed();
        int victory = player.getVictory();
        int defeat = gamePlayed - victory;

        int scorePlayer = (victory * 10) - (defeat * 5);

        player.setSkillLevel(scorePlayer);
    }

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
