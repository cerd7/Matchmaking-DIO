package com.cerd7.matchmaking;

import com.cerd7.matchmaking.crontoller.MatchController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MatchController matchController = new MatchController();

        System.out.println("name");
        String name = sc.next();
        System.out.println("Pais");
        String pais = sc.next();
        System.out.println("inQueue");
        boolean intQueue = true;

        Integer gamePlayed = sc.nextInt();
        Integer victory = sc.nextInt();

        matchController.createPayer(name, pais, intQueue, victory, gamePlayed);
    }
 }
        //----> Add player on queue <----\\

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
