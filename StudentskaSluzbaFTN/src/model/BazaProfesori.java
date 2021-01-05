package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Predmet.Semestar;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class BazaProfesori {
	
	private static BazaProfesori instance = null;

	public static BazaProfesori getInstance() {
		if (instance == null) {
			instance = new BazaProfesori();
		}
		return instance;
	}

	private List<Profesor> profesori;
	private List<Profesor> prikaziProfesore = new ArrayList<Profesor>();
	private List<String> kolone;
	private ArrayList<Predmet> profesorNePredaje;

	private BazaProfesori() {
		
		inicijalizacijaPredmeta();
		inicijalizacijaProfesira();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		this.kolone.add("Broj lične karte");
	}

	private void inicijalizacijaProfesira() {
		this.profesori = new ArrayList<Profesor>();
		Profesor p1 = new Profesor("Aleksandar", "Kovačević", Titula.dr, Zvanje.RedovniProfesor, "726941852");
		//p1.getPredmeti().add((new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI)));
		//p1.setProfesorNePredaje(profesorNePredaje);
		profesori.add(p1);
		Profesor p2 = new Profesor("Veljko", "Petrović", Titula.ProfDr, Zvanje.RedovniProfesor, "882651493");
		//p2.getPredmeti().add(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		profesori.add(p2);
		profesori.add(new Profesor("Milan", "Rapaić", Titula.ProfDr, Zvanje.VanredniProfesor, "010607244"));
		profesori.add(new Profesor("Petar", "Marić", Titula.dr, Zvanje.Docent, "040961175"));
	}
	
	private void inicijalizacijaPredmeta() {
		
		this.profesorNePredaje = new ArrayList<Predmet>();
		//predmeti.add(new Predmet("E2212", "Matematička analiza 1", 9, 1, Semestar.ZIMSKI));
		profesorNePredaje.add(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		profesorNePredaje.add(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		profesorNePredaje.add(new Predmet("E2218", "Operativni sistemi", 8, 2, Semestar.LETNJI));
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public ArrayList<Predmet> getProfesorNePredaje() {
		return profesorNePredaje;
	}

	public void setProfesorNePredaje(ArrayList<Predmet> profesorNePredaje) {
		this.profesorNePredaje = profesorNePredaje;
	}
	
	
	public List<Profesor> getPrikaziProfesore() {
		return prikaziProfesore;
	}

	public void setPrikaziProfesore(List<Profesor> prikaziProfesore) {
		this.prikaziProfesore = prikaziProfesore;
	}

	public void nadjiPredmeteKojeNePredajeProfesor(String brLK) {
		ArrayList<Predmet> ret = new ArrayList<Predmet>();
		
		for(Profesor prof : profesori) {
			if(prof.getBrojLicneKarte().equals(brLK)) {
				for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
					if(!(p.getProfesor().getBrojLicneKarte().equals(brLK))) {
						ret.add(p);
					}
				}
				prof.setProfesorNePredaje(ret);
				setProfesorNePredaje(ret);
			}
		}
	}
	
	public ArrayList<Profesor> prikaziProfesore() {
		ArrayList<Profesor> ret = new ArrayList<Profesor>();
		
		for(Profesor p : profesori) {
			if(p.getDodaj())
				ret.add(p);
		}
		
		return ret;
	}
	
	public void setListaIzabranih() {
		this.prikaziProfesore = prikaziProfesore();
	}
	
	public void prikaziSve() {
		for(Profesor p : this.profesori) {
			p.setDodaj(true);
		}
		
		this.setListaIzabranih();
	}
	

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
	
			Profesor profesor = this.prikaziProfesore.get(row);
			switch (column) {
			case 0:
				return profesor.getIme();
			case 1:
				return profesor.getPrezime();
			case 2:
				return profesor.getTitula().toString();
			case 3:
				return profesor.getZvanje().toString();	
			case 4:
				return profesor.getBrojLicneKarte();
			default:
				return null;
			}
	}

	public void dodajProfesora(Profesor p) {
		this.profesori.add(p);
	}
	
	public boolean validirajProfesora(String brLK) {
		
		 if(BazaProfesori.getInstance() != null) {
			 for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
				 if(brLK.equals(p.getBrojLicneKarte())) {
					 return false;
				 }
			 }
		 }
		 return true;
	}
	
	public Profesor nadjiProfesora(String brLK) {
		
		Profesor ret = null;
		
		for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
			 if(brLK.equals(p.getBrojLicneKarte())) {
				 ret =  p;
				 break;
			 }
		 }

		return ret;
	}

	public void izbrisiProfesora(String brojLK) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(brojLK)) {
				profesori.remove(p);
				break;
			}
		}
	}

	public void izmeniProfesora(String prz, String ime, Date datum, String adresaStan,
			  					String brTel, String eMail, String adresaKanc,
			  					String brLK, Titula titula, Zvanje zvanje, String kljuc) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(kljuc)) {
				p.setIme(ime);
				p.setPrezime(prz);
				p.setDatumRodjenja(datum);
				p.setAdresaStanovanja(adresaStan);
				p.setKontaktTelefon(brTel);
				p.setEmailAdresa(eMail);
				p.setAdresaKancelarije(adresaKanc);
				p.setBrojLicneKarte(brLK);
				p.setTitula(titula);
				p.setZvanje(zvanje);
	
				break;
			}
		}
		ispisiListu();
	}
	
	public void ispisiListu() {
		
		for(Profesor p : profesori)
			System.out.println(p);
	}
}
