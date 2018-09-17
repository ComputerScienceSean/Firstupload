import java.util.ArrayList;
import java.util.Scanner;

public class Games {
    private String gametype;
    private String tournament;
    private String playerlist;
    private String winners;


    public void newGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE TYPE OF GAME");
        String temp = input.next();
        if (temp.equalsIgnoreCase("Poker") || temp.equalsIgnoreCase("Blackjack") || temp.equalsIgnoreCase("Roulette")) {
            temp = gametype;
        } else {
            System.out.println("INVALID GAME TYPE, TRY AGAIN");
            newGame();
        }
        Tournaments tm = new Tournaments();
        System.out.print(tm.getTournamentList());
        System.out.println("CHOOSE THE TOURNAMENT TO ADD TO GAME, PRESS THE NUMBER ACCORDING TO YOU CHOICE");
        int enteredSize = input.nextInt();
    }
}
