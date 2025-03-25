package com.cerd7.matchmaking.service.imp;

import com.cerd7.matchmaking.models.Player;
import com.cerd7.matchmaking.models.PlayerStatus;
import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.MatchService;

public class MatchServiceImp implements MatchService
{
    private final PlayerRepository playerRepository = new PlayerRepository();

    @Override
    public void createPayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory)
    {
        Player player = new Player();
        PlayerStatus playerStatus = new PlayerStatus();

        player.setNickname(name);
        player.setCountry(country);
        player.setInQueue(inQueue);

        playerStatus.setVictory(victory);
        playerStatus.setQtyGamePlayed(gamePlayed);
        playerStatus.setWinRate(calculateWinRate(gamePlayed, victory));
        playerStatus.setElo(calculateElo(gamePlayed, victory));

        player.setPlayerStatus(playerStatus);

        playerRepository.addPlayers(player);
    }

    @Override
    public String calculateElo(Integer victory, Integer gamePlayed)
    {
        String elo;
        System.out.println("victory: " + victory);
        System.out.println("gamePlayed: " + gamePlayed);
        int defeat = victory - gamePlayed;

        System.out.println("Defeat: " + defeat);
        int scorePlayer = ((victory * 5) - (defeat * 5));

        if(scorePlayer <= 10)
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
        Double winRate;
        int defeat = victory - gamePlayed;
        return gamePlayed == 0 ? 0.0 : (victory.doubleValue() / gamePlayed) * 100;
    }
}
