package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.DodavanjePredmetaView;
import view.DodavanjeStudentaView;

public class KeyListenerPredmet implements KeyListener {
	
	DodavanjePredmetaView dp;
	
	boolean omoguciSifra = false;
	boolean omoguciNaziv = false;
	boolean omoguciESPB = false;

	public KeyListenerPredmet(DodavanjePredmetaView dp) {
		// TODO Auto-generated constructor stub
		
		this.dp = dp;
	}
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		JTextField txt = (JTextField) arg0.getComponent();
		
		
		if(txt.getName().equals("txtSifraPred"))
			omoguciSifra = PredmetController.getInstance().validirajSifruPredmeta(txt.getText(), "dodavanje");
		else if(txt.getName().equals("txtNazivPred"))
			omoguciNaziv = PredmetController.getInstance().validirajNazivPredmeta(txt.getText());
		else if(txt.getName().equals("txtESPB"))
			omoguciESPB = PredmetController.getInstance().validirajESPB(txt.getText());
		
		
		if(omoguciSifra && omoguciNaziv && omoguciESPB) {
			dp.osveziDugmad(true);
		} else {
			dp.osveziDugmad(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
