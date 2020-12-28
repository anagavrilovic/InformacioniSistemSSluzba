package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.StudentController;

public class CreateDocumentActionDelete extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionDelete() {
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Brisanje entiteta (Ctrl-D)");
		putValue(SMALL_ICON, GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(TabbedPane.getInstance().getIndex() == 0) {
			
			if(TabbedPane.getInstance().getIndexFromSelectedRow().equals("")) {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Selektujte red!", "Nije selektovan nijedan red", JOptionPane.INFORMATION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
				return;
			}
			
			String message = StudentController.getInstance().izbrisiStudenta(TabbedPane.getInstance().getIndexFromSelectedRow());
			
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), message, "Uspešno brisanje", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")));
			
		} /*else if(TabbedPane.getInstance().getIndex() == 1) {
				IzmenaProfesoraView ip = new IzmenaProfesoraView (GlavniProzor.getInstance(),
				TabbedPane.getInstance().nadjiKlljuc());
		} else if(TabbedPane.getInstance().getIndex() == 2) {
			IzmenaPredmetaView ip = new IzmenaPredmetaView(GlavniProzor.getInstance(), TabbedPane.getInstance().getSifraPredFromSelectedRow());
		}*/
		
	}

}