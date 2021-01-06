package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import view.DodavanjePredmetaView;
import view.DodavanjeStudentaView;
import view.IzmenaPredmetaView;

public class KeyListenerPredmetIzmena implements KeyListener {
	
	IzmenaPredmetaView ip;
	
	boolean omoguciSifra = true;
	boolean omoguciNaziv = true;
	boolean omoguciESPB = true;

	public KeyListenerPredmetIzmena(IzmenaPredmetaView ip) {
		// TODO Auto-generated constructor stub
		
		this.ip = ip;
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
			omoguciSifra = PredmetController.getInstance().validirajSifruPredmeta(txt.getText(), "izmena");
		else if(txt.getName().equals("txtNazivPred"))
			omoguciNaziv = PredmetController.getInstance().validirajNazivPredmeta(txt.getText());
		else if(txt.getName().equals("txtESPB"))
			omoguciESPB = PredmetController.getInstance().validirajESPB(txt.getText());
		
		
		if(omoguciSifra && omoguciNaziv && omoguciESPB) {
			ip.osveziDugmad(true);
		} else {
			ip.osveziDugmad(false);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}