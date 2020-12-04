package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionSearch extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionSearch() {
	
		putValue(SHORT_DESCRIPTION, "Pretraga entiteta");
		putValue(SMALL_ICON, new ImageIcon("images/search.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}