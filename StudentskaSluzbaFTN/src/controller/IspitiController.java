package controller;

import model.BazaPredmeti;
import model.BazaStudenti;
import model.Ocena;
import model.Predmet;


public class IspitiController {

	public static IspitiController instance = null;
	
	public static IspitiController getInstance() {
		
		if (instance == null) {
			instance = new IspitiController();
		}
		return instance;
	}
	
	private IspitiController() {}
		
	
	public void ponistiOcenu(String index, Predmet predmet) {
		
		Ocena ocena = new Ocena();
		for(Ocena o : BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakPolozenih()) {
			if(o.getPredmet().getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				ocena = o;
				break;
			}
		}
		
		BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakPolozenih().remove(ocena);
		BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakNepolozenih().add(predmet);
		
		//pi.azurirajPrikazPredmet(null, -1);
		//PrikazNepolozenihIspita.getInstance(index).azurirajPrikazPredmet(null, -1);
		
	}
		
	
	public void ukloniPredmet(String index, Predmet predmet) {
		
		BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakNepolozenih().remove(predmet);
		BazaPredmeti.getInstance().pronadjiPredmet(predmet.getSifraPredmeta()).getStudentiNisuPolozili().
			remove(BazaStudenti.getInstance().pronadjiStudenta(index));
		
		//PrikazNepolozenihIspita.getInstance(index).azurirajPrikazPredmet(null, -1);
		
	}
}
