import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private LocalDate birth, death;
    private Person parents[] = new Person[2];

    static private List<PersonFile> nameFiles = new ArrayList<PersonFile>();

    public Person(String name, LocalDate birth) {
        this(name, birth, null);
    }

    public Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
        try {
            if (birth.isAfter(death)) {
                throw new NegativeLifespanException(birth, death, "Possible time-space loophole.");
            }
        } catch (NullPointerException e) {}
    }

    public Person(String name, LocalDate birth, LocalDate death, Person parent1, Person parent2) throws IncestException {
        this(name, birth, death);
        parents[0] = parent1;
        parents[1] = parent2;

        checkForIncest();
    }

    public Person(String name, LocalDate birth, Person parent1, Person parent2) throws IncestException {
        this(name, birth, null, parent1, parent2);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }

    void checkForIncest() throws IncestException {
        if(parents[0] == null || parents[1] == null)
            return;
        for(var leftSideParent : parents[0].parents) {
            if (leftSideParent == null) continue;
            for (var rightSideParent : parents[1].parents) {
                if (rightSideParent == null) continue;
                if (leftSideParent == rightSideParent)
                    throw new IncestException(leftSideParent, this);
            }
        }
    }
    public static Person loadPerson(String path) throws AmbigiousPersonException {
        File file = new File(path);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            //} catch (Exception e) { //O TU BYŁO!
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + path);
            return null;
        }
        String name = scanner.nextLine();
        for (PersonFile i : nameFiles) {
            if (i.name.equals(name) && !i.path.equals(path)) {
                throw new AmbigiousPersonException(name, i.path, path);
            }
        }
        String tmp = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birth = LocalDate.parse(tmp, format);
        LocalDate death = null;
        Person loadedPerson;
        if (scanner.hasNextLine()) {
            tmp = scanner.nextLine();
            death = LocalDate.parse(tmp, format);
            loadedPerson = new Person(name, birth, death);
        } else {
            loadedPerson = new Person(name, birth);
        }
        PersonFile someone = new PersonFile(name, path);
        nameFiles.add(someone);
        scanner.close();
        return loadedPerson;
    }


}
