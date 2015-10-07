package org.academiadecodigo.antonio.sokoban;

import org.academiadecodigo.simplegraphics.graphics.Color;

/**
 * Created by cadet on 28/09/15.
 */
public class Box extends GameObject {
    private boolean stored;
    private boolean justMoved;
    private int lastCol;
    private int lastRow;

    public Box(int col, int row, int cell) {
        this.stored = false;
        this.justMoved = false;
        id = ID.BOX;
        this.width = cell;
        this.height = cell;
        this.x = col * cell;
        this.y = row * cell;
        this.col = col;
        this.row = row;
        this.picture = newPicture(x, y, "resources/box2.png");

    }

    @Override
    public int getLastCol() {
        return lastCol;
    }

    @Override
    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    @Override
    public int getLastRow() {
        return lastRow;
    }

    public boolean isJustMoved() {
        return justMoved;
    }

    public void setJustMoved(boolean justMoved) {
        this.justMoved = justMoved;
    }

    @Override

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }
}
