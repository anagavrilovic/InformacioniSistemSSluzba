package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.DodavanjeProfesoraView;

public class ProfesorKeyListener implements KeyListener{
	
	private DodavanjeProfesoraView dpv;
	
	private boolean validno1 = false;
	private boolean validno2 = false;
	private boolean validno3 = false;
	private boolean validno4 = false;
	private boolean validno5 = false;
	private boolean validno6 = false;
	private boolean validno7 = false;
	private boolean validno8 = false;
	
	 public ProfesorKeyListener(DodavanjeProfesoraView dpv) {
		// TODO Auto-generated constructor stub
		this.dpv = dpv;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		JTextField txt = (JTextField) e.getComponent();
		
		if(txt.getName().equals("txtIme"))
			validno1 = ProfesorContoller.getInstance().validirajIme(txt.getText().trim());
		else if(txt.getName().equals("txtPrz"))
			validno2 = ProfesorContoller.getInstance().validirajPrezime(txt.getText().trim());
		else if(txt.getName().equals("txtDatum"))
			validno3 = ProfesorContoller.getInstance().validirajDatum(txt.getText().trim());
		else if(txt.getName().equals("txtAdresaStan"))
			validno4 = ProfesorContoller.getInstance().validirajAdresuStanovanja(txt.getText().trim());
		else if(txt.getName().equals("txtBrTel"))
			validno5 = ProfesorContoller.getInstance().validirajTelefon(txt.getText().trim());
		else if (txt.getName().equals("txteMail"))
			validno6 = ProfesorContoller.getInstance().validirajEMail(txt.getText().trim());
		else if (txt.getName().equals("txtAdresaKanc"))
			validno7 = ProfesorContoller.getInstance().validirajAdresuKancelarije(txt.getText().trim());
		else if (txt.getName().equals("txtBrLK"))
			validno8 = ProfesorContoller.getInstance().validirajBrojLicneKarte(txt.getText().trim());
		
		
		if(validno1 && validno2 && validno3 && validno4 && validno5 && validno6 && validno7 && validno8)
			DodavanjeProfesoraView.btnPotvrdi.setEnabled(true);
		else
			DodavanjeProfesoraView.btnPotvrdi.setEnabled(false);
	}
	
}
