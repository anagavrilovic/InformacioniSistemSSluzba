package view;

//Kod napisan po uzoru na materijale sa vje�bi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionEdit extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionEdit() {
		//putValue(NAME, "Edit");
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(SHORT_DESCRIPTION, "Izmena postojeceg entiteta (Ctrl-I)");
		putValue(SMALL_ICON, new ImageIcon("images/edit.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//putValue(NAME, "Novi naziv");
	}

}