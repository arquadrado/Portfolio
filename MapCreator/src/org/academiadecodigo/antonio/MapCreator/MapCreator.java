package org.academiadecodigo.antonio.MapCreator;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by cadet on 09/10/15.
 */
public class MapCreator implements KeyboardHandler {

    private Keyboard keyboard;
    private Cursor cursor;
    private Tile[][] grid;
    private int cellSize = 50;


    public void start(){
        run();
    }

    public void run(){

        createCursor();
        createGrid(20, 10);
        createKeyboard();

    }

    public void createCursor(){

        cursor = new Cursor();
    }

    public void createGrid(int col, int row){
        grid = new Tile[col][row];

        for(int i = 0; i < col; i++){
            grid[i] = new Tile[row];
            for(int j = 0; j < row; j++){
                grid[i][j] = new Tile(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }

    }

    public void createKeyboard(){
        keyboard = new Keyboard(this);

        KeyboardEvent[] event = new KeyboardEvent[7];

        for(int i = 0; i < event.length; i++){

                event[i] = new KeyboardEvent();
                if(i == 0)event[i].setKey(KeyboardEvent.KEY_W);
                if(i == 1)event[i].setKey(KeyboardEvent.KEY_S);
                if(i == 2)event[i].setKey(KeyboardEvent.KEY_A);
                if(i == 3)event[i].setKey(KeyboardEvent.KEY_D);
                if(i == 4)event[i].setKey(KeyboardEvent.KEY_R);
                if(i == 5)event[i].setKey(KeyboardEvent.KEY_Z);
                if(i == 6)event[i].setKey(KeyboardEvent.KEY_SPACE);
                event[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(event[i]);

        }
    }


    public void keyPressed(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_W ){
            cursor.move(0, -1);
        }
        if(e.getKey() == KeyboardEvent.KEY_S){
            cursor.move(0, 1);
        }
        if(e.getKey() == KeyboardEvent.KEY_A){
            cursor.move(-1, 0);
        }
        if(e.getKey() == KeyboardEvent.KEY_D) {
            cursor.move(1, 0);
        }
        if(e.getKey() == KeyboardEvent.KEY_R){
            grid[cursor.getCol()][cursor.getRow()].removeObject();
        }

        if(e.getKey() == KeyboardEvent.KEY_Z) {
            grid[cursor.getCol()][cursor.getRow()].createBox();
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE){
            grid[cursor.getCol()][cursor.getRow()].createWall();
        }



    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public static void main(String[] args) {
        MapCreator mapCreator = new MapCreator();
        mapCreator.start();
    }
}
