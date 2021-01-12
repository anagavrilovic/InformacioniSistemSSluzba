package serijalizacija;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.BazaStudenti;
import model.Student;

public class SerijalizacijaStudenta {
	

	public static void ispisiStudente()throws IOException {
		 
		ObjectOutputStream out = null;
 
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.bin")));
			out.writeObject(BazaStudenti.getInstance().getStudentList());
			
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
}
 



