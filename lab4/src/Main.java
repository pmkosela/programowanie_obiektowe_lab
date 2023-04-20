import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void save(String path) {
        try {
            List<Person> people = new ArrayList<>();
            Person janusz = new Person("Janusz",
                    LocalDate.of(1975, 1, 1));
            people.add(janusz);

            Person grazyna = new Person("Grażyna",
                    LocalDate.of(1975, 1, 1));
            people.add(grazyna);

            Person krystyna = new Person("Krystyna",
                    LocalDate.of(1975, 1, 1));
            people.add(krystyna);

            Person seba = new Person("Seba",
                    LocalDate.of(1990, 1, 1),
                    janusz, grazyna);
            people.add(seba);

            Person edzio = new Person("Edzio",
                    LocalDate.of(1975, 1, 1));
            people.add(edzio);

            Person karyna = new Person("Karyna",
                    LocalDate.of(1995, 1, 1),
                    edzio, krystyna);
            people.add(karyna);

            Person brajan = new Person("Brajan",
                    LocalDate.of(2011, 1, 1),
                    seba, karyna);
            people.add(brajan);

            System.out.println(brajan);

            try {
                FileOutputStream stream = new FileOutputStream(path);
                ObjectOutputStream objectStream = new ObjectOutputStream(stream);
                objectStream.writeObject(people);
                objectStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IncestException e) {
            e.printStackTrace();
        }

    }

    public static void load(String path) {
        List<Person> people;
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);

            people = (List<Person>) in.readObject();

            System.out.println(people);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            Person alicja = Person.loadPerson("/tmp/test/test_same_osoby/Alicja Stefanek.txt");
            System.out.println(alicja);
            Person alicja2 = Person.loadPerson("/tmp/test/test_same_osoby/Alicja Stefanek2.txt");
            System.out.println(alicja2);
        } catch (AmbigiousPersonException e){
            System.out.println(e.getMessage());
            System.out.println(e.path1);
            System.out.println(e.path2);
        }


        //save("people.bin");

        //load("people.bin");
        /*
        try {
            Person mirek = new Person("Mirek",
                    LocalDate.of(2130, 5, 7),
                    LocalDate.of(1990, 8, 1));

            System.out.println(mirek);
        } catch (NegativeLifespanException e) {
            e.printStackTrace();
            System.err.println(e.lifespan);
        } catch (DateTimeException e) {

            System.err.println(e.getMessage());
            System.out.println("DT EXC");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("FINALLY");
        }

         */

    }
}