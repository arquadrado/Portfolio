package org.academiadecodigo.antonio.crashtest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import org.academiadecodigo.antonio.crashtest.GameWorld.GameRenderer;
import org.academiadecodigo.antonio.crashtest.GameWorld.GameWorld;
import org.academiadecodigo.antonio.crashtest.Helpers.InputHandler;

/**
 * Created by cadet on 16/10/15.
 */
public class GameScreen implements Screen {

    GameWorld world;
    GameRenderer renderer;
    private float runTime;

    public GameScreen(){


        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) (gameHeight / 2);

        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world.getBandi()));

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
