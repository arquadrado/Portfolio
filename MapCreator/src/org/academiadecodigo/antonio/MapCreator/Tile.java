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
    private Rectangle rectangle;

    public Tile(int originX, int originY, int col, int row){
        this.rectangle = new Rectangle(originX, originY, col, row);
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    public void createWall(){
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
        this.wall = true;
    }

    public void createBox(){
        rectangle.setColor(Color.GRAY);
        rectangle.fill();
        this.box = true;

    }

    public void createStoragePoint(){
        rectangle.setColor(Color.LIGHT_GRAY);
        rectangle.fill();
        this.storagePoint = true;

    }

    public void removeObject(){
        this.wall = false;
        this.box = false;
        this.storagePoint = false;
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }
}
