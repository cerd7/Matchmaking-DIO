package com.cerd7.matchmaking.main;

import com.cerd7.matchmaking.service.MatchMaker;
import com.cerd7.matchmaking.models.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        //Add player on queue
        List<Player> queue = new ArrayList<>();
        queue.add(new Player("1111", "Juninho27",0, 10, 2));
        queue.add(new Player("2222", "BrunoBalaTensa", 0, 10, 4));
        queue.add(new Player("3333", "JoaoReiDuGado", 0, 10, 5));
        queue.add(new Player("4444", "TropaDoInguica", 0, 10, 3));
        queue.add(new Player("5555", "Cerd7", 0, 10, 10));

        //Create list for store matches - list matches go store the player is wait on queue.
        MatchMaker matchMaker = new MatchMaker();
        List<List<Player>> matches = matchMaker.createMatches(queue);

        //Show results of party
        for (int i = 0; i < matches.size(); i++)
        {
            System.out.println("Match " + (i + 1) + ":");
            for (Player player : matches.get(i)) {
                System.out.println(" - " + player.getNickname() + " | Score: " + player.getSkillLevel());
            }
        }
    }
}