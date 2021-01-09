package serijalizacija;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.BazaProfesori;
import model.Profesor;

public class SerijalizacijaProfesora {
	
public static void ispisiProfesore()throws IOException {
		
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("profesori.txt")));
			for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
				out.writeObject(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
}
