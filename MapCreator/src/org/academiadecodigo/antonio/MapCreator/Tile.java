package org.academiadecodigo.antonio.MapCreator;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by cadet on 09/10/15.
 */
public class Tile {
    private boolean wall = false;
    private boolean box = false;
    private boolean storagePoint = false;
    private boolean player = false;
    private Rectangle body;
    private static int size = 50;
    private int col;
    private int row;

    public Tile(int col, int row){
        this.col = col;
        this.row = row;
        this.body = new Rectangle(col * size, row * size, size, size);
        body.setColor(Color.BLACK);
        body.draw();
    }

    public static int getSize() {
        return size;
    }

    public void createPlayer(){
        body.setColor(Color.BLUE);
        body.fill();
        this.player = true;
    }

    public void createWall(){
        body.setColor(Color.BLACK);
        body.fill();
        this.wall = true;
    }

    public void createBox(){
        body.setColor(Color.GRAY);
        body.fill();
        this.box = true;

    }

    public void createStoragePoint(){
        body.setColor(Color.LIGHT_GRAY);
        body.fill();
        this.storagePoint = true;

    }

    public void removeObject(){
        this.wall = false;
        this.box = false;
        this.storagePoint = false;
        body.setColor(Color.BLACK);
        body.draw();
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isBox() {
        return box;
    }
    public boolean isPlayer() {
        return player;
    }

    public boolean isStoragePoint() {
        return storagePoint;
    }

}
