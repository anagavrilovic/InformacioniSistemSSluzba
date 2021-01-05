package controller;

import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Predmet;
import model.Predmet.Semestar;
import model.Profesor;
import model.Student;
import view.TabbedPane;

public class PredmetController {
	
	private int espbBod;
	
	public static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public String dodajPredmet(String sifraPred, String nazivPred, Semestar semestar, int godStud, String espb) {
		
		String validacija = validirajPredmet(sifraPred, nazivPred, semestar, godStud, espb, "dodavanje");
		if(!validacija.equals("Uspešno"))
			return validacija;
		
		Predmet predmet = new Predmet();
		predmet.setSifraPredmeta(sifraPred);
		predmet.setNazivPredmeta(nazivPred);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudija(godStud);
		predmet.setEspb(espbBod);
		
		BazaPredmeti.getInstance().dodajPredmet(predmet);
		BazaPredmeti.getInstance().prikaziSve();
		TabbedPane.getInstance().azurirajPrikazPredmet("Dodavanje predmeta", -1);

		return "Predmet uspešno dodat!";
	}
	
	public String izmeniPredmet(String staraSifra, String sifraPred, String nazivPred, Semestar semestar, int godStud, String espb, String profesor) {
		
		if(!staraSifra.equals(sifraPred))
			if(!BazaPredmeti.getInstance().validirajSifruPredmeta(sifraPred))
				return "Već postoji predmet sa ovom šifrom!"; 
		
		String validacija = validirajPredmet(sifraPred, nazivPred, semestar, godStud, espb, "izmena");
		if(!validacija.equals("Uspešno"))
			return validacija;
		
		BazaPredmeti.getInstance().izmeniPredmet(staraSifra, sifraPred, nazivPred, espbBod, godStud, semestar, profesor);
		BazaPredmeti.getInstance().prikaziSve();
		TabbedPane.getInstance().azurirajPrikazPredmet("Izmena predmeta", -1);

		return "Predmet uspešno izmenjen!";
	}
	
	public String izbrisiPredmet(String sifraPredm) {
			
			for(Student s : BazaStudenti.getInstance().getStudentList()) {
				for(Predmet p : s.getSpisakNepolozenih()) {
					if(p.getSifraPredmeta().equals(sifraPredm))
						s.getSpisakNepolozenih().remove(p);
				}
			}
			
			for(Profesor prof : BazaProfesori.getInstance().getProfesori()) {
				for(Predmet p : prof.getPredmeti()) {
					if(p.getSifraPredmeta().equals(sifraPredm))
						prof.getPredmeti().remove(p);
				}
			}
			
			BazaPredmeti.getInstance().izbrisiPredmet(sifraPredm);
			TabbedPane.getInstance().azurirajPrikazPredmet("Brisanje predmeta", -1);
			return	"Izbrisali ste izabrani predmet!";
	}
	
	private String validirajPredmet(String sifraPred, String nazivPred, Semestar semestar, int godStud, String espb, String akcija) {
		
		// validacija za sifru predmeta
		if (sifraPred == null) 
			return "Unesite šifru predmeta!";
		
		sifraPred = sifraPred.trim();
		if (sifraPred.isEmpty()) 
			return "Unesite šifru predmeta!";
		
		if(akcija.equals("dodavanje")) {
			if(!BazaPredmeti.getInstance().validirajSifruPredmeta(sifraPred))
				return "Već postoji predmet sa ovom šifrom!";
		}

		// validacija za naziv predmeta
		if (nazivPred == null) 
			return "Unesite naziv predmeta!";
		
		nazivPred = nazivPred.trim();
		if (nazivPred.isEmpty()) 
			return "Unesite naziv predmeta!";
		
		// validacija za espb
		if (espb == null) 
			return "Unesite broj ESPB bodova!";
		
		espb = espb.trim();
		if (espb.isEmpty()) 
			return "Unesite broj ESPB bodova!";
		if(!Pattern.matches("[0-9]+", espb)) 
			return "ESPB bodovi se unose u obliku broja!";
		espbBod = Integer.parseInt(espb);

		
		return "Uspešno";
	}
}
