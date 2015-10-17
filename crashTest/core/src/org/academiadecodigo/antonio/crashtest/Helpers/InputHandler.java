package org.academiadecodigo.antonio.crashtest.Helpers;

import com.badlogic.gdx.InputProcessor;
import org.academiadecodigo.antonio.crashtest.GameObjects.Bandi;

/**
 * Created by cadet on 16/10/15.
 */
public class InputHandler implements InputProcessor {

    private Bandi bandi;

    public InputHandler(Bandi bandi){
        this.bandi = bandi;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        bandi.onClick();

        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
