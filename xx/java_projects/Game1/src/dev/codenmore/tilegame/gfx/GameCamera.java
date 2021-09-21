
package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public class GameCamera {
    
    private Game game ;
    private float xOffSet , yOffSet ;
    
    public GameCamera(Game gm ,float xoffset , float yoffset){
        game = gm ;
        xOffSet = xoffset ;
        yOffSet = yoffset ;
    }
    
    public void centerOnEntity(Entity e){
        xOffSet = e.getX()-game.getWidth()/2 + e.getWidth()/2 ;
        yOffSet = e.getY()-game.getHeight()/2 + e.getHeight()/2 ;
    }
    
    public void move(float xAmt , float yAmt){
        xOffSet += xAmt ;
        yOffSet += yAmt ;
    }
    
// XoffSet
    public void setXOffSet(float xoff){xOffSet = xoff ;}
    public float getXOffSet(){ return xOffSet  ;}
// YOffSet
    public void setYOffSet(float yoff){yOffSet = yoff ;}
    public float getYOffSet(){ return yOffSet  ;}
    
}
