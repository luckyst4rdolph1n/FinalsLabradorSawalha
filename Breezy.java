import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;

public class Breezy extends PowerUps{
    
    BufferedImage breezy;
    double x, y, width, height;

    public Breezy(double x, double y){
        this.x = x;
        this.y = y;
        width = 18;
        height = 17;

        getPowerUpImage();
    }

    public void getPowerUpImage(){
        try{
            breezy = ImageIO.read(getClass().getResourceAsStream("/resources/breezy.png"));
        }catch(IOException e){

        }
    }

    /*public void addSpeed(double speedx){

    }*/

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

    public void setX(double n){
        x = n;
    }

    public void setY(double n){
        y = n;
    }


    public void draw(Graphics2D g2d){
        BufferedImage image = breezy;
        g2d.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
    }
}
