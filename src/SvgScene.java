import java.io.File;
import java.io.FileWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {

    private List<Polygon> polygons;
    public SvgScene(){
        polygons = new ArrayList<Polygon>();
    }

    public void addPolygon(Polygon polygon){
        polygons.add(polygon);
    }
    public void save(String path){
        FileWriter file;
        try{
            file = new FileWriter(path);
            for (Polygon p: this.polygons) {
                file.write(p.toSvg());//nie działa
            }
            file.close();
        }
        catch(Exception cokolwiek){System.out.println("error");}
    }
}
//Napisz klasę SvgScene posiadającą prywatną listę obiektów Polygon.
// Napisz metodę, która przyjmuje obiekt klasy Polygon oraz dodaje go do
// listy w obiekcie SvgScene. Napisz funkcję save(String),
// która utworzy plik HTML w ścieżce danej argumentem i zapisze do
// niego reprezentacje wszystkich wielokątów znajdujących się na kanwie.