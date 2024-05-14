/**
	This Platforms class extends Entity class.
    This serves as the foundation of the platforms as well as for setting its image.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 4 May 2024
	
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

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Platforms extends Entity{

    public BufferedImage pf;
    public String imgPath;
    private double x, y, w, h;

    /**
     * constructor for Platforms
     * @param imgPath location of the file
     * @param x x position
     * @param y y position
     * @param w width
     * @param h height
     */

    public Platforms(String imgPath, double x, double y, double w, double h){
        this.imgPath = imgPath;
        this.x = x;//0
        this.y = y;//570;
        this.w = w;//800;
        this.h = h;//31;
        setImages();
    }

    /**
     * sets the image of the platform
     */

    public void setImages(){
        try{
            pf = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){
           

        }
    }

    /**
     * returns the x position
     */

    public double getX(){
        return x;
    }

    /**
     * returns the y position
     */

    public double getY(){
        return y;
    }

    /**
     * returns the width
     */

    public double getWidth(){
        return w;
    }

     /**
     * returns the height
     */

    public double getHeight(){
        return h;
    }

    /**
     * gets the top coordinate of the platform
     */

    public double getTop(){
        double top = y;
        return top;
    }

    /**
     * gets the coordinate of the bottom of the platform
     */

    public double getBottom(){
        double bottom = y + h;
        return bottom;
    }

    /**
     * gets the coordinate of the right of the platform
     */

    public double getRight(){
        double right = x + w;
        return right;
    }

    /**
     * gets the coordinate of the left of the platform
     */

    public double getLeft(){
        double left = x;
        return left;
    }

    /**
     * draws the platform
     */
    
    public void draw(Graphics2D g2d){
        BufferedImage img = pf;
        g2d.drawImage(img, (int)x, (int)y, (int)w, (int)h, null);
    }
}
