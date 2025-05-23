package com.cerd7.matchmaking.contoller;

import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.imp.MatchServiceImp;
import java.util.Scanner;

public class MatchController
{
    private final PlayerRepository playerRepository =  new PlayerRepository();
    private final MatchServiceImp matchServiceIMP = new MatchServiceImp();
    private final Scanner sc = new Scanner(System.in);

    public MatchController()
    {
        startInteraction();
    }

    private void startInteraction() {
        int input;
        System.out.print("\u001b[1;31m");
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
                ⠀⠀⢸⡇⠀⠀⠀⠀⠀⣿⣿⠀⢸⣠⣿⣿⣿⣿⡀⠀⠂⠀⠀⠂⠁⠀⠀⠀⠀⠀⠀⠀⠂⠈⠀⢸⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿  (☞ ͡° ͜ʖ ͡°)☞   @cerddev\s
                """
        );
        System.out.print("\u001b[1;0m");
        System.out.println(
                """
                        \s
                                     \s
                                      ==== Matchmaking System ====
                        \s"""
        );

        do {
            System.out.print("\u001b[1;32m");
            System.out.println(
                    """
                                                    OPTIONS:
                             _______________________________________________________
                             1. To clean up the file and add new players.          \s
                             2. To start generating a match with existing players. \s
                             3. To see all existing players.                       \s
                             4. To add a new player. 
                             0. Exit.                              \s
                            """
            );

            System.out.print("Select an option: ");
            input = sc.nextInt();sc.nextLine();
            System.out.print("\u001b[1;0m");

            switch (input) {
                case 1:
                    interactionClearFile();
                    break;
                case 2:
                    playerRepository.createMatches();
                    break;
                case 3:
                    matchServiceIMP.readFileContent();
                    break;
                case 4:
                    interactionCreatePlayer();
                    break;
                case 0:
                    System.out.println("Closing...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while(input != 0);
    }

    private void interactionCreatePlayer()
    {
        String country = "";
        boolean inQueue = false;
        int gamePlayed = 0;
        int victory = 0;

        System.out.println("Welcome on space for create a new player. Let's go!");
        System.out.print("Set the name of the player: ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("""
                        Now you need select which country you player is... \s
                        See the options -> BRA, USA or RUS.
                        """);
        
        while(true)
        {
            System.out.print("Set the country player:");
            country = sc.nextLine();
            if(country.equalsIgnoreCase("BRA") || country.equalsIgnoreCase("USA") || country.equalsIgnoreCase("RUS"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid option. Please, try again.");
            }
        }

        System.out.println();

        while(true)
        {
            System.out.print("Is your player in queue? (Y/N): ");
            String inQueueValue = sc.nextLine();
            if (inQueueValue.equalsIgnoreCase("Y")) {
                inQueue = true;
                break;
            } else if (inQueueValue.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Invalid option. Please, try again.");
            }
        }

        System.out.println();

        while(true)
        {
            System.out.print("Set the number of games played: ");
            gamePlayed = sc.nextInt();sc.nextLine();
            if(gamePlayed < 0)
            {
                System.out.print("""
                        The number of matches played cannot be less than zero!
                        Please, try again...
                        """);
            }
            else {
                break;
            }
        }

        while(true)
        {
            System.out.print("Set the number of victories: ");
            victory = sc.nextInt();sc.nextLine();
            if(gamePlayed < victory)
            {
                System.out.print("""
                        The number victory of wins cannot be greater than the number of matches played!
                        Please, try again...
                        """);
            }
            else if(victory < 0)
            {
                System.out.print("""
                        The number of wins must not be below zero!
                        Please, try again...
                        """);
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
        matchServiceIMP.clearFile();
        while (true) 
        {
            System.out.println("Do you want to add new players to your archive?(Y/N)");
            String cacheD = sc.nextLine();

            if (cacheD.equalsIgnoreCase("Y")) 
            {
                interactionCreatePlayer();
                while (true) {
                    System.out.println("Do you want to add more players? (Y/N)");
                    String cacheS = sc.nextLine();

                    if (cacheS.equalsIgnoreCase("Y")) 
                    {
                        interactionCreatePlayer();
                    } else if (cacheS.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        System.out.println("Invalid option. Please, try again.");
                    }
                }
                break;
            } 
            else if (cacheD.equalsIgnoreCase("N")) 
            {
                break;
            } 
            else 
            {
                System.out.println("Invalid option. Please, try again.");
            }
        }
    }
}
