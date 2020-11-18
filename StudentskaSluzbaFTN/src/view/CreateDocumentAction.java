package view;

/*Kod preuzet iz materijala sa vjezbi*/

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentAction extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentAction() {
		//putValue(NAME, "Kreiranje dokumenta");
		//putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		//putValue(SHORT_DESCRIPTION, "Kreiranje novog dokumenta unutar worksapce");
		//putValue(SMALL_ICON, new ImageIcon("images/home.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//putValue(NAME, "Novi naziv");
	}

}