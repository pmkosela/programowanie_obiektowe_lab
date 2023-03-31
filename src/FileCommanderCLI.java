import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCommanderCLI {

    private FileCommander fileCommander;
    private BufferedReader reader;
    private BufferedWriter writer;
    public FileCommanderCLI(InputStream inputstream, OutputStream outputstream){
        this.fileCommander = new FileCommander();
        InputStreamReader inputStrmRdr = new InputStreamReader(inputstream);
        OutputStreamWriter outputStrmWrtr = new OutputStreamWriter(outputstream);
        this.reader = new BufferedReader(inputStrmRdr);
        this.writer = new BufferedWriter(outputStrmWrtr);
    }
    private void runCommand(String command){
        String[] cmds = command.split(" ");
        switch(cmds[0]){
            case "ls": fileCommander.ls(); break;
            case "pwd": fileCommander.pwd(); break;
            case "cd":
                Path parameter;
                if(cmds.length == 0){
                    parameter = Paths.get(System.getProperty("user.home"));
                } else {
                    parameter = Paths.get(cmds[1]);
                }
                fileCommander.cd(parameter);
                break;
        }
    }
    public void eventLoop(){
        while(true){
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            runCommand(line);
        }
    }
}
