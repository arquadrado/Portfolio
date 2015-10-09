package org.academiadecodigo.antonio.MapCreator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by cadet on 09/10/15.
 */
public class Cursor{

    public Rectangle body;
    private int cellSize = 50;
    private int col = 0;
    private int row = 0;

    public Cursor() {
        this.body = new Rectangle(0, 0, 50, 50);
        body.setColor(Color.RED);
        body.fill();
    }

    public void move(int wayX, int wayY){
        body.translate(cellSize * wayX, cellSize * wayY);
        col += wayX;
        row += wayY;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
