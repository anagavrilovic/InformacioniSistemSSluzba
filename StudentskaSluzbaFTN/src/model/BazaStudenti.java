package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Predmet.Semestar;
import model.Student.Status;


// Klasa pisana po ugledu na klasu BazaIgraca sa vežbi
public class BazaStudenti {

	private static BazaStudenti instance = null;
	
	public static BazaStudenti getInstance() {
		if (instance == null) {
			instance = new BazaStudenti();
		}
		return instance;
	}
	
	private List<Student> studentList;
	private List<String> kolone;
	private List<String> kolonePP;							// STUDENT 1: lista naziva kolona za #prikaz_polozenih_predmeta
	private ArrayList<Predmet> nepolozeniPredmeti;
	private ArrayList<Student> izabraniStudenti;			// STUDENT 1: lista studenata koji treba da se prikažu kao rezultat pretrage
	
	private BazaStudenti() {
		
		//inicijalizacijaNepolozenihPredmeta();
		//initStudente();
		
		kolone = new ArrayList<String>();
		kolone.add("Indeks");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Godina studija");
		kolone.add("Status");
		kolone.add("Prosek");
		
		kolonePP = new ArrayList<String>();
		kolonePP.add("Šifra predmeta");
		kolonePP.add("Naziv predmeta");
		kolonePP.add("ESPB");
		kolonePP.add("Ocena");
		kolonePP.add("Datum");
	}
	
	private void initStudente() {
		studentList = new ArrayList<Student>();
		
		Student s1 = new Student("Gavrilović", "Ana", "RA65/2018", 3, Status.B);
		s1.setSpisakPolozenih(initPredmeteAna());
		s1.setProsecnaOcena(s1.izracunajProsecnuOcenu());
		s1.setSpisakNepolozenih(nepolozeniPredmeti);
		studentList.add(s1);
		Student s2 = new Student("Klještan", "Marija", "RA55/2018", 3, Status.B);
		s2.setSpisakPolozenih(initPredmeteMarija());
		s2.setProsecnaOcena(s2.izracunajProsecnuOcenu());
		studentList.add(s2);
		studentList.add(new Student("Samardžija", "Milica", "RA66/2018", 3, Status.B));
		studentList.add(new Student("Atić", "Nevena", "RA67/2018", 3, Status.B));
		Student s3 = new Student("Mijatović", "Nikola", "RA87/2018", 3, Status.B);
		s3.setSpisakPolozenih(initPredmeteNikola());
		s3.setProsecnaOcena(s3.izracunajProsecnuOcenu());
		studentList.add(s3);
	}
	
	
	private void inicijalizacijaNepolozenihPredmeta() {
		this.nepolozeniPredmeti = new ArrayList<Predmet>();
		//nepolozeniPredmeti.add(new Predmet("E2212", "Matematička analiza 1", 9, 1, Semestar.ZIMSKI));
		//nepolozeniPredmeti.add(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		nepolozeniPredmeti.add(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
	}
	
	// ------ probne inicijalizacije
	private ArrayList<Ocena> initPredmeteAna() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();
		
		Ocena o1 = new Ocena();
		o1.setPredmet(new Predmet("E2212", "Matematička analiza 1", 9, 1, Semestar.ZIMSKI));
		ocene.add(o1);
		Ocena o2 = new Ocena();
		o2.setPredmet(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		ocene.add(o2);
		Ocena o3 = new Ocena();
		o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		//ocene.add(o3);
		
		return ocene;
	}
	
	//---- probne inicijalizacije
	private ArrayList<Ocena> initPredmeteMarija() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();

		Ocena o2 = new Ocena();
		o2.setPredmet(new Predmet("E2214", "Objektno programiranje", 8, 2, Semestar.ZIMSKI));
		ocene.add(o2);
		Ocena o1 = new Ocena();
		o1.setPredmet(new Predmet("E2218", "Operativni sistemi", 8, 2, Semestar.LETNJI));
		ocene.add(o1);
		Ocena o3 = new Ocena();
		o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		ocene.add(o3);
		
