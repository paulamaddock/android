package com.paul.androidgames.mrnom;

import com.paul.androidgames.framework.Screen;
import com.paul.androidgames.framework.impxsl.AndroidGame;

/**
 * Created by Maddock on 2/22/2015.
 */
public class MrNomGame extends AndroidGame {

    @Override
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
