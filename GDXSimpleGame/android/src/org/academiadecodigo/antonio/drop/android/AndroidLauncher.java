package org.academiadecodigo.antonio.drop.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import org.academiadecodigo.antonio.drop.Drop;

public class AndroidLauncher extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration config= new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;

        initialize(new Drop(), config);
    }
}
