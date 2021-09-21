
package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
    
    // static stuff 
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile rockTile = new RockTile(2);
    
    // class
    public static final int TILEWIDTH = 64 , TILEHEIGHT = 64 ;
    protected BufferedImage Texture; 
    protected final int id ;
    
    public Tile(BufferedImage T , int I){
        Texture = T ;                                       
        id = I ;  
        tiles[id] = this ;
    }
    
    public void tick(){
        
    }
    public void render(Graphics g ,int x , int y ){
        g.drawImage(Texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    public boolean isSolid(){ // u can walk or not(walkableTiles ?)
        // Solid = can't walk , notSolid = can walk
        return false ;
    }
    
    public int getId(){return id ;}
    
}
