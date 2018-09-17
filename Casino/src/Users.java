import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private String firstName;
    private String lastName;
    private String cpr;
    private String dealerOrEmployee;
    private String username;
    private String password;
    private ArrayList<Users> userList = new ArrayList<>();

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(String firstName, String lastName, String cpr, String dealerOrEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpr = cpr;
        this.dealerOrEmployee = dealerOrEmployee;
    }

    public Users(){

    }

    public ArrayList<Users> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Users> userList) {
        this.userList = userList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getDealerOrEmployee() {
        return dealerOrEmployee;
    }

    public void setDealerOrEmployee(String dealerOrEmployee) {
        this.dealerOrEmployee = dealerOrEmployee;
    }

    public void newUser() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE FIRST NAME OF THE NEW USER");
        firstName = input.next();
        System.out.println("ENTER THE LAST NAME OF THE NEW USER");
        lastName = input.next();
        System.out.println("ENTER THE CPR NUMBER OF THE NEW USER");
        cpr = input.next();
        System.out.println("PRESS 1 IF YOU ARE ADDING A DEALER \nPRESS 2 IF YOU ARE ADDING A PLAYER");
        dealerOrEmployee = input.next();
        if (dealerOrEmployee.equals(1)) {
            dealerOrEmployee = "dealer";
        } else if (dealerOrEmployee.equals(2)){
            dealerOrEmployee = "player";
        }
        userList.add(new Users(firstName, lastName, cpr, dealerOrEmployee));

    }


}
