package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionHelp extends AbstractAction {
	
	public CreateDocumentActionHelp() {
		putValue(NAME, "Help");
		putValue(SHORT_DESCRIPTION, "Opis o nacinu koriscenja aplikacije (Ctrl-H)");
		putValue(SMALL_ICON, new ImageIcon("images/question.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_H);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
