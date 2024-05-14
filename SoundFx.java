/**
	This SoundFx class is for playing the sounds.
    It accesses the .wav file of the sounds and makes it possible for the program to use it.
	
	@author Zandalee Beck Q. Labrador (233393); Shamika Anne E. Sawalha (235724) 
	@version 6 March 2024
	
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

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class SoundFx {
    /* The method accepts two parameters: the name of the file, and if the sound will loop
     * This gets the desired file and plays it.
    */
    public void PlaySound(String soundLocation, boolean looping) {
        try {
            File source = new File(soundLocation);
            if (source.exists()) { //the file exists and is found 
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(source);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                if (looping) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                clip.start();
            }
            
        } catch (Exception e) {//file cannot be found
            System.out.println(e);
        }
    }
}
