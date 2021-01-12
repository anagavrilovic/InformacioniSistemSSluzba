package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Student implements Serializable {
	
	public enum Status{B, S};
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trGodStudija;
	private Status status;
	private double prosecnaOcena;
	private ArrayList<Ocena> spisakPolozenih;
	private ArrayList<Predmet> spisakNepolozenih;
	private boolean s = true;  										// indikator koji se koristi za pretragu studenata
	private transient ArrayList<Predmet> listaPredZaDodavanje;				// lista predmeta koja treba da se pojavi pri prikazu 
																	// liste predmeta za dodavanje
	
	
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
		this.spisakPolozenih = spisakPolozenih;
		this.spisakNepolozenih = spisakNepolozenih;
		this.prosecnaOcena = prosecnaOcena;
	}
	
	public Student(String prezime, String ime, String brojIndeksa, int trGodStudija, Status status) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.brojIndeksa = brojIndeksa;
		this.trGodStudija = trGodStudija;
		this.status = status;
		this.spisakNepolozenih = new ArrayList<Predmet>();
		this.spisakPolozenih = new ArrayList<Ocena>();
		this.prosecnaOcena = izracunajProsecnuOcenu();
	}
	
	// STUDENT 1: metoda koja se koristi za prikaz i računanje prosečne ocene studenta u panelu za prikaz položenih ispita 
	public double izracunajProsecnuOcenu() {
		double prosOc = 0;
		
		for(Ocena o : getSpisakPolozenih()) {
			prosOc += o.getOcena();
		}
		
		if(getSpisakPolozenih().size() != 0) {
			prosOc = prosOc/getSpisakPolozenih().size();
		} else {
			prosOc = 0;
		}
		
		this.prosecnaOcena = prosOc;
		return prosOc;
	}
	
	// STUDENT 1: metoda koja se koristi za prikaz i računanje ESPB bodova studenta u panelu za prikaz položenih ispita
	// funkcionalnost: #prikaz_polozenih_ispita
	public int getUkupnoESPB() {
		int espb = 0;
		
		for(Ocena o : getSpisakPolozenih()) {
			espb += o.getPredmet().getEspb();
		}
		
		return espb;
	}
	
	// STUDENT 1: metoda koja se koristi za prikaz tabele sa položenim ispitima studenta
	// funkcionalnost: #prikaz_polozenih_ispita
	public String getValueAt(int row, int column) {
		Ocena ocena = this.getSpisakPolozenih().get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return Integer.toString(ocena.getPredmet().getEspb());
		case 3:
			return Integer.toString(ocena.getOcena());
		case 4:
			return dateToString(ocena.getDatum());
		default:
			return null;
		}
	}
	
	// STUDENT 1: konverzija datuma u string
	private String dateToString(Date date) {
		if(date != null) {
			String retVal;
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
			retVal = sdf.format(date);
			return retVal;
		} 
		
		return "";
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

	public boolean getS() {
		return s;
	}

	public void setS(boolean s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", email=" + email
				+ ", brojIndeksa=" + brojIndeksa + ", godinaUpisa=" + godinaUpisa + ", trGodStudija=" + trGodStudija
				+ ", status=" + status + ", prosecnaOcena=" + prosecnaOcena + ", spisakPolozenih=" + spisakPolozenih
				+ ", spisakNepolozenih=" + spisakNepolozenih + "]";
	}
	
	// STUDENT 1: metoda koja formira listu predmeta koje je moguće dodati određenom studentu
	// funkcionalnost: #dodavanje_predmeta_studentu
	public void setListaPredmetaZaDodavanje() {
		ArrayList<Predmet> predmetList = new ArrayList<Predmet>();
		
		
		for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
			boolean polozen = false;
			boolean nepolozen = false;
			
			if(p.getGodinaStudija() >= getTrGodStudija()) {
				for(Ocena o : getSpisakPolozenih()) {
					if(o.getPredmet().getSifraPredmeta().equals(p.getSifraPredmeta())) {
						polozen = true;
						break;
					}
				}
				
				if(!polozen) {
					for(Predmet p1 : getSpisakNepolozenih()) {
						if(p1.getSifraPredmeta().equals(p.getSifraPredmeta())) {
							nepolozen = true;
							break;
						}
					}
					
					if(!nepolozen)
					predmetList.add(p);
				}
			}
		}
		
		
		listaPredZaDodavanje = predmetList;
	}
	
	// STUDENT 1: metoda koja vraća broj kolona za tabelu za dodavanje predmeta
	// funkcionalnost: #dodavanje_predmeta_studentu
	public int getColumnCountDodavanje() {
		return 1;
	}
	
	// STUDENT 1:
	// funkcionalnost: #dodavanje_predmeta_studentu
	public String getValueAtPredDodavanje(int row, int column) {
		if(column == 0) 
			return this.getListaPredZaDodavanje().get(row).getSifraNaziv();
		else return " ";
	}

	public ArrayList<Predmet> getListaPredZaDodavanje() {
		return listaPredZaDodavanje;
	}

	public void setListaPredZaDodavanje(ArrayList<Predmet> listaPredZaDodavanje) {
		this.listaPredZaDodavanje = listaPredZaDodavanje;
	}
	
	
	
}
