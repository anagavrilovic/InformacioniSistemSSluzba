package controller;

import model.BazaStudenti;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.PrikazNepolozenihIspita;
import view.PrikazPolozenihIspita;


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
		
		PrikazPolozenihIspita.getInstance(index).azurirajPrikazPredmet(null, -1);
		PrikazNepolozenihIspita.getInstance(index).azurirajPrikazPredmet(null, -1);
		
	}
		
}
