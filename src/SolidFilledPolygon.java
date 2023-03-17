/* Napisz klasę SolidFilledPolygon dziedziczącą po Polygon. Klasa powinna
posiadać prywatne pole String color ustawiane, obok tablicy punktów, w
konstruktorze. Przemodeluj funkcję toSvg w interfejsie Shape tak, aby możliwe
było przekazanie jej parametru typu String, który zostanie umieszczony w tagu
rysowanego obiektu. Wykorzystaj poniższy kod:
"<polygon points=\"%s\" %s />"
W klasie SolidFilledPolygon zdefiniuj metodę toSvg, która nadpisze metodę klasy
nadrzędnej. Wewnątrz tej metody wywołaj metodę toSvg klasy nadrzędnej, przekazując jej jako
parametr napis powstały ze sformatowania:
"fill=\"%s\" %s "
kolejno kolorem i parametrem napisowym.
*  */
public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points);
        this.color = color;
    }
    @Override
    public String toSvg(String parameters){
        String output = String.format("fill=\"%s\" %s ", color, parameters);
        return super.toSvg(output);
    }
}
