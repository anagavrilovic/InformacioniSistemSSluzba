package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.DodavanjeProfesoraView;
import view.IzmenaProfesoraView;

public class IzmenaProfesoraKeyListener implements KeyListener{
	
	private IzmenaProfesoraView ipv;
	
	private boolean validno1 = true;
	private boolean validno2 = true;
	private boolean validno3 = true;
	private boolean validno4 = true;
	private boolean validno5 = true;
	private boolean validno6 = true;
	private boolean validno7 = true;
	private boolean validno8 = true;
	
	 public IzmenaProfesoraKeyListener (IzmenaProfesoraView ipv) {
		// TODO Auto-generated constructor stub
		this.ipv = ipv;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

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
			IzmenaProfesoraView.btnPotvrdi.setEnabled(true);
		else
			IzmenaProfesoraView.btnPotvrdi.setEnabled(false);
	}

	
}
