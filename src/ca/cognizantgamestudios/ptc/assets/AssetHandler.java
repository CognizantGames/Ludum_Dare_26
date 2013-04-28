package ca.cognizantgamestudios.ptc.assets;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AssetHandler {
    public static SpriteSheet sprite;
    public static Image splash;
    public static Image menuBackground;
    public static Music music;

    public static void loadImages() throws SlickException{
        sprite = new SpriteSheet("res/spritesheet.png", 32, 32);
        splash = new Image("res/splash.png");
        menuBackground = new Image("res/menuBackground.png");
    }
    public static void loadMusic()throws SlickException{
        music = new Music("res/converted.ogg");
    }
    public static void loadSounds()throws SlickException{

    }
}
