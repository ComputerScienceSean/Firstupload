import java.util.ArrayList;
import java.util.Scanner;

public class Tournaments {
    private String name;
    public int price;
    private static ArrayList<Tournaments> tournamentList = new ArrayList<>();

    public Tournaments(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Tournaments() {
    }

    public ArrayList<Tournaments> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(ArrayList<Tournaments> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public void newTournament(){
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE NAME OF THE TOURNAMENT");
        name = input.next();
        System.out.println("ENTER THE PRICE OF THE TOURNAMENT");
        price = input.nextInt();
        tournamentList.add(new Tournaments(name, price));

    }

    @Override
    public String toString() {
        int i = 0;
        return "EXISTING TOURNAMENTS:\n" + name;  //+ ", DKK" + price;
    }
}
