package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serijalizacija {
	
	public static void sacuvajPodatke() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File f = new File("podaci.bin");
		Data data = new Data();
		
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		
		try {
			out.writeObject(data);
		}
		finally {
			out.close();
		}
	}
	
	public static void deserijalizuj()  {
		File file = new File("podaci.bin");
		Data data = new Data();
		
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			data = (Data) ois.readObject();
			BazaStudenti.getInstance().setStudentList(data.getStudenti());
			BazaProfesori.getInstance().setProfesori(data.getProfesori());
			BazaPredmeti.getInstance().setPredmeti(data.getPredmeti());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
