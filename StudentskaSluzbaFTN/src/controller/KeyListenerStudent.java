package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.DodavanjeStudentaView;

public class KeyListenerStudent implements KeyListener {
	
	DodavanjeStudentaView ds;
	
	boolean omoguciIme = false;
	boolean omoguciPrezime = false;
	boolean omoguciAdresu = false;
	boolean omoguciBrInd = false;
	boolean omoguciBrTel = false;
	boolean omoguciDatum = false;
	boolean omoguciEmail = false;
	boolean omoguciGodUpisa = false;

	public KeyListenerStudent(DodavanjeStudentaView ds) {
		this.ds = ds;
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
			omoguciBrInd = StudentController.getInstance().validirajBrIndeksa(txt.getText(), "dodavanje");
		else if(txt.getName().equals("txtBrojTel"))
			omoguciBrTel = StudentController.getInstance().validirajBrojTelefona(txt.getText());
		else if(txt.getName().equals("txtDatum"))
			omoguciDatum = StudentController.getInstance().validirajDatumRodjenja(txt.getText());
		else if(txt.getName().equals("txtEmail"))
			omoguciEmail = StudentController.getInstance().validirajEmail(txt.getText());
		else if(txt.getName().equals("txtGodUpisa"))
			omoguciGodUpisa = StudentController.getInstance().validirajGodinuUpisa(txt.getText());
		
		
		if(omoguciIme && omoguciPrezime && omoguciAdresu && omoguciBrInd && omoguciBrTel && omoguciDatum && omoguciEmail && omoguciGodUpisa) {
			ds.osveziDugmad(true);
		} else {
			ds.osveziDugmad(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
