import java.util.Locale;
/*Napisz publiczną, statyczną metodę wytwórczą klasy Polygon o nazwie square.
 Funkcja powinna przyjąć jako argumenty: obiekt Line,
  obiekt Style i zwrócić wielokąt będący kwadratem,
   którego przekątną jest dany odcinek.

Przeciąż metodę klasy Line zwracającą prostopadły odcinek tak,
 aby przyjmowała jako dodatkowy argument długość zwracanego odcinka.
*/
public class Polygon extends Shape {

    private Point[] arr;

    public Polygon(int count) {
        arr = new Point[count];
    }

    public Polygon(int count, Style style) {
        arr = new Point[count];
        this.style = style;
    }

    public void setPoint(int index, Point point) {
        arr[index] = point;
    }
    public static Polygon square(Segment segment,Style style){
        Point point = new Point((segment.getA().x+segment.getB().x)/2,
                (segment.getA().y+segment.getB().y)/2);
        Segment segmentprostopadly = Segment.perpendicular(segment,point)[0];
        Point[] arr={segment.getA(),segmentprostopadly.getA(),
                segment.getB(),segmentprostopadly.getB()};
        Polygon kwadrat = new Polygon(4);
        kwadrat.setPoints(arr);
        return kwadrat;
    }
    public void setPoints(Point[] points){
        arr = points;
    }

    public String toSvg() {
        String pointsString = "";
        for(Point point : arr)
            pointsString += point.x + "," + point.y + " ";
        String styleString = "";
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\"%s />",
                             pointsString, styleString);
    }
}
