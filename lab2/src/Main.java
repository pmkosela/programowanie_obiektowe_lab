public class Main {
    public static void main(String[] args) {
        Segment segment = new Segment(new Point(10,100), new Point(110,99));
        Segment[] perp2 = Segment.perpendicular(segment, segment.getA());

        System.out.println(segment.toSvg());
        for(int i=0;i<perp2.length;i++)
            System.out.println(perp2[i].toSvg());
        System.out.println(segment.length());

        Polygon poly = new Polygon(4);
        poly.setPoints(new Point[]{new Point(120,30), new Point(170,180),
                       new Point(240,320), new Point(110,30)});
        System.out.println(poly.toSvg());
        SvgScene svgscene = new SvgScene();
        svgscene.addPolygon(poly);
        svgscene.save("/tmp/plik.html");
    }
}