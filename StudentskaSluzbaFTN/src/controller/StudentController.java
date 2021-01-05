package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.BazaStudenti;
import model.Student;
import model.Student.Status;
import view.TabbedPane;

public class StudentController {
	
	public static StudentController instance = null;
	private Date date;
	private int god;
	
	public static StudentController getInstance() {
		
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public String dodajStudenta(String ime, String prezime, String datRodj, String adresa, String brTel, String email, 
			String brIndeksa, String godUpisa, int trGodStudija, Status status) {
		
		String validacija = validirajStudenta(ime, prezime, datRodj, adresa, brTel, email, brIndeksa, godUpisa, trGodStudija, status, "dodavanje");
		if(!validacija.equals("Uspešno"))
			return validacija;
		
		Student student = new Student();
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setDatumRodjenja(date);
		student.setBrojIndeksa(brIndeksa);
		student.setAdresaStanovanja(adresa);
		student.setEmail(email);
		student.setKontaktTelefon(brTel);
		student.setGodinaUpisa(god);
		student.setTrGodStudija(trGodStudija);
		student.setStatus(status);
		
		BazaStudenti.getInstance().dodajStudenta(student);
		BazaStudenti.getInstance().izaberiSve();
		TabbedPane.getInstance().azurirajPrikazStudent("Dodavanje studenta", -1);

		return "Student uspešno dodat!";
	}
	
	
	public String izmeniStudenta(String stariIndeks, String ime, String prezime, String datRodj, String adresa, String brTel, String email, 
			String brIndeksa, String godUpisa, int trGodStudija, Status status) {
		
		if(!stariIndeks.equals(brIndeksa))
			if(!BazaStudenti.getInstance().validirajStudenta(brIndeksa))
				return "Već postoji student sa ovim brojem indeksa!"; 
		
		String validacija = validirajStudenta(ime, prezime, datRodj, adresa, brTel, email, brIndeksa, godUpisa, trGodStudija, status, "izmena");
		if(!validacija.equals("Uspešno"))
			return validacija;
		
		BazaStudenti.getInstance().izmeniStudenta(stariIndeks, ime, prezime, date, brIndeksa, adresa, email, brTel, god, trGodStudija, status);
		BazaStudenti.getInstance().izaberiSve();
		TabbedPane.getInstance().azurirajPrikazStudent("Izmena studenta", -1);

		return "Student uspešno izmenjen!";
	}
	
	public String izbrisiStudenta(String index) {
		
		BazaPredmeti.getInstance().izbrisiStudentaSaPolozenihPredmeta(index);
		BazaPredmeti.getInstance().izbrisiStudentaSaNepolozenihPredmeta(index);
		BazaStudenti.getInstance().izbrisiStudenta(index);
		
		BazaStudenti.getInstance().izaberiSve();
		TabbedPane.getInstance().azurirajPrikazStudent("Brisanje", -1);
		
		return "Student uspešno izbrisan!";
	}
	
	
	private String validirajStudenta(String ime, String prezime, String datRodj, String adresa, String brTel, String email, 
			String brIndeksa, String godUpisa, int trGodStudija, Status status, String akcija) {
		
		// validacija za ime
		if (ime == null) 
			return "Unesite ime studenta!"; 
		
		ime = ime.trim();
		if (ime.isEmpty()) 
			return "Unesite ime studenta!";
		if(!Pattern.matches("[a-zA-ZćčžđšĆČŽĐŠ]+", ime)) 
			return "Ime se mora sastojati isključivo od slova!";

		// validacija za prezime
		if (prezime == null) 
			return "Unesite prezime studenta!";
		
		prezime = prezime.trim();
		if (prezime.isEmpty()) 
			return "Unesite prezime studenta!";
		if(!Pattern.matches("[a-zA-ZćčžđšĆČŽĐŠ]+", prezime)) 
			return "Prezime se mora sastojati isključivo od slova!";

		// validacija za datum
		if (datRodj == null) 
			return "Unesite datum rodjenja studenta!";
		
		datRodj = datRodj.trim();
		if (datRodj.isEmpty()) 
			return "Unesite datum rodjenja studenta!";
		try {
			date = new SimpleDateFormat("dd.MM.yyyy.").parse(datRodj);
		} catch (ParseException e) {
			return "Datum mora biti u formatu dd.MM.yyyy.";
		}
		
		// validacija za adresu
		if (adresa == null) 
			return "Unesite adresu studenta!";
		
		adresa = adresa.trim();
		if (adresa.isEmpty()) 
			return "Unesite adresu studenta!";
		
		// validacija za broj telefona
		if (brTel == null) 
			return "Unesite broj telefona studenta!";

		brTel = brTel.trim();
		if (brTel.isEmpty()) 
			return "Unesite broj telefona studenta!";
		if(brTel.length() != 9 && brTel.length() != 10) 
			return "Broj telefona mora sadržati 9 ili 10 cifara!";
		if(!Pattern.matches("[0-9]+", brTel)) 
			return "Broj telefona se mora sastojati isključivo od slova!";
		
		// validacija za email
		if (email == null) 
			return "Unesite e-mail adresu studenta!";
		
		email = email.trim();
		if (email.isEmpty()) 
			return "Unesite e-mail adresu studenta!";
		if(!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", email)) 
			return "Neispravna e-mail adresa!";
		
		// validacija za broj indeksa
		if (brIndeksa == null) 
			return "Unesite broj indeksa studenta!";
		
		brIndeksa = brIndeksa.trim();
		if (brIndeksa.isEmpty()) 
			return "Unesite broj indeksa studenta!";
		if(akcija.equals("dodavanje")) {
			if(!BazaStudenti.getInstance().validirajStudenta(brIndeksa))
				return "Već postoji student sa ovim brojem indeksa!"; 
		}
		
		// validacija za godinu upisa
		if (godUpisa == null) 
			return "Unesite godinu upisa studenta!";
		
		godUpisa = godUpisa.trim();
		if (godUpisa.isEmpty()) 
			return "Unesite godinu upisa studenta!";
		if(godUpisa.length() != 4) 
			return "Godina upisa se sastoji od 4 cifre!";
		if(!Pattern.matches("[0-9]+", godUpisa)) 
			return "Godina upisa se mora sastojati isključivo od slova!";
		god = Integer.parseInt(godUpisa);
		
		return "Uspešno";  
	}
	
}
