package org.academiadecodigo.antonio.MapCreator;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.*;

/**
 * Created by cadet on 09/10/15.
 */
public class MapCreator implements KeyboardHandler {

    private Keyboard keyboard;
    private Cursor cursor;
    private Tile[][] grid;
    private PrintWriter fileWriter;
    protected int cols = 19;
    protected int rows = 17;


    public void start(){
        run();
    }

    public void run(){

        createGrid(cols, rows);
        createKeyboard();
        createCursor();

    }

    public void creatorFileWriter(){
        try {
            fileWriter = new PrintWriter("map-level-5.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(){
        creatorFileWriter();
        String string = "";
        for(int i = 0; i < rows; i++){
            if(i != 0){
                string += '\n';
            }
            for(int j = 0; j < cols; j++){

                if(grid[i][j].isWall()){
                    string += '#';
                }else if(grid[i][j].isBox()){
                    string += 'x';
                }else if(grid[i][j].isStoragePoint()){
                    string += 'p';
                }else if(grid[i][j].isBox() && grid[i][j].isStoragePoint()){
                    string += '$';
                }else  if(grid[i][j].isPlayer()){
                    string += 'j';
                }else  {
                    string += '0';
                }
            }
        }
        fileWriter.print(string);
        fileWriter.close();
    }
    public void createCursor(){

        cursor = new Cursor(cols, rows, Tile.getSize());
    }

    public void createGrid(int col, int row){
        grid = new Tile[row][col];

        for(int i = 0; i < row; i++){
            grid[i] = new Tile[col];
            for(int j = 0; j < col; j++){
                grid[i][j] = new Tile(j, i);
            }
        }

    }

    public void createKeyboard(){
        keyboard = new Keyboard(this);

        KeyboardEvent[] event = new KeyboardEvent[10];

        for(int i = 0; i < event.length; i++){

                event[i] = new KeyboardEvent();
                if(i == 0)event[i].setKey(KeyboardEvent.KEY_W);
                if(i == 1)event[i].setKey(KeyboardEvent.KEY_S);
                if(i == 2)event[i].setKey(KeyboardEvent.KEY_A);
                if(i == 3)event[i].setKey(KeyboardEvent.KEY_D);
                if(i == 4)event[i].setKey(KeyboardEvent.KEY_B);
                if(i == 5)event[i].setKey(KeyboardEvent.KEY_N);
                if(i == 6)event[i].setKey(KeyboardEvent.KEY_M);
                if(i == 7)event[i].setKey(KeyboardEvent.KEY_SPACE);
                if(i == 8)event[i].setKey(KeyboardEvent.KEY_P);
                if(i == 9)event[i].setKey(KeyboardEvent.KEY_V);
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
        if(e.getKey() == KeyboardEvent.KEY_V) {
            grid[cursor.getRow()][cursor.getCol()].createPlayer();
        }
        if(e.getKey() == KeyboardEvent.KEY_B) {
            grid[cursor.getRow()][cursor.getCol()].createBox();
        }
        if(e.getKey() == KeyboardEvent.KEY_M){
            grid[cursor.getRow()][cursor.getCol()].removeObject();
        }
        if(e.getKey() == KeyboardEvent.KEY_N) {
            grid[cursor.getRow()][cursor.getCol()].createStoragePoint();
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE){
            grid[cursor.getRow()][cursor.getCol()].createWall();
        }
        if(e.getKey() == KeyboardEvent.KEY_P){
            writeFile();

            System.out.println("written");
        }



    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public static void main(String[] args) {
        MapCreator mapCreator = new MapCreator();
        mapCreator.start();
    }
}
