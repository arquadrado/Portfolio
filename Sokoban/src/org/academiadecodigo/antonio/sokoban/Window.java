package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


/**
 * Created by cadet on 28/09/15.
 */
public class Window extends Game{

    private static int WIDTH;
    private static int HEIGHT;
    private static int col;
    private static int row;
    private static int cellSize;
    private static int originX = 0;
    private static int originY = 0;
    private static Rectangle window;
    private static boolean[][] grid;
    private static Wall[][] blockGrid;


    public Window(int cols, int rows, int cellSize){
        this.cellSize = cellSize;
        this.col = cols;
        this.row = rows;
        this.WIDTH = cellSize * col;
        this.HEIGHT = cellSize * row;


        window = new Rectangle(originX, originY, WIDTH, HEIGHT);

        window.setColor(Color.WHITE);
        window.draw();




    }



    public static int getRow() {
        return row;
    }

    public static int getCol() {
        return col;
    }





    public static int getCellSize() {
        return cellSize;
    }



}
