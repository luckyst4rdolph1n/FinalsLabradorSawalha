/**
	This GameStarter class instantiates the game for each player.
    It connects to the server and sets up the GUI.
	
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

public class GameStarter {

    public static void main(String[] args) {
        GameFrame gf = new GameFrame(800, 600);
        gf.connectToServer();
        gf.createPlayers();
        gf.createGameScene();
        gf.setUpGUI();
    }
    
}
