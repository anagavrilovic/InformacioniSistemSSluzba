package controller;

import java.util.ArrayList;
import java.util.StringTokenizer;

import model.BazaStudenti;
import model.Student;
import view.TabbedPane;

public class PretragaStudenata {
	
	public static PretragaStudenata instance = null;
	
	public static PretragaStudenata getInstance() {
		
		if (instance == null) {
			instance = new PretragaStudenata();
		}
		return instance;
	}
	
	private PretragaStudenata() {}
	
	
	public void pretraziStudente(String text) {
		StringTokenizer st = new StringTokenizer(text);
		ArrayList<String> reci = new ArrayList<String>();
		int brojReci = st.countTokens();
		
		while(st.hasMoreTokens()) {
			String rec = st.nextToken().toLowerCase();
			reci.add(rec);
			System.out.println(rec);
			System.out.println(brojReci);
		}
		
		for(Student s : BazaStudenti.getInstance().getStudentList())
				s.setS(true);
		
		if(brojReci != 0) {
			System.out.println("hej");
			for(Student s : BazaStudenti.getInstance().getStudentList()) {
				if(!s.getPrezime().toLowerCase().contains(reci.get(0))) {
					s.setS(false);
					System.out.println(s.getIme());
				}
			}
			
			if(reci.size() >= 2) {
				System.out.println("imam ime");
				for(Student s : BazaStudenti.getInstance().getStudentList()) {
					if(s.getS()) {
						if(!s.getIme().toLowerCase().contains(reci.get(1)))
							s.setS(false);
					}
				}
			}
			
			if(reci.size() == 3) {
				System.out.println("imam indeks");
				for(Student s : BazaStudenti.getInstance().getStudentList()) {
					if(s.getS()) {
						if(!s.getBrojIndeksa().toLowerCase().contains(reci.get(2)))
							s.setS(false);
					}
				}
			}
		}
		
		//BazaStudenti.getInstance().setListaIzabranih();
		TabbedPane.getInstance().azurirajPrikazPredmet(null, -1);
	}
	
	// https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
	public boolean validacijaUnosa(String text) {
		StringTokenizer st = new StringTokenizer(text);
		int reci = st.countTokens();
		
		if(reci > 3)
			return false;
		
		return true;
	}
	
}
