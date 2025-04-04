package com.cerd7.matchmaking.crontoller;

import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.imp.MatchServiceImp;

import java.util.Scanner;

public class MatchController
{
    private final PlayerRepository playerRepository =  new PlayerRepository();
    private final MatchServiceImp matchServiceIMP = new MatchServiceImp();
    private final Scanner sc = new Scanner(System.in);

    public void startInteraction() {
        int input;
        System.out.print("\u001b[1;32m");
        System.out.println(
                """
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠉⠐⠙⠦⠉⠀⠀⠠⢀⠀⠀⠠⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                          ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣥⢭⡍⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠠⠐⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠄⢀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣋⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠆⡄⢐⡀⢀⠀⠀⠀⠀⡀⠀⠀⠀⠢⠂⡀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⠳⠦⡀⠀⠀⠀⢀⠀⠀⠀⣠⢢⠃⠀⠘⣦⣄⢄⠐⡀⢠⠀⠐⣦⠀⠀⠀⠐⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠈⠀⠀⠀⡏⢀⣜⡜⠁⠘⠐⠀⠀⠈⠳⡀⠡⠤⢠⣵⡄⢹⣧⡄⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣖⣢⣼⣇⣞⢼⡃⠤⠴⢖⡄⠀⢠⡨⠂⠉⠀⠀⠈⠹⡾⠿⣷⣧⡀⠀⠀⣨⣽⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠁⠀⠀⠀⠀⠈⣿⣿⣃⠀⠀⠀⠀⠀⢠⢗⢚⢿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠏⣄⠀⠀⢀⡀⡴⠚⠉⠘⣧⣶⣤⣶⣾⠟⡀⠀⣸⣿⣷⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣞⠀⠝⠻⠿⠿⠛⠁⠀⠀⠀⠀⠉⠉⠁⠀⠀⣠⣾⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣮⡄⠀⠀⢀⠀⠀⠀⡀⠀⠀⠀⠀⠀⣼⣿⣿⢿⠿⠿⠿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⢀⡄⠈⠉⠁⠈⠈⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⢤⣀⡤⠖⠁⠁⠰⠶⠊⠀⠀⠀⠀⠀⡆⠀⠐⣽⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣿⣭⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⣿⣿⣿⣿⣇⡇⠀⠀⠀⠀⠀⠈⠀⠀⠀⣄⣤⣤⣀⡠⣩⣼⣾⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⡻⠿⣏⢿⣿⢿⣿⣿⣾⣿⣿⣿⣿⡐⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠀⠀⠀⠀⠀⠀⠀⠈⠠⠾⠛⠋⠉⠉⡟⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣭⣭⣥⣤⣧⣿⠯⠅⠛⠉⠘⣿⣿⣇⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⠠⠀⠀⠀⠀⠈⠍⠙⠛⠛⠛⠿⠿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⢉⠭⠙⠉⠁⠀⠀⠀⠀⠀⠀⣿⣿⣭⡆⠀⠐⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠁⢀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠄⠂⠀⠀               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠀⠀⠀⠄⡀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⢀⠐⠀⠀⠀⠀⠀⠀⠠⠀⠀⢀⠀⠀⠀⠀⠀⡠⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⡀⠊⠀⠀⠀⠀⠀               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠀⠀⠀⠀⠀⠀⢄⢀⠀⠄⣂⣨⣿⣿⣿⡇⡂⠀⠀⠀⠀⠀⠀⠤⠀⡠⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢀⠀⣀⠀⠊⠀⠀⠀⠀⠀⠀⠀               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠀⠀⠀⠀⠀⠀⠀⠈⠒⠾⣟⠉⢸⣿⣿⣿⡄⡈⠀⠀⠀⠀⡐⠐⠐⠒⠒⠂⠀⠨⡀⠀⠀⠀⠀⠈⠀⠀⡀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠚⢿⣿⣿⣿⠀⠀⠀⠠⠀⡀⠀⠀⠀⠄⠀⠀⠁⡀⠀⠀⠀⡀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣶⢸               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⣶⣿⡷⡒⢠⠄⢀⠀⠀⠀⠀⠀⠀⠸⣿⣿⡿⠐⠀⠀⠀⠀⠀⠀⠀⠐⡴⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣟⣻⣿⣿⣇               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠋⠁⢰⡇⠀⠀⠀⠀⠈⣶⣶⠀⢤⠀⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⢠⠅⠀⢂⠀⠀⠀⠀⢀⠀⠀⢀⠀⠄⢰⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿               ⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇⌇
                ⠀⠀⢸⡇⠀⠀⠀⠀⠀⣿⣿⠀⢸⣠⣿⣿⣿⣿⡀⠀⠂⠀⠀⠂⠁⠀⠀⠀⠀⠀⠀⠀⠂⠈⠀⢸⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  (☞ ͡° ͜ʖ ͡°)☞ @cerddev\s
                """
        );
        System.out.println(
                """
                        \s
                                     \s
                                      ==== Matchmaking System ====
                        \s"""
        );

       // boolean isRunning = true;
        do {
            System.out.println(
                    """
                                                    OPTIONS:
                             _______________________________________________________
                             1. To create a new file to store players.             \s
                             2. To start generating a match with existing players. \s
                             3. To see all the existing players in the bank.       \s
                             4. To add the same player.                            \s
                            """
            );

            System.out.print("Select an option: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    interactionClearFile();
                    break;
                case 2:
                    playerRepository.createMatches();
                    break;
                case 3:
                    playerRepository.readPlayers();
                    break;
                case 4:
                    interactionCreatePlayer();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while(input >= 5);
    }

    private void interactionCreatePlayer()
    {
        String country = "";
        boolean inQueue = false;
        int gamePlayed = 0;
        int victory = 0;

        System.out.print("\u001b[1;37m");
        System.out.println("Welcome on space for create a new player. Let´s go!");
        System.out.print("Set the name of the player: ");
        String name = sc.next();
        System.out.println();
        System.out.print("""
                        Now you need select which country you player is... \s
                        See the options -> BRA, USA or RUS.
                        """);
        for(int i = 0; i < 1000; i++)
        {
            System.out.print("Set the country player:");
            country = sc.next();
            if(country.equals("BRA") || country.equals("USA") || country.equals("RUS"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid option. Please, try again.");
                i++;
            }
        }
        System.out.println();
        for(int i = 0; i < 1000; i++)
        {
            System.out.print("You player is in queue? (Y/N): ");
            String inQueueValue = sc.next();
            if (inQueueValue.equals("Y")) {
                inQueue = true;
                break;
            } else if (inQueueValue.equals("N")) {
                break;
            } else {
                System.out.println("Invalid option. Please, try again.");
                i++;
            }
        }
        System.out.println();

        for(int i = 0; i < 1000; i++)
        {
            System.out.print("Set the number of games played: ");
            gamePlayed = sc.nextInt();
            if(gamePlayed < 0)
            {
                System.out.print("""
                        The number of matches played cannot be less than zero!
                        Please, try again...
                        """);
                i++;
            }
            else {
                break;
            }
        }
        for(int i = 0; i < 1000; i++)
        {
            System.out.print("Set the number of victories: ");
            victory = sc.nextInt();
            if(gamePlayed < victory)
            {
                System.out.print("""
                        The number victory of wins cannot be greater than the number of matches played!
                        Please, try again...
                        """);
                i++;
            }
            else if(victory < 0)
            {
                System.out.print("""
                        The number of wins must not be below zero!
                        Please, try again...
                        """);
                i++;
            }
            else
            {
                break;
            }
        }

        matchServiceIMP.createPlayer(name,country,inQueue, gamePlayed, victory);
    }

    private void interactionClearFile()
    {
        boolean isRunning = true;
        if(matchServiceIMP.clearFile())
        {
            matchServiceIMP.clearFile();
            do {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("Do you want to add new players to your archive?(Y/N)");
                    String cacheD = sc.next();

                    if (cacheD.equals("Y")) {
                        interactionCreatePlayer();
                        for (int j = 0; j < 1000; j++) {
                            System.out.println("Do you want to add more players? (Y/N)");
                            String cacheS = sc.next();

                            if (cacheS.equals("Y")) {
                                interactionCreatePlayer();
                                j++;
                            } else if (cacheS.equals("N")) {
                                isRunning = false;
                                break;
                            } else {
                                System.out.println("Invalid option. Please, try again.");
                                j++;
                            }
                        }
                    } else if (cacheD.equals("N")) {
                        isRunning = false;
                        break;
                    } else {
                        System.out.println("Invalid option. Please, try again.");
                        i++;
                    }
                }
            } while (isRunning);
        }else {
            matchServiceIMP.clearFile();
        }
    }
}
