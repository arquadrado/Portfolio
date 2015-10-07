package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 28/09/15.
 */
public class Box extends GameObject {
    private boolean stored;
    public Box(int col, int row, int cell) {
        this.stored = false;
        id = ID.BOX;
        this.width = cell;
        this.height = cell;
        this.x = col * cell;
        this.y = row * cell;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/box2.png");

    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }
}
