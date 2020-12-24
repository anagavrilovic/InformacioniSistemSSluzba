package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionClose extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateDocumentActionClose() {
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Izlaz (Ctrl-C)");
		putValue(SMALL_ICON, new ImageIcon("images/close.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
