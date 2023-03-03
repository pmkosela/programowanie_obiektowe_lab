import java.util.Locale;

/*
 * Zdefiniuj klasę Segment reprezentującą odcinek, posiadającą dwa prywatne punkty klasy Point.
 * Wygeneruj akcesory i mutatory klasy Segment. Napisz publiczną metodę, która zwraca długość odcinka.
 * W kolejnym kroku usuń mutatory i utwórz konstruktor ustawiający te pola na wartości swoich dwóch
 * parametrów.
 */
public class Segment {
    public Point getA() {
        return a;
    }

    /*public void setA(Point a) {
        this.a = a;
    }*/

    public Point getB() {
        return b;
    }

    /*public void setB(Point b) {
        this.b = b;
    }*/

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    private Point a;
    private Point b;

    public double length() {
        double x1 = this.a.x;
        double x2 = this.b.x;
        double y1 = this.a.y;
        double y2 = this.b.y;
        double part1 = Math.pow(x1 - x2, 2);
        //part1 *= part1;
        double part2 = Math.pow(y1 - y2, 2);
        //part2 *= part2;
        return Math.sqrt(part1 + part2);
    }

    public String toSvg() {
        String output;
        //<line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />
        output = String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\"" +
                        "y2=\"%f\" style=\"stroke:rgb(0,0,0);stroke-width:2\" />",
                               this.a.x, this.a.y, this.b.x, this.b.y);
        return output;
    }

    public double[] getLine() {
        double x1 = this.a.x;
        double y1 = this.a.y;
        double x2 = this.b.x;
        double y2 = this.b.y;
        double a = (y1 - y2) / (x1 - x2);
        double b = y2 - x2 * a;
        return new double[] {a, b};
    }

}
