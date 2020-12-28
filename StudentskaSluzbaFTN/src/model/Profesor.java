package model;

import java.util.ArrayList;
import java.util.Date;

public class Profesor {
	
	public enum Titula {
		
		BSc{
			public String toString () {
				return "BSc";
			}
		},
		
		MSc{
			public String toString () {
				return "MSc";
			}
		},
		
		mr{
			public String toString () {
				return "mr";
			}
		},
		
		dr{
			public String toString () {
				return "dr";
			}
		},
		
		ProfDr {
			public String toString () {
				return "Prof. dr";
			}
		}
	}
	
	public enum Zvanje {
		
		SaradnikUNastavi {
			public String toString () {
				return "Saradnik u nastavi";
			}
		},
		
		Asistent {
			public String toString () {
				return "Asistent";
			}
		},
		
		AsistentSaDoktoratom{
			public String toString () {
				return "Asistent sa doktoratom";
			}
		},
		
		Docent{
			public String toString () {
				return "Docent";
			}
		},
		
		VanredniProfesor{
			public String toString () {
				return "Vanredni profesor";
			}
		},
		
		RedovniProfesor{
			public String toString () {
				return "Redovni profesor";
			}
		},
		
		ProfesorEmeritus{
			public String toString () {
				return "Profesor emeritus";
			}
		}	
	}
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private String brojLicneKarte;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet>predmeti;
	
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
		this.titula = Titula.BSc;
		this.zvanje = Zvanje.Asistent;
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor (String prz, String ime, Date dt, String adrStan, String email, String adrKanc, 
					 String brlk, Titula titula, Zvanje zvanje) {
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
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor (String ime, String prezime, Titula titula, Zvanje zvanje, String brLK) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.titula = titula;
		this.zvanje = zvanje;
		this.brojLicneKarte = brLK;
		this.predmeti = new ArrayList<Predmet>();
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

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", emailAdresa="
				+ emailAdresa + ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte
				+ ", titula=" + titula + ", zvanje=" + zvanje + ", predmeti=" + predmeti + ", getPrezime()="
				+ getPrezime() + ", getIme()=" + getIme() + ", getDatumRodjenja()=" + getDatumRodjenja()
				+ ", getAdresaStanovanja()=" + getAdresaStanovanja() + ", getKontaktTelefon()=" + getKontaktTelefon()
				+ ", getEmailAdresa()=" + getEmailAdresa() + ", getAdresaKancelarije()=" + getAdresaKancelarije()
				+ ", getBrojLicneKarte()=" + getBrojLicneKarte() + ", getTitula()=" + getTitula() + ", getZvanje()="
				+ getZvanje() + ", getPredmeti()=" + getPredmeti() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
