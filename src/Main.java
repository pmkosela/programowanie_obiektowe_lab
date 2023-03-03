public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Segment s = new Segment(p1, p2);
        //s.setA(p1);
        //s.setB(p2);
        System.out.println(s.length());
        System.out.println(s.toSvg());
    }

    /*
     * Napisz funkcję (metodę klasy głównej), która przyjmie: obiekt segment klasy Segment oraz obiekt
     * point klasy Point. Funkcja powinna zwrócić odcinek prostopadły do segment, rozpoczynający się w
     * punkcie point o długości równej odcinkowi segment.
     */
    public Segment perpendicular(Segment segment, Point point) {
        // Wyznaczenie prostej przechodzącej przez segment.
        double[] lineSegment = {0, 0};
        lineSegment = segment.getLine();
        // Wyznaczenie współczynnik kierunkowy prostej prostopadłej.
        double a = -1 / lineSegment[0];
        double[] ppndLine = {a, 0};
        // Znalezienie takiej stałej, aby druga prosta przechodziła przez punkt.
        ppndLine[1] = point.y - a * point.x;

        /* Znalezienie punktów leżących na prostej prostopadłej, które są w odpowiedniej odległości
           od zadanego punktu. */

        return segment;//roboczo
    }
}