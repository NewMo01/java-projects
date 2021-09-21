
package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.gfx.Assets;
import java.awt.Graphics;

public class Player extends Creature {
    
    
    public Player(Game gm ,float x_p, float y_p){
        super(gm , x_p , y_p ,Creature.DEFAULT_WIDTH,Creature.DEFALUT_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }
    private void getInput(){
        xMove = 0 ; yMove = 0 ;
        if(game.getKeyManager().up){ yMove = -speed; }
        if(game.getKeyManager().down){ yMove = speed; }
        if(game.getKeyManager().left){ xMove = -speed ; }
        if(game.getKeyManager().right){ xMove = speed; }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage( Assets.player , (int)(x-game.getGameCamera().getXOffSet()) 
                , (int)(y-game.getGameCamera().getYOffSet()),width,height , null);
    }
    
}
