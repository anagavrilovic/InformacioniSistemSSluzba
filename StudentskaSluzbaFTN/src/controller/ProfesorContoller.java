package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.TabbedPane;

public class ProfesorContoller {
	
	private static ProfesorContoller instance = null;

	public static ProfesorContoller getInstance() {
		if (instance == null) {
			instance = new ProfesorContoller();
		}
		return instance;
	}
	
	//private Date datumRodjenja;
	
	
	private ProfesorContoller() {}
	
	
	public boolean validirajIme(String ime) {
		if(ime.equals("")  || ime == null) 
		    return false;
		else if(!Pattern.matches("[a-zA-ZčćšđžČĆŠĐŽ]+", ime))
			return false;
		
		return true;
	}
	
	public boolean validirajPrezime(String prz) {
		 if(prz.equals("") || prz == null )
			 return false;
		 else if(!Pattern.matches("[a-zA-ZčćšđžČĆŠĐŽ]+", prz))
				return false;
		 
		 return true;
	}
	
	public boolean validirajDatum(String datum) {
		
		 if(datum.equals("") || datum == null )
			 return false;
		 
		 Date todayDate = new Date();
	   	 Date datumRodjenja;
	   	 
			try {
			 datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datum);
				// System.out.println("13456");
			} catch (Exception e){
				return false;
			}	
			
			 if(todayDate.before(datumRodjenja)) {
				    return false;
				}
			 
			return true;
	}
	
	public boolean validirajAdresuStanovanja(String adresaStan) {
		if(adresaStan.equals("") || adresaStan == null )
			 return false;
		
		return true;
	}
	
	public boolean validirajTelefon(String brTel) {
		if(brTel.equals("") || brTel == null )
			 return false;
		else if(!Pattern.matches("[0-9]+", brTel))
			 return false;
		else if(!(brTel.length() == 9 || brTel.length() == 10))
			 return false;
			 
		return true;
	}
	
	public boolean validirajEMail (String eMail) {
		
		if(eMail.equals("") || eMail == null )
			 return false;
			
		if(!eMail.contains("@"))
			 return false;
		 else if(!eMail.contains("."))
			 return false;
		 else if(!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", eMail))
			 return false;
		
		return true;
	}
	
	public boolean validirajAdresuKancelarije (String adresaKanc) {
		
		if(adresaKanc.equals("") || adresaKanc == null )
			 return false;
		
		return true;
	}
	
	public boolean validirajBrojLicneKarte(String brLK) {
		
		if(brLK.equals("") || brLK == null )
			 return false;
		
		 if(!Pattern.matches("[0-9]+", brLK))
				return false;
		 else if(!(brLK.length() == 9))
			 return false;
		 else if(!BazaProfesori.getInstance().validirajProfesora(brLK))
			 return false;
		 
		 return true;
	}
	
	private String validacijaProfesora(String ime, String prz, String datum, String adresaStan,
			 String brTel, String eMail, String adresaKanc,
			 String brLK, Titula titula, Zvanje zvanje, boolean valLK) {
	
			
		if(valLK) {
			if(!BazaProfesori.getInstance().validirajProfesora(brLK))
				return "Broj lične karte mora biti jedinstven!"; 	 
			}
			
			return "Uspešna validacija!";		
		}
	
	

	public String dodajProfesora(String ime, String prz, String datum, String adresaStan,
								 String brTel, String eMail, String adresaKanc,
								 String brLK, Titula titula, Zvanje zvanje) {
		
		 Date datumRodjenja;
			try {
			 datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datum);
				// System.out.println("13456");
			} catch (Exception e){
				datumRodjenja =  null;
			}	
		
		Profesor prof= new Profesor(prz, ime, datumRodjenja, adresaStan, brTel,
			        				eMail, adresaKanc, brLK, titula, zvanje);
		
		BazaProfesori.getInstance().dodajProfesora(prof);
		BazaProfesori.getInstance().prikaziSve();
		TabbedPane.getInstance().azurirajPrikazProf("Dodavanje profesora", -1);
		
		return "Uspešno ste uneli profesora!";
	}
	
	
	public String izmeniProfesora(String ime, String prz, String datum, String adresaStan,
								  String brTel, String eMail, String adresaKanc,
								  String brLK, Titula titula, Zvanje zvanje, String kljuc) {
		
		String validacija;
		
		if(brLK.equals(kljuc)) {	
			 validacija = validacijaProfesora(ime, prz, datum, adresaStan, brTel, eMail,
											  adresaKanc, brLK, titula, zvanje, false);
		}
		else {
			 validacija = validacijaProfesora(ime, prz, datum, adresaStan, brTel, eMail,
					 						  adresaKanc, brLK, titula, zvanje, true);
		}
			
			
		if(!(validacija.equals("Uspešna validacija!")))
		return validacija;
		
		 Date datumRodjenja;
			try {
			 datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datum);
				// System.out.println("13456");
			} catch (Exception e){
				datumRodjenja =  null;
			}	
		
		
		BazaProfesori.getInstance().izmeniProfesora(prz, ime, datumRodjenja, adresaStan, brTel,
												    eMail, adresaKanc, brLK, titula, zvanje, kljuc);
		BazaProfesori.getInstance().prikaziSve();
		TabbedPane.getInstance().azurirajPrikazProf("Izmena profesora", -1);
		
		return "Uspešno ste izmenili izabranog profesora!";
	}
	
	public String izbrisiProfesora(String brojLK) {
				
		BazaPredmeti.getInstance().izbrisiProfesora(brojLK);
		BazaProfesori.getInstance().izbrisiProfesora(brojLK);

		BazaProfesori.getInstance().prikaziSve();
		TabbedPane.getInstance().azurirajPrikazProf("brisanje", -1);
		
		return "Profesor uspešno izbrisan!";
	}
}
