import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread("localhost", 5000);
        serverThread.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Login: ");
        try {
            String line = reader.readLine();
            serverThread.login(line);

            while(true) {
                String command = reader.readLine();
                if(command.startsWith("/")) {
                    String data[] = command.substring(1).split("\\s+", 2);
                    switch(data[0]) {
                        case "online" -> serverThread.online();
                        case "w" -> serverThread.whisper(data[1]);
                        case "file" -> serverThread.sendFile(data[1]);
                        default -> System.out.println("Unknown command");
                    }
                }
                else serverThread.broadcast(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}