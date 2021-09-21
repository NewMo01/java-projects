
package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public abstract class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=4.0f;
    public static final int DEFAULT_WIDTH = 40 ,
                            DEFALUT_HEIGHT = 40;
    
    protected int health ;
    protected float speed ;
    protected float xMove,yMove;
    
    public Creature(Game game ,float x_p, float y_p,int w,int h) {
        super(game , x_p, y_p,w,h);
        health = DEFAULT_HEALTH ; 
        speed = DEFAULT_SPEED;
        xMove=0 ;
        yMove=0;
    }
    public void move(){
        x += xMove ;
        y += yMove ;
    }
    // Getters and setters
    public void setXMove(float xm){xMove=xm;}
    public float getXMove(){return xMove;}
    
    public void setYMove(float ym){yMove=ym;}
    public float getYMove(){return yMove;}
    
    public void setHealth(int h){health=h;}
    public int getHealth(){return health;}
    
    public void setSpeed(float s){speed=s;}
    public float getSpeed(){return speed;}
    
    
}
