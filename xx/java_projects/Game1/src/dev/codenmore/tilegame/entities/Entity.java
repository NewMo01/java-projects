
package dev.codenmore.tilegame.entities;

import dev.codenmore.tilegame.Game;
import java.awt.Graphics;

public abstract class Entity {
    
    protected Game game ;
    protected float x , y ;
    protected int width , height ;
    
    public Entity(Game g ,float x_p ,float y_p, int w , int h ){
        game =  g ;
        x = x_p ;
        y = y_p ; 
        width = w ;
        height = h ;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
    public void setX(float v){x=v ;}
    public float getX(){return x ;}
    
    public void setY(float v){y=v;}
    public float getY(){return y ;}
    
    public void setWidth(int w){width=w;}
    public int getWidth(){return width;}
    
    public void setHeight(int h){height=h;}
    public int getHeight(){return height;}
    
}
