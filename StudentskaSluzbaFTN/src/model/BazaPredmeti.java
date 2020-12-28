package model;

import java.util.ArrayList;
import java.util.List;

import model.Predmet.Semestar;

public class BazaPredmeti {
	
	private static BazaPredmeti instance = null;

	public static BazaPredmeti getInstance() {
		if (instance == null) {
			instance = new BazaPredmeti();
		}
		return instance;
	}

	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmeti() {
	
		inicijalizacijaPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj bodova");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
	}

	private void inicijalizacijaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("E2212", "Matematička analiza 1", 9, 1, Semestar.ZIMSKI));
		predmeti.add(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		predmeti.add(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		predmeti.add(new Predmet("E2218", "Operativni sistemi", 8, 2, Semestar.LETNJI));
	}
	
	public boolean validirajSifruPredmeta(String sifraPred) {
		if(BazaPredmeti.getInstance() != null) {
			for(Predmet predmet : BazaPredmeti.getInstance().getPredmeti()) {
				if (sifraPred.equals(predmet.getSifraPredmeta())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public Predmet pronadjiPredmet(String sifra) {
		for(Predmet predmet : this.getPredmeti()) {
			if (sifra.equals(predmet.getSifraPredmeta())) {
				return predmet;
			} 
		}
		
		return new Predmet();
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}


	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getEspb());
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}

	public void dodajPredmet(String sifra, String naziv, int espb, int godina, Semestar semestar) {
		this.predmeti.add(new Predmet(sifra, naziv, espb, godina, semestar));
	}
	
	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}

	public void izbrisiPredmet(String sifra) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifra)) {
				predmeti.remove(p);
				break;
			}
		}
	}

	public void izmeniPredmet(String staraSifra, String sifra, String naziv, int espb, int godina, Semestar semestar) {
		for (Predmet p : getPredmeti()) {
			if (p.getSifraPredmeta().equals(staraSifra)) {
				p.setSifraPredmeta(sifra);
				p.setNazivPredmeta(naziv);;
				p.setEspb(espb);
				p.setGodinaStudija(godina);
				p.setSemestar(semestar);
				
			}
		}
	}
}
