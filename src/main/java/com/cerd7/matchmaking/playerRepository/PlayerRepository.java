package com.cerd7.matchmaking.playerRepository;

import com.cerd7.matchmaking.models.Player;

public class PlayerRepository
{
    private Player player;
    public PlayerRepository(Player player)
    {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
