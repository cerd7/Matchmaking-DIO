package com.cerd7.matchmaking.service.imp;

import com.cerd7.matchmaking.models.Player;
import com.cerd7.matchmaking.models.PlayerStatus;
import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.MatchService;

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
    public void clearFile()
    {
        System.out.print("\u001b[1;31m");
        System.out.println("Cool!! Let's clear up the file... (¬‿¬)");
        System.out.print("\u001b[0m");
        playerRepository.clearFile();

        System.out.println("Now let's start adding your players!");
    }

    @Override
    public String calculateElo(Integer gamePlayed, Integer victory)
    {
        System.out.println("victory: " + victory);
        System.out.println("gamePlayed: " + gamePlayed);

        String elo;
        int scorePlayer;
        int defeat = 19;
        int multiplierDefeat = gamePlayed - victory;

        int win = 23;
        int multiplierVictory = victory;

        if(gamePlayed.equals(victory))
        {
            scorePlayer = (win * multiplierVictory);
        }
        else
        {
            scorePlayer = ((win * multiplierVictory) - (defeat * multiplierDefeat));
        }
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
}
