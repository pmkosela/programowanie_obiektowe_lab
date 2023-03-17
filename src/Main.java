public class Main {
    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
        Ellipse ellipse = new Ellipse(new Vec2(120,60), 5.5, 7.5);

        SvgScene scene = new SvgScene();
        scene.add(poly);
        scene.saveHtml("/tmp/scene.html");

        SolidFillShapeDecorator polyDecorator = new SolidFillShapeDecorator(poly, "#000000");
        SolidFillShapeDecorator ellipseDecorator = new SolidFillShapeDecorator(ellipse, "#FFFFFF");
        StrokeShapeDecorator polyDecorator2 = new StrokeShapeDecorator(polyDecorator, "red", 12);
        StrokeShapeDecorator ellipseDecorator2 = new StrokeShapeDecorator(ellipseDecorator,"red",3);
    }
}