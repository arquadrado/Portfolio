package org.academiadecodigo.antonio.sokoban;

/**
 * Created by cadet on 29/09/15.
 */
public class CollisionDetector {

    Box[] boxes;

    public CollisionDetector(Box[] boxes){
        this.boxes = boxes;
    }
    public boolean hasBox(int col, int row){

        for(Box b : boxes){

            if (b.getCol() == col && b.getRow() == row) {
                return true;
            }
        }

        return false;
    }

}
