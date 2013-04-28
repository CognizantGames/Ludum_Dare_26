package ca.cognizantgamestudios.ptc.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
    public static final String GAME_NAME = "Panzer Techno Coop";
    public static final int Splash = 0;
    public static final int Menu = 1;
    public static final int Play = 2;
    public static final int Server = 3;
    public Main(){
        super(GAME_NAME);
        this.addState(new Splash());
        this.addState(new Menu());
        this.addState(new Play());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main());
        //app.setDisplayMode(app.getScreenWidth(), app.getScreenHeight(),true);
        app.setDisplayMode(1024, 768, false);
        app.setVSync(true);
        app.setMouseGrabbed(true);
        app.setShowFPS(false);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(Splash).init(gameContainer, this);
        this.getState(Menu).init(gameContainer, this);
        this.getState(Play).init(gameContainer, this);
        this.getState(Server).init(gameContainer, this);
        this.enterState(Splash);
    }
}
