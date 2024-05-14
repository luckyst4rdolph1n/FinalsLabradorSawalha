/**
	This PowerUps class extends Entity class.
    This serves as the foundation of the powerups Chocy and Breezy.
	
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

import java.awt.*;

public abstract class PowerUps extends Entity{
    public double x, y;

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
     * draws the powerups
     */
    abstract void draw(Graphics2D g2d);

}