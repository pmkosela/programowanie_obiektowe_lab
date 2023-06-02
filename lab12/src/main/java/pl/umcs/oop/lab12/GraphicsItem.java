package pl.umcs.oop.lab12;

import javafx.scene.canvas.GraphicsContext;

public abstract class GraphicsItem {
    protected double x, y;
    protected double width, height;

    protected static double canvasWidth, canvasHeight;

    public static void setCanvasSize(double canvasWidth, double canvasHeight) {
        GraphicsItem.canvasWidth = canvasWidth;
        GraphicsItem.canvasHeight = canvasHeight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public abstract void draw(GraphicsContext graphicsContext);
}
