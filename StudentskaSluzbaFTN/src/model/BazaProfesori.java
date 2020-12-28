package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private List<String> kolone;

	private BazaProfesori() {
	
		inicijalizacijaProfesira();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	private void inicijalizacijaProfesira() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Aleksandar", "Kovačević", Titula.dr, Zvanje.RedovniProfesor, "726941852"));
		profesori.add(new Profesor("Veljko", "Petrović", Titula.ProfDr, Zvanje.RedovniProfesor, "882651493"));
		profesori.add(new Profesor("Milan", "Rapaić", Titula.ProfDr, Zvanje.VanredniProfesor, "010607244"));
		profesori.add(new Profesor("Petar", "Marić", Titula.dr, Zvanje.Docent, "040961175"));
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}


	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
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

	/*public void izbrisiProfesora(Profesor prof) {
		for (Profesor p : profesori) {
			if (p.getId() == id) {
				profesori.remove(p);
				break;
			}
		}
	}*/

	public void izmeniProfesora(String prz, String ime, Date datum, String adresaStan,
			  					String brTel, String eMail, String adresaKanc,
			  					String brLK, Titula titula, Zvanje zvanje) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(brLK)) {
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
		//ispisiListu();
	}
	
	public void ispisiListu() {
		
		for(Profesor p : profesori)
			System.out.println(p);
	}
}
