package controller;

import model.BazaPredmeti;
import model.BazaStudenti;
import model.Ocena;
import model.Predmet;
import view.PrikazNepolozenihIspita;
import view.PrikazPolozenihIspita;


public class IspitiController {
	
	private PrikazPolozenihIspita polozeni;
	private PrikazNepolozenihIspita nepolozeni;

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
		
		polozeni.azurirajPrikazPredmet(null, -1);
		nepolozeni.azurirajPrikazPredmet(null, -1);
		
	}
		
	
	public void ukloniPredmet(String index, Predmet predmet) {
		
		BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakNepolozenih().remove(predmet);
		BazaPredmeti.getInstance().pronadjiPredmet(predmet.getSifraPredmeta()).getStudentiNisuPolozili().
			remove(BazaStudenti.getInstance().pronadjiStudenta(index));
		
		nepolozeni.azurirajPrikazPredmet(null, -1);
		
	}
	
	public void setPrikazPolozenih(PrikazPolozenihIspita polozeni) {
		this.polozeni = polozeni;
	}
	
	public void setPrikazNepolozenih(PrikazNepolozenihIspita nepolozeni) {
		this.nepolozeni = nepolozeni;
	}
}
