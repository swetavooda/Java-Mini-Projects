import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Song {
  String name;
  int id;
  String artist;
  String filename;
  String album;
  int noOfTimesPlayed;
public Song(String name, String artist, String filename, String album, int id2) {
	super();
	this.name = name;
	this.artist = artist;
	this.filename = filename;
	this.album = album;
	this.id = id2;
}

}

class Jukebox
{
	static Song [] playlist;
	public static Song [] loadPlaylist(String filecsv)
	{
		
		try {
			File f = new File(filecsv);
			FileReader fis = new FileReader(f);
			BufferedReader br = new BufferedReader(fis);
			playlist = new Song[5];
			int count=0;
			String d = br.readLine();
			while (d != null)
			{
				
				//System.out.println(d);
				String song [] = d.split(",");
			    if(song != null)
			    {
			    	int id = Integer.parseInt(song[0]);
			    	String name = song[1];
			    	String artist = song[2];
			       	String album = song[3];
			    	String filename = song[4];
			     		
			    	playlist[count]=new Song(name, artist, filename, album, id);
			    }
			    count++;
			    d= br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playlist;
		
	}
	public Song[] searchByArtist(String artistName)
	{
		int k = 0;
		Song [] result = new Song[20];
		for (int i = 0; i < playlist.length; i++) {
			Song g = playlist[i];
			if(g.artist.equalsIgnoreCase(artistName))
			{
				result[k]= g;
				k++;
			}
		}
		return result;
	}
}
