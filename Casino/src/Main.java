import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Users> globalUsers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.login();
    }
}
