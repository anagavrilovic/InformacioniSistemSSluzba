package serijalizacija;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.BazaStudenti;
import model.Student;

public class SerijalizacijaStudenta {
	

	public static void ispisiStudente()throws IOException {
		
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.txt")));
			for(Student s : BazaStudenti.getInstance().getStudentList()) {
				out.writeObject(s);
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
