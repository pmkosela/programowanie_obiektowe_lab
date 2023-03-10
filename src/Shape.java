/*
Utwórz klasę abstrakcyjną Shape, która otrzyma jako pole, obiekt klasy Style.
Uczyń pole tego obiektu chronionym. Utwórz publiczny konstruktor, który ustawia
to pole. Napisz abstrakcyjną metodę toSvg(). Zmodyfikuj klasę Polygon, aby
dziedziczyła po klasie Shape.
 */
public abstract class Shape {
    protected Style style;

    public Shape() {
        style = new Style("none", "black", 1);
    }
    public Shape(Style style) {
        this.style = style;
    }
    public abstract String toSvg();
}
