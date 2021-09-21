
package dev.codenmore.tilegame.worlds;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;
import java.awt.Graphics;

public class World {
    
    private Game game ;
    private int width , height , spwanX , spwanY ;
    private int[][] tiles ;
    
    public World(Game game ,String path){
        this.game = game ;
        loadWorld(path);
    }
    
    public void tick(){
        
    }
    public void render(Graphics g){
        // we make a limit to render just the tiles that we see not all tiles to be more efficient
        int xStart = (int)Math.max(0, game.getGameCamera().getXOffSet()/Tile.TILEWIDTH );
        int xEnd = (int)Math.min(width, (game.getGameCamera().getXOffSet()+game.getWidth())/Tile.TILEWIDTH+1) ;
        int yStart = (int)Math.max(0, game.getGameCamera().getYOffSet()/Tile.TILEHEIGHT ); ;
        int yEnd = (int)Math.min(height,(game.getGameCamera().getYOffSet()+game.getHeight())/Tile.TILEHEIGHT+1) ; ;
        
        for(int y=yStart ; y<yEnd ; y++){
            for(int x=xStart ; x<xEnd ; x++)
                getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH-game.getGameCamera().getXOffSet()) , 
                        (int)(y*Tile.TILEHEIGHT-game.getGameCamera().getYOffSet()) );
        }
    }
    public Tile getTile(int x , int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)return Tile.dirtTile;
        return t  ;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+"); // to split it on space or newLine
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spwanX = Utils.parseInt(tokens[2]);
        spwanY = Utils.parseInt(tokens[3]);
        
        tiles  = new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y*width)+4]);
            }
        }
    }
    
    
}
