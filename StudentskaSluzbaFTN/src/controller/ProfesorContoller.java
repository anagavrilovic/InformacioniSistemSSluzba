package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import model.BazaProfesori;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;
import view.DodavanjeProfesoraView;
import view.TabbedPane;

public class ProfesorContoller {
	
	private static ProfesorContoller instance = null;

	public static ProfesorContoller getInstance() {
		if (instance == null) {
			instance = new ProfesorContoller();
		}
		return instance;
	}
	
	//private Profesor profesor;
	//private DodavanjeProfesoraView profesorView;
	
	public ProfesorContoller() {
		//this.profesor = new Profesor();
		//this.profesorView = new DodavanjeProfesoraView();
	}

	/*public ProfesorContoller(Profesor profesor, DodavanjeProfesoraView profesorView) {
		setProfesor(profesor);
		setProfesorView(profesorView);
	}*/
	
	public String updateProfesor(String ime, String prz, String datum, String adresaStan,
								 String brTel, String eMail, String adresaKanc,
								 String brLK, Titula titula, Zvanje zvanje){
		
		if(ime.trim().equals("")  || ime == null)		
			return "Morate unijeti ime profesora!";
		else if(prz.trim().equals("") || prz == null )
			return "Morate unijeti prezime profesora!";
		else if(datum.trim().equals("") || datum == null)
			return "Morate unijeti datum rođenja profesora!";
		else if(adresaStan.trim().equals("") || adresaStan == null)
			return "Morate unijeti adresu stanovanja profesora!";
		else if(brTel.trim().equals("") || brTel == null)
			return "Morate unijeti kontakt telefon profesora!";
		else if(eMail.trim().equals("") || eMail == null)
			return "Morate unijeti e-Mail adresu profesora!";
		else if(adresaKanc.trim().equals("") || adresaKanc == null)
			return "Morate unijeti adresu kancelarije profesora!";
		else if(brLK.trim().equals("") || brLK == null)
			return "Morate unijeti broj lične karte profesora!";
		else if(titula == null)
			return "Morate unijeti titulu profesora!";
		else if(zvanje == null)
			return "Morate unijeti zvanje profesora!";
		
		if(!Pattern.matches("[a-zA-Z]+", ime))
			return "Ime se mora sastojati isključivo od slova!";
		else if(!Pattern.matches("[a-zA-Z]+", prz))
			return "Prezime se mora sastojati isključivo od slova!";
		
		 if(!Pattern.matches("[0-9]+", brTel))
			return "Broj telefona se mora sastojati isključivo od cifara!";
		 else if(!(brTel.length() == 9 || brTel.length() == 10))
			 return "Broj telefona mora da sadrži 9 ili 10 cifara!";
		 
		 if(!eMail.contains("@"))
			 return "Pogrešan format za e-mail adresu!";
		 else if(!eMail.contains("."))
			 return "Pogrešan format za e-mail adresu!";
		 
		 if(!Pattern.matches("[0-9]+", brLK))
				return "Broj lične karte se mora sastojati isključivo od cifara!";
		 else if(!(brLK.length() == 9))
			 return "Broj lične karte mora da sadrži tačno 9 cifara!";
		 
		 if(BazaProfesori.getInstance() != null) {
			 for(Profesor p : BazaProfesori.getInstance().getProfesori()) {
				 if(brLK == p.getBrojLicneKarte()) {
					 return "Broj lične karte mora biti jedinstven!";
				 }
			 }
		 }
		 
		 Date datumRodjenja;
			 
		try {
			 datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").parse(datum);
		} catch (ParseException e) {
			e.printStackTrace();
			return "Pogrešan format datuma!";
		}
		
		Profesor prof= new Profesor(prz, ime, datumRodjenja, adresaStan, 
			        eMail, adresaKanc, brLK, titula, zvanje);
		
		BazaProfesori.getInstance().dodajProfesora(prof);
		TabbedPane.getInstance().azurirajPrikazProf("Dodavanje profesora", -1);
		
		return "Uspešno ste uneli profesora!";
	}


	/*public Profesor getStudent() {
		return profesor;
	}

	private void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new NullPointerException();
		}
		this.profesor = profesor;
	}

	public DodavanjeProfesoraView getStudentView() {
		return profesorView;
	}

	private void setProfesorView(DodavanjeProfesoraView profesorView) {
		if (profesorView == null) {
			throw new NullPointerException();
		}
		this.profesorView = profesorView;
	}*/
}
