package org.academiadecodigo.antonio.sokoban;



/**
 * Created by cadet on 28/09/15.
 */
public class Player extends GameObject {


    private int lastCol;
    private int lastRow;
    private Direction direction;
    boolean frame;
    String framePath;
    String sprite = "facing";





    public Player(int col, int row, int size){
        id = ID.PLAYER;
        this.width = size;
        this.height = size;
        this.x = col * size;
        this.y = row * size;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/" + chooseChar() + "bot1.png");
    }



    public String chooseChar(){

        String path = sprite;

        return path;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public void setPosition(int col, int row){
        this.col = col;
        this.row = row;
    }
    public String changeFrame(String framePath1, String framePath2){
        if(frame){
            framePath = framePath1;
            frame = !frame;
        } else{
            framePath = framePath2;
            frame = !frame;
        }
        return framePath;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
