package model;

import java.util.ArrayList;
import java.util.List;


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
	
	private BazaStudenti() {
		
		initStudente();
		
		kolone = new ArrayList<String>();
		kolone.add("Indeks");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Godina studija");
		kolone.add("Status");
		kolone.add("Prosek");
	}
	
	private void initStudente() {
		studentList = new ArrayList<Student>();
		
		studentList.add(new Student("Gavrilović", "Ana", "RA65/2018", 3, Status.B, 10.0));
		studentList.add(new Student("Klještan", "Marija", "RA55/2018", 3, Status.B, 10.0));
		studentList.add(new Student("Samardžija", "Milica", "RA66/2018", 3, Status.B, 10.0));
		studentList.add(new Student("Atić", "Nevena", "RA67/2018", 3, Status.B, 10.0));
		studentList.add(new Student("Mijatović", "Nikola", "RA87/2018", 3, Status.B, 10.0));
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studentList.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studentList.get(row);
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
	
	public void dodajStudenta(String brojIndeksa, String ime, String prezime, int trGodStudija, Status status, double prosecnaOcena) {
		studentList.add(new Student(prezime, ime, brojIndeksa, trGodStudija, status, prosecnaOcena));
	}
	
	public void izbrisiStudenta(String indeks) {
		for (Student s : studentList) {
			if (s.getBrojIndeksa() == indeks) {
				studentList.remove(s);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String brIndeksa, String ime, String prezime, int trGodStudija, Status status, double prosecnaOcena) {
		for (Student s : studentList) {
			if (s.getBrojIndeksa() == brIndeksa) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setTrGodStudija(trGodStudija);
				s.setStatus(status);
				s.setProsecnaOcena(prosecnaOcena);
			}
		}
	}
	
}
