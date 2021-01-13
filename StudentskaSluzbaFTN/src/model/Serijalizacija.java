package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serijalizacija {
	
	public static void sacuvajPodatke() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File f = new File("podaci.txt");
		Data data = new Data();
		
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		
		try {
			out.writeObject(data);
		}
		finally {
			out.close();
		}
	}

}
