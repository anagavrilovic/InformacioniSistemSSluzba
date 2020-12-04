package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionAbout extends AbstractAction {

	public CreateDocumentActionAbout() {
		putValue(NAME, "About");
		putValue(SHORT_DESCRIPTION, "Opis aplikacije (Ctrl-A)");
		putValue(SMALL_ICON, new ImageIcon("images/info.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
