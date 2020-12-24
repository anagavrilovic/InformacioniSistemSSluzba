package model;

import java.util.ArrayList;

public class Predmet {
	
	public enum Semestar{
		 ZIMSKI(0), LETNJI(1);
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
	private ArrayList<String> studentiPolozili;
	private ArrayList<String> studentiNisuPolozili;
	
	public Predmet() {
		super();
		this.sifraPredmeta = "";
		this.nazivPredmeta = "";
		this.semestar = Semestar.ZIMSKI;
		this.godinaStudija = 0;
		this.profesor = new Profesor();
		this.espb = 0;
		this.studentiPolozili = new ArrayList<String>();
		this.studentiNisuPolozili = new ArrayList<String>();
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija, 
					Profesor profesor, int espb, ArrayList<String> studentiPolozili, 
					ArrayList<String> studentiNisuPolozili) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
		this.studentiPolozili = studentiPolozili;
		this.studentiNisuPolozili = studentiNisuPolozili;
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

	public ArrayList<String> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(ArrayList<String> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public ArrayList<String> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(ArrayList<String> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
}
