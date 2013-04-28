package ca.cognizantgamestudios.ptc.game;

import ca.cognizantgamestudios.ptc.assets.AssetHandler;
import org.newdawn.slick.*;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play implements GameState {
    Animation player, turret;
    Animation enemy, enemyTurret;
    Animation smoke, explosion;

    int[] duration = {200, 200, 200, 200};

    public int localPlayerX, localPlayerY;

    private int ammo = 32;
    private int points = 0;
    private int time;
    private int seconds;
    private int countDown;

    float turretAngle;
    float mouseX, mouseY;
    float speed = 0.2f;

    boolean isFired = false;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Image[] playerImages= {AssetHandler.sprite.getSprite(0,0), AssetHandler.sprite.getSprite(1,0), AssetHandler.sprite.getSprite(2,0), AssetHandler.sprite.getSprite(3,0)};
        Image[] turretImages = {AssetHandler.sprite.getSprite(0,1), AssetHandler.sprite.getSprite(1,1), AssetHandler.sprite.getSprite(2,1), AssetHandler.sprite.getSprite(3,1)};

        player = new Animation(playerImages, duration);
        turret = new Animation(turretImages, duration);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //draw local player
        player.draw(localPlayerX, localPlayerY);
        turret.getCurrentFrame().draw(localPlayerX, localPlayerY);
        turret.getCurrentFrame().setRotation(-turretAngle);
        //draw stats...
        graphics.setColor(Color.black);
        graphics.drawString("Ammo: "+ammo, 15, 15);
        graphics.drawString("Points: "+points, 15, 35);
        graphics.drawString("Time Left: "+countDown, 15, 55);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        time += delta;
        seconds = time/1000;
        countDown = 120 - seconds;
        player.getCurrentFrame().setRotation(0);

        if(input.isKeyDown(Input.KEY_W)){
            localPlayerY -= delta * speed;
            player.start();
            player.getCurrentFrame().setRotation(0);
        }else if(input.isKeyDown(Input.KEY_S)){
            localPlayerY += delta * speed;
            player.start();
            player.getCurrentFrame().setRotation(180);
        }else if(input.isKeyDown(Input.KEY_D)){
            localPlayerX += delta * speed;
            player.start();
            player.getCurrentFrame().setRotation(90);
        }else if(input.isKeyDown(Input.KEY_A)){
            localPlayerX -= delta * speed;
            player.start();
            player.getCurrentFrame().setRotation(270);
        }

        mouseX = input.getMouseX();
        mouseY = input.getMouseY();

        float xDistance = mouseX - localPlayerX;
        float yDistance = mouseY - localPlayerY;

        turretAngle = (float)(360+Math.toDegrees(Math.atan2(xDistance, yDistance))) % 360;

        if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && ammo > 0 && !isFired){
            //fire the cannon
            turret.start();
            ammo--;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            stateBasedGame.enterState(1);
        }

    }

    @Override
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void leave(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void controllerLeftPressed(int i) {}
    @Override
    public void controllerLeftReleased(int i) {}
    @Override
    public void controllerRightPressed(int i) {}
    @Override
    public void controllerRightReleased(int i) {}
    @Override
    public void controllerUpPressed(int i) {}
    @Override
    public void controllerUpReleased(int i) {}
    @Override
    public void controllerDownPressed(int i) {}
    @Override
    public void controllerDownReleased(int i) {}
    @Override
    public void controllerButtonPressed(int i, int i2) {}
    @Override
    public void controllerButtonReleased(int i, int i2) {}
    @Override
    public void keyPressed(int i, char c) {}
    @Override
    public void keyReleased(int i, char c) {}
    @Override
    public void mouseWheelMoved(int i) {}
    @Override
    public void mouseClicked(int i, int i2, int i3, int i4) {}
    @Override
    public void mousePressed(int i, int i2, int i3) {}
    @Override
    public void mouseReleased(int i, int i2, int i3) {}
    @Override
    public void mouseMoved(int i, int i2, int i3, int i4) {}
    @Override
    public void mouseDragged(int i, int i2, int i3, int i4) {}
    @Override
    public void setInput(Input input) {}
    @Override
    public boolean isAcceptingInput() {return false;}
    @Override
    public void inputEnded() {}
    @Override
    public void inputStarted() {}
    @Override
    public int getID() {
        return 2;
    }
}
