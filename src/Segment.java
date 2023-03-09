import java.util.Locale;

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
        output = String.format(Locale.ENGLISH,
                         "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\"" +
                               "style=\"stroke:rgb(0,0,0);stroke-width:2\" />",
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

    public static Segment[] perpendicular(Segment segment, Point point) {
        double a;
        a = (segment.getA().y - segment.getB().y);
        a /= (segment.getA().x - segment.getB().x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;
        double r = segment.length();

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(point, new Point(x1,y1)),
                             new Segment(point, new Point(x2,y2))};
    }

}
