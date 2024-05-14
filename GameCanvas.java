/**
	This GameCanvas class is for drawing the images.
    It draws the playing field and the entities.
	
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
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameCanvas extends JComponent{
    private int width;
    private int height;

    Thread gameThread;
    Player player1, player2;
    //Enemy enemy1;
    Background bg1;
    Platforms baseGround, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
    boolean running;
    public ArrayList<Platforms> platforms;
    public ArrayList<Breezy> breezies;
    public ArrayList<Chocy> chocies;

    public Flag flag;
    //KeyHandler playerKey;

    private int FPS = 60;

    /**
     * constructor for the canvas
     * @param w width
     * @param h height
     * @param plyr1 first player
     * @param plyr2 second player
     * @param bg1 the background
     * @param platforms platforms
     * @param breezies Breezy power ups
     * @param chocies Chocy power ups
     * @param flag finish line
     */
    public GameCanvas(int w, int h, Player plyr1, Player plyr2, Background bg1, ArrayList<Platforms> platforms, ArrayList<Breezy> breezies, ArrayList<Chocy> chocies, Flag flag){
        width = w;
        height = h;
        player1 = plyr1;
        player2 = plyr2;
        this.bg1 = bg1;
        this.platforms = platforms;
        this.breezies = breezies;
        this.chocies = chocies;
        this.flag = flag;
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * casts the graphics into Graphics 2D
     */
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        bg1.draw(g2d); 

        flag.draw(g2d);

        for(int i=0; i<platforms.size(); i++){
            platforms.get(i).draw(g2d);
        }

        for(int i=0; i<breezies.size(); i++){
            breezies.get(i).draw(g2d);
        }

        for(int i=0; i<chocies.size(); i++){
            chocies.get(i).draw(g2d);
        }

        player1.draw(g2d);
        player2.draw(g2d);

        g2d.dispose();
        
    }
}
