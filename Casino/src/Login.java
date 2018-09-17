import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    public Users superUser = new Users("Alice", "1234");

    public void run() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("src/Login.txt"));
        System.out.println("ENTER YOUR USERNAME");
        Scanner input = new Scanner(System.in);
        String dealerUser = scan.nextLine();
        System.out.println("ENTER YOUR PASSWORD");
        String dealerPass = scan.nextLine();

        String userInput = input.nextLine();
        String passInput = input.nextLine();

        if(userInput.equalsIgnoreCase(dealerUser) && passInput.equals(dealerPass)){
            System.out.println("YOU HAVE SUCCESSFULLY LOGGED IN");
        } else {
            System.out.println("WRONG LOGIN INFORMATION, TRY AGAIN");
            run();
        }
    }

    public void login() throws Exception {
        Login newLogin = new Login();
        System.out.println("PRESS 1 FOR DEALER/EMPLOYEE LOGIN \nPRESS 2 FOR PLAYER LOGIN");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("WELCOME DEALER/EMPLOYEE");
            newLogin.run();
            dealerMenu();
        } else if (choice == 2){
            System.out.println("WELCOME PLAYER");
        }
    }


    public void dealerMenu() throws Exception{
        System.out.println("PRESS 1 TO ADD USER \nPRESS 2 TO ADD TOURNAMENT \nPRESS 3 TO ADD GAME \nPRESS 4 TO END THE PROGRAM");
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        if(!quit){
            int choice = input.nextInt();
            switch (choice){
                case 1: //ADD USER
                    superUser.newUser();
                    break;
                case 2: // ADD TOURNAMENT
                    Tournaments tm = new Tournaments();
                    tm.newTournament();
                    break;
                case 3: // ADD GAME
                    Games game = new Games();
                    game.newGame();
                    break;
                case 4:
                    System.out.println("ENDING PROGRAM");
                    quit = true;
                    break;
                default:
                    System.out.println("UNKNOWN INPUT, TRY AGAIN");
                    dealerMenu();
                    break;
            }
            if(!quit){
                dealerMenu();
            }
        }
    }
}
