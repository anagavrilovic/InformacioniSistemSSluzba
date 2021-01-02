package model;

import java.util.ArrayList;
import java.util.List;

import model.Predmet.Semestar;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

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
	
	private List<Predmet> nepolozeniPredmeti;
	private List<Predmet> profesorPredaje;
	private List<String> profesorKolone;
	private boolean prikaziPredmet;

	private BazaPredmeti() {
	
		inicijalizacijaPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
		//zaglavlje tabele koja prikazuje predmete koje predaje profesor
		
		this.profesorKolone = new ArrayList<String>();
		this.profesorKolone.add("Šifra");
		this.profesorKolone.add("Naziv");
		this.profesorKolone.add("Godina studija");
		this.profesorKolone.add("Semestar");
		
		this.nepolozeniPredmeti = new ArrayList<Predmet>();

	}

	private void inicijalizacijaPredmeta() {
		this.predmeti = new ArrayList<Predmet>();
		Predmet p1 = new Predmet("E2212", "Matematička analiza 1", 9, 1, Semestar.ZIMSKI);
		//p1.setProfesor(new Profesor("Petar", "Marić", Titula.dr, Zvanje.Docent, "040961175"));
		predmeti.add(p1);
		
		Predmet p2 = new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI);
		//p2.setProfesor(new Profesor("Aleksandar", "Kovačević", Titula.dr, Zvanje.RedovniProfesor, "726941852"));
		predmeti.add(p2);
		
		Predmet p3 = new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI);
		//p3.setProfesor(new Profesor("Milan", "Rapaić", Titula.ProfDr, Zvanje.VanredniProfesor, "010607244"));
		predmeti.add(p3);
		
		Predmet p4 = new Predmet("E2218", "Operativni sistemi", 8, 2, Semestar.LETNJI);
		//p4.setProfesor(new Profesor("Aleksandar", "Kovačević", Titula.dr, Zvanje.RedovniProfesor, "726941852"));
		predmeti.add(p4);
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
	
	public void izbrisiStudentaSaPolozenihPredmeta(String index) {
		for(Predmet p : getPredmeti()) {
			for(Student s : p.getStudentiPolozili()) {
				if (s.getBrojIndeksa().equals(index)) {
					p.getStudentiPolozili().remove(s);
					break;
				}
			}
		}
	}
	
	public void izbrisiStudentaSaNepolozenihPredmeta(String index) {
		for(Predmet p : getPredmeti()) {
			for(Student s : p.getStudentiNisuPolozili()) {
				if (s.getBrojIndeksa().equals(index)) {
					p.getStudentiNisuPolozili().remove(s);
					break;
				}
			}
		}
	}
	
	public void izbrisiProfesora(String brojLK) {
		for(Predmet p : getPredmeti()) {
			if(p.getProfesor().getBrojLicneKarte().equals(brojLK))
				p.setProfesor(new Profesor());
		}
	}
	
	public void nadjiNepolozeneIspite(String index) {
		
		List<Student> studenti = BazaStudenti.getInstance().getStudentList();
		
		for(Student s : studenti) {
			if(s.getBrojIndeksa().equals(index)) {
				setNepolozeniPredmeti(s.getSpisakNepolozenih());
				break;
			}
		}
	}
	
	public void nadjiPredmeteKojePredajeProfesor(String brLK) {
		List<Profesor> profesori = BazaProfesori.getInstance().getProfesori();
		
		//1. pristup (dodaj predmete svakom profesoru)
		/*for(Profesor prof : profesori) {
			if(prof.getBrojLicneKarte().equals(brLK)) {
				setProfesorPredaje(prof.getPredmeti());
			}
		}*/
		
		//2.pristup-> nadji preko predmeta
		ArrayList<Predmet> ret = new ArrayList<Predmet>();
		
		for(Profesor prof : profesori) {
			if(prof.getBrojLicneKarte().equals(brLK)) {
				for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
					if((p.getProfesor().getBrojLicneKarte().equals(brLK))) {
						ret.add(p);
					}
				}
				prof.setPredmeti(ret);
				setProfesorPredaje(ret);
			}
		}
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	public List<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(List<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	public List<Predmet> getProfesorPredaje() {
		return profesorPredaje;
	}

	public void setProfesorPredaje(List<Predmet> profesorPredaje) {
		this.profesorPredaje = profesorPredaje;
	}


	public int getColumnCount() {
		return 5;
	}
	
	//za tabelu koja predstavlja prikaz predmeta koje predaje profesor
	
	public String getColumNameProf(int index) {
		return this.profesorKolone.get(index);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		if(predmet.isPrikazi()) {
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
		return  "";
	}
	
	public boolean prikaziPredmet(Predmet p) {
		return prikaziPredmet;
	}
	
	//potrebno za implemenataciju pretrage predmeta
	
	public String getValueAtSort(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		if(predmet.isPrikazi()) {
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
		return "";
	}
	
	//potrebno za implementaciju prikaza nepolozenih predmeta
	
	public String getValueAtNepolozeniPredmeti(int row, int column) {
		Predmet predmet = this.nepolozeniPredmeti.get(row);
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
	
	//potrebno za implementaciju funkcionalnosti profesor predaje predmete
	
	public String getValueAtProfesorPredmeti(int row, int column) {
		Predmet predmet = this.profesorPredaje.get(row);
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

	public boolean isPrikaziPredmet() {
		return prikaziPredmet;
	}

	public void setPrikaziPredmet(boolean prikaziPredmet) {
		this.prikaziPredmet = prikaziPredmet;
	}
		
}
