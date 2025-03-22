package com.cerd7.matchmaking.repository;

import com.cerd7.matchmaking.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private final File file = new File("src/main/resources/players.json");
    private List<Player> lookingPlayers;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void readPlayers() {
        try {
            lookingPlayers = objectMapper.readValue(new File(String.valueOf(file)), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
            for (Player player : lookingPlayers) {
                if (player.getNickname() != null) {
                    System.out.println("Player name is: " + player.getNickname() + "elo: " + player.getPlayerStatus().getElo());
                }
            }
        } catch (Exception e) {
            System.out.println("players not found " + e.getMessage());
        }
    }

    public void addPlayers(Player player) {
        try {
            if (file.exists() && file.length() > 0) {
                lookingPlayers = objectMapper.readValue(new File(String.valueOf(file)), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));

                lookingPlayers.add(player);
                objectMapper.writeValue(file, lookingPlayers);
                System.out.println("New Player add");
            }
            else
            {
                lookingPlayers = new ArrayList<>();
                lookingPlayers.add(player);
                objectMapper.writeValue(file, lookingPlayers);
                System.out.println("New file created and user added.");
            }
        } catch (Exception e) {
            System.out.println("player don't add " + e.getMessage());
        }
    }
}
