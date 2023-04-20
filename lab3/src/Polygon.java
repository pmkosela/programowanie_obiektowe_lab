import java.util.Locale;

public class Polygon implements Shape {

    private Vec2[] points;

    public Polygon(Vec2[] points) {

        this.points = points;
    }

    public String toSvg(String parameters) {
        String pointsString = "";
        for(Vec2 vec2 : points)
            pointsString += vec2.x + "," + vec2.y + " ";
        return String.format(Locale.ENGLISH,"\"<polygon points=\\\"%s\\\" %s />\"",
                             pointsString, parameters);
    }
}
