package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionNew extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionNew() {
		putValue(NAME, "New");
		putValue(SHORT_DESCRIPTION, "Dodavanje novog entiteta (Ctrl-N)");
		putValue(SMALL_ICON, new ImageIcon("images/add.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}