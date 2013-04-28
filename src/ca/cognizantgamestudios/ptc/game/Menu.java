package ca.cognizantgamestudios.ptc.game;

import ca.cognizantgamestudios.ptc.assets.AssetHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

    private final static int BUTTON_SCALE = 4;
    private final static int OFFSET = 150;

    Image play, play1, playSelectedImage, playSelectedImage1;
    Image exit, exit1, exitSelectedImage, exitSelectedImage1;
    Image team1, team2;

    Image bg;
    Boolean selectedPlay = false;
    Boolean selectedExit = false;
    Music music;
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bg = AssetHandler.menuBackground;

        exit = AssetHandler.sprite.getSprite(4,2);
        exit1 = AssetHandler.sprite.getSprite(5,2);
        exitSelectedImage = AssetHandler.sprite.getSprite(6, 2);
        exitSelectedImage1 = AssetHandler.sprite.getSprite(7,2);

        play = AssetHandler.sprite.getSprite(0,2);
        play1 = AssetHandler.sprite.getSprite(1,2);
        playSelectedImage = AssetHandler.sprite.getSprite(2,2);
        playSelectedImage1 = AssetHandler.sprite.getSprite(3,2);

        music = AssetHandler.music;
        music.loop();
        music.setVolume(0.2f);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        gameContainer.setMouseGrabbed(false);
        graphics.setBackground(Color.white);
        bg.draw(0,0,gameContainer.getWidth(), gameContainer.getHeight());
        if(!selectedPlay){
            play.draw(512-play.getWidth()*4,348,play.getWidth()*BUTTON_SCALE, play.getHeight()*BUTTON_SCALE);
            play1.draw(512+(32*BUTTON_SCALE)-play.getWidth()*4,348, play1.getWidth()*BUTTON_SCALE, play1.getHeight()*BUTTON_SCALE);
        }else{
            playSelectedImage.draw(512-play.getWidth()*4,348,playSelectedImage.getWidth()*BUTTON_SCALE, playSelectedImage.getHeight()*BUTTON_SCALE);
            playSelectedImage1.draw(512+(32*BUTTON_SCALE)-play.getWidth()*4,348,playSelectedImage1.getWidth()*BUTTON_SCALE, playSelectedImage1.getHeight()*BUTTON_SCALE);
        }
        if(!selectedExit){
            exit.draw(512-exit1.getWidth()*4, 348+OFFSET, exit.getWidth()*BUTTON_SCALE, exit.getHeight()*BUTTON_SCALE);
            exit1.draw(512+(32*BUTTON_SCALE)-exit1.getWidth()*4, 348+OFFSET, exit1.getWidth()*BUTTON_SCALE, exit1.getHeight()*BUTTON_SCALE);
        }else{
            exitSelectedImage.draw(512-exit1.getWidth()*4, 348+OFFSET, exit.getWidth()*BUTTON_SCALE, exit.getHeight()*BUTTON_SCALE);
            exitSelectedImage1.draw(512+(32*BUTTON_SCALE)-exit1.getWidth()*4, 348+OFFSET, exit1.getWidth()*BUTTON_SCALE, exit1.getHeight()*BUTTON_SCALE);
        }
        graphics.drawString("Press 'M' to Mute the music: ", 15, 15);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        MouseOverArea playButton = new MouseOverArea(gameContainer, play, 512-play.getWidth()*4, 348, play.getWidth()*BUTTON_SCALE, play.getHeight()*BUTTON_SCALE);
        MouseOverArea playButton1 = new MouseOverArea(gameContainer, play1, 512+(32*BUTTON_SCALE)-play.getWidth()*4, 348, play.getWidth()*BUTTON_SCALE, play.getHeight()*BUTTON_SCALE);

        MouseOverArea exitButton = new MouseOverArea(gameContainer, exit, 512-play.getWidth()*4, 348+OFFSET, exit.getWidth()*BUTTON_SCALE, exit.getHeight()*BUTTON_SCALE);
        MouseOverArea exitButton1 = new MouseOverArea(gameContainer, exit1, 512+(32*BUTTON_SCALE)-play.getWidth()*4, 348+OFFSET, exit1.getWidth()*BUTTON_SCALE, exit1.getHeight()*BUTTON_SCALE);

        if(music.getVolume() > 0 && input.isKeyDown(Input.KEY_M)){
            music.setVolume(0);
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }else if(music.getVolume() == 0 && input.isKeyDown(Input.KEY_M)){
            music.setVolume(0.4f);
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        if(playButton.isMouseOver() || playButton1.isMouseOver()){
            selectedPlay = true;
            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
                stateBasedGame.enterState(2);
            }
        }else{
            selectedPlay = false;
        }
        if(exitButton.isMouseOver() || exitButton1.isMouseOver()){
            selectedExit = true;
            if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
                //maybe implement a "are you sure you want to exit!!"
                gameContainer.exit();
            }
        }else{
            selectedExit = false;
        }
    }

    @Override
    public int getID() {
        return 1;
    }
}
