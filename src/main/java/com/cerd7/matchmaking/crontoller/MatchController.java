package com.cerd7.matchmaking.crontoller;

import com.cerd7.matchmaking.repository.PlayerRepository;
import com.cerd7.matchmaking.service.imp.MatchServiceImp;

import java.util.Scanner;

public class MatchController
{
    private final PlayerRepository playerRepository =  new PlayerRepository();
    private final MatchServiceImp matchServiceIMP = new MatchServiceImp();

    public void startInteraction()
    {
        Scanner sc = new Scanner(System.in);

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
        do
        {
            System.out.println(
                    """       
                     ==== Welcome to the Matchmaking App ====
                    """
            );
            System.out.println(
                    """
                      --------------------------------------
                     |    Welcome to the Matchmaking App    |
                     |  ---------------------------------   |
                     |   *Set your preferred option below*  |
                      --------------------------------------
                    """
            );

            System.out.println(
                    """
                                            OPTIONS:
                     _______________________________________________________
                     |1 - To create a new file to store players.            |
                     |______________________________________________________|
                     |2 - To start generating a match with existing players.|
                     |______________________________________________________|
                     |3 - To see all the existing players in the bank.      |
                     |______________________________________________________|
                     |4 - To add the same player.                           |
                     |______________________________________________________|
                    """
            );
                int input = sc.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("New file created.");
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
        }while(true);
    }













    private void createPayer(String name, String country, boolean inQueue, Integer gamePlayed, Integer victory)
    {
        matchServiceIMP.createPlayer(name,country,inQueue, gamePlayed, victory);
    }
}
