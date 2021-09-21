
package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import java.awt.Graphics;

public abstract class State {
    // switch between states(Link the states)(game state manager)
    // show what is the state that shows on the screen
    private static State currentState = null;
    
    public static void setState(State state){currentState = state ;}    
    public static State getState(){return currentState;}
    
    
    // class
    protected Game game;
    public State(Game gm){
        game = gm ;
        
    }
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
