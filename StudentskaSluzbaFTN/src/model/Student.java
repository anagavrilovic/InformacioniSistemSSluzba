package model;

import java.util.ArrayList;
import java.util.Date;

enum Status{B, S};

public class Student {
	public String prezime;
	public String ime;
	public Date datumRodjenja;
	public String adresaStanovanja;
	public String kontaktTelefon;
	public String email;
	public String brojIndeksa;
	public int godinaUpisa;
	public int trGodStudija;
	public Status status;
	public double prosecnaOcena;
	public ArrayList<Ocena> spisakPolozenih;
	public ArrayList<Predmet> spisakNepolozenih;
	
	
	public Student() {
		super();
		this.prezime = "";
		this.ime = "";
		this.datumRodjenja = new Date();
		this.adresaStanovanja = "";
		this.kontaktTelefon = "";
		this.email = "";
		this.brojIndeksa = "";
		this.godinaUpisa = 0;
		this.trGodStudija = 0;
		this.status = Status.B;
		this.prosecnaOcena = 0;
		this.spisakPolozenih = new ArrayList<Ocena>();
		this.spisakNepolozenih = new ArrayList<Predmet>();
	}

	public Student(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, int godinaUpisa, int trGodStudija, Status status, double prosecnaOcena,
			ArrayList<Ocena> spisakPolozenih, ArrayList<Predmet> spisakNepolozenih) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trGodStudija = trGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.spisakPolozenih = spisakPolozenih;
		this.spisakNepolozenih = spisakNepolozenih;
	}
	
	public Student(String prezime, String ime, String brojIndeksa, int trGodStudija, Status status,
			double prosecnaOcena) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.brojIndeksa = brojIndeksa;
		this.trGodStudija = trGodStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrGodStudija() {
		return trGodStudija;
	}

	public void setTrGodStudija(int trGodStudija) {
		this.trGodStudija = trGodStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Ocena> getSpisakPolozenih() {
		return spisakPolozenih;
	}

	public void setSpisakPolozenih(ArrayList<Ocena> spisakPolozenih) {
		this.spisakPolozenih = spisakPolozenih;
	}

	public ArrayList<Predmet> getSpisakNepolozenih() {
		return spisakNepolozenih;
	}

	public void setSpisakNepolozenih(ArrayList<Predmet> spisakNepolozenih) {
		this.spisakNepolozenih = spisakNepolozenih;
	}
	
	public void dodajPolozen(Ocena ocena, Predmet predmet) {
		spisakPolozenih.add(ocena);
		ukloniNepolozen(predmet);
	}
	
	public void dodajNepolozen(Predmet predmet) {
		spisakNepolozenih.add(predmet);
	}
	
	public void ukloniNepolozen(Predmet predmet) {
		spisakNepolozenih.remove(predmet);
	}
	
}
