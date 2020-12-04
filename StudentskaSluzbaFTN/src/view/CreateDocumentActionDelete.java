package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionDelete extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionDelete() {
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Brisanje entiteta (Ctrl-D)");
		putValue(SMALL_ICON, new ImageIcon("images/trash.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}