
package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private static final int width =94 , height = 94 ;
    public static BufferedImage player,tree,grass,dirt,stone ;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.Load("/Textures/sheet.png"));
        
        player = sheet.crop(0,0,width,height);
        tree = sheet.crop(width,0,width,height);
        grass = sheet.crop(width*2,0,width,height);
        dirt = sheet.crop(0,height,width,height);
        stone = sheet.crop(width,height,width,height);
    }
    
    
}
