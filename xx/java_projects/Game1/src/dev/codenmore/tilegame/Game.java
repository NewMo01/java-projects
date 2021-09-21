
package dev.codenmore.tilegame;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.gfx.SpriteSheet;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.states.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable {
// Definitions
    private Display display ;
    private int width,height ; public String title ;
    private Thread thread ;
    private boolean running = false;
    BufferStrategy bs ; // tell computer how to draw things on the screen 
    Graphics g ;  
    // states
    private State gameState ; 
    private State menuState ;
    // input
    private KeyManager keyManager ;
    // camera
    private GameCamera camera ;
// constructor    
    public Game(String t , int w , int h){
        title = t ; width = w ;  height = h ; 
        keyManager = new KeyManager();
    }
// initialize all the graphics , it'll get things ready for game  
    private void init(){       
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        
        camera = new GameCamera(this,0,0);
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }
// working on the game
    // update everything in the game    
    private void tick(){
        getKeyManager().tick();
        if(State.getState() != null) State.getState().tick();
        
    }
    // draw the screen  to see the current scene
    private void render(){
        bs = display.get_can().getBufferStrategy();
        if(bs==null){display.get_can().createBufferStrategy(3);return;}
        g = bs.getDrawGraphics(); // like a praintBrush
        // Clear the screen
        g.clearRect(0, 0, width, height);
        // Draw Here  
        if(State.getState() != null) State.getState().render(g);
        // End Drawing
        bs.show();
        g.dispose();
    }
// Run the game
    @Override
    public void run() {
        
        init();
        // The Time
        int fps = 60 ;
        double timePerTick = 1000_000_000/fps ; //time for one frame(Tick)
        double delta = 0 ;
        long now ;
        long lastTime = System.nanoTime();
        long timer=0; int frames=0 ; 
        while(running){
            now = System.nanoTime();
            delta  += (now-lastTime) ;
            timer += now-lastTime ; 
            lastTime = now ;
            if(delta >= timePerTick){
            tick();
            render();  
            delta-=timePerTick;
            frames++ ;
            }
            if(timer>=1000_000_000){
                System.out.println("The frames in 1 sec: "+frames);
                timer = 0 ; frames = 0 ;
            }
        }
        stop(); // to stop our thread
        
    }
    // Getting methods
    public KeyManager getKeyManager(){return keyManager;}
    public GameCamera getGameCamera(){return camera ;};
    public int getWidth(){return width;}
    public int getHeight(){return height ;}
    // start game
    public synchronized void start(){
        if (running){return;}
        running = true ;
        thread = new Thread(this);
        thread.start();
    }
    //stop game
    public synchronized void stop(){
        if (!running){return;}
        running = false ;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
