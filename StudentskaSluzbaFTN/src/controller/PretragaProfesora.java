package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import model.BazaProfesori;
import model.Profesor;
import view.TabbedPane;

public class PretragaProfesora {
	
	private static PretragaProfesora instance = null;

	public static  PretragaProfesora getInstance() {
		if (instance == null) {
			instance = new  PretragaProfesora();
		}
		return instance;
	}
	
	private String unos;
	private String prezime;
	private String ime;
	
	public PretragaProfesora() {
		this.prezime = "";
		this.ime = "";
	}
	
	public boolean validacijaUnosa(String u) {
		
		this.unos = u;
		
		String temp = u.trim();

		//preuzeto sa sajta https://www.javatpoint.com/string-tokenizer-in-java
		StringTokenizer st = new StringTokenizer(temp);
		int num = st.countTokens();
				
		if(num >=0 && num <= 2)
			return true;
		else
			return false;
	}
	
	public void pronadjiProfesore() {
		
		List<Profesor> profesori = new ArrayList<Profesor>();
		
		if(unos == null)
			unos = "";
		
		StringTokenizer st = new StringTokenizer(unos);
		
		String[] delovi = {"", ""};
		int i = 0;
		while(st.hasMoreTokens()) {
			delovi[i] = st.nextToken();
			i++;
		}
		
		this.prezime = delovi[0];
		this.ime = delovi[1];
		
		if(prezime == "" && ime =="") {
			for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
				p.setDodaj(true);
				BazaProfesori.getInstance().prikaziSve();
			}
		}
		else if(prezime != "" && ime == "") {
			for(Profesor p :  BazaProfesori.getInstance().getProfesori()) {
				if(p.getPrezime().toLowerCase().contains(this.prezime.toLowerCase())) {
						p.setDodaj(true);
				}
				else {
					p.setDodaj(false);
				}
			}
		}
		else {
			for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
				
				if(p.getPrezime().toLowerCase().contains(this.prezime.toLowerCase())) {
					if(p.getIme().toLowerCase().contains(this.ime.toLowerCase())) {
						p.setDodaj(true);
					}
					else {
						p.setDodaj(false);
					}
				}
				else {
					p.setDodaj(false);
				}
			}
		}
		BazaProfesori.getInstance().setListaIzabranih();
		TabbedPane.getInstance().azurirajPrikazProf("Pretraga profesora", -1);
	}
}
