import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class Server extends Thread {
    public static void main(String[] args) {
        System.out.println("=============SERVER==============");

        final int PORT_LISTEN = 5656;


        try (ServerSocket server = new ServerSocket(PORT_LISTEN)) {
            System.out.println("Server starting...\n");

            while (true) {

                Socket socket = server.accept();
                System.out.println("Client connected");

                String clientIp = socket.getInetAddress().getHostAddress();
                System.out.println("IP: " + clientIp);
                System.out.println("PORT: " + socket.getPort());

                new ServerThread(socket).start();

                InputStream input = socket.getInputStream();
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                OutputStream output = socket.getOutputStream();
                PrintWriter outToUser = new PrintWriter(socket.getOutputStream(), true);





                byte[] dataIn = new byte[1024];
                input.read(dataIn);
                String msgIn = new String(dataIn);
                msgIn = msgIn.trim();

                System.out.println("IN -->" + msgIn + "<--");

                String msgToSend = "SERVER: [sender: " + clientIp + " ]: " + msgIn;
                byte[] dataToSend = msgToSend.getBytes();
                output.write(dataToSend);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}