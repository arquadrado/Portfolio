package org.academiadecodigo.antonio.MapCreator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by cadet on 09/10/15.
 */
public class Cursor extends MapCreator{

    public Rectangle body;
    private int col = 0;
    private int row = 0;


    public Cursor() {
        this.body = new Rectangle(0, 0, 50, 50);
        body.setColor(Color.RED);
        body.fill();
    }

    /*public void move(int wayX, int wayY){
        if(col >= cols -1){
            col = 0;
            body.translate((-cols + 1) * cellSize, 0);
        }else if(row >= rows - 1){
            row = 0;
            body.translate(0, (-rows + 1) * cellSize);
        }else{
            body.translate(cellSize * wayX, cellSize * wayY);
            col += wayX;
            row += wayY;
        }
    }*/

    public void move(int wayX, int wayY){
        this.body.delete();
        col = (col + wayX) % (cols);
        row = (row + wayY) % (rows);
        if(col < 0)col += cols;
        if(row < 0)row += rows;
        System.out.println("Col: " + col + " Row: " + row );
        this.body = new Rectangle(col * cellSize, row * cellSize, cellSize, cellSize);
        body.setColor(Color.GREEN);
        body.fill();

    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
