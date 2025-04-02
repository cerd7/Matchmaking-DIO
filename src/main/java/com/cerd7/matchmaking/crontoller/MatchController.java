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
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠉⠐⠙⠦⠉⠀⠀⠠⢀⠀⠀⠠⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣥⢭⡍⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠠⠐⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠄⢀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣋⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠆⡄⢐⡀⢀⠀⠀⠀⠀⡀⠀⠀⠀⠢⠂⡀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⠳⠦⡀⠀⠀⠀⢀⠀⠀⠀⣠⢢⠃⠀⠘⣦⣄⢄⠐⡀⢠⠀⠐⣦⠀⠀⠀⠐⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠈⠀⠀⠀⡏⢀⣜⡜⠁⠘⠐⠀⠀⠈⠳⡀⠡⠤⢠⣵⡄⢹⣧⡄⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣖⣢⣼⣇⣞⢼⡃⠤⠴⢖⡄⠀⢠⡨⠂⠉⠀⠀⠈⠹⡾⠿⣷⣧⡀⠀⠀⣨⣽⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠁⠀⠀⠀⠀⠈⣿⣿⣃⠀⠀⠀⠀⠀⢠⢗⢚⢿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠏⣄⠀⠀⢀⡀⡴⠚⠉⠘⣧⣶⣤⣶⣾⠟⡀⠀⣸⣿⣷⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣞⠀⠝⠻⠿⠿⠛⠁⠀⠀⠀⠀⠉⠉⠁⠀⠀⣠⣾⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣮⡄⠀⠀⢀⠀⠀⠀⡀⠀⠀⠀⠀⠀⣼⣿⣿⢿⠿⠿⠿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⢀⡄⠈⠉⠁⠈⠈⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⢤⣀⡤⠖⠁⠁⠰⠶⠊⠀⠀⠀⠀⠀⡆⠀⠐⣽⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣭⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⣿⣿⣿⣿⣇⡇⠀⠀⠀⠀⠀⠈⠀⠀⠀⣄⣤⣤⣀⡠⣩⣼⣾⣿⣿⣿⣿⣿⣿⣿⣿
                        ⡻⠿⣏⢿⣿⢿⣿⣿⣾⣿⣿⣿⣿⡐⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠀⠀⠀⠀⠀⠀⠀⠈⠠⠾⠛⠋⠉⠉⡟⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣭⣭⣥⣤⣧⣿⠯⠅⠛⠉⠘⣿⣿⣇⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⠠⠀⠀⠀⠀⠈⠍⠙⠛⠛⠛⠿⠿
                        ⢉⠭⠙⠉⠁⠀⠀⠀⠀⠀⠀⣿⣿⣭⡆⠀⠐⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠁⢀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠄⠂⠀⠀
                        ⠀⠀⠀⠄⡀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⢀⠐⠀⠀⠀⠀⠀⠀⠠⠀⠀⢀⠀⠀⠀⠀⠀⡠⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⡀⠊⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⢄⢀⠀⠄⣂⣨⣿⣿⣿⡇⡂⠀⠀⠀⠀⠀⠀⠤⠀⡠⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢀⠀⣀⠀⠊⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠈⠒⠾⣟⠉⢸⣿⣿⣿⡄⡈⠀⠀⠀⠀⡐⠐⠐⠒⠒⠂⠀⠨⡀⠀⠀⠀⠀⠈⠀⠀⡀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀
                        ⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠚⢿⣿⣿⣿⠀⠀⠀⠠⠀⡀⠀⠀⠀⠄⠀⠀⠁⡀⠀⠀⠀⡀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣶⢸
                        ⣶⣿⡷⡒⢠⠄⢀⠀⠀⠀⠀⠀⠀⠸⣿⣿⡿⠐⠀⠀⠀⠀⠀⠀⠀⠐⡴⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣟⣻⣿⣿⣇
                        ⠋⠁⢰⡇⠀⠀⠀⠀⠈⣶⣶⠀⢤⠀⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⢠⠅⠀⢂⠀⠀⠀⠀⢀⠀⠀⢀⠀⠄⢰⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⠀⠀⢸⡇⠀⠀⠀⠀⠀⣿⣿⠀⢸⣠⣿⣿⣿⣿⡀⠀⠂⠀⠀⠂⠁⠀⠀⠀⠀⠀⠀⠀⠂⠈⠀⢸⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿"""
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
                    createPayer();
                    return;
                case 2:
                    playerRepository.createMatches();
                    break;
                case 3:
                    playerRepository.readPlayers();
                    break;
                case 4:
                    System.out.println("New player added.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while(input >= 5);
    }


    private void createPayer() {
        boolean inQueue = false;
        System.out.println("Welcome on space for create a new player. Let´s go!");
        System.out.print("Set the name of the player: ");
        String name = sc.next();
        System.out.print("Set the country of the player: ");
        String country = sc.next();

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

        System.out.print("Set the number of games played: ");
        Integer gamePlayed = sc.nextInt();
        System.out.print("Set the number of victories: ");
        Integer victory = sc.nextInt();

        matchServiceIMP.createPlayer(name,country,inQueue, gamePlayed, victory);
    }
}
