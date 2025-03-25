package com.cerd7.matchmaking.service.imp;

import com.cerd7.matchmaking.models.Player;
import com.cerd7.matchmaking.models.PlayerStatus;
import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.MatchService;

import java.util.List;

public class MatchServiceImp implements MatchService
{
    private final PlayerRepository playerRepository = new PlayerRepository();

    @Override
    public void createPlayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory)
    {
        Player player = new Player();
        PlayerStatus playerStatus = new PlayerStatus();

        player.setNickname(name);
        player.setCountry(country);
        player.setInQueue(inQueue);

        playerStatus.setVictory(victory);
        playerStatus.setQtyGamePlayed(gamePlayed);
        playerStatus.setWinRate(calculateWinRate(playerStatus.getQtyGamePlayed(), playerStatus.getVictory()));
        playerStatus.setElo(calculateElo(playerStatus.getQtyGamePlayed(), playerStatus.getVictory()));

        player.setPlayerStatus(playerStatus);

        playerRepository.createPlayers(player);
    }

    @Override
    public String calculateElo(Integer gamePlayed, Integer victory)
    {
        String elo;

        System.out.println("victory: " + victory);
        System.out.println("gamePlayed: " + gamePlayed);

        int defeat = gamePlayed - victory;

        System.out.println("Defeat: " + defeat);
        int scorePlayer = ((victory * 2) - (defeat * 2));

        System.out.println("Score: " + scorePlayer);

        if(scorePlayer < 0)
        {
            elo = "Unranked";
        }
        else if(scorePlayer <= 10)
        {
            elo = "Iron";
        }
        else if(scorePlayer <= 20)
        {
            elo = "bronze";
        }
        else if(scorePlayer <= 50)
        {
            elo = "Silver";
        }
        else if(scorePlayer <= 80)
        {
            elo = "Gold";
        }
        else if(scorePlayer <= 90)
        {
            elo = "Diamond";
        }
        else
        {
            elo = "Legendary";
        }
        return elo;
    }

    @Override
    public Double calculateWinRate(Integer gamePlayed, Integer victory) {
        return gamePlayed == 0 ? 0.0 : (victory.doubleValue() / gamePlayed) * 100;
    }

    @Override
    public List<List<Player>> createMatches()
    {

        return List.of();
    }
}
