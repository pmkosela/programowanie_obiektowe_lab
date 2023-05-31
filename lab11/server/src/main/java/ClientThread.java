import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    public Socket getSocket() {
        return socket;
    }

    private Socket socket;
    private PrintWriter writer;
    private Server server;
    private String clientName = null;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            writer = new PrintWriter(output, true);
            String message;
            while ((message = reader.readLine()) != null){
                String prefix = message.substring(0,2);
                String postfix = message.substring(2);
                switch(prefix) {
                    case "LO" -> login(postfix);
                    case "BR" -> server.broadcast(this,postfix);
                    case "WH" -> server.whisper(this,postfix);
                    case "ON" -> server.online(this);
                    case "FI" -> server.sendFile(this,postfix);
                }

                System.out.println(message);
            }
            System.out.println("closed");
            server.removeClient(this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message){
        writer.println(message);
    }

    public String getClientName() {
        return clientName;
    }

    public void login(String name) {
        clientName = name;
        server.online(this);
        server.broadcastLogin(this);
    }


}

