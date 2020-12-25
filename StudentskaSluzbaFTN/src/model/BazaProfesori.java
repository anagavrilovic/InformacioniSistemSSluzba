package model;

import java.util.ArrayList;
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
		profesori.add(new Profesor("Aleksandar", "Kovačević", Titula.dr, Zvanje.RedovniProfesor));
		profesori.add(new Profesor("Veljko", "Petrović", Titula.ProfDr, Zvanje.RedovniProfesor));
		profesori.add(new Profesor("Milan", "Rapaić", Titula.ProfDr, Zvanje.VanredniProfesor));
		profesori.add(new Profesor("Petar", "Marić", Titula.dr, Zvanje.Docent));
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
		default:
			return null;
		}
	}

	public void dodajProfesora(String ime, String prezime, Titula titula, Zvanje zvanje) {
		this.profesori.add(new Profesor(ime, prezime, titula, zvanje));
	}

	/*public void izbrisiProfesora(long id) {
		for (Profesor p : profesori) {
			if (p.getId() == id) {
				profesori.remove(p);
				break;
			}
		}
	}

	public void izmeniProfesora(long id, String ime, String prezime, String titula, String zvanje) {
		for (Profesor p : profesori) {
			if (p.getId() == id) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}*/
}
