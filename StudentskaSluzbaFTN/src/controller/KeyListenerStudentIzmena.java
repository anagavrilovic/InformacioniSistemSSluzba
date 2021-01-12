package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.IzmenaStudentaView;

public class KeyListenerStudentIzmena implements KeyListener {
	
	IzmenaStudentaView is;
	
	boolean omoguciIme = true;
	boolean omoguciPrezime = true;
	boolean omoguciAdresu = true;
	boolean omoguciBrInd = true;
	boolean omoguciBrTel = true;
	boolean omoguciDatum = true;
	boolean omoguciEmail = true;
	boolean omoguciGodUpisa = true;

	public KeyListenerStudentIzmena(IzmenaStudentaView is) {
		this.is = is;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		JTextField txt = (JTextField) arg0.getComponent();
		
		
		if(txt.getName().equals("txtIme")) 
			omoguciIme = StudentController.getInstance().validirajIme(txt.getText());
		else if(txt.getName().equals("txtPrezime")) 
			omoguciPrezime = StudentController.getInstance().validirajPrezime(txt.getText());
		else if(txt.getName().equals("txtAdresa"))
			omoguciAdresu = StudentController.getInstance().validirajAdresu(txt.getText());
		else if(txt.getName().equals("txtBrInd"))
			omoguciBrInd = StudentController.getInstance().validirajBrIndeksa(txt.getText(), "izmena");
		else if(txt.getName().equals("txtBrojTel"))
			omoguciBrTel = StudentController.getInstance().validirajBrojTelefona(txt.getText());
		else if(txt.getName().equals("txtDatum"))
			omoguciDatum = StudentController.getInstance().validirajDatumRodjenja(txt.getText());
		else if(txt.getName().equals("txtEmail"))
			omoguciEmail = StudentController.getInstance().validirajEmail(txt.getText());
		else if(txt.getName().equals("txtGodUpisa"))
			omoguciGodUpisa = StudentController.getInstance().validirajGodinuUpisa(txt.getText());

		
		if(omoguciIme && omoguciPrezime && omoguciAdresu && omoguciBrInd && omoguciBrTel && omoguciDatum && omoguciEmail && omoguciGodUpisa) {
			is.osveziDugmad(true);
		} else {
			is.osveziDugmad(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}