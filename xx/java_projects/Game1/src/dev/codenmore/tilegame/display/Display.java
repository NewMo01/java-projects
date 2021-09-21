
package dev.codenmore.tilegame.display;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
public class Display {
// Definitions
    private String title ; private int width,height;
    private JFrame frame ;  private Canvas canvas ;
// constructor    
    public Display(String t , int w , int h){
        title = t ; width = w ; height = h ;
        screen(); 
    }
    
    private void screen(){
// frame
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setLocation(200,70);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
// canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        frame.add(canvas); frame.pack();
    }
    public Canvas get_can(){return canvas;}
    public JFrame getFrame(){return frame;}
}
