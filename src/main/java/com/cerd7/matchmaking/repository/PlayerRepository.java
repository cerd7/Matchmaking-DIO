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

    public void readPlayers(/*int input*/) {
        try {
            lookingPlayers = objectMapper.readValue(new File(String.valueOf(file)), objectMapper.getTypeFactory().constructCollectionType(List.class, Player.class));

            /*switch (input)
            {
                case 1:
                {

                    List<Player> player = new ArrayList<>(lookingPlayers.stream()
                            .filter(pBRA -> pBRA.getPlayerStatus().getElo().equals("BRA"))
                            .toList());
                    Player p = player.remove(0);
                    System.out.print("Players BRA:");
                    System.out.println(p.getNickname() + p.getCountry());

                }
                    break;
                case 2:///ver por pais
                    break;
                case 3:///ver por elo
                    break;
                default:///infos erradas
                    break;
            }*/
            for (Player player : lookingPlayers)
            {
                if (player.getNickname() != null) {
                    System.out.println("USERNAME =>["+player.getNickname()+"]"+" | ELO =>["+player.getPlayerStatus().getElo()+"]");
                }
            }
        } catch (Exception e) {
            System.out.println("players not found " + e.getMessage());
        }
    }

    public void clearFile() {
        try
        {
            if(file.length() > 0)
            {
                objectMapper.writeValue(new File(String.valueOf(file)), Collections.emptyList());
                System.out.println("FILE CLEARED! ˗ˏˋ✸ˎˊ˗");
            }else {
                System.out.println("FILE IS EMPTY!");
            }
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
                    .filter(Player::getInQueue).sorted(Comparator.comparing(Player::getCountry)).collect(Collectors.toList());

            System.out.println("PLAYERS IN QUEUE: " + playersInQueue.size());

            if (playersInQueue.isEmpty()) {
                System.out.println("No players in queue. No matches created.");
                return;
            }

            List<List<Player>> matches = new ArrayList<>();
            List<Player> unmatched = new ArrayList<>();
            Set<String> matchedPlayerNicknames = new HashSet<>();

            while (playersInQueue.size() >= 2)
            {
                Player p1 = playersInQueue.remove(0);

                if (matchedPlayerNicknames.contains(p1.getNickname()))
                {
                    System.out.println("\nSkipping player " + p1.getNickname() + " - already matched in a game");
                    continue;
                }

                List<Player> opponent = new ArrayList<>(playersInQueue.stream()
                        .filter(p -> p.getCountry().equals(p1.getCountry()) && p.getPlayerStatus().getElo().equals(p1.getPlayerStatus().getElo()))
                        .toList());

                if (!opponent.isEmpty())
                {
                    Player p2 = opponent.get(0);
                    playersInQueue.remove(p2);

                    matchedPlayerNicknames.add(p1.getNickname());
                    matchedPlayerNicknames.add(p2.getNickname());

                    matches.add(Arrays.asList(p1, p2));
                    System.out.print("""
                            \nMatch created:\s
                            \s""");
                    System.out.println("USERNAME =>["+p1.getNickname()+"]" + " | ELO =>["+p1.getPlayerStatus().getElo()+"]"+
                            " VS " + "USERNAME =>["+p2.getNickname()+"]"+"| ELO =>[" + p2.getPlayerStatus().getElo()+"]");
                }
                else
                {
                    unmatched.add(p1);
                }

                    //-->> Logic to update the player's paired status to false
                    /*for (Player p : lookingPlayers) {
                        if (unmatched.contains(p)) {
                            p.setInQueue(true);
                        } else if (matches.stream().flatMap(List::stream).anyMatch(matchedPlayer ->
                                matchedPlayer.getNickname().equals(p.getNickname()))) {
                            p.setInQueue(false);
                        }
                    }
                    objectMapper.writeValue(file, lookingPlayers);*/
            }
            if (!unmatched.isEmpty()) {
                System.out.println("\nPlayers returned to queue without matches: " + unmatched.size());
                for (Player p : unmatched) {
                    System.out.println("👾"+p.getNickname()+" -> "+ " COUNTRY =>["+p.getCountry()+"]" +
                            " - ELO =>[" + p.getPlayerStatus().getElo()+"]");
                }
            }
            System.out.println("\nTotal matches created: " + matches.size());
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON: " + e.getMessage(), e);
        }
    }
}
