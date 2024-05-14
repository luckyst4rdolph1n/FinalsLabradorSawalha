/**
	This abstract class of Entity is for setting the sprites.
    It is the backbone of the layout and imaging of the game.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 2 May 2024
	
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

public abstract class Entity {
    public double x, y, w, h, speed;

    //public BufferedImage player, enemy;
    //public Rectangle hitbox;

    /**
     * drawing the entity
     * @param g2d graphics2D for drawing
     */
    abstract void draw(Graphics2D g2d);

    /**
     * gets the x-position
     * @return x
     */
    public double getX(){
        return x;
    }

    /**
     * gets the y-position
     * @return y
     */
    public double getY(){
        return y;
    }

    /**
     * gets the width
     * @return w
     */
    public double getWidth(){
        return w;
    }

    /**
     * gets the height
     * @return h
     */
    public double getHeight(){
        return h;
    }

    /**
     * identifies top of the object
     * @return y coordinate of the top
     */
    public double getTop(){
        double top = y;
        return top;
    }

    /**
     * identifies bottom of the object
     * @return y coordinate of the bottom
     */
    public double getBottom(){
        double bottom = y + h;
        return bottom;
    }

    /**
     * identifies right of the object
     * @return x coordinate of the right
     */
    public double getRight(){
        double right = x + w;
        return right;
    }

    /**
     * identifies top of the object
     * @return x coordinate of the left
     */
    public double getLeft(){
        double left = x;
        return left;
    }

}
