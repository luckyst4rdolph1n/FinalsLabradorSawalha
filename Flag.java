/**
	This Flag class is for the finish line.
    It extends the Entity class and sets the foundation and image for the flag.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 5 May 2024
	
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

public class Flag extends Entity{
    
    BufferedImage flag;
    double x, y, width, height;

    public Flag(){
        x = 745;
        y = 56;
        width = 26;
        height = 27;

        getPowerUpImage();
    }

    public void getPowerUpImage(){
        try{
            flag = ImageIO.read(getClass().getResourceAsStream("/resources/flag.png"));
        }catch(IOException e){

        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getWidth(){
        return w;
    }

    public double getHeight(){
        return h;
    }

    public double getTop(){
        double top = y;
        return top;
    }

    public double getBottom(){
        double bottom = y + h;
        return bottom;
    }

    public double getRight(){
        double right = x + w;
        return right;
    }

    public double getLeft(){
        double left = x;
        return left;
    }

    public void draw(Graphics2D g2d){
        BufferedImage image = flag;
        g2d.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }
}