package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class CreateDocumentActionEdit extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionEdit() {
		putValue(NAME, "Edit");
		putValue(SHORT_DESCRIPTION, "Izmena postojeceg entiteta (Ctrl-E)");
		putValue(SMALL_ICON, GlavniProzor.resizeIcon(new ImageIcon("images/edit.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(TabbedPane.getInstance().getIndex() == 0) {
		//	DodavanjeStudentaView ds = new DodavanjeStudentaView(GlavniProzor.getInstance());
		} else if(TabbedPane.getInstance().getIndex() == 1) {
			IzmenaProfesoraView ip = new IzmenaProfesoraView (GlavniProzor.getInstance(),
				TabbedPane.getInstance().nadjiKlljuc());	
			System.out.println(TabbedPane.getInstance().getProfesorTable().getSelectedRow());
		} else if(TabbedPane.getInstance().getIndex() == 2) {
			//DodavanjePredmetaView dp = new DodavanjePredmetaView(GlavniProzor.getInstance());
		}
	}

}