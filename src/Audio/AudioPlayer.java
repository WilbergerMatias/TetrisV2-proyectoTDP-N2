package Audio;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

//import javazoom.jl.player.Player;

public class AudioPlayer implements Runnable {
	
	protected String file;
	protected int songLength =83000;
	public AudioPlayer( String file ) {
		this.file = file;
	}

	@Override
	public void run() {
		try{
			File f = new File(getClass().getClassLoader().getResource(this.file).toURI());
			FileInputStream fis = new FileInputStream(f);
			Player playMP3 = new Player(fis);
			playMP3.play();
			Thread.sleep(songLength);
		}
		catch(Exception ex)
		{  
			ex.printStackTrace();
		}
	}

}