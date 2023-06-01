package client;

public interface ClientReceiver {

    void receiveBroadcast(String sender, String message);

    void receiveWhisper(String sender, String message);

    void receiveFile(String sender, long fileSize, String fileName);

    void receiveLoginBroadcast(String sender);

    void receiveLogoutBroadcast(String sender);

    void receiveOnline(String[] clientNames);

    void receiveFileProgress(int progress);

}