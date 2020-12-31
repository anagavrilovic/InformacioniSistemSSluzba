package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.Predmet;
import model.Profesor;
import view.TabbedPane;

public class PretragaPredmeta {
	
	private static PretragaPredmeta instance = null;

	public static  PretragaPredmeta getInstance() {
		if (instance == null) {
			instance = new  PretragaPredmeta();
		}
		return instance;
	}
	
	private String unos;
	private String naziv;
//	public static int brojPrikazanih = 0;
	
	public PretragaPredmeta() {
		this.naziv = "";
	}
	
	public boolean validacijaUnosa(String u) {
		
		this.unos = u;
		
		String temp = u.trim();

		//preuzeto sa sajta https://www.javatpoint.com/string-tokenizer-in-java
		StringTokenizer st = new StringTokenizer(temp);
		int num = st.countTokens();
				
		if(num ==0 || num == 1)
			return true;
		else
			return false;
	}
	
	public void pronadjiPredmete() {
		
		List<Predmet> predmeti = new ArrayList<Predmet>();
		
		if(unos == null)
			unos = "";
		
		StringTokenizer st = new StringTokenizer(unos);
		
	
		while(st.hasMoreTokens()) {
			this.naziv = st.nextToken();
		}
		
		
		if(unos == "") {
			for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
				p.setPrikazi(true);
				// brojPrikazanih++;
			}
		} 
		else {
			for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
				if(p.getNazivPredmeta().toLowerCase().contains(unos.toLowerCase())) {
					p.setPrikazi(true);
					// brojPrikazanih++;
				}
				else 
					p.setPrikazi(false);
			}
		}
		
		TabbedPane.getInstance().azurirajPrikazPredmet("Pretraga predmeta", -1);
		//brojPrikazanih = 0;
	}
}
