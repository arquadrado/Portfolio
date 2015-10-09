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
        grid = new boolean[row][col];
        blockGrid = new Wall[row][col];

        for(int i = 0; i < row; i++){
            grid[i] = new boolean[col];
        }
        for(int i = 0; i < row; i++){
            blockGrid[i] = new Wall[col];
        }

        window = new Rectangle(originX, originY, WIDTH, HEIGHT);

        window.setColor(Color.WHITE);
        window.draw();




    }

    public static void createWalls(int level){

        //level 1
        if(level == 1){

            //row 2
            putBlocks(2, 4, 5);
            //row 3
            putBlocks(3, 4, 1);
            putBlocks(3, 8, 1);
            //row 4
            putBlocks(4, 4, 1);
            putBlocks(4, 8, 1);
            //row 5
            putBlocks(5, 2, 3);
            putBlocks(5, 8, 2);
            //row 6
            putBlocks(6, 2, 1);
            putBlocks(6, 9, 1);
            //row 7
            putBlocks(7, 0, 3);
            putBlocks(7, 4, 1);
            putBlocks(7, 6, 2);
            putBlocks(7, 9, 1);
            putBlocks(7, 13, 6);
            //row 8
            putBlocks(8, 0, 1);
            putBlocks(8, 4, 1);
            putBlocks(8, 6, 2);
            putBlocks(8, 9, 5);
            putBlocks(8, 18, 1);
            //row 9
            putBlocks(9, 0, 1);
            putBlocks(9, 18, 1);
            //row 10
            putBlocks(10, 0, 5);
            putBlocks(10, 6, 3);
            putBlocks(10, 10, 1);
            putBlocks(10, 12, 2);
            putBlocks(10, 18, 1);
            //row 11
            putBlocks(11, 4, 1);
            putBlocks(11, 10, 9);
            //row 12
            putBlocks(12, 4, 7);
        }
        // level 2
        if(level == 2){

            //row 2
            putBlocks(2, 4, 12);
            //row 3
            putBlocks(3, 4, 1);
            putBlocks(3, 9, 1);
            putBlocks(3, 15, 3);
            //row 4
            putBlocks(4, 4, 1);
            putBlocks(4, 9, 1);
            putBlocks(4, 17, 1);
            //row 5
            putBlocks(5, 4, 1);
            putBlocks(5, 9, 1);
            putBlocks(5, 11, 4);
            putBlocks(5, 17, 1);
            //row 6
            putBlocks(6, 4, 1);
            putBlocks(6, 13, 2);
            putBlocks(6, 17, 1);
            //row 7
            putBlocks(7, 4, 1);
            putBlocks(7, 9, 1);
            putBlocks(7, 11, 1);
            putBlocks(7, 16, 2);
            //row 8
            putBlocks(8, 4, 6);
            putBlocks(8, 11, 2);
            putBlocks(8, 17, 1);
            //row 9
            putBlocks(9, 6, 1);
            putBlocks(9, 17, 1);
            //row 10
            putBlocks(10, 6, 1);
            putBlocks(10, 11, 1);
            putBlocks(10, 17, 1);
            //row 11
            putBlocks(11, 6, 12);
            //row 12

        }
        if(level == 3) {
            //row 2
            putBlocks(2, 9, 8);
            //row 3
            putBlocks(3, 9, 1);
            putBlocks(3, 16, 1);
            //row 4
            putBlocks(4, 9, 1);
            putBlocks(4, 12, 1);
            putBlocks(4, 15, 2);
            //row 5
            putBlocks(5, 9, 1);
            putBlocks(5, 15, 1);
            //row 6
            putBlocks(6, 9, 2);
            putBlocks(6, 15, 1);
            //row 7
            putBlocks(7, 1, 9);
            putBlocks(7, 13, 1);
            putBlocks(7, 15, 3);
            //row 8
            putBlocks(8, 1, 1);
            putBlocks(8, 8, 2);
            putBlocks(8, 17, 1);
            //row 9
            putBlocks(9, 1, 2);
            putBlocks(9, 17, 1);
            //row 10
            putBlocks(10, 1, 1);
            putBlocks(10, 8, 10);
            //row 11
            putBlocks(11, 1, 8);

        }

        if(level == 4) {
            // row 1
            putBlocks(0, 11, 8);
            //row 1
            putBlocks(1, 11, 1);
            putBlocks(1, 18, 1);
            //row 2
            putBlocks(2, 0, 12);
            putBlocks(2, 18, 1);
            //row 3
            putBlocks(3, 0, 1);
            putBlocks(3, 5, 1);
            putBlocks(3, 18, 1);
            //row 4
            putBlocks(4, 0, 1);
            putBlocks(4, 5, 1);
            putBlocks(4, 11, 1);
            putBlocks(4, 18, 1);
            //row 5
            putBlocks(5, 0, 1);
            putBlocks(5, 11, 1);
            putBlocks(5, 18, 1);
            //row 6
            putBlocks(6, 0, 1);
            putBlocks(6, 5, 1);
            putBlocks(6, 11, 8);
            //row 7
            putBlocks(7, 0, 1);
            putBlocks(7, 5, 1);
            putBlocks(7, 11, 1);
            //row 8
            putBlocks(8, 0, 2);
            putBlocks(8, 3, 9);
            //row 9
            putBlocks(9, 0, 1);
            putBlocks(9, 5, 1);
            putBlocks(9, 10, 2);
            //row 10
            putBlocks(10, 0, 1);
            putBlocks(10, 10, 2);
            //row 11
            putBlocks(11, 0, 1);
            putBlocks(11, 5, 1);
            putBlocks(11, 11, 1);
            //row 12
            putBlocks(12, 0, 1);
            putBlocks(12, 5, 1);
            putBlocks(12, 10, 2);
            //row 13
            putBlocks(13, 0, 11);

        }

        //level 5
        if(level == 5){
            //row 1
            putBlocks(1, 9, 5);
            //row 2
            putBlocks(2, 9, 1);
            putBlocks(2, 13, 5);
            //row 3
            putBlocks(3, 9, 1);
            putBlocks(3, 11, 1);
            putBlocks(3, 13, 2);
            putBlocks(3, 17, 1);
            //row 4
            putBlocks(4, 9, 1);
            putBlocks(4, 17, 1);
            //row 5
            putBlocks(5, 1, 9);
            putBlocks(5, 11, 3);
            putBlocks(5, 17, 1);
            //row 6
            putBlocks(6, 1, 1);
            putBlocks(6, 8, 2);
            putBlocks(6, 15, 3);
            //row 7
            putBlocks(7, 1, 1);
            putBlocks(7, 15, 2);
            //row 8
            putBlocks(8, 1, 1);
            putBlocks(8, 8, 2);
            putBlocks(8, 16, 1);
            //row 9
            putBlocks(9, 1, 9);
            putBlocks(9, 15, 2);
            //row 10
            putBlocks(10, 9, 1);
            putBlocks(10, 16, 1);
            //row 11
            putBlocks(11, 9, 3);
            putBlocks(11, 13, 2);
            putBlocks(11, 16, 1);
            //row 12
            putBlocks(12, 11, 1);
            putBlocks(12, 16, 1);
            //row 13
            putBlocks(13, 11, 6);
        }

        //level 6
        if(level == 6){
            //row 2
            putBlocks(2, 4, 6);
            putBlocks(2, 12, 3);
            //row 3
            putBlocks(3, 4, 1);
            putBlocks(3, 9, 1);
            putBlocks(3, 11, 2);
            putBlocks(3, 14, 2);
            //row 4
            putBlocks(4, 4, 1);
            putBlocks(4, 9, 3);
            putBlocks(4, 15, 1);
            //row 5
            putBlocks(5, 4, 1);
            putBlocks(5, 15, 1);
            //row 6
            putBlocks(6, 4, 1);
            putBlocks(6, 9, 1);
            putBlocks(6, 11, 1);
            putBlocks(6, 15, 1);
            //row 7
            putBlocks(7, 4, 1);
            putBlocks(7, 7, 3);
            putBlocks(7, 11, 1);
            putBlocks(7, 15, 1);
            //row 8
            putBlocks(8, 4, 4);
            putBlocks(8, 11, 1);
            putBlocks(8, 15, 1);
            //row 9
            putBlocks(9, 7, 1);
            putBlocks(9, 11, 1);
            putBlocks(9, 15, 1);
            //row 10
            putBlocks(10, 7, 1);
            putBlocks(10, 15, 1);
            //row 11
            putBlocks(11, 7, 1);
            putBlocks(11, 10, 2);
            putBlocks(11, 15, 1);
            //row 12
            putBlocks(12, 7, 9);


        }
        //level 7
        if(level == 7){
            //row 0
            putBlocks(0, 7, 5);

            //row 1
            putBlocks(1, 1, 7);
            putBlocks(1, 11, 2);

            //row 2
            putBlocks(2, 0, 2);
            putBlocks(2, 3, 1);
            putBlocks(2, 6, 2);
            putBlocks(2, 12, 1);

            //row 3
            putBlocks(3, 0, 1);
            putBlocks(3, 12, 1);

            //row 4
            putBlocks(4, 0, 1);
            putBlocks(4, 6, 3);
            putBlocks(4, 12, 1);

            //row 5
            putBlocks(5, 0, 3);
            putBlocks(5, 4, 5);
            putBlocks(5, 10, 3);

            //row 6
            putBlocks(6, 0, 1);
            putBlocks(6, 5, 3);
            putBlocks(6, 11, 1);

            //row 7
            putBlocks(7, 0, 1);
            putBlocks(7, 11, 1);

            //row 8
            putBlocks(8, 0, 1);
            putBlocks(8, 5, 3);
            putBlocks(8, 11, 1);

            //row 9
            putBlocks(9, 0, 1);
            putBlocks(9, 5, 1);
            putBlocks(9, 7, 1);
            putBlocks(9, 11, 1);

            //row 10
            putBlocks(10, 0, 1);
            putBlocks(10, 3, 3);
            putBlocks(10, 7, 5);

            //row 11
            putBlocks(11, 0, 4);
        }
    }

    public static int getRow() {
        return row;
    }

    public static int getCol() {
        return col;
    }

    public static void deleteWall(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]){
                    blockGrid[i][j].picture.delete();
                }

                grid[i][j] = false;
            }

        }

    }
    public boolean[][] getGrid() {
        return grid;
    }


    public static int getCellSize() {
        return cellSize;
    }

    public static void putBlocks(int row, int col, int quantity){
        for(int i = 0; i < quantity; i++){
            blockGrid[row][col + i] = new Wall(col + i, row, 50);
            grid[row][col + i] = true;
        }
    }


}
