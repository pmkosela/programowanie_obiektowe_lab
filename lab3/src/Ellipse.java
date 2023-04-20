import java.util.Locale;

public class Ellipse implements Shape{
    Vec2 center;
    double rx,ry;

    public Ellipse(Vec2 center, double rx, double ry) {
        this.rx=rx;
        this.ry=ry;
        this.center=center;

    }

    @Override
    public String toSvg(String parameters) {
        return String.format(Locale.ENGLISH, "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s />", center.x, center.y, rx, ry, parameters);
    }
}