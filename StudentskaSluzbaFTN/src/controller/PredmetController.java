package controller;

import java.util.regex.Pattern;

import model.BazaPredmeti;
import model.Predmet;
import model.Predmet.Semestar;
import view.TabbedPane;

public class PredmetController {
	public static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public String dodajPredmet(String sifraPred, String nazivPred, Semestar semestar, int godStud, String espb) {
		
		// validacija za sifru predmeta
		if (sifraPred == null) {
			return "Unesite šifru predmeta!";
		}
		sifraPred = sifraPred.trim();
		if (sifraPred.isEmpty()) { 
			return "Unesite šifru predmeta!";
		}
		
		if(!BazaPredmeti.getInstance().validirajSifruPredmeta(sifraPred))
			return "Već postoji predmet sa ovom šifrom!";

		// validacija za naziv predmeta
		if (nazivPred == null) {
			return "Unesite naziv predmeta!";
		}
		nazivPred = nazivPred.trim();
		if (nazivPred.isEmpty()) {
			return "Unesite naziv predmeta!";
		}
		
		// validacija za espb
		if (espb == null) {
			return "Unesite broj ESPB bodova!";
		}
		espb = espb.trim();
		if (espb.isEmpty()) {
			return "Unesite broj ESPB bodova!";
		}
		if(!Pattern.matches("[0-9]+", espb)) 
			return "ESPB bodovi se unose u obliku broja!";
		
		int espbBod = Integer.parseInt(espb);
		
		Predmet predmet = new Predmet();
		predmet.setSifraPredmeta(sifraPred);
		predmet.setNazivPredmeta(nazivPred);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudija(godStud);
		predmet.setEspb(espbBod);
		
		BazaPredmeti.getInstance().dodajPredmet(predmet);
		TabbedPane.getInstance().azurirajPrikazPredmet("Dodavanje predmeta", -1);

		return "Model uspešno ažuriran!";
		}
}
