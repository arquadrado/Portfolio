package org.academiadecodigo.antonio.crashtest.GameWorld;

import org.academiadecodigo.antonio.crashtest.GameObjects.Bandi;


/**
 * Created by cadet on 16/10/15.
 */
public class GameWorld {

    private Bandi bandi;

    public GameWorld(int midPointY) {
        bandi = new Bandi(33, midPointY - 5, 17, 12);
    }

    public void update(float delta) {
        bandi.update(delta);
    }

    public Bandi getBandi() {
        return bandi;

    }


}
