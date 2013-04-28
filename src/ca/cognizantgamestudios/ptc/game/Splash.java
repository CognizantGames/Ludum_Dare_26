package ca.cognizantgamestudios.ptc.game;

import ca.cognizantgamestudios.ptc.assets.AssetHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Splash extends BasicGameState {

    public Image splashImage;
    int time, seconds, fadeTime;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        AssetHandler.loadImages();
        AssetHandler.loadMusic();
        AssetHandler.loadSounds();

        splashImage = AssetHandler.splash;
        splashImage.setAlpha(0);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        splashImage.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        time += delta;
        seconds = time/1000;
        fadeTime = time;

        while(fadeTime > 100){
            splashImage.setAlpha(splashImage.getAlpha() + 0.001f);
            fadeTime -= 100;
        }
        if(seconds == 3){
            stateBasedGame.enterState(1);
        }
    }
    @Override
    public int getID() {
        return 0;
    }
}
