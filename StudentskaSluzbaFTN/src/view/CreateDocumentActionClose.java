package view;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class CreateDocumentActionClose extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateDocumentActionClose() {
		putValue(NAME, "Close");
		putValue(SHORT_DESCRIPTION, "Izlaz (Ctrl-C)");
		putValue(SMALL_ICON, GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String[] options = {"Da", "Ne" };
		int code = JOptionPane.showOptionDialog(GlavniProzor.getInstance().getContentPane(),"Da li ste sigurni da želite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), options, null);
		
		if (code != JOptionPane.YES_OPTION) {
			GlavniProzor.getInstance().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else {
			GlavniProzor.getInstance().dispose();
		}
	}
}
