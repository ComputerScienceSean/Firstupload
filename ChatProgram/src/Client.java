import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Client implements Runnable {

    //final static ArrayList<String> names = new ArrayList<>();
    Socket socket;

    public static void main(String[] args) {

        new Client().doStuff(args);
    }



    public void doStuff(String[] args){
        System.out.println("=============CLIENT==============");

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the IP for the server (type 0 for localhost): ");
        String ipToConnect = args.length >= 1 ? args[0] : sc.nextLine();

        System.out.print("What is the PORT for the server: ");
        int portToConnect = args.length >= 2 ? Integer.parseInt(args[1]) : sc.nextInt();


        final int PORT_SERVER = portToConnect;
        final String IP_SERVER_STR = ipToConnect.equals("0") ? "127.0.0.1" : ipToConnect;



        try {
            InetAddress ip = InetAddress.getByName(IP_SERVER_STR);
            System.out.println("\nConnecting...");
            System.out.println("SERVER IP: " + IP_SERVER_STR);
            System.out.println("SERVER PORT: " + PORT_SERVER + "\n");

            socket = new Socket(ip, PORT_SERVER);
            sc = new Scanner(System.in);

            System.out.println("Enter Name");
            String name = sc.nextLine();
            String resp = write("Join " + name + ", " + ipToConnect + ":" + portToConnect);
            if (resp.equals("J_OK")) {

                while (true) {

                    if (name == null) {
                        System.out.println("Invalid name. Try again! \n" +
                                "Username is max 12 chars long, only letters, digits, ‘-‘ and ‘_’ allowed.");
                       // notify();
                        return;
                    }
                    write(name);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String write(String msgToSend) throws IOException{
        synchronized (this) {
            OutputStream output = socket.getOutputStream();
            output.write(msgToSend.getBytes());
            output.write('\n');
            output.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();

            System.out.println("What do you want to send? ");

            System.out.println("IN -->" + line + "<--");


            return line;
        }
    }

    public void run(){
        boolean shouldRun = true;
        while(shouldRun){
            try {
                synchronized (this) {
                    wait(60 * 1000);
                }
                write("I'm alive");
            } catch (InterruptedException e) {
                shouldRun = false;
            } catch (IOException ex) {
                shouldRun = false;
            }
        }
    }
}