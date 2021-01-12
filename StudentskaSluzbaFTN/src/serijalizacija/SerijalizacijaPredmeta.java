package serijalizacija;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaPredmeti;
import model.Predmet;

public class SerijalizacijaPredmeta {

	public static void ispisiPredmete()throws IOException {
		
		ObjectOutputStream out = null;
		 
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.bin")));
			out.writeObject(BazaPredmeti.getInstance().getPredmeti());
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void ucitajPredmete() throws IOException {
		 
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.bin")))){

			BazaPredmeti.getInstance().setPredmeti((List<Predmet>) ois.readObject());
 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 
	}
}
