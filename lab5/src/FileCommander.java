import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileCommander {
    Path path;

    public FileCommander() {
        this.path = Paths.get(System.getProperty("user.home"));
    }

    public String pwd() {
        return this.path.toString();
    }

    public void cd(Path newPath) {
        path.resolve(newPath).normalize();
    }

    public List<String> ls(){
        Comparator<Path> comparator = (path1, path2) ->{
            boolean p1IsDir = Files.isDirectory((Path)path1);
            boolean p2IsDir = Files.isDirectory((Path)path2);
            if (p1IsDir == p2IsDir) {
                return 0;
            } else
            if (p1IsDir == true) {
                return 1;
            } else return -1;
        };
        comparator = comparator.thenComparing(Path::getFileName);

        List<String> list;
        try {
            list = (Files.list(this.path))
                    .sorted(comparator)
                    .map((p)->{
                        String s;
                        if (Files.isDirectory(p)){
                            s = "[" + p.toString() + "]";
                        }else{
                            s = p.toString();
                        }
                        return s;})
                    .collect(Collectors.toList());
        } catch (IOException exception) {
            throw new RuntimeException();
        }
        return list;
    }



}
