package com.cerd7.matchmaking;

import com.cerd7.matchmaking.crontoller.MatchController;

public class Main {
    public static void main(String[] args)
    {
        MatchController matchController = new MatchController();
        matchController.startInteraction();
    }
 }
