package org.academiadecodigo.antonio.crashtest.Helpers;

import org.academiadecodigo.antonio.crashtest.spritesheet.MyAnimations;

/**
 * Created by cadet on 16/10/15.
 */
public class AssetLoader {


    public static MyAnimations animation;


    public static void load() {

        animation = new MyAnimations("android/assets/crashfacingright.png", 14, 1, 50, 50, false);

        animation.createAnimation();

    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
    }

}
