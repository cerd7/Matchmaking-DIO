package com.cerd7.matchmaking.crontoller;

import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.imp.MatchServiceImp;

public class MatchController
{
    private final PlayerRepository playerRepository =  new PlayerRepository();
    private final MatchServiceImp matchServiceIMP = new MatchServiceImp();

    public void createPayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory)
    {
        matchServiceIMP.createPlayer(name,country,inQueue, gamePlayed, victory);
    }
}
