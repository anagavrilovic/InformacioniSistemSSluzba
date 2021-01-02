package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BazaPredmeti;
import model.BazaProfesori;
import model.BazaStudenti;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import view.DodavanjePredmetaProfesoru;
import view.DodavanjePremetaStudentu;
import view.DodavanjeProfesoraPredmetu;
import view.PrikazNepolozenihIspita;
import view.PrikazPolozenihIspita;
import view.ProfesorPredajePredmeteView;
import view.TabbedPane;


public class IspitiController {
	
	private PrikazPolozenihIspita polozeni;
	private PrikazNepolozenihIspita nepolozeni;
	private DodavanjePremetaStudentu dsp;
	private DodavanjeProfesoraPredmetu dpp;

	private DodavanjePredmetaProfesoru dpredprof;
	private ProfesorPredajePredmeteView ppp;

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
		
	
	public void ukloniPredmetStudentu(String index, Predmet predmet) {
		
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
	
	public void setDodavanjePredmeta(DodavanjePremetaStudentu dodaj) {
		this.dsp = dodaj;
	}
	
	public void setDodavanjeProfesoraPredmetu(DodavanjeProfesoraPredmetu dpp) {
		this.dpp = dpp;
	}

	public void setDodavanjePredmetaProfesoru(DodavanjePredmetaProfesoru dpp) {
		this.dpredprof = dpp;
	}
	
	public void setProfesorPredajePredmete(ProfesorPredajePredmeteView ppp) {
		this.ppp = ppp;
	}
	
	
	//Student 2- potrebno za funkcionalnost upis ocjene 
	public boolean validirajDatum (String jtfText)  {
		
		Date datum;
		
		try {
			 datum = new SimpleDateFormat("dd.MM.yyyy.").parse(jtfText);
			 return true;
		} catch (ParseException e){
			return false;
		}	
	}
	
	//Student 2- potrebno za funkcionalnost upis ocjene 
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
	
	public void dodajPredmetStudentu(String index, String sifraPred) {
		
		for(Predmet p : BazaStudenti.getInstance().pronadjiStudenta(index).getListaPredZaDodavanje()) {
			if(p.getSifraPredmeta().equals(sifraPred)) {
				BazaStudenti.getInstance().pronadjiStudenta(index).getListaPredZaDodavanje().remove(p);
				break;
			}
			
		}
		
		for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifraPred)) {
				BazaStudenti.getInstance().pronadjiStudenta(index).dodajNepolozen(p);
			}
		}
		
		this.nepolozeni.azurirajPrikazPredmet(null, -1);
		this.dsp.azurirajPrikazPredmet(" ", -1);
		
	}
	
	public void dodajProfesoraPredmetu(String sifraPredmeta, String brojLK) {
		
		for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifraPredmeta)) {
				p.setProfesor(BazaProfesori.getInstance().nadjiProfesora(brojLK));
				BazaProfesori.getInstance().nadjiProfesora(brojLK).getPredmeti().add(p);
			}
		}
		
		this.dpp.azurirajPrikazPredmet(null, -1);
	}

	//Student 2- potrebno za funkcionalnost Dodavanje predmeta profesoru
	public void dodajPredmetProfesoru(String brLK, String sifraPredmeta) {
			
		for(Predmet p : BazaProfesori.getInstance().nadjiProfesora(brLK).getProfesorNePredaje()) {
			if(p.getSifraPredmeta().equals(sifraPredmeta)) {
				BazaProfesori.getInstance().nadjiProfesora(brLK).getProfesorNePredaje().remove(p);
				break;
			}
		}

		
		for(Predmet p : BazaPredmeti.getInstance().getPredmeti()) {
			if(p.getSifraPredmeta().equals(sifraPredmeta)) {
				BazaProfesori.getInstance().nadjiProfesora(brLK).getPredmeti().add(p);
				p.setProfesor(BazaProfesori.getInstance().nadjiProfesora(brLK));
			}		
		}
	
		this.dpredprof.azurirajPrikazPredmet("", -1);
		this.ppp.azurirajPrikazPredmet(null, -1);

	}
	
	public void ukloniPredmetProfesoru(String brojLK, Predmet predmet) {
		
		BazaProfesori.getInstance().nadjiProfesora(brojLK).getPredmeti().remove(predmet);
		BazaPredmeti.getInstance().pronadjiPredmet(predmet.getSifraPredmeta()).setProfesor(new Profesor());
		
		this.ppp.azurirajPrikazPredmet(null, -1);
		
	}
	
	public void ukloniProfesoraSaPredmeta(String brLK, Predmet predmet) {
		
		BazaPredmeti.getInstance().pronadjiPredmet(predmet.getSifraPredmeta()).setProfesor(new Profesor());
		BazaProfesori.getInstance().nadjiProfesora(brLK).getPredmeti().remove(predmet);
		
		this.ppp.azurirajPrikazPredmet(null, -1);
	}
	
}

