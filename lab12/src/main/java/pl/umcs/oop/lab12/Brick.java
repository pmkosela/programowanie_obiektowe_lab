package pl.umcs.oop.lab12;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends GraphicsItem{

    static private int gridRows;
    static private int gridCols;
    private Color color;

    public static void setGridRows(int gridRows) {
        Brick.gridRows = gridRows;
    }

    public static void setGridCols(int gridCols) {
        Brick.gridCols = gridCols;
    }
    public Brick(int x, int y, Color color){
        this.width = canvasWidth/gridCols;
        this.height = canvasHeight/gridRows;
        this.x = width * x;
        this.y = height * y;
        this.color = color;
    }
    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x, y, width, height);
    }

}
