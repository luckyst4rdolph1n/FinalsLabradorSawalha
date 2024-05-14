import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Platforms extends Entity{

    public BufferedImage pf;
    public String imgPath;
    private double x, y, w, h;

    public Platforms(String imgPath, double x, double y, double w, double h){
        this.imgPath = imgPath;
        this.x = x;//0
        this.y = y;//570;
        this.w = w;//800;
        this.h = h;//31;
        setImages();
    }

    public void setImages(){
        try{
            pf = ImageIO.read(getClass().getResourceAsStream(imgPath));
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
        BufferedImage img = pf;
        g2d.drawImage(img, (int)x, (int)y, (int)w, (int)h, null);
    }
}
