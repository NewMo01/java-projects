
package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class RockTile extends Tile {
    
    public RockTile(int I){
        super(Assets.stone, I);
    }
    
    @Override
    public boolean isSolid(){
        return true ;
    }
    
}
