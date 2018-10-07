import java.io.*;
import java.net.Socket;
import java.util.HashSet;

public class ServerThread extends Thread {
    private Socket socket;
    private String name;
    private BufferedReader inFromUser;
    private OutputStream outToUser;
    private static HashSet<String> names = new HashSet<>();
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public ServerThread (Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try {
            inFromUser = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outToUser = socket.getOutputStream();



            String joinMsg = inFromUser.readLine();

                if (joinMsg.startsWith("JOIN ")){
                    boolean ok = true;
                    int p = joinMsg.indexOf(",");
                    if ( p > 0){
                        String s = joinMsg.substring( 5, p);
                        for (char ch : s.toUpperCase().toCharArray()){
                            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVXYZ_-".indexOf( ch )<0){
                                 ok = false;
                            }
                            if ( ok == true ) {
                                write("J_OK");
                                //USER ACCEPTED
                                //check på protokol
                            }
                        }
                    }
                }


               // String resp = outToUser("Join " + name + ", " + ipToConnect + ":" + portToConnect);

            while (true) {
                String input = inFromUser.readLine();

                if (input == null) {
                    return;
                }
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + ": " + input);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            if (name != null) {
                names.remove(name);
            }
            if (outToUser != null) {
                writers.remove(outToUser);
            }
            try {
                socket.close();
            } catch (IOException e){
            }
        }



            /*InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);


            String text;

            do {
                text = reader.readLine();
                String reverseText = new StringBuilder(text).reverse().toString();
                writer.println("Server: " + reverseText);

            } while (!text.equals("quit"));

            socket.close();*/
    }
    public void write(String msgToSend) throws IOException{
        outToUser.write(msgToSend.getBytes());
        outToUser.write('\n');
        outToUser.flush();

    }
}
