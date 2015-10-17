package org.academiadecodigo.antonio.crashtest.spritesheet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by cadet on 15/10/15.
 */
public class MyAnimations {

    private int FRAME_COLS;
    private int FRAME_ROWS;
    private int xPosition;
    private int yPosition;

    Animation standing;
    Texture spriteSheet;
    TextureRegion[] frames;
    TextureRegion currentFrame;
    String path;
    float stateTime;
    boolean backwards;

    public MyAnimations(String path, int cols, int rows, int xPosition, int yPosition, boolean backwards){
        FRAME_COLS = cols;
        FRAME_ROWS = rows;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.path = path;
        this.backwards = backwards;

    }

    public void createAnimation(){

        spriteSheet = new Texture(Gdx.files.internal(path));

        TextureRegion[][] tmp = TextureRegion.split(spriteSheet, spriteSheet.getWidth()/FRAME_COLS, spriteSheet.getHeight()/FRAME_ROWS);

        frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];


        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            if(backwards){
                for (int j = FRAME_COLS - 1; j >= 0; j--) {
                    frames[index++] = tmp[i][j];
                }
                }else {
                for (int j = 0; j < FRAME_COLS; j++) {
                    frames[index++] = tmp[i][j];
                }
            }
        }

        standing = new Animation(1.00f/ (FRAME_COLS * FRAME_ROWS), frames);
        stateTime = 0f;
    }

    public float getStateTime() {
        return stateTime;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }

    public Animation getStanding() {
        return standing;
    }

    public void setStanding(Animation standing) {
        this.standing = standing;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
}