		return ocene;
	}
	
	//------ probne inicijalizacije
	private ArrayList<Ocena> initPredmeteNikola() {
		ArrayList<Ocena> ocene = new ArrayList<Ocena>();

		Ocena o3 = new Ocena();
		o3.setPredmet(new Predmet("E2216", "Sistemi automatskog upravljanja", 8, 2, Semestar.LETNJI));
		ocene.add(o3);
		
		return ocene;
	}
	
	// STUDENT 1: validacija za jedinstvenost broja indeksa
	// funkcionalnost: #dodavanje_studenta
	public boolean validirajStudenta(String brojIndeksa) {
		if(BazaStudenti.getInstance() != null) {
			for(Student student : BazaStudenti.getInstance().getStudentList()) {
				if (brojIndeksa.equals(student.getBrojIndeksa())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// trazi studenta sa odreženim brojem indeksa
	public Student pronadjiStudenta(String brojIndeksa) {
		for(Student student : this.getStudentList()) {
			if (brojIndeksa.equals(student.getBrojIndeksa())) {
				return student;
			} 
		}
		
		return new Student();
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	// STUDENT 1: metode za ispis tabele za prikaz studenata
	// funkcionalnost: #prikaz_studenata
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studentList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.izabraniStudenti.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrGodStudija());
		case 4:
			if(student.getStatus() == Status.B) 
				return "Budžet";
			else
				return "Samofinansiranje";
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	public int getColumnCount() {
		return kolone.size();
	}
	
	// STUDENT 1: 
	// funkcionalnost: #dodavanje_studenta
	public void dodajStudenta(String brojIndeksa, String ime, String prezime, int trGodStudija, Status status) {
		studentList.add(new Student(prezime, ime, brojIndeksa, trGodStudija, status));
	}
	
	public void dodajStudenta(Student student) {
		studentList.add(student);
	}
	
	
	// STUDENT 1: 
	// funkcionalnost: #brisanje_studenta
	public void izbrisiStudenta(String indeks) {
		for (Student s : studentList) {
			if (s.getBrojIndeksa().equals(indeks)) {
				studentList.remove(s);
				break;
			}
		}
	}
	
	// STUDENT 1: 
	// funkcionalnost: #izmena_studenta
	public void izmeniStudenta(String stariIndeks, String ime, String prezime, Date datumRodj, String brojIndeksa, String adresa, String email, 
			String brTel, int godUpisa, int trGodStudija, Status status) {
		for (Student s : getStudentList()) {
			if (s.getBrojIndeksa().equals(stariIndeks)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodj);
				s.setAdresaStanovanja(adresa);
				s.setEmail(email);
				s.setKontaktTelefon(brTel);
				s.setBrojIndeksa(brojIndeksa);
				s.setGodinaUpisa(godUpisa);
				s.setTrGodStudija(trGodStudija);
				s.setStatus(status);
			}
		}
	}
	
	public int getColumnCountPolozeniPredmeti() {
		return 5;
	}
	
	public String getColumnNamePolozeniPredmeti(int index) {
		return this.kolonePP.get(index);
	}
	
	
	// STUDENT 1: popunjava listu studenata koji treba da se prikažu kao rezultat pretrage
	// funkcionalnost: #pretraga_studenata
	public ArrayList<Student> getlistaIzabranih() {
		ArrayList<Student> retList = new ArrayList<Student>();
		
		for(Student s : getStudentList()) {
			if(s.getS())
				retList.add(s);
		}
		
		return retList;
	}
	
	public void setListaIzabranih() {
		this.izabraniStudenti = getlistaIzabranih();
	}
	
	// STUDENT 1: kada treba prikazati sve studente
	// funkcionalnost: #prikaz_studenata #pretraga_studenata
	public void izaberiSve() {
		for(Student s : this.getStudentList()) {
			s.setS(true);
		}
		
		this.setListaIzabranih();
	}
	
}
