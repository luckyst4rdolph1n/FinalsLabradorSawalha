/**
	This Breezy class is for the Breezy power-up.
    It extends the PowerUps class and sets the foundation and image for the Breezy.
	
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

public class Breezy extends PowerUps{
    
    BufferedImage breezy;
    double x, y, width, height;

    /**
     * It sets the width, height, and position of the Breezy.
     * @param x x-position
     * @param y y-position
     */
    public Breezy(double x, double y){
        this.x = x;
        this.y = y;
        width = 18;
        height = 17;

        getPowerUpImage();
    }

    /**
     * locates the file of the image
     */
    public void getPowerUpImage(){
        try{
            breezy = ImageIO.read(getClass().getResourceAsStream("/resources/breezy.png"));
        }catch(IOException e){

        }
    }

    /**
     * returns the x-position
     */
    public double getX(){
        return x;
    }

    /**
     * returns the y-position
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
        BufferedImage image = breezy;
        g2d.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }
}
