
package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage ima ;
    
    public SpriteSheet(BufferedImage s){
        ima = s ;
    }
       
    public BufferedImage crop(int x,int y,int w,int h){
        
        return ima.getSubimage(x, y, w, h);
    }
    
    
}
