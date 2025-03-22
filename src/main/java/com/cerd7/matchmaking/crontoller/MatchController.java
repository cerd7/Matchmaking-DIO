package com.cerd7.matchmaking.crontoller;

import com.cerd7.matchmaking.models.Player;
import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.imp.MatchServiceIMP;


public class MatchController
{
    private final PlayerRepository playerRepository =  new PlayerRepository();
    private MatchServiceIMP matchServiceIMP = new MatchServiceIMP();

    public void createPayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory)
    {
        matchServiceIMP.createPayer(name,country,inQueue, gamePlayed, victory);
    }
}
