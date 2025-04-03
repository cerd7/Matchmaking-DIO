package com.cerd7.matchmaking.repository;

import com.cerd7.matchmaking.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    public void clearFile()
    {
        try
        {
            lookingPlayers = objectMapper.readValue(new File(String.valueOf(file)), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));
            objectMapper.writeValue(file, "");
            System.out.println("FILE CLEARED! ˗ˏˋ ✸ ˎˊ˗");
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON: " + e.getMessage(), e);
        }
    }

    public void createPlayers(Player player) {
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
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON: " + e.getMessage(), e);
        }
    }

    public void createMatches() {
        try {
            lookingPlayers = objectMapper.readValue(file, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Player.class));

            List<Player> playersInQueue = lookingPlayers.stream()
                    .filter(Player::getInQueue)
                    .collect(Collectors.toList());

            System.out.println("Players in queue: " + playersInQueue.size());

            if (playersInQueue.isEmpty()) {
                System.out.println("No players in queue. No matches created.");
                return;
            }

            playersInQueue.sort(
                    Comparator.comparing(Player::getCountry)
                            .thenComparing((Player p) -> p.getPlayerStatus().getWinRate(), Comparator.reverseOrder())
            );

            List<List<Player>> matches = new ArrayList<>();

            while (playersInQueue.size() >= 2) {
                Player p1 = playersInQueue.remove(0);

                Optional<Player> opponent = playersInQueue.stream()
                        .filter(p -> p.getCountry().equals(p1.getCountry()))
                        .findFirst();

                if (opponent.isPresent()) {
                    Player p2 = opponent.get();
                    playersInQueue.remove(p2);
                    matches.add(Arrays.asList(p1, p2));
                    System.out.println("Match created: " + p1.getNickname() + " -- Elo: " + p1.getPlayerStatus().getElo() +
                            " vs " + p2.getNickname() + " -- Elo: " + p2.getPlayerStatus().getElo() +
                            " (Country: " + p1.getCountry() + ")");
                } else {
                    System.out.println("No match found for: " + p1.getNickname() + " (Country: " + p1.getCountry() + ")");
                }
            }

            if (!playersInQueue.isEmpty()) {
                System.out.println("Player not matched: " + playersInQueue.get(0).getNickname());
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON: " + e.getMessage(), e);
        }
    }
}
