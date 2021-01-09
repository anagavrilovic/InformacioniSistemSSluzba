package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{
	
	public enum Semestar{
		 ZIMSKI(0) {
			 public String toString() {
				 return "Zimski";
				 }
		 }, 
		 LETNJI(1) {
			 public String toString() {
				 return "Letnji";
		}
	 };
	 int doba;
	
	private Semestar () {}
	private Semestar (int i) {this.doba=i;}
}
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private int godinaStudija;
	private Profesor profesor;
	private int espb;
	private ArrayList<Student> studentiPolozili;
	private ArrayList<Student> studentiNisuPolozili;
	private transient boolean prikazi;
	
	public Predmet() {
		super();
		this.sifraPredmeta = "";
		this.nazivPredmeta = "";
		this.semestar = Semestar.ZIMSKI;
		this.godinaStudija = 0;
		this.profesor = new Profesor();
		this.espb = 0;
		this.studentiPolozili = new ArrayList<Student>();
		this.studentiNisuPolozili = new ArrayList<Student>();
		this.prikazi = true;
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, 
				   Profesor profesor, int espb, ArrayList<Student> studentiPolozili, 
				   ArrayList<Student> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
		this.prikazi = true;
	}
	
	public Predmet(String sifra, String naziv, int espb, int godina, Semestar semestar) {
		super();
		this.sifraPredmeta = sifra;
		this.nazivPredmeta = naziv;
		this.espb = espb;
		this.godinaStudija = godina; 
		this.semestar = semestar;
		this.studentiPolozili = new ArrayList<Student>();
		this.studentiNisuPolozili = new ArrayList<Student>();
		this.profesor = new Profesor();
		this.prikazi = true;
	}
	
	public Predmet(Predmet p) {
		super();
		this.sifraPredmeta = p.sifraPredmeta;
		this.nazivPredmeta = p.nazivPredmeta;
		this.semestar = p.semestar;
		this.godinaStudija = p.godinaStudija;
		this.profesor = p.profesor;
		this.espb = p.espb;
		this.studentiPolozili = p.studentiPolozili;
		this.studentiNisuPolozili = p.studentiNisuPolozili;
		this.prikazi = true;
	}

	
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public ArrayList<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(ArrayList<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	
	public boolean isPrikazi() {
		return prikazi;
	}

	public void setPrikazi(boolean prikazi) {
		this.prikazi = prikazi;
	}

	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", profesor=" + profesor + ", espb=" + espb
				+ ", studentiPolozili=" + studentiPolozili + ", studentiNisuPolozili=" + studentiNisuPolozili + "]";
	}
	
	public String getSifraNaziv() {
		return this.getSifraPredmeta() + " - " + this.getNazivPredmeta();
	}
	
	// STUDENT 1: 
	// funkcionalnost: #dodavanje_profesora_na_predmet
	public String getImePrezimeProfesora() {
		if(!this.getProfesor().getBrojLicneKarte().equals(""))
			return this.getProfesor().getBrojLicneKarte() + " - " + this.getProfesor().getIme() + " " + this.getProfesor().getPrezime();
		else
			return "";
	}
	
}
