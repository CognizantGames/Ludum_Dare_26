package ca.cognizantgamestudios.ptc.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Server extends BasicGameState{
    private final String string = "This is the Server";

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setBackground(Color.white);
        graphics.setColor(Color.black);
        graphics.drawString(string, gameContainer.getWidth()/2-string.length(), gameContainer.getHeight()/2-string.length());
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }
    @Override
    public int getID() {
        return 3;
    }
}
