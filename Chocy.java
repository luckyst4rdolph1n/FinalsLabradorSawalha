/**
	This Chocy class is for the Chocy power-up.
    It extends the PowerUps class and sets the foundation and image for the Chocy.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 10 May 2024
	
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
import java.awt.image.BufferedImage;
import java.awt.*;

public class Chocy extends PowerUps{
    
    BufferedImage chocy;
    double x, y, width, height;

    /**
     * constructor that sets the size and position of the Chocy
     * @param x x-position
     * @param y y-position
     */

    public Chocy(double x, double y){
        this.x = x;
        this.y = y;
        width = 15;
        height = 22;

        getPowerUpImage();
    }
    
    /**
     * locates the file for the image of the power-up
     */

    public void getPowerUpImage(){
        try{
            chocy = ImageIO.read(getClass().getResourceAsStream("/resources/chocy.png"));
        }catch(IOException e){

        }
    }

    /**
     * returns x positon
     */

    public double getX(){
        return x;
    }

    /**
     * returns y position
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
     * sets the x-position
     * @param n new x-position
     */

    public void setX(double n){
        x = n;
    }

    /**
     * sets the y-position
     * @param n new y-position
     */

    public void setY(double n){
        y = n;
    }

    /**
     * draws the power-up
     */
    
    public void draw(Graphics2D g2d){
        BufferedImage image = chocy;
        g2d.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }
}
