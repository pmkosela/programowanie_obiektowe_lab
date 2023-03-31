public class Main {
    public static void main(String[] args) {
        FileCommanderCLI fc = new FileCommanderCLI(System.in, System.out);
        fc.eventLoop();
    }
}