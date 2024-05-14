/**
	This Player class is for the individual characters of the game.
    This serves as the foundation of the player as well as for the image of the player.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 3 May 2024
	
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

public class Player{

    public BufferedImage player;
    public double x, y, speed, width, height;
    public double velx, vely, jumpVel;
    public double gravity;
    public boolean collides, grav;
    public String imgPath;

    /**
     * constructor for player
     * @param x x position
     * @param y y position
     * @param imgPath location of file
     */
    public Player(double x, double y, String imgPath){
        this.x = x;
        this.y = y;
        this.imgPath = imgPath;
        getPlayerImage();
        setDefaultValues();
    }
    
    /**
     * fetches the file
     */
    public void getPlayerImage(){
        try{
            player = ImageIO.read(getClass().getResourceAsStream(imgPath));
        }catch(IOException e){

        }
    }

    /**
     * sets the default values of some of the parameters of the player
     */
    public void setDefaultValues(){
        speed = 5;
        width = 40;
        height = 40;
        gravity = 1;
        jumpVel = 15;
    }

    /**
     * sets the bottom of the player
     * @param top topmost part of player
     */
    public void setBottom(double top){
        y = top - height;
    }

    /**
     * sets the top of the player
     * @param bottom bottommost part of player
     */
    public void setTop(double bottom){
        y = bottom;
    }

    /**
     * sets the right part of the player
     * @param left leftmost part of the player
     */
    public void setRight(double left){
        x = left - width;
    }

    /**
     * sets the left part of the player
     * @param right rightmost part
     */
    public void setLeft(double right){
        x = right;
    }

    /**
     * returns x position
     * @return x
     */
    public double getX(){
        return x;
    }

    /**
     * returns y position
     * @return y
     */
    public double getY(){
        return y;
    }

    /**
     * sets the x coordinate
     * @param n new x coordinate
     */
    public void setX(double n){
        x = n;
    }

    /**
     * sets the y coordinate
     * @param n new y coordinate
     */
    public void setY(double n){
        y = n;
    }

    /**
     * draws the player
     * @param g2d Graphics2D
     */
    public void draw(Graphics2D g2d){
        BufferedImage image = player;
        g2d.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
    }
   
}
