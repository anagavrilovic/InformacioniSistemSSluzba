package controller;

import model.Predmet;
import model.Predmet.Semestar;

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
		
		/*if(!BazaPredmeti.getInstance().validirajSifruPredmeta(sifraPred))
			return "Već postoji student sa ovim brojem indeksa!";*/

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
		
		int espbBod = Integer.parseInt(espb);
		
		Predmet predmet = new Predmet();
		predmet.setSifraPredmeta(sifraPred);
		predmet.setNazivPredmeta(nazivPred);
		predmet.setSemestar(semestar);
		predmet.setGodinaStudija(godStud);
		predmet.setEspb(espbBod);
		
		//BazaPredmeti.getInstance().dodajStudenta(predmet);
		//TabbedPane.getInstance().azurirajPrikaz("Dodavanje predmeta", -1);

		return "Model uspešno ažuriran!";
		}
}
