package org.academiadecodigo.antonio.crashtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.antonio.crashtest.spritesheet.MyAnimations;


public class Crash extends ApplicationAdapter {

    protected MyAnimations standingAnimation;
    protected MyAnimations runningRightAnimation;
    protected MyAnimations runningLeftAnimation;
    SpriteBatch spriteBatch;

    @Override
    public void create() {
        standingAnimation = new MyAnimations("android/assets/fighter.png", 15, 1, 50);
        //runningRightAnimation = new MyAnimations("android/assets/runningright.png", 9, 1, 50);
        //runningLeftAnimation = new MyAnimations("android/assets/runningleft.png", 9, 1, 50);
        standingAnimation.createAnimation();

        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        standingAnimation.setStateTime(standingAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
        //runningRightAnimation.setStateTime(runningRightAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
        //runningLeftAnimation.setStateTime(runningLeftAnimation.getStateTime() + Gdx.graphics.getDeltaTime());

       /* if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            standingAnimation.setxPosition((int) (standingAnimation.getxPosition() - 200 * Gdx.graphics.getDeltaTime()));
            runningRightAnimation.setxPosition((int) (runningRightAnimation.getxPosition() - 200 * Gdx.graphics.getDeltaTime()));
            runningLeftAnimation.setxPosition((int) (runningLeftAnimation.getxPosition() - 200 * Gdx.graphics.getDeltaTime()));

            runningLeftAnimation.setCurrentFrame(runningLeftAnimation.getStanding().getKeyFrame(standingAnimation.getStateTime(), true));

        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            standingAnimation.setxPosition((int) (standingAnimation.getxPosition() + 200 * Gdx.graphics.getDeltaTime()));
            runningRightAnimation.setxPosition((int) (runningRightAnimation.getxPosition() + 200 * Gdx.graphics.getDeltaTime()));
            runningLeftAnimation.setxPosition((int) (runningLeftAnimation.getxPosition() + 200 * Gdx.graphics.getDeltaTime()));

            runningRightAnimation.setCurrentFrame(runningRightAnimation.getStanding().getKeyFrame(runningRightAnimation.getStateTime(), true));
        } else {*/
            standingAnimation.setCurrentFrame(standingAnimation.getStanding().getKeyFrame(standingAnimation.getStateTime(), true));
        //}


        spriteBatch.begin();
        //if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))spriteBatch.draw(runningRightAnimation.getCurrentFrame(), runningRightAnimation.getxPosition(), 50);
        //else if(Gdx.input.isKeyPressed(Input.Keys.LEFT))spriteBatch.draw(runningLeftAnimation.getCurrentFrame(), runningLeftAnimation.getxPosition(), 50);
        spriteBatch.draw(standingAnimation.getCurrentFrame(), standingAnimation.getxPosition(), 50);
        spriteBatch.end();
    }
}
