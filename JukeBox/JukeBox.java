import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class JukeBox {
	private static Clip clip;
	private static AudioInputStream audioInputStream;
    static Song [] playlist;
    static String status = "stop";
	public static void main(String[] args) throws Exception, LineUnavailableException, UnsupportedAudioFileException {
	

		playlist = Jukebox.loadPlaylist("[Give directory of the list of songs (.csv) file]");
		displayList(playlist);
		Scanner sc = new Scanner(System.in);
		while(true)
		{
		int songno = sc.nextInt();
		if(status.equals("play"))
		{
			System.out.println("Changing Song....");
			clip.stop();
			status="stop";
		}
		play(songno-1);
		}
	}

	private static void play(int songno) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		// create AudioInputStream object 
			
				Song s = playlist[songno];
				audioInputStream = AudioSystem.getAudioInputStream(new File("[give directory of the .wav audio files]"+s.filename).getAbsoluteFile()); 
				
				// create clip reference 
				clip = AudioSystem.getClip(); 
				
				// open audioInputStream to the clip 
				clip.open(audioInputStream); 
				
				//clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
				
				status="play";
	}

	private static void displayList(Song[] playlist) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			Song s = playlist[i];
			System.out.println(s.id+" "+s.name);
		}
	}
	
}
