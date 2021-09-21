
package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;
import java.awt.Graphics;

public class GameState extends State {
    
    private Player player ; 
    private World world ;
     
    public GameState(Game gm){
        super(gm);
        world = new World(gm , "Res/worlds/world1.txt");
        player = new Player(gm,50,50) ; 
        
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }
    
    
    
}
