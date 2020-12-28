package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
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
	
	private Date datumRodjenja;
	
	
	private ProfesorContoller() {}
	
	private String validacijaProfesora(String ime, String prz, String datum, String adresaStan,
								 String brTel, String eMail, String adresaKanc,
								 String brLK, Titula titula, Zvanje zvanje, boolean valLK) {
		if(ime.equals("")  || ime == null) 
			return "Morate uneti ime profesora!";
		else if(prz.equals("") || prz == null )
			return "Morate uneti prezime profesora!";
		else if(datum.equals("") || datum == null)
			return "Morate uneti datum rođenja profesora!";
		else if(adresaStan.equals("") || adresaStan == null)
			return "Morate uneti adresu stanovanja profesora!";
		else if(brTel.equals("") || brTel == null)
			return "Morate uneti kontakt telefon profesora!";
		else if(eMail.equals("") || eMail == null)
			return "Morate uneti e-Mail adresu profesora!";
		else if(adresaKanc.equals("") || adresaKanc == null)
			return "Morate uneti adresu kancelarije profesora!";
		else if(brLK.equals("") || brLK == null)
			return "Morate uneti broj lične karte profesora!";
		else if(titula == null)
			return "Morate uneti titulu profesora!";
		else if(zvanje == null)
			return "Morate uneti zvanje profesora!";
		
		if(!Pattern.matches("[a-zA-ZčćšđžČĆŠĐŽ]+", ime))
			return "Ime se mora sastojati isključivo od slova!";
		else if(!Pattern.matches("[a-zA-ZčćšđžČĆŠĐŽ]+", prz))
			return "Prezime se mora sastojati isključivo od slova!";
		
		 if(!Pattern.matches("[0-9]+", brTel))
			return "Broj telefona se mora sastojati isključivo od cifara!";
		 else if(!(brTel.length() == 9 || brTel.length() == 10))
			 return "Broj telefona mora da sadrži 9 ili 10 cifara!";
		 
		 if(!eMail.contains("@"))
			 return "Pogrešan format za e-mail adresu!";
		 else if(!eMail.contains("."))
			 return "Pogrešan format za e-mail adresu!";
		 else if(!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", eMail))
			 return "Pogrešan format za e-mail adresu!";
		 
		 if(!Pattern.matches("[0-9]+", brLK))
				return "Broj lične karte se mora sastojati isključivo od cifara!";
		 else if(!(brLK.length() == 9))
			 return "Broj lične karte mora da sadrži tačno 9 cifara!";
		 
		 if(valLK) {
			 if(!BazaProfesori.getInstance().validirajProfesora(brLK))
				 return "Broj lične karte mora biti jedinstven!"; 	 
		 }
		 
		try {
			 datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datum);
		} catch (ParseException e) {
			e.printStackTrace();
			return "Pogrešan format datuma!";
		}
		
		return "Uspešna validacija!";		
	}
	

	public String dodajProfesora(String ime, String prz, String datum, String adresaStan,
								 String brTel, String eMail, String adresaKanc,
								 String brLK, Titula titula, Zvanje zvanje) {
		
		
		String validacija = validacijaProfesora(ime, prz, datum, adresaStan, brTel, eMail,
												adresaKanc, brLK, titula, zvanje, true);
		
		if(!(validacija.equals("Uspešna validacija!")))
				return validacija;
		
		
		Profesor prof= new Profesor(prz, ime, datumRodjenja, adresaStan, 
			        				eMail, adresaKanc, brLK, titula, zvanje);
		
		BazaProfesori.getInstance().dodajProfesora(prof);
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
		
		BazaProfesori.getInstance().izmeniProfesora(prz, ime, datumRodjenja, adresaStan, brTel,
												    eMail, adresaKanc, brLK, titula, zvanje, kljuc);
		TabbedPane.getInstance().azurirajPrikazProf("Izmena profesora", -1);
		
		return "Uspešno ste izmenili izabranog profesora!";
	}
	
	public String izbrisiProfesora(String brojLK) {
		
		BazaPredmeti.getInstance().izbrisiProfesora(brojLK);
		BazaProfesori.getInstance().izbrisiProfesora(brojLK);
		
		TabbedPane.getInstance().azurirajPrikazProf("brisanje", -1);
		
		return "Profesor uspešno izbrisan!";
	}
}
