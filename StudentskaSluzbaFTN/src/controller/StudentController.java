package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.BazaStudenti;
import model.Student;
import model.Student.Status;
import view.TabbedPane;

public class StudentController {
	
	public static StudentController instance = null;
	
	public static StudentController getInstance() {
		
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public String dodajStudenta(String ime, String prezime, String datRodj, String adresa, String brTel, String email, 
			String brIndeksa, String godUpisa, int trGodStudija, Status status) {
		
		Date date;
		try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
            df.setLenient(false);
            date = df.parse(datRodj);
        } catch (ParseException e) {
        	date = null;
        }
		
		int god = Integer.parseInt(godUpisa);
		
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
		
		Date date;
		try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
            df.setLenient(false);
            date = df.parse(datRodj);
        } catch (ParseException e) {
        	date = null;
        }
		
		int god = Integer.parseInt(godUpisa);
		
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
	
	public boolean validirajNoviIndeks(String stariIndeks, String brIndeksa) {
		if(!stariIndeks.equals(brIndeksa))
			if(!BazaStudenti.getInstance().validirajStudenta(brIndeksa))
				return false; 
		return true;
	}
	
	public boolean validirajIme(String ime) {
		if (ime == null) 
			return false; 
		
		ime = ime.trim();
		if (ime.isEmpty()) 
			return false;
		if(!Pattern.matches("[a-zA-ZćčžđšĆČŽĐŠ]+", ime)) 
			return false;
		
		return true;
	}
	
	public boolean validirajPrezime(String prezime) {
		if (prezime == null) 
			return false;
		
		prezime = prezime.trim();
		if (prezime.isEmpty()) 
			return false;
		if(!Pattern.matches("[a-zA-ZćčžđšĆČŽĐŠ]+", prezime)) 
			return false;
		
		return true;
	}
	
	public boolean validirajDatumRodjenja(String datRodj) {
		if (datRodj == null) 
			return false;
		
		datRodj = datRodj.trim();
		if (datRodj.isEmpty()) 
			return false;
		
		Date date;
		try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
            df.setLenient(false);
            date = df.parse(datRodj);
        } catch (ParseException e) {
            return false;
        }

		Date today = new Date();
		if(today.before(date))
			return false;
		
		return true;
	}
	
	public boolean validirajAdresu(String adresa) {
		if (adresa == null) 
			return false;
		
		adresa = adresa.trim();
		if (adresa.isEmpty()) 
			return false;
		
		return true;
	}
	
	public boolean validirajBrojTelefona(String brTel) {
		if (brTel == null) 
			return false;

		brTel = brTel.trim();
		if (brTel.isEmpty()) 
			return false;
		if(brTel.length() != 9 && brTel.length() != 10) 
			return false;
		if(!Pattern.matches("[0-9]+", brTel)) 
			return false;
		
		return true;
	}
	
	public boolean validirajEmail(String email) {
		if (email == null) 
			return false;
		
		email = email.trim();
		if (email.isEmpty()) 
			return false;
		if(!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", email)) 
			return false;
		
		return true;
	}
	
	public boolean validirajBrIndeksa(String brIndeksa, String akcija) {
		if (brIndeksa == null) 
			return false;
		
		brIndeksa = brIndeksa.trim();
		if (brIndeksa.isEmpty()) 
			return false;
		if(akcija.equals("dodavanje")) {
			if(!BazaStudenti.getInstance().validirajStudenta(brIndeksa))
				return false;
		}
		
		return true;
	}
	
	public boolean validirajGodinuUpisa(String godUpisa) {
		if (godUpisa == null) 
			return false;
		
		godUpisa = godUpisa.trim();
		if (godUpisa.isEmpty()) 
			return false;
		if(godUpisa.length() != 4) 
			return false;
		if(!Pattern.matches("[0-9]+", godUpisa)) 
			return false;
		int god = Integer.parseInt(godUpisa);
		
		int trenutnaGodina = Year.now().getValue();
		if(god > trenutnaGodina)
			return false;
		
		return true;
	}
	
	
}
