/**
	This KeyHandler class manages the keyboard input.
    It is necessary for moving the player.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 6 May 2024

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

import java.awt.event.*;

public class KeyHandler implements KeyListener{

    public boolean playerUp, playerDown, playerRight, playerLeft;
    public boolean startingPage;

    @Override
    public void keyTyped(KeyEvent e){

    }

    /**
     * sets a variable as true when an arrow is pressed
     */
    
    @Override
    public void keyPressed(KeyEvent e){
        int pressed = e.getKeyCode();

        if(pressed == KeyEvent.VK_UP){
            playerUp = true;
        }if(pressed == KeyEvent.VK_DOWN){
            playerDown = true;
        }if(pressed == KeyEvent.VK_RIGHT){
            playerRight = true;
        }if(pressed == KeyEvent.VK_LEFT){
            playerLeft = true;
        }if(pressed == KeyEvent.VK_S){
            startingPage = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int pressed = e.getKeyCode();

        if(pressed == KeyEvent.VK_UP){
            playerUp = false;
        }if(pressed == KeyEvent.VK_DOWN){
            playerDown = false;
        }if(pressed == KeyEvent.VK_RIGHT){
            playerRight = false;
        }if(pressed == KeyEvent.VK_LEFT){
            playerLeft = false;
        }if(pressed == KeyEvent.VK_LEFT){
            playerLeft = false;
        }
    }
}