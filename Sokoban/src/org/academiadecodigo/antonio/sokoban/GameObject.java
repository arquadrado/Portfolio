package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by cadet on 28/09/15.
 */
public class GameObject {


    protected ID id;
    protected int width;
    protected int height;
    protected int col;
    protected int row;
    protected int x;
    protected int y;
    protected int lastCol;
    protected int lastRow;
    protected Rectangle rectangle;
    public Picture picture;



    public GameObject(){

    }



    public Picture newPicture(int x, int y, String path){

        String picturePath = path;
        Picture picture = new Picture(x, y, picturePath);
        picture.draw();


        return picture;
    }
    public Rectangle newObject(int x, int y,Color color){

        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(color);
        rectangle.fill();

        return rectangle;
    }

    public Rectangle newStroke(int x, int y,Color color){

        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(color);
        rectangle.draw();

        return rectangle;
    }


    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int x) {
        this.col = x;
    }

    public void setRow(int y) {
        this.row = y;
    }


    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public ID getId() {
        return id;
    }
}