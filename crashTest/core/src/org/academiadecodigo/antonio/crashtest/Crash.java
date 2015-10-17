package org.academiadecodigo.antonio.crashtest;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.antonio.crashtest.spritesheet.MyAnimations;

public class Crash extends ApplicationAdapter {

    protected MyAnimations facingRightAnimation;
    protected MyAnimations facingLeftAnimation;
    protected MyAnimations runningRightAnimation;
    protected MyAnimations runningLeftAnimation;
    protected int velocity = 200;
    protected boolean facingRight = true;
    SpriteBatch spriteBatch;

    @Override
    public void create() {
        facingRightAnimation = new MyAnimations("android/assets/crashfacingright.png", 14, 1, 400, 50, false);
        facingLeftAnimation = new MyAnimations("android/assets/crashfacingleft.png", 14, 1, 400, 50, true);
        runningRightAnimation = new MyAnimations("android/assets/crashrunning.png", 14, 1, 400, 50, false);
        runningLeftAnimation = new MyAnimations("android/assets/crashrunningback.png", 14, 1, 400, 50, true);
        facingRightAnimation.createAnimation();
        facingLeftAnimation.createAnimation();
        runningRightAnimation.createAnimation();
        runningLeftAnimation.createAnimation();
        spriteBatch = new SpriteBatch();

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        setAnimationStateTime();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            facingRight = false;
            setCharacterPositionX(-1);

            currentFrame(runningLeftAnimation);

        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            facingRight = true;
            setCharacterPositionX(1);

            currentFrame(runningRightAnimation);
        } else if(Gdx.input.isKeyPressed(Input.Keys.UP)){

            setCharacterPositionY(1);
            currentFrame(runningRightAnimation);

        } else {
            currentFrame(facingRightAnimation);
            currentFrame(facingLeftAnimation);
        }


        spriteBatch.begin();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spriteBatch.draw(runningRightAnimation.getCurrentFrame(), runningRightAnimation.getxPosition(), runningRightAnimation.getyPosition());
        }else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            spriteBatch.draw(runningLeftAnimation.getCurrentFrame(), runningLeftAnimation.getxPosition(), runningLeftAnimation.getyPosition());
        } else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            spriteBatch.draw(runningRightAnimation.getCurrentFrame(), facingRightAnimation.getxPosition(), facingRightAnimation.getyPosition());
        } else  {
            if(facingRight){
                spriteBatch.draw(facingRightAnimation.getCurrentFrame(), facingRightAnimation.getxPosition(), facingRightAnimation.getyPosition());
            } else {
                spriteBatch.draw(facingLeftAnimation.getCurrentFrame(), facingLeftAnimation.getxPosition(), facingLeftAnimation.getyPosition());
            }

        }

        spriteBatch.end();
    }

    public void setCharacterPositionX(int direction){
        velocity = 200;
        facingRightAnimation.setxPosition((int) (facingRightAnimation.getxPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
        facingLeftAnimation.setxPosition((int) (facingLeftAnimation.getxPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
        runningRightAnimation.setxPosition((int) (runningRightAnimation.getxPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
        runningLeftAnimation.setxPosition((int) (runningLeftAnimation.getxPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
    }

    public void setCharacterPositionY(int direction){

            facingRightAnimation.setyPosition((int) (facingRightAnimation.getyPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
            facingLeftAnimation.setyPosition((int) (facingLeftAnimation.getyPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
            runningRightAnimation.setyPosition((int) (runningRightAnimation.getyPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));
            runningLeftAnimation.setyPosition((int) (runningLeftAnimation.getyPosition() + (velocity * direction) * Gdx.graphics.getDeltaTime()));


    }

    public void setAnimationStateTime(){
        facingRightAnimation.setStateTime(facingRightAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
        facingLeftAnimation.setStateTime(facingLeftAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
        runningRightAnimation.setStateTime(runningRightAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
        runningLeftAnimation.setStateTime(runningLeftAnimation.getStateTime() + Gdx.graphics.getDeltaTime());
    }

    public void currentFrame(MyAnimations animation){
        animation.setCurrentFrame(animation.getStanding().getKeyFrame(animation.getStateTime(), true));
    }
}
