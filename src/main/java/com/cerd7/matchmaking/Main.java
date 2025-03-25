package com.cerd7.matchmaking;

import com.cerd7.matchmaking.crontoller.MatchController;
import com.cerd7.matchmaking.repository.PlayerRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MatchController matchController = new MatchController();
        PlayerRepository playerRepository = new PlayerRepository();

        System.out.println("name");
        String name = sc.next();
        System.out.println("country");
        String pais = sc.next();
        System.out.println("inQueue = true");
    boolean intQueue = true;
        System.out.println("gamePlayed");
        Integer gamePlayed = sc.nextInt();
        System.out.println("victory");
        Integer victory = sc.nextInt();

        playerRepository.createMatches();
        matchController.createPayer(name, pais, intQueue, gamePlayed, victory);
    }
 }
    /*
        //Create list for store matches - list matches go store the player is wait on queue.
        MatchMaker matchMaker = new MatchMaker();
        List<List<Player>> matches = matchMaker.createMatches(queue);

        //---> Show results of party <---\\
        for (int i = 0; i < matches.size(); i++)
        {
            System.out.println("Match " + (i + 1) + ":");
            for (Player player : matches.get(i)) {
                System.out.println(" - " + player.getNickname() + " | Score: " + player.getSkillLevel());
            }
        }
     */
