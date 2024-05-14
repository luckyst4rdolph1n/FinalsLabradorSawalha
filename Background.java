/**
	This Background class is for playing the sounds.
    It accesses the image for the background and sets its size.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 30 Apr 2024
	
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
**/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Background {
    
    public BufferedImage bg;
    private int bgx, bgy, bgw, bgh;
    public String path;
/**
 * finds the file and uses it as the background
 * @param path file location
 */
    public Background(String path){
        bgx = 0;
        bgy = 0;
        bgw = 800;
        bgh = 600;
        this.path = path;
        setBackgroundImage();
    }

    /**
     * finds the file
     */
    public void setBackgroundImage(){
        try{
            bg = ImageIO.read(getClass().getResourceAsStream(path));
        }catch(IOException e){

        }   
    }

    /**
     * drawing the image
     * @param g2d Graphics2D for drawing
     */
    public void draw(Graphics2D g2d){
        BufferedImage image = bg;
        
        g2d.drawImage(image, bgx, bgy, bgw, bgh, null);
    }
    
}
