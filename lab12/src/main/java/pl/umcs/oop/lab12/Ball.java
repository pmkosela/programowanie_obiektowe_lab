package pl.umcs.oop.lab12;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends GraphicsItem {
    private Point2D moveVector = new Point2D(1, -1).normalize();
    private double velocity = 450;
    private Point2D lastPosition;
    public record ExtremePoints(Point2D topLeft, Point2D bottomLeft, Point2D topRight, Point2D bottomRight){};

    public Ball() {
        x = -100;
        y = -100;
        width = height = canvasHeight * .015;
    }

    public Point2D getLastPosition() {
        return lastPosition;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(x, y, width, height);
    }

    public void setPosition(Point2D point) {
        this.x = point.getX() - width/2;
        this.y = point.getY() - height/2;
        lastPosition = point;
    }

    public void updatePosition(double diff) {
        lastPosition = new Point2D(x, y);
        x += moveVector.getX() * velocity * diff;
        y += moveVector.getY() * velocity * diff;
    }

    static int i = 0;
    public void bounceHorizontally(){
        moveVector = new Point2D(-moveVector.getX(), moveVector.getY()).normalize();
        ++i;
        System.out.println(i);
    }
    public void bounceVertically(){
        moveVector = new Point2D(moveVector.getX(), -moveVector.getY()).normalize();
        ++i;
        System.out.println(i);
    }

    public ExtremePoints extremePoints() {
        Point2D topLeft = new Point2D(x-width/2,y-height/2);
        Point2D bottomLeft = new Point2D(x-width/2,y+height/2);
        Point2D topRight = new Point2D(x+width/2,y-width/2);
        Point2D bottomRight = new Point2D(x+width/2,y+height/2);
        return new ExtremePoints(topLeft,bottomLeft,topRight,bottomRight);
    }
}
