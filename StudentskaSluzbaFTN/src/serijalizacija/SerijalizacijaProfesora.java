package serijalizacija;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaProfesori;
import model.Profesor;

public class SerijalizacijaProfesora {
	
	public static void ispisiProfesore()throws IOException {
		
		ObjectOutputStream out = null;
		 
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("profesori.bin")));
			out.writeObject(BazaProfesori.getInstance().getProfesori());
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
	
	public static void ucitajProfesore() throws IOException {
		 
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("profesori.bin")))){

			BazaProfesori.getInstance().setProfesori((List<Profesor>) ois.readObject());
 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 
	}
}
