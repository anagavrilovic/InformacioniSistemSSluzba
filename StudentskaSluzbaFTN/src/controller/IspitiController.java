package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BazaStudenti;
import model.Ocena;
import model.Predmet;
import view.PrikazNepolozenihIspita;
import view.PrikazPolozenihIspita;
import view.TabbedPane;

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
	
	public boolean validirajDatum (String jtfText)  {
		
		Date datum;
		
		try {
			 datum = new SimpleDateFormat("dd.MM.yyyy.").parse(jtfText);
			 return true;
		} catch (ParseException e){
			return false;
		}	
	}
	
	public void dodajPredmetUListuPolozenih(Predmet p, String datum, int ocena) {
		
		String index = TabbedPane.getInstance().getIndexFromSelectedRow();
		
		Ocena o = new Ocena();
		o.setPredmet(p);
		o.setOcena(ocena);
	    o.setStudent(BazaStudenti.getInstance().pronadjiStudenta(index));
		
		BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakPolozenih().add(o);
		this.polozeni.azurirajPrikazPredmet(null, -1);
		
		
		List<Predmet> nepolozeniPredmeti = BazaStudenti.getInstance().pronadjiStudenta(index).getSpisakNepolozenih();
		for(Predmet predm : nepolozeniPredmeti) {
			if(predm.getSifraPredmeta().equals(p.getSifraPredmeta())) {
				nepolozeniPredmeti.remove(predm);
				break;
			}
		}
				
		this.nepolozeni.azurirajPrikazPredmet(null, -1);
	}


	public void setPrikazPolozenih(PrikazPolozenihIspita polozeni) {
		this.polozeni = polozeni;
	}


	public void setPrikazNepolozenih(PrikazNepolozenihIspita nepolozeni) {
		this.nepolozeni = nepolozeni;
	}
	
	
 
}