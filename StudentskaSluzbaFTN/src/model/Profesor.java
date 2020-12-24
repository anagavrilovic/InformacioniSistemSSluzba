package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor {
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private String titula;
	private String zvanje;
	private ArrayList<String>predmeti;
	
	public Profesor () {
		super();
		this.prezime = "";
		this.ime = "";
		this.datumRodjenja = new Date();
		this.adresaStanovanja = "";
		this.kontaktTelefon = "";
		this.emailAdresa = "";
		this.adresaKancelarije = "";
		this.brojLicneKarte = "";
		this.titula = "";
		this.zvanje = "";
		this.predmeti = new ArrayList<String>();
	}
	
	public Profesor (String prz, String ime, Date dt, String adrStan, String email, String adrKanc, 
					String brlk, String titula, String zvanje) {
		super();
		this.prezime = prz;
		this.ime = ime;
		this.datumRodjenja = dt;
		this.adresaStanovanja = adrStan;
		this.emailAdresa = email;
		this.adresaKancelarije = adrKanc;
		this.brojLicneKarte = brlk;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = new ArrayList<String>();
	}
	
	public Profesor (Profesor p) {
		super();
		this.prezime = p.prezime;
		this.ime = p.ime;
		this.datumRodjenja = p.datumRodjenja;
		this.adresaStanovanja = p.adresaStanovanja;
		this.emailAdresa = p.emailAdresa;
		this.adresaKancelarije = p.adresaKancelarije;
		this.brojLicneKarte = p.brojLicneKarte;
		this.titula = p.titula;
		this.zvanje = p.zvanje;
		this.predmeti = p.predmeti;
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

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<String> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<String> predmeti) {
		this.predmeti = predmeti;
	}
}
